package com.bancandes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.bancandes.entities.GerenteOficina;


public interface GerenteOficinaRepository extends JpaRepository<GerenteOficina,String>{

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO gerenteOficina (numero_documento ,telefono ,nombre ,nacionalidad, direccionFisica ,direccionElectronica ,departamento ,codigoPostal, ciudad, tipoDocumento) VALUES (:numDocumento, :telefono, :nombre, :nacionalidad, :direccionFisica, :direccionElectronica, :departamento, :codigoPostal, :ciudad, :tipoDocumento)", nativeQuery = true)
    void insertarGerenteOficina(@Param("numDocumento") String numDocumento, @Param("telefono") String telefono, @Param("nombre")String nombre,
    @Param("nacionalidad")String nacionalidad, @Param("direccionFisica") String direccionFisica, @Param("direccionElectronica")String direccionElectronica,
    @Param("departamento")String departamento, @Param("codigoPostal") String codigoPostal,  @Param("ciudad")String ciudad, @Param("tipoDocumento")GerenteOficina.TipoDocumento tipoDocumento);
}
