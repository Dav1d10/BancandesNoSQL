package com.bancandes.repository;

import java.util.Collection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.bancandes.entities.CajeroEntity;


public interface CajeroRepository extends MongoRepository<CajeroEntity,String>{


    @Query("{}")
    Collection<CajeroEntity> darCajeros();


    @Query("{ 'num_documento': ?0}")
    CajeroEntity darCajero(String num_documento);
    /* 
    @Query(value = "SELECT * FROM cajero",nativeQuery = true)
    Collection<CajeroEntity> darCajeros();


    @Query(value = "SELECT * FROM cajero WHERE num_documento=:num_documento", nativeQuery = true)
    CajeroEntity darCajero(@Param("num_documento")String num_documento);

    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cajero (num_documento,telefono,nombre,nacionalidad,direccion_fisica,direccion_electronica,departamento,codigo_postal,ciudad,tipo_documento) VALUES(:num_documento, :telefono, :nombre, :nacionalidad, :direccion_fisica, :direccion_electronica, :departamento, :codigo_postal, :ciudad, :tipo_documento)", nativeQuery =true)  
    void insertarCajero(@Param("num_documento") String num_documento, @Param("telefono") String telefono, @Param("nombre")String nombre,
    @Param("nacionalidad")String nacionalidad, @Param("direccion_fisica") String direccion_fisica, @Param("direccion_electronica")String direccion_electronica,
    @Param("departamento")String departamento, @Param("codigo_postal") String codigo_postal,  @Param("ciudad")String ciudad, @Param("tipo_documento")String tipo_documento);

    @Modifying
    @Transactional
    @Query(value = "UPDATE cajero SET num_documento=:num_documento,telefono=:telefono ,nombre=:nombre ,nacionalidad=:nacionalidad, direccion_fisica=:direccion_fisica,direccion_electronica=:direccion_electronica ,departamento=:departamento ,codigo_postal=:codigo_postal, ciudad=:ciudad, tipo_documento=:tipo_documento WHERE num_documento=:num_documento" , nativeQuery =true)  
    void actualizarCajero(@Param("num_documento") String num_documento, @Param("telefono") String telefono, @Param("nombre")String nombre,
    @Param("nacionalidad")String nacionalidad, @Param("direccion_fisica") String direccion_fisica, @Param("direccion_electronica")String direccion_electronica,
    @Param("departamento")String departamento, @Param("codigo_postal") String codigo_postal,  @Param("ciudad")String ciudad, @Param("tipo_documento")String tipo_documento);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cajero WHERE num_documento=:num_documento", nativeQuery = true)
    void eliminarCajero(@Param("num_documento") String num_documento);
    */
}

