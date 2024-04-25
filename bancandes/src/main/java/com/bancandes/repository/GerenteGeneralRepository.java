package com.bancandes.repository;


import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.bancandes.entities.GerenteGeneral;


public interface GerenteGeneralRepository extends JpaRepository<GerenteGeneral,String>{
    

    
    @Query(value = "SELECT * FROM gerente_general",nativeQuery = true)

    Collection<GerenteGeneral> darGerentesGenerales();


    @Query(value = "SELECT * FROM gerente_general WHERE numDocumento= :numDocumento", nativeQuery = true)
    GerenteGeneral darGerenteGeneral(@Param("numDocumento")String numDocumento);


    @Query(value = "INSERT INTO gerente_general (numDocumento,telefono,nombre,nacionalidad,direccionFisica,direccionElectronica,departamento,codigoPostal,ciudad,tipoDocumento)  VALUES (:numDocumento, :telefono, :nombre, :nacionalidad, :direccionFisica, :direccionElectronica, :departamento, :codigoPostal, :ciudad, :TipoDocumento)", nativeQuery =true)  
    void insertarGerenteGeneral(@Param("numDocumento") String numDocumento, @Param("telefono") String telefono, @Param("nombre")String nombre,
    @Param("nacionalidad")String nacionalidad, @Param("direccionFisica") String direccionFisica, @Param("direccionElectronica")String direccionElectronica,
    @Param("departamento")String departamento, @Param("codigoPostal") String codigoPostal,  @Param("ciudad")String ciudad, @Param("TipoDocumento")String tipoDocumento);

    @Modifying
    @Transactional
    @Query(value = "UPDATE gerente_general SET numDocumento=:numDocumento,telefono:=telefono ,nombre:=nombre ,nacionalidad:=nacionalidad, direccionFisica:=direccionFisica,direccionElectronica:=direccionElectronica ,departamento:=departamento ,codigoPostal:=codigoPostal, ciudad:=ciudad, tipoDocumento:=tipoDocumento)  VALUES (:numDocumento, :telefono, :nombre, :nacionalidad, :direccionFisica, :direccionElectronica, :departamento, :codigoPostal, :ciudad, :TipoDocumento)", nativeQuery =true)  
    void actualizarCliente(@Param("numDocumento") String numDocumento, @Param("telefono") String telefono, @Param("nombre")String nombre,
    @Param("nacionalidad")String nacionalidad, @Param("direccionFisica") String direccionFisica, @Param("direccionElectronica")String direccionElectronica,
    @Param("departamento")String departamento, @Param("codigoPostal") String codigoPostal,  @Param("ciudad")String ciudad, @Param("TipoDocumento")String tipoDocumento);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM gerente_general WHERE numDocumento = :numDocumento", nativeQuery = true)
    void eliminarCliente(@Param("numDocumento") String numDocumento);
}
