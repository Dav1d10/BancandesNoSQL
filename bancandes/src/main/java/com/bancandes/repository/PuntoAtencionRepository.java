package com.bancandes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bancandes.entities.PuntoAtencionEntity;

public interface PuntoAtencionRepository extends JpaRepository<PuntoAtencionEntity, Integer>{
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO puntos_de_atencion (id_punto_atencion, localizacion, tipo_punto_atencion) VALUES(bancandes_sequence.nextval, :localizacion, :tipo_punto_atencion)", nativeQuery = true)
    void insertarPuntoAtencion(@Param("localizacion") String localizacion, @Param("tipo_punto_atencion") PuntoAtencionEntity.TipoPuntoAtencion tipo_punto_atencion);


}
