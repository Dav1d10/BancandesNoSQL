package com.bancandes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bancandes.entities.PideEntity;
import java.util.Collection;

public interface PideRepository extends JpaRepository<PideEntity, Integer>{
    
    @Query(value = "SELECT * FROM pide", nativeQuery = true)
    Collection<PideEntity> darHace();

    @Query(value = "SELECT FROM pide WHERE id_cliente =: id_cliente AND id_prestamo =: id_prestamo", nativeQuery = true)
    PideEntity darPidePorId(@Param("id_cliente") String id_cliente, @Param("id_prestamo") int id_prestamo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM pide WHERE id_cliente =: id_cliente AND id_prestamo =: id_prestamo", nativeQuery = true)
    void eliminarPide(@Param("id_cliente") String id_cliente, @Param("id_prestamo") int id_prestamo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE pide SET id_cliente = :id_cliente_actualizado, id_prestamo = :id_prestamo_actualizado WHERE id_cliente = :id_cliente AND id_prestamo = :id_prestamo", nativeQuery = true)
    void actualizarPide(@Param("id_cliente") String id_cliente, @Param("id_prestamo") int id_prestamo, @Param("id_cliente_actualizado") String id_cliente_actualizado, @Param("id_prestamo_actualizado") int id_prestamo_actualizado);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO pide (id_cliente, id_prestamo) VALUES (:id_cliente, :id_prestamo)", nativeQuery = true)
    void insertarPide(@Param("id_cliente") String id_cliente, @Param("id_prestamo") int id_prestamo);

}
