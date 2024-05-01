package com.bancandes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import com.bancandes.entities.TieneEntity;
import com.bancandes.entities.TienePK;



import java.util.Collection;

public interface TieneRepository extends JpaRepository<TieneEntity, TienePK>{
    
    public interface TieneProjection {
        String getIdCliente();
        String getNumeroCuenta();
    }
    @Query(value = "SELECT id_cliente AS idCliente, numero_cuenta AS numeroCuenta FROM tiene", nativeQuery = true)
    Collection<TieneProjection> darTienes();


    @Query(value = "SELECT FROM tiene WHERE numero_cuenta =: numero_cuenta AND id_cliente =: id_cliente", nativeQuery = true)
    TieneEntity darTienePorId(@Param("numero_cuenta") int numero_cuenta, @Param("id_cliente") String id_cliente);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tiene WHERE numero_cuenta =: numero_cuenta AND id_cliente =: id_cliente", nativeQuery = true)
    void eliminarTiene(@Param("numero_cuenta") int numero_cuenta, @Param("id_cliente") String id_cliente);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tiene SET numero_cuenta = :id_cuenta_actualizado, id_cliente = :id_cliente_actualizado WHERE numero_cuenta = :numero_cuenta AND id_cliente = :id_cliente", nativeQuery = true)
    void actualizarTiene(@Param("numero_cuenta") int numero_cuenta, @Param("id_cliente") String id_cliente, @Param("id_cuenta_actualizado") int id_cuenta_actualizado, @Param("id_cliente_actualizado") String id_cliente_actualizado);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tiene (numero_cuenta, id_cliente) VALUES (:numero_cuenta, :id_cliente)", nativeQuery = true)
    void insertarTiene(@Param("numero_cuenta") int numero_cuenta, @Param("id_cliente") String id_cliente);

}
