package com.bancandes.repository;

import java.util.Collection;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.bancandes.entities.ClienteEntity;


public interface ClienteRepository extends MongoRepository<ClienteEntity, String>{

   
    /* 
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



    @Query(value = "SELECT \r\n" + //
    "c.tipo_documento AS TIPO_CLIENTE, \r\n" + //
    "c.nombre AS NOMBRE , \r\n" + //
    "c.num_documento AS NUM_DOC, \r\n" + //
    "cu.numero_cuenta AS NUM_CUENTA, \r\n" + //
    "o.nombre AS NOMBRE_OFICINA, \r\n" + //
    "p.id_prestamo AS NUM_PRESTAMO, \r\n" + //
    "cu.saldo AS SALDO \r\n" + //
    "FROM \r\n" + //
        "cliente c \r\n" + //
    "LEFT JOIN \r\n" + //
        "tiene t ON c.num_documento = t.id_cliente \r\n" + //
    "LEFT JOIN \r\n" + //
        "cuenta cu ON t.id_cuenta = cu.numero_cuenta \r\n" + //
    "LEFT JOIN \r\n" + //
        "pertenece pe ON cu.numero_cuenta = pe.id_cuenta \r\n" + //
    "LEFT JOIN \r\n" + //
        "oficina o ON pe.id_oficina = o.id_oficina \r\n" + //
    "LEFT JOIN \r\n" + //
        "pide pd ON c.num_documento = pd.id_cliente \r\n" + //
    "LEFT JOIN \r\n" + //
        "prestamo p ON pd.id_prestamo = p.id_prestamo \r\n" + //
    "WHERE \r\n" + //
        "c.num_documento = :num_documento", nativeQuery = true)
    Collection<RespuestaInfoCliente> darClientePorNumDoc(@Param("num_documento") String num_documento);
    */
}

