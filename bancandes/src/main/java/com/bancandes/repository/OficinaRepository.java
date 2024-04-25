package com.bancandes.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bancandes.entities.OficinaEntity;

public interface OficinaRepository extends JpaRepository<OficinaEntity, Integer> {

    @Query(value = "SELECT * FROM OFICINA", nativeQuery = true)
    Collection<OficinaEntity> darOficinas();

    @Query(value = "SELECT * FROM OFICINA WHERE id_oficina= :id_oficina", nativeQuery = true)
    OficinaEntity darOficina(@Param("id_oficina") int id_oficina);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO OFICINA (id, nombre, direccion, puntos_atencion) VALUES(id_oficina.nextval, :nombre, :direccion, :puntos_atencion)", nativeQuery = true)
    void insertarOficina(@Param("nombre") String nombre, @Param("direccion") String direccion, @Param("puntos_atencion") Integer puntos_atencion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE OFICINA SET nombre=:nombre, direccion=:direccion, puntos_atencion=:puntos_atencion WHERE id_oficina=:id_oficina", nativeQuery =true)
    void actualizarOficina(@Param("id_oficina") int id_oficina, @Param("nombre") String nombre, @Param("direccion") String direccion, @Param("puntos_atencion") Integer puntos_atencion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM OFICINA WHERE id_oficina = :id_oficina", nativeQuery = true)
    void eliminarOficina(@Param("id_oficina") int id_oficina);

}
