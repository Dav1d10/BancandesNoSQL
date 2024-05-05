package com.bancandes.repository;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import com.bancandes.entities.OperacionPrestamoEntity;

public interface OperacionPrestamoRepository extends JpaRepository<OperacionPrestamoEntity, Integer> {

    @Query(value = "SELECT * FROM OPERACION_PRESTAMO", nativeQuery = true)
    Collection<OperacionPrestamoEntity> darOperacionesPrestamos();

    @Query(value = "SELECT * FROM OPERACION_PRESTAMO WHERE id= :id", nativeQuery = true)
    OperacionPrestamoEntity darOperacionPrestamo(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO OPERACION_PRESTAMO (id, valor, fecha, prestamo_afectado, tipo_operacion, producto_prestamo) VALUES(id_operacion_prestamo.nextval, :valor, :fecha, :prestamo_afectado, :tipo_operacion, :producto_prestamo)", nativeQuery =true)
    void insertarOperacionPrestamo(@Param("valor")int valor, @Param("fecha")Date fecha,  @Param("prestamo_afectado")int prestamo_afectado, @Param("tipo_operacion")String tipo_operacion, @Param("producto_prestamo")String producto_prestamo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE OPERACION_PRESTAMO SET valor=:valor, fecha=:fecha, prestamo_afectado=:prestamo_afectado, tipo_operacion=:tipo_operacion, producto_prestamo=:producto_prestamo WHERE id=:id", nativeQuery =true)
    void actualizarOperacionPrestamo(@Param("id") int id, @Param("valor")int valor, @Param("fecha")Date fecha,  @Param("prestamo_afectado")int prestamo_afectado, @Param("tipo_operacion")String tipo_operacion, @Param("producto_prestamo")String producto_prestamo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM OPERACION_PRESTAMO WHERE id=:id", nativeQuery = true)
    void eliminarOperacionPrestamo(@Param("id") int id);
    
}
