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


    @Query(value = "SELECT * FROM cliente WHERE num_documento=:num_documento", nativeQuery = true)
    ClienteEntity darCliente(@Param("num_documento")String num_documento);

    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cliente (num_documento,telefono,nombre,nacionalidad,direccion_fisica,direccion_electronica,departamento,codigo_postal,ciudad,tipo_documento) VALUES(:num_documento, :telefono, :nombre, :nacionalidad, :direccion_fisica, :direccion_electronica, :departamento, :codigo_postal, :ciudad, :tipo_documento)", nativeQuery =true)  
    void insertarCliente(@Param("num_documento") String num_documento, @Param("telefono") String telefono, @Param("nombre")String nombre,
    @Param("nacionalidad")String nacionalidad, @Param("direccion_fisica") String direccion_fisica, @Param("direccion_electronica")String direccion_electronica,
    @Param("departamento")String departamento, @Param("codigo_postal") String codigo_postal,  @Param("ciudad")String ciudad, @Param("tipo_documento")String tipo_documento);

    @Modifying
    @Transactional
    @Query(value = "UPDATE cliente SET num_documento=:num_documento,telefono=:telefono ,nombre=:nombre ,nacionalidad=:nacionalidad, direccion_fisica=:direccion_fisica,direccion_electronica=:direccion_electronica ,departamento=:departamento ,codigo_postal=:codigo_postal, ciudad=:ciudad, tipo_documento=:tipo_documento WHERE num_documento=:num_documento" , nativeQuery =true)  
    void actualizarCliente(@Param("num_documento") String num_documento, @Param("telefono") String telefono, @Param("nombre")String nombre,
    @Param("nacionalidad")String nacionalidad, @Param("direccion_fisica") String direccion_fisica, @Param("direccion_electronica")String direccion_electronica,
    @Param("departamento")String departamento, @Param("codigo_postal") String codigo_postal,  @Param("ciudad")String ciudad, @Param("tipo_documento")String tipo_documento);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cliente WHERE num_documento=:num_documento", nativeQuery = true)
    void eliminarCliente(@Param("num_documento") String num_documento);
}

