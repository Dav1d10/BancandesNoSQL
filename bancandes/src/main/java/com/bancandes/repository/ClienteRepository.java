package com.bancandes.repository;


import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.bancandes.entities.ClienteEntity;


public interface ClienteRepository extends JpaRepository<ClienteEntity,Integer>{

    @Query(value = "SELECT * FROM clientes", nativeQuery = true)
    Collection<ClienteEntity> darClientes();


    @Query(value = "SELECT * FROM clientes WHERE numDocumento = :id", nativeQuery = true)
    ClienteEntity darCliente(@Param("numDocumento") int id);




    @Modifying
    @Transactional
    @Query(value = "INSERT INTO clientes (numDocumento ,telefono ,nombre ,nacionalidad, direccionFisica ,direccionElectronica ,departamento ,codigoPostal, ciudad, tipoDocumento)")
    void insertarCliente(@Param("numDocumento") Integer numDocumento, @Param("telefono") String telefono, @Param("nombre")String nombre,
    @Param("nacionalidad")String nacionalidad, @Param("direccionFisica") String direccionFisica, @Param("direccionElectronica")String direccionElectronica,
    @Param("departamento")String departamento, @Param("codigoPostal") String codigoPostal,  @Param("ciudad")String ciudad, @Param("tipoDocumento")ClienteEntity.TipoDocumento tipoDocumento);

}
