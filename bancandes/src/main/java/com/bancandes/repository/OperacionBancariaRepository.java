package com.bancandes.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bancandes.entities.OperacionBancariaEntity;

public interface OperacionBancariaRepository extends JpaRepository<OperacionBancariaEntity, Integer> {
    
    @Query(value = "SELECT * FROM OperacionBancaria", nativeQuery = true)
    Collection<OperacionBancariaEntity> darOperacionesBancarias();

    @Query(value = "SELECT * FROM OperacionBancaria WHERE id= :id", nativeQuery = true)
    OperacionBancariaEntity darOperacionBancaria(@Param("id") int id);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO OperacionBancaria (id, valor, hora, fecha, producto, tipo) VALUES(bancandes_sequence.nextval, :valor, :hora, :fecha, :producto, :tipo)", nativeQuery =true)
    void insertarOperacionBancaria(@Param("valor")int valor, @Param("hora")String hora, @Param("fecha")String fecha, @Param("producto")OperacionBancariaEntity.Producto producto, @Param("tipo")OperacionBancariaEntity.Tipo tipo );
}
