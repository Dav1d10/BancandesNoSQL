package com.bancandes.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bancandes.entities.CuentaEntity;


public interface CuentaRepository extends JpaRepository<CuentaEntity, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cuentas (numero_cuenta, saldo, fecha_ultima_transaccion, fecha_creacion, tipo_cuenta, estado_cuenta) VALUES(bancandes_sequence.nextval, :saldo, :fecha_ultima_transaccion, :fecha_creacion, :tipo_cuenta, :estado_cuenta)", nativeQuery = true)
    void insertarCuenta(@Param("saldo") Integer saldo, @Param("fecha_ultima_transaccion") Date fecha_ultima_transaccion, @Param("fecha_creacion") Date fecha_creacion, @Param("tipo_cuenta") CuentaEntity.TipoCuenta tipo_cuenta, @Param("estado_cuenta") CuentaEntity.EstadoCuenta estado_cuenta);

}