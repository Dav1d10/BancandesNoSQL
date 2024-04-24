package com.bancandes.repository;

import java.sql.Date;
import java.sql.Time;
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
    @Query(value = "INSERT INTO OPERACION_BANCARIA (id, valor, hora, fecha, producto, tipo) VALUES(bancandes_sequence.nextval, :valor, :hora, :fecha, :producto, :tipo)", nativeQuery =true)
    void insertarOperacionBancaria(@Param("valor")int valor, @Param("hora")Time hora, @Param("fecha")Date fecha, @Param("producto")String producto, @Param("tipo")String tipo );

    @Modifying
    @Transactional
    @Query(value = "UPDATE OPERACION_BANCARIA SET valor=:valor, hora=:hora, fecha=:fecha, producto=:producto, tipo=:tipo WHERE id=:id", nativeQuery =true)
    void actualizarOperacionBancaria(@Param("id") int id, @Param("valor")int valor, @Param("hora")Time hora, @Param("fecha")Date fecha, @Param("producto")String producto, @Param("tipo")String tipo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM OPERACION_BANCARIA WHERE id=:id", nativeQuery = true)
    void eliminarOperacionBancaria(@Param("id") int id);
}
