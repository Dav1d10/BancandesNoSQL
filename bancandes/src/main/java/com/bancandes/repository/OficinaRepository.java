package com.bancandes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bancandes.entities.OficinaEntity;

public interface OficinaRepository extends JpaRepository<OficinaEntity, Integer> {
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO oficinas (id, nombre, direccion, puntos_atencion) VALUES(bancandes_sequence.nextval, :nombre, :direccion, :puntos_atencion)", nativeQuery = true)
    void insterarOficina(@Param("nombre") String nombre, @Param("direccion") String direccion, @Param("puntos_atencion") Integer puntos_atencion);

}
