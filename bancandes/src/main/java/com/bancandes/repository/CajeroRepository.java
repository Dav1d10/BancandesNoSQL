package com.bancandes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bancandes.entities.CajeroEntity;
import com.bancandes.entities.TipoDocumento;



public interface CajeroRepository extends JpaRepository<CajeroEntity,Integer>{

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cajero (numDocumento ,telefono ,nombre ,nacionalidad, direccionFisica ,direccionElectronica ,departamento ,codigoPostal, ciudad, tipoDocumento)")
    void insertarGerenteGeneral(@Param("numDocumento") Integer numDocumento, @Param("telefono") String telefono, @Param("nombre")String nombre,
    @Param("nacionalidad")String nacionalidad, @Param("direccionFisica") String direccionFisica, @Param("direccionElectronica")String direccionElectronica,
    @Param("departamento")String departamento, @Param("codigoPostal") String codigoPostal,  @Param("ciudad")String ciudad, @Param("tipoDocumento")TipoDocumento tipoDocumento);


    
}
