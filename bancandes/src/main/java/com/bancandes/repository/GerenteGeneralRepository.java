package com.bancandes.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.bancandes.entities.GerenteGeneral;


public interface GerenteGeneralRepository extends JpaRepository<GerenteGeneral,Integer>{
    

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO gerenteGeneral (numero_documento ,telefono ,nombre ,nacionalidad, direccionFisica ,direccionElectronica ,departamento ,codigoPostal, ciudad, tipoDocumento) VALUES (:numDocumento, :telefono, :nombre, :nacionalidad, :direccionFisica, :direccionElectronica, :departamento, :codigoPostal, :ciudad, :tipoDocumento)", nativeQuery = true)
    void insertarGerenteGeneral(@Param("numDocumento") Integer numDocumento, @Param("telefono") String telefono, @Param("nombre")String nombre,
    @Param("nacionalidad")String nacionalidad, @Param("direccionFisica") String direccionFisica, @Param("direccionElectronica")String direccionElectronica,
    @Param("departamento")String departamento, @Param("codigoPostal") String codigoPostal,  @Param("ciudad")String ciudad, @Param("tipoDocumento")GerenteGeneral.TipoDocumento tipoDocumento);


}

