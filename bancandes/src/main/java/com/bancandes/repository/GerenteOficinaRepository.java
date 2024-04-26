package com.bancandes.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.bancandes.entities.GerenteOficina;


public interface GerenteOficinaRepository extends JpaRepository<GerenteOficina,String>{

    @Query(value = "SELECT * FROM gerente_de_oficina",nativeQuery = true)
    Collection<GerenteOficina> darGerentesOficinas();


    @Query(value = "SELECT * FROM gerente_de_oficina WHERE num_documento=:num_documento", nativeQuery = true)
    GerenteOficina darGerenteOficina(@Param("num_documento")String num_documento);

    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO gerente_de_oficina (num_documento,telefono,nombre,nacionalidad,direccion_fisica,direccion_electronica,departamento,codigo_postal,ciudad,tipo_documento) VALUES(:num_documento, :telefono, :nombre, :nacionalidad, :direccion_fisica, :direccion_electronica, :departamento, :codigo_postal, :ciudad, :tipo_documento)", nativeQuery =true)  
    void insertarGerenteOficina(@Param("num_documento") String num_documento, @Param("telefono") String telefono, @Param("nombre")String nombre,
    @Param("nacionalidad")String nacionalidad, @Param("direccion_fisica") String direccion_fisica, @Param("direccion_electronica")String direccion_electronica,
    @Param("departamento")String departamento, @Param("codigo_postal") String codigo_postal,  @Param("ciudad")String ciudad, @Param("tipo_documento")String tipo_documento);

    @Modifying
    @Transactional
    @Query(value = "UPDATE gerente_oficina SET num_documento=:num_documento,telefono=:telefono ,nombre=:nombre ,nacionalidad=:nacionalidad, direccion_fisica=:direccion_fisica,direccion_electronica=:direccion_electronica ,departamento=:departamento ,codigo_postal=:codigo_postal, ciudad=:ciudad, tipo_documento=:tipo_documento WHERE num_documento=:num_documento" , nativeQuery =true)  
    void actualizarGerenteOficina(@Param("num_documento") String num_documento, @Param("telefono") String telefono, @Param("nombre")String nombre,
    @Param("nacionalidad")String nacionalidad, @Param("direccion_fisica") String direccion_fisica, @Param("direccion_electronica")String direccion_electronica,
    @Param("departamento")String departamento, @Param("codigo_postal") String codigo_postal,  @Param("ciudad")String ciudad, @Param("tipo_documento")String tipo_documento);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM gerente_de_oficina WHERE num_documento=:num_documento", nativeQuery = true)
    void eliminarGerenteOficina(@Param("num_documento") String num_documento);
}

