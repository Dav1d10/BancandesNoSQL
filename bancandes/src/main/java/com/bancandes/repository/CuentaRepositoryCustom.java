package com.bancandes.repository;

import java.util.Date;

public interface CuentaRepositoryCustom {

    void actualizarCuenta(int numero_cuenta, int saldo, Date fechaUltimaTransaccion, Date fechaCreacion, String tipoCuenta, String estadoCuenta);
    
}
