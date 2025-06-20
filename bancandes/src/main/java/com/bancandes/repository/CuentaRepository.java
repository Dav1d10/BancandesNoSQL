package com.bancandes.repository;


import java.util.Collection;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.bancandes.entities.CuentaEntity;


public interface CuentaRepository extends MongoRepository<CuentaEntity, Integer>, CuentaRepositoryCustom {

    

    @Query("{}")
    List<CuentaEntity> darCuentas();

    @Query("{ 'numero_cuenta': ?0}")
    CuentaEntity darCuenta(int numero_cuenta);

    /* 
    @Query(value = "SELECT * FROM cuenta", nativeQuery = true)
    Collection<CuentaEntity> darCuentas();
    */

    /* 
    @Query(value = "SELECT * FROM cuenta WHERE numero_cuenta=:numero_cuenta", nativeQuery = true)
    CuentaEntity darCuenta(@Param("numero_cuenta") int numero_cuenta);
    */

    /* 
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO CUENTA (numero_cuenta, saldo, fecha_ultima_transaccion, fecha_creacion, tipo_cuenta, estado_cuenta) VALUES(id_cuenta.nextval, :saldo, :fecha_ultima_transaccion, :fecha_creacion, :tipo_cuenta, :estado_cuenta)", nativeQuery = true)
    void insertarCuenta(@Param("saldo") Integer saldo, @Param("fecha_ultima_transaccion") Date fecha_ultima_transaccion, @Param("fecha_creacion") Date fecha_creacion, @Param("tipo_cuenta") String tipo_cuenta, @Param("estado_cuenta") String estado_cuenta);
    */

    /* 
    @Modifying
    @Transactional
    @Query(value = "UPDATE cuenta SET saldo=:saldo, fecha_ultima_transaccion=:fecha_ultima_transaccion, fecha_creacion=:fecha_creacion, tipo_cuenta=:tipo_cuenta, estado_cuenta=:estado_cuenta WHERE numero_cuenta=:numero_cuenta", nativeQuery = true)
    void actualizarCuenta(@Param("numero_cuenta") int numero_cuenta, @Param("saldo") Integer saldo, @Param("fecha_ultima_transaccion") Date fecha_ultima_transaccion, @Param("fecha_creacion") Date fecha_creacion, @Param("tipo_cuenta") String tipo_cuenta, @Param("estado_cuenta") String estado_cuenta);
    */

    /* 
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CUENTA WHERE numero_cuenta = :numero_cuenta", nativeQuery = true)
    void eliminarCuenta(@Param("numero_cuenta") int numero_cuenta);
    */
    
    /* 
    @Query(value = "UPDATE cuenta\r\n" + //
                    "SET SALDO = SALDO - :cantidad_retiro_transferencia\r\n" + //
                    "WHERE numero_cuenta = :numero_cuenta_origen\r\n", nativeQuery = true)
    void transferenciaRetiroCuenta(@Param("numero_cuenta_origen") int numero_cuenta_origen, @Param("cantidad_retiro_transferencia") int cantidad_retiro_transferencia);    


    @Query(value = "UPDATE cuenta\r\n" + //
                    "SET SALDO = SALDO + :cantidad_consignacion_transferencia\r\n" + //
                    "WHERE numero_cuenta = :numero_cuenta_destino\r\n", nativeQuery = true)
    void transferenciaConsignacionCuenta(@Param("numero_cuenta_destino") int numero_cuenta_destino, @Param("cantidad_consignacion_transferencia")int cantidad_consignacion_transferencia);    
    */

}