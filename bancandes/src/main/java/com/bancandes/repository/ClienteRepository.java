package com.bancandes.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bancandes.entities.ClienteEntity;


public interface ClienteRepository extends JpaRepository<ClienteEntity, String>{
    
    @Query(value = "SELECT * FROM cliente",nativeQuery = true)

    Collection<ClienteEntity> darClientes();


    @Query(value = "SELECT * FROM cliente WHERE numDocumento= :numDocumento", nativeQuery = true)
    ClienteEntity darCliente(@Param("numDocumento")String numDocumento);


    @Query(value = "INSERT INTO cliente (numDocumento,telefono,nombre,nacionalidad,direccionFisica,direccionElectronica,departamento,codigoPostal,ciudad,TipoDocumento)  VALUES (:numDocumento, :telefono, :nombre, :nacionalidad, :direccionFisica, :direccionElectronica, :departamento, :codigoPostal, :ciudad, :TipoDocumento)", nativeQuery =true)  
    void insertarCliente(@Param("numDocumento") String numDocumento, @Param("telefono") String telefono, @Param("nombre")String nombre,
    @Param("nacionalidad")String nacionalidad, @Param("direccionFisica") String direccionFisica, @Param("direccionElectronica")String direccionElectronica,
    @Param("departamento")String departamento, @Param("codigoPostal") String codigoPostal,  @Param("ciudad")String ciudad, @Param("TipoDocumento")String TipoDocumento);

    @Modifying
    @Transactional
    @Query(value = "UPDATE cliente SET numDocumento=:numDocumento,telefono:=telefono ,nombre:=nombre ,nacionalidad:=nacionalidad, direccionFisica:=direccionFisica,direccionElectronica:=direccionElectronica ,departamento:=departamento ,codigoPostal:=codigoPostal, ciudad:=ciudad, TipoDocumento:=TipoDocumento)  VALUES (:numDocumento, :telefono, :nombre, :nacionalidad, :direccionFisica, :direccionElectronica, :departamento, :codigoPostal, :ciudad, :TipoDocumento)", nativeQuery =true)  
    void actualizarCliente(@Param("numDocumento") String numDocumento, @Param("telefono") String telefono, @Param("nombre")String nombre,
    @Param("nacionalidad")String nacionalidad, @Param("direccionFisica") String direccionFisica, @Param("direccionElectronica")String direccionElectronica,
    @Param("departamento")String departamento, @Param("codigoPostal") String codigoPostal,  @Param("ciudad")String ciudad, @Param("TipoDocumento")String TipoDocumento);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cliente WHERE numDocumento = :numDocumento", nativeQuery = true)
    void eliminarCliente(@Param("numDocumento") String numDocumento);
}
