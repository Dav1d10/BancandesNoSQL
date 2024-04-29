package com.bancandes.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bancandes.entities.ManejaEntity;
import com.bancandes.entities.ManejaPK;

public interface ManejaRepository extends JpaRepository<ManejaEntity, ManejaPK>{

    @Query(value = "SELECT * FROM maneja", nativeQuery = true)
    Collection<ManejaEntity> darManeja();

    @Query(value = "SELECT FROM maneja WHERE id_oficina =: id_oficina AND id_gerenteoficina =: id_ogerenteoficina", nativeQuery = true)
    ManejaEntity darManejaPorId(@Param("id_oficina") int id_oficina, @Param("id_gerenteoficina") int id_gerenteoficina);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM maneja WHERE id_oficina =: id_oficina AND id_gerenteoficina =: id_ogerenteoficina", nativeQuery = true)
    void eliminarManeja(@Param("id_oficina") int id_oficina, @Param("id_gerenteoficina") int id_gerenteoficina);

    @Modifying
    @Transactional
    @Query(value = "UPDATE maneja SET id_oficina = :id_oficina_actualizado, id_gerenteoficina = :id_gerenteoficina_actualizado WHERE id_oficina = :id_oficina AND id_gerenteoficina = :id_gerenteoficina", nativeQuery = true)
    void actualizarManeja(@Param("id_oficina") int id_oficina, @Param("id_gerenteoficina") int id_gerenteoficina, @Param("id_oficina_actualizado") int id_oficina_actualizado, @Param("id_gerenteoficina_actualizado") int id_gerenteoficina_actualizado);
    

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO maneja (id_oficina, id_gerenteoficina) VALUES (:id_oficina, :id_gerenteoficina)", nativeQuery = true)
    void insertarManeja(@Param("id_oficina") int id_oficina, @Param("id_gerenteoficina") int id_gerenteoficina);
    
}
