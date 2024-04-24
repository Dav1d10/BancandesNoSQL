package com.bancandes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bancandes.entities.PuntoAtencionEntity;
import java.util.Collection;

public interface PuntoAtencionRepository extends JpaRepository<PuntoAtencionEntity, Integer>{

    @Query(value = "SELECT * FROM PUNTOS_DE_ATENCION", nativeQuery = true)
    Collection<PuntoAtencionEntity> darPuntosAtencion();

    @Query(value = "SELECT * FROM PUNTOS_DE_ATENCION WHERE id_punto_atencion= :id_punto_atencion", nativeQuery = true)
    PuntoAtencionEntity darPuntoAtencion(@Param("id_punto_atencion") int id_punto_atencion);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO PUNTOS_DE_ATENCION (id_punto_atencion, localizacion, tipo_punto_atencion) VALUES(bancandes_sequence.nextval, :localizacion, :tipo_punto_atencion)", nativeQuery = true)
    void insertarPuntoAtencion(@Param("localizacion") String localizacion, @Param("tipo_punto_atencion") PuntoAtencionEntity.TipoPuntoAtencion tipo_punto_atencion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PUNTOS_DE_ATENCION SET localizacion=:localizacion, tipo_punto_atencion=:tipo_punto_atencion WHERE id_punto_atencion=:id_punto_atencion", nativeQuery =true)
    void actualizarPuntoAtencion(@Param("localizacion") String localizacion, @Param("tipo_punto_atencion") PuntoAtencionEntity.TipoPuntoAtencion tipo_punto_atencion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PUNTOS_DE_ATENCION WHERE id_punto_atencion = :id_punto_atencion AND NOT EXISTS (SELECT 1 FROM operaciones WHERE punto_atencion_id = :id_punto_atencion)", nativeQuery = true)
    void eliminarPuntoAtencion(@Param("id_punto_atencion") Integer id_punto_atencion);
}


