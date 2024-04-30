package com.bancandes.servicios;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.bancandes.entities.CuentaEntity;
import com.bancandes.repository.CuentaRepository;
import com.bancandes.repository.OperacionBancariaRepository;

@Service
public class CuentasServicio {

    private CuentaRepository cuentaRepository;

    private OperacionBancariaRepository operacionBancariaRepository;

     

    public CuentasServicio(CuentaRepository cuentaRepository, OperacionBancariaRepository operacionBancariaRepository) {
        this.cuentaRepository = cuentaRepository;
        this.operacionBancariaRepository = operacionBancariaRepository;
    }



    @Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
    public void consignacionCuentaSerializable(int numero_cuenta, int cantidad_consignacion) {
        try {
            LocalDate fechaActual = LocalDate.now();
            LocalTime horaActual = LocalTime.now();
            Date fechaSql = Date.valueOf(fechaActual);
            CuentaEntity cuentaActual = cuentaRepository.darCuenta(numero_cuenta);
            cuentaRepository.actualizarCuenta(numero_cuenta, cuentaActual.getSaldo() + cantidad_consignacion, cuentaActual.getFecha_ultima_transaccion(), cuentaActual.getFecha_creacion(), cuentaActual.getTipo_cuenta().name(), cuentaActual.getEstado_cuenta().name());
            operacionBancariaRepository.insertarOperacionBancaria(cantidad_consignacion, horaActual.format(DateTimeFormatter.ofPattern("HH:mm:ss")), fechaSql, "CUENTA", "CONSIGNACION");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    


    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public void consignacionCuentaReadCommited(int numero_cuenta, int cantidad_consignacion) {
        try {
            LocalDate fechaActual = LocalDate.now();
            LocalTime horaActual = LocalTime.now();
            Date fechaSql = Date.valueOf(fechaActual);
            CuentaEntity cuentaActual = cuentaRepository.darCuenta(numero_cuenta);
            cuentaRepository.actualizarCuenta(numero_cuenta, cuentaActual.getSaldo() + cantidad_consignacion, cuentaActual.getFecha_ultima_transaccion(), cuentaActual.getFecha_creacion(), cuentaActual.getTipo_cuenta().name(), cuentaActual.getEstado_cuenta().name());
            operacionBancariaRepository.insertarOperacionBancaria(cantidad_consignacion, horaActual.format(DateTimeFormatter.ofPattern("HH:mm:ss")), fechaSql, "CUENTA", "CONSIGNACION");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
    public void retiroCuentaSerializable(int numero_cuenta, int cantidad_consignacion) {
        try {
            LocalDate fechaActual = LocalDate.now();
            LocalTime horaActual = LocalTime.now();
            Date fechaSql = Date.valueOf(fechaActual);
            CuentaEntity cuentaActual = cuentaRepository.darCuenta(numero_cuenta);
            cuentaRepository.actualizarCuenta(numero_cuenta, cuentaActual.getSaldo() - cantidad_consignacion, cuentaActual.getFecha_ultima_transaccion(), cuentaActual.getFecha_creacion(), cuentaActual.getTipo_cuenta().name(), cuentaActual.getEstado_cuenta().name());
            operacionBancariaRepository.insertarOperacionBancaria(cantidad_consignacion, horaActual.format(DateTimeFormatter.ofPattern("HH:mm:ss")), fechaSql, "CUENTA", "RETIRO");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public void retiroCuentaReadCommitted(int numero_cuenta, int cantidad_consignacion) {
        try {
            LocalDate fechaActual = LocalDate.now();
            LocalTime horaActual = LocalTime.now();
            Date fechaSql = Date.valueOf(fechaActual);
            CuentaEntity cuentaActual = cuentaRepository.darCuenta(numero_cuenta);
            cuentaRepository.actualizarCuenta(numero_cuenta, cuentaActual.getSaldo() - cantidad_consignacion, cuentaActual.getFecha_ultima_transaccion(), cuentaActual.getFecha_creacion(), cuentaActual.getTipo_cuenta().name(), cuentaActual.getEstado_cuenta().name());
            operacionBancariaRepository.insertarOperacionBancaria(cantidad_consignacion, horaActual.format(DateTimeFormatter.ofPattern("HH:mm:ss")), fechaSql, "CUENTA", "RETIRO");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
    public void transferenciaCuentasSerializable(int numero_cuenta_origen, int cantidad_retiro_transferencia, int numero_cuenta_destino, int cantidad_consignacion_transferencia) {
        try {
            cuentaRepository.transferenciaRetiroCuenta(numero_cuenta_origen, cantidad_retiro_transferencia);
            cuentaRepository.transferenciaConsignacionCuenta(numero_cuenta_destino, cantidad_consignacion_transferencia);
        } catch (Exception e) {
            System.out.println("No pudo realizarse la transferencia");
        }
    }


    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public void transferenciaCuentasReadCommited(int numero_cuenta_origen, int cantidad_retiro_transferencia, int numero_cuenta_destino, int cantidad_consignacion_transferencia) {
        try {
            cuentaRepository.transferenciaRetiroCuenta(numero_cuenta_origen, cantidad_retiro_transferencia);
            cuentaRepository.transferenciaConsignacionCuenta(numero_cuenta_destino, cantidad_consignacion_transferencia);
        } catch (Exception e) {
            System.out.println("No pudo realizarse la transferencia");
        }
    }

    
    
}
