package com.bancandes.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.bancandes.entities.PrestamoEntity;
import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PrestamoRepository extends JpaRepository<PrestamoEntity, Integer> {

    @Query(value = "SELECT * FROM Prestamo", nativeQuery = true)
    Collection<PrestamoEntity> darPrestamos();

    @Query(value = "SELECT * FROM PRESTAMO WHERE id_prestamo= :id_prestamo", nativeQuery = true)
    PrestamoEntity darPrestamo(@Param("id_prestamo") int id_prestamo);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO PRESTAMO (id_prestamo, monto, interes, num_cuotas, dia_pago, valor_cuota, estado_prestamo) VALUES(bancandes_sequence.nextval, :monto, :interes, :num_cuotas, :dia_pago, :valor_cuota, :estado_prestamo)", nativeQuery =true)
    void insertarPrestamo(@Param("monto")Integer monto, @Param("interes")Integer interes, @Param("num_cuotas")Integer num_cuotas, @Param("dia_pago")Date dia_pago, @Param("valor_cuota")Integer valor_cuota, @Param("estado_prestamo")PrestamoEntity.EstadoPrestamo estado_prestamo);


    @Modifying
    @Transactional
    @Query(value = "UPDATE PRESTAMO SET monto=:monto, interes=:interes, num_cuotas=:num_cuotas, dia_pago=:dia_pago, valor_cuota=:valor_cuota, estado_prestamo=:estado_prestamo WHERE id_prestamo=:id_prestamo", nativeQuery =true)
    void actualizarPrestamo(@Param("monto")Integer monto, @Param("interes")Integer interes, @Param("num_cuotas")Integer num_cuotas, @Param("dia_pago")Date dia_pago, @Param("valor_cuota")Integer valor_cuota, @Param("estado_prestamo")PrestamoEntity.EstadoPrestamo estado_prestamo);
}
  