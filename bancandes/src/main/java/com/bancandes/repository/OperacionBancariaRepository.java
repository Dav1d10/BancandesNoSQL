package com.bancandes.repository;


import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bancandes.entities.OperacionBancariaEntity;

public interface OperacionBancariaRepository extends JpaRepository<OperacionBancariaEntity, Integer> {
    
    @Query(value = "SELECT * FROM OPERACION_BANCARIA", nativeQuery = true)
    Collection<OperacionBancariaEntity> darOperacionesBancarias();

    @Query(value = "SELECT * FROM OPERACION_BANCARIA WHERE id= :id", nativeQuery = true)
    OperacionBancariaEntity darOperacionBancaria(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO OPERACION_BANCARIA (id, valor, hora, fecha, producto, tipo) VALUES(id_operacion_bancaria.nextval, :valor, :hora, :fecha, :producto, :tipo)", nativeQuery =true)
    void insertarOperacionBancaria(@Param("valor")int valor, @Param("hora")String hora, @Param("fecha")Date fecha, @Param("producto")String producto, @Param("tipo")String tipo );

    @Modifying
    @Transactional
    @Query(value = "UPDATE OPERACION_BANCARIA SET valor=:valor, hora=:hora, fecha=:fecha, producto=:producto, tipo=:tipo WHERE id=:id", nativeQuery =true)
    void actualizarOperacionBancaria(@Param("id") int id, @Param("valor")int valor, @Param("hora")String hora, @Param("fecha")Date fecha, @Param("producto")String producto, @Param("tipo")String tipo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM OPERACION_BANCARIA WHERE id=:id", nativeQuery = true)
    void eliminarOperacionBancaria(@Param("id") int id);

    @Query(value = "SELECT id_operacion_bancaria.CURRVAL FROM DUAL", nativeQuery = true)
    int obtenerUltimoId();


    @Query(value = "SELECT ob.*\r\n" + // 
                    "FROM operacion_bancaria ob\r\n" + //
                    "INNER JOIN hace h ON ob.id = h.id_operacionbancaria\r\n" + //
                    "INNER JOIN cuenta c ON h.id_cuenta = c.numero_cuenta\r\n" + //
                    "WHERE c.numero_cuenta = :numero_cuenta AND ob.fecha >= SYSDATE - 30", nativeQuery = true)
    Collection<OperacionBancariaEntity> darOperacionesBancariasPorCuentaEnLosUltimos30Dias(@Param("numero_cuenta") int numero_cuenta);
}
