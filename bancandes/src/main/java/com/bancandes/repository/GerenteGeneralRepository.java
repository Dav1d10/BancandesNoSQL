package com.bancandes.repository;


import java.util.Collection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.bancandes.entities.GerenteGeneral;


public interface GerenteGeneralRepository extends MongoRepository<GerenteGeneral,String>{
    

    /* 
    @Query(value = "SELECT * FROM gerente_general",nativeQuery = true)
    Collection<GerenteGeneral> darGerentesGenerales();


    @Query(value = "SELECT * FROM gerente_general WHERE num_documento=:num_documento", nativeQuery = true)
    GerenteGeneral darGerenteGeneral(@Param("num_documento")String num_documento);

    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO gerente_general (num_documento,telefono,nombre,nacionalidad,direccion_fisica,direccion_electronica,departamento,codigo_postal,ciudad,tipo_documento) VALUES(:num_documento, :telefono, :nombre, :nacionalidad, :direccion_fisica, :direccion_electronica, :departamento, :codigo_postal, :ciudad, :tipo_documento)", nativeQuery =true)  
    void insertarGerenteGeneral(@Param("num_documento") String num_documento, @Param("telefono") String telefono, @Param("nombre")String nombre,
    @Param("nacionalidad")String nacionalidad, @Param("direccion_fisica") String direccion_fisica, @Param("direccion_electronica")String direccion_electronica,
    @Param("departamento")String departamento, @Param("codigo_postal") String codigo_postal,  @Param("ciudad")String ciudad, @Param("tipo_documento")String tipo_documento);

    @Modifying
    @Transactional
    @Query(value = "UPDATE gerente_general SET num_documento=:num_documento,telefono=:telefono ,nombre=:nombre ,nacionalidad=:nacionalidad, direccion_fisica=:direccion_fisica,direccion_electronica=:direccion_electronica ,departamento=:departamento ,codigo_postal=:codigo_postal, ciudad=:ciudad, tipo_documento=:tipo_documento WHERE num_documento=:num_documento" , nativeQuery =true)  
    void actualizarGerenteGeneral(@Param("num_documento") String num_documento, @Param("telefono") String telefono, @Param("nombre")String nombre,
    @Param("nacionalidad")String nacionalidad, @Param("direccion_fisica") String direccion_fisica, @Param("direccion_electronica")String direccion_electronica,
    @Param("departamento")String departamento, @Param("codigo_postal") String codigo_postal,  @Param("ciudad")String ciudad, @Param("tipo_documento")String tipo_documento);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM gerente_general WHERE num_documento=:num_documento", nativeQuery = true)
    void eliminarGerenteGeneral(@Param("num_documento") String num_documento);
    */
}
