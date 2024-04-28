package com.bancandes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bancandes.entities.EjecutaEntity;
import com.bancandes.entities.EjecutaPK;

import java.util.Collection;

public interface EjecutaRepository extends JpaRepository<EjecutaEntity, EjecutaPK>{

    @Query(value = "SELECT * FROM ejecuta", nativeQuery = true)
    Collection<EjecutaEntity> darEjecuta();

    @Query(value = "SELECT FROM ejecuta WHERE id_operacionbancaria =: id_operacionbancaria AND id_cliente =: id_cliente", nativeQuery = true)
    EjecutaEntity darEjecutaPorId(@Param("id_operacionbancaria") int id_operacionbancaria, @Param("id_cliente") String id_cliente);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ejecuta WHERE id_operacionbancaria =: id_operacionbancaria AND id_cliente =: id_cliente", nativeQuery = true)
    void eliminarEjecuta(@Param("id_operacionbancaria") int id_operacionbancaria, @Param("id_cliente") String id_cliente);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ejecuta SET id_operacionbancaria = :id_operacionbancaria_actualizado, id_cliente = :id_cliente_actualizado WHERE id_operacionbancaria = :id_operacionbancaria AND id_cliente = :id_cliente", nativeQuery = true)
    void actualizarEjecuta(@Param("id_operacionbancaria") int id_operacionbancaria, @Param("id_cliente") String id_cliente, @Param("id_operacionbancaria_actualizado") int id_operacionbancaria_actualizado, @Param("id_cliente_actualizado") String id_cliente_actualizado);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ejecuta (id_operacionbancaria, id_cliente) VALUES (:id_operacionbancaria, :id_cliente)", nativeQuery = true)
    void insertarEjecuta(@Param("id_operacionbancaria") int id_operacionbancaria, @Param("id_cliente") String id_cliente);

}