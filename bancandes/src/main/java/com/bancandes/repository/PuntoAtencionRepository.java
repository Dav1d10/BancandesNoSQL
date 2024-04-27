package com.bancandes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bancandes.entities.PuntoAtencionEntity;
import java.util.Collection;

public interface PuntoAtencionRepository extends JpaRepository<PuntoAtencionEntity, Integer>{

    @Query(value = "SELECT * FROM PUNTO_DE_ATENCION", nativeQuery = true)
    Collection<PuntoAtencionEntity> darPuntosAtencion();

    @Query(value = "SELECT * FROM PUNTO_DE_ATENCION WHERE id_punto_atencion= :id_punto_atencion", nativeQuery = true)
    PuntoAtencionEntity darPuntoAtencion(@Param("id_punto_atencion") int id_punto_atencion);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO PUNTO_DE_ATENCION (id_punto_atencion, localizacion, tipo_punto_atencion) VALUES(id_punto_atencion.nextval, :localizacion, :tipo_punto_atencion)", nativeQuery = true)
    void insertarPuntoAtencion(@Param("localizacion") String localizacion, @Param("tipo_punto_atencion") String tipo_punto_atencion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PUNTO_DE_ATENCION SET localizacion=:localizacion, tipo_punto_atencion=:tipo_punto_atencion WHERE id_punto_atencion=:id_punto_atencion", nativeQuery =true)
    void actualizarPuntoAtencion(@Param("id_punto_atencion") int id_punto_atencion, @Param("localizacion") String localizacion, @Param("tipo_punto_atencion") String tipo_punto_atencion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PUNTO_DE_ATENCION WHERE id_punto_atencion = :id_punto_atencion", nativeQuery = true)
    void eliminarPuntoAtencion(@Param("id_punto_atencion") int id_punto_atencion);
}


