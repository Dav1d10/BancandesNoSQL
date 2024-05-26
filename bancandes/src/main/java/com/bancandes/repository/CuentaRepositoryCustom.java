package com.bancandes.repository;

import java.util.Date;

import com.bancandes.entities.CuentaEntity.EstadoCuenta;
import com.bancandes.entities.CuentaEntity.TipoCuenta;

public interface CuentaRepositoryCustom {

    void actualizarCuenta(int numero_cuenta, int saldo, Date fechaUltimaTransaccion, Date fechaCreacion, TipoCuenta tipoCuenta, EstadoCuenta estadoCuenta);
    
}
