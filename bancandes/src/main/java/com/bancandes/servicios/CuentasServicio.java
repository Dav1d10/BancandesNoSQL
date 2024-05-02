package com.bancandes.servicios;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.bancandes.entities.CuentaEntity;
import com.bancandes.exceptions.SaldoInsuficienteException;
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
    public void transferenciaCuentasSerializable(int numero_cuenta_origen, int numero_cuenta_destino, int cantidad_transferencia) throws SaldoInsuficienteException {
        LocalDate fechaActual = LocalDate.now();
        LocalTime horaActual = LocalTime.now();
        Date fechaSql = Date.valueOf(fechaActual);
        CuentaEntity cuentaOrigen = cuentaRepository.darCuenta(numero_cuenta_origen);
        CuentaEntity cuentaDestino = cuentaRepository.darCuenta(numero_cuenta_destino);
        if (cuentaOrigen.getSaldo() >= cantidad_transferencia) {
            cuentaRepository.actualizarCuenta(numero_cuenta_origen, cuentaOrigen.getSaldo() - cantidad_transferencia, fechaSql, cuentaOrigen.getFecha_creacion(), cuentaOrigen.getTipo_cuenta().name(), cuentaOrigen.getEstado_cuenta().name());
            cuentaRepository.actualizarCuenta(numero_cuenta_destino, cuentaDestino.getSaldo() + cantidad_transferencia , fechaSql, cuentaDestino.getFecha_creacion(), cuentaDestino.getTipo_cuenta().name(), cuentaDestino.getEstado_cuenta().name());
            operacionBancariaRepository.insertarOperacionBancaria(cantidad_transferencia, horaActual.format(DateTimeFormatter.ofPattern("HH:mm:ss")), fechaSql, "CUENTA", "TRANSFERENCIA");
            operacionBancariaRepository.insertarOperacionBancaria(cantidad_transferencia, horaActual.format(DateTimeFormatter.ofPattern("HH:mm:ss")), fechaSql, "CUENTA", "CONSIGNACION");
        } else {
            throw new SaldoInsuficienteException("No hay suficiente saldo en la cuenta origen.");
        }
    }


    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public void transferenciaCuentasReadCommitted(int numero_cuenta_origen, int numero_cuenta_destino, int cantidad_transferencia) throws SaldoInsuficienteException {
        LocalDate fechaActual = LocalDate.now();
        LocalTime horaActual = LocalTime.now();
        Date fechaSql = Date.valueOf(fechaActual);
        CuentaEntity cuentaOrigen = cuentaRepository.darCuenta(numero_cuenta_origen);
        CuentaEntity cuentaDestino = cuentaRepository.darCuenta(numero_cuenta_destino);
        if (cuentaOrigen.getSaldo() >= cantidad_transferencia) {
            cuentaRepository.actualizarCuenta(numero_cuenta_origen, cuentaOrigen.getSaldo() - cantidad_transferencia, fechaSql, cuentaOrigen.getFecha_creacion(), cuentaOrigen.getTipo_cuenta().name(), cuentaOrigen.getEstado_cuenta().name());
            cuentaRepository.actualizarCuenta(numero_cuenta_destino, cuentaDestino.getSaldo() + cantidad_transferencia , fechaSql, cuentaDestino.getFecha_creacion(), cuentaDestino.getTipo_cuenta().name(), cuentaDestino.getEstado_cuenta().name());
            operacionBancariaRepository.insertarOperacionBancaria(cantidad_transferencia, horaActual.format(DateTimeFormatter.ofPattern("HH:mm:ss")), fechaSql, "CUENTA", "TRANSFERENCIA");
            operacionBancariaRepository.insertarOperacionBancaria(cantidad_transferencia, horaActual.format(DateTimeFormatter.ofPattern("HH:mm:ss")), fechaSql, "CUENTA", "CONSIGNACION");
        } else {
            throw new SaldoInsuficienteException("No hay suficiente saldo en la cuenta origen.");
        }
    }

    }


    

    
    

