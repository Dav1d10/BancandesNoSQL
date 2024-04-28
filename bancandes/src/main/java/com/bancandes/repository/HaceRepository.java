package com.bancandes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bancandes.entities.HaceEntity;
import com.bancandes.entities.HacePK;

import java.util.Collection;

public interface HaceRepository extends JpaRepository<HaceEntity, HacePK>{

    @Query(value = "SELECT * FROM hace", nativeQuery = true)
    Collection<HaceEntity> darHace();

    @Query(value = "SELECT FROM hace WHERE numero_cuenta =: numero_cuenta AND id =: id", nativeQuery = true)
    HaceEntity darHacePorId(@Param("numero_cuenta") Integer numero_cuenta, @Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM hace WHERE numero_cuenta =: numero_cuenta AND id =: id", nativeQuery = true)
    void eliminarHace(@Param("numero_cuenta") Integer numero_cuenta, @Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE hace SET numero_cuenta =: numero_cuenta_actualizado, id = :id_actualizado WHERE numero_cuenta =: numero_cuenta AND id = :id", nativeQuery = true)
    void actualizarHace(@Param("numero_cuenta") Integer numero_cuenta, @Param("id") Integer id, @Param("numero_cuenta_actualizado") Integer numero_cuenta_actualizado, @Param("id_actualizado") Integer id_actualizado);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO hace (numero_cuenta, id) VALUES (:numero_cuenta, :id)", nativeQuery = true)
    void insertarHace(@Param("numero_cuenta") Integer numero_cuenta, @Param("id") Integer id);

}
