package com.bancandes.repository;


import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bancandes.entities.PerteneceEntity;
import com.bancandes.entities.PertenecePK;

import jakarta.transaction.Transactional;

public interface PerteneceRepository extends JpaRepository<PerteneceEntity, PertenecePK>
{
    @Query(value = "SELECT * FROM pertenece", nativeQuery = true)
    Collection<PerteneceEntity> darPertenece();

    @Query(value = "SELECT * FROM pertenece WHERE id_cuenta = :id_cuenta AND id_oficina = :id_oficina", nativeQuery = true)
    PerteneceEntity darPertenecePorId(@Param("id_cuenta") Integer id_cuenta, @Param("id_oficina") Integer id_oficina);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM pertenece WHERE id_cuenta = :id_cuenta AND id_oficina = :id_oficina", nativeQuery = true)
    void eliminarPertenece(@Param("id_cuenta") Integer id_cuenta, @Param("id_oficina") Integer id_oficina);

    
    @Modifying
    @Transactional
    @Query(value = "UPDATE pertenece SET id_cuenta = :id_cuenta_actualizado, id_oficina = :id_oficina_actualizado WHERE id_cuenta = :id_cuenta AND id_oficina = :id_oficina", nativeQuery = true)
    void actualizarPertenece(@Param("id_cuenta") Integer id_cuenta, @Param("id_oficina") Integer id_oficina, @Param("id_cuenta_actualizado") Integer id_cuenta_actualizado, @Param("id_oficina_actualizado") Integer id_oficina_actualizado);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO pertenece (id_cuenta, id_oficina) VALUES (:id_cuenta, :id_oficina)", nativeQuery = true)
    void insertarPertenece(@Param("id_cuenta") Integer id_cuenta, @Param("id_oficina") Integer id_oficina);

}


