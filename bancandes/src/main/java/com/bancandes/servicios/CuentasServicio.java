package com.bancandes.servicios;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.bancandes.entities.CuentaEntity;
import com.bancandes.repository.CuentaRepository;

@Service
public class CuentasServicio {

    private CuentaRepository cuentaRepository;


    public CuentasServicio(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
    public void consignacionCuentaSerializable(int numero_cuenta, int cantidad_consignacion) {
        try {
            CuentaEntity cuentaActual = cuentaRepository.darCuenta(numero_cuenta);
            cuentaRepository.actualizarCuenta(numero_cuenta, cuentaActual.getSaldo() + cantidad_consignacion, cuentaActual.getFecha_ultima_transaccion(), cuentaActual.getFecha_creacion(), cuentaActual.getTipo_cuenta().name(), cuentaActual.getEstado_cuenta().name());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    


    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public void consignacionCuentaReadCommited(int numero_cuenta, int cantidad_consignacion) {
        try {
            cuentaRepository.consignacionCuenta(numero_cuenta, cantidad_consignacion);
        } catch (Exception e) {
            System.out.println("No pudo realizarse la consignación");
        }
    }


    @Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
    public void retiroCuentaSerializable(int numero_cuenta, int cantidad_consignacion) {
        try {
            cuentaRepository.retiroCuenta(numero_cuenta, cantidad_consignacion);
        } catch (Exception e) {
            System.out.println("No pudo realizarse el retiro");
        }
    }


    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public void retiroCuentaReadCommitted(int numero_cuenta, int cantidad_consignacion) {
        try {
            cuentaRepository.retiroCuenta(numero_cuenta, cantidad_consignacion);
        } catch (Exception e) {
            System.out.println("No pudo realizarse el retiro");
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
