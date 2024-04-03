package com.bancandes.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bancandes.entities.CajeroEntity;
import com.bancandes.entities.ClienteEntity;
import com.bancandes.entities.CuentaEntity;

public interface ClienteRepository extends JpaRepository<CuentaEntity, Integer>{
    
    @Query(value = "SELECT * FROM cliente",nativeQuery = true)

    Collection<ClienteEntity> darClientes();


    @Query(value = "SELECT * FROM cliente WHERE numero_documento= :numero_documento", nativeQuery = true)
    ClienteEntity darCliente(@Param("numero_documento")int numDocumento);


    @Query(value = "INSERT INTO cliente (numero_documento ,telefono ,nombre ,nacionalidad, direccionFisica ,direccionElectronica ,departamento ,codigoPostal, ciudad, tipoDocumento)  VALUES (:numero_documento, :telefono, :nombre, :nacionalidad, :direccion_fisica, :direccion_electronica, :departamento, :codigo_postal, :ciudad, :tipo_documento)", nativeQuery =true)  
    void insertarCliente(@Param("numero_documento") Integer numDocumento, @Param("telefono") String telefono, @Param("nombre")String nombre,
    @Param("nacionalidad")String nacionalidad, @Param("direccion_fisica") String direccionFisica, @Param("direccion_electronica")String direccionElectronica,
    @Param("departamento")String departamento, @Param("codigo_postal") String codigoPostal,  @Param("ciudad")String ciudad, @Param("tipo_documento")CajeroEntity.TipoDocumento tipoDocumento);

}
