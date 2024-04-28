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
    
    @Query(value = "SELECT * FROM tiene", nativeQuery = true)
    Collection<TieneEntity> darTiene();

    @Query(value = "SELECT FROM tiene WHERE id_cuenta =: id_cuenta AND id_cliente =: id_cliente", nativeQuery = true)
    TieneEntity darTienePorId(@Param("id_cuenta") int id_cuenta, @Param("id_cliente") String id_cliente);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tiene WHERE id_cuenta =: id_cuenta AND id_cliente =: id_cliente", nativeQuery = true)
    void eliminarTiene(@Param("id_cuenta") int id_cuenta, @Param("id_cliente") String id_cliente);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tiene SET id_cuenta = :id_cuenta_actualizado, id_cliente = :id_cliente_actualizado WHERE id_cuenta = :id_cuenta AND id_cliente = :id_cliente", nativeQuery = true)
    void actualizarTiene(@Param("id_cuenta") int id_cuenta, @Param("id_cliente") String id_cliente, @Param("id_cuenta_actualizado") int id_cuenta_actualizado, @Param("id_cliente_actualizado") String id_cliente_actualizado);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tiene (id_cuenta, id_cliente) VALUES (:id_cuenta, :id_cliente)", nativeQuery = true)
    void insertarTiene(@Param("id_cuenta") int id_cuenta, @Param("id_cliente") String id_cliente);

}
