package com.bancandes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bancandes.entities.OcurreEntity;
import com.bancandes.entities.OcurrePK;

import java.util.Collection;

public interface OcurreRepository extends JpaRepository<OcurreEntity, OcurrePK>{

    @Query(value = "SELECT * FROM ocurre", nativeQuery = true)
    Collection<OcurreEntity> darOcurre();

    @Query(value = "SELECT FROM ocurre WHERE id_operacionbancaria =: id_operacionbancaria AND id_puntoatencion =: id_opuntoatencion", nativeQuery = true)
    OcurreEntity darOcurrePorId(@Param("id_operacionbancaria") int id_operacionbancaria, @Param("id_puntoatencion") int id_puntoatencion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ocurre WHERE id_operacionbancaria =: id_operacionbancaria AND id_puntoatencion =: id_opuntoatencion", nativeQuery = true)
    void eliminarOcurre(@Param("id_operacionbancaria") int id_operacionbancaria, @Param("id_puntoatencion") int id_puntoatencion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ocurre SET id_operacionbancaria = :id_operacionbancaria_actualizado, id_puntoatencion = :id_puntoatencion_actualizado WHERE id_operacionbancaria = :id_operacionbancaria AND id_puntoatencion = :id_puntoatencion", nativeQuery = true)
    void actualizarOcurre(@Param("id_operacionbancaria") int id_operacionbancaria, @Param("id_puntoatencion") int id_puntoatencion, @Param("id_operacionbancaria_actualizado") int id_operacionbancaria_actualizado, @Param("id_puntoatencion_actualizado") int id_puntoatencion_actualizado);
    

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ocurre (id_operacionbancaria, id_puntoatencion) VALUES (:id_operacionbancaria, :id_puntoatencion)", nativeQuery = true)
    void insertarOcurre(@Param("id_operacionbancaria") int id_operacionbancaria, @Param("id_puntoatencion") int id_puntoatencion);
    
}
