package com.bancandes.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.bancandes.entities.PrestamoEntity;

import java.sql.Date;
import java.util.Collection;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PrestamoRepository extends JpaRepository<PrestamoEntity, Integer> {

    @Query(value = "SELECT * FROM PRESTAMO", nativeQuery = true)
    Collection<PrestamoEntity> darPrestamos();

    @Query(value = "SELECT * FROM PRESTAMO WHERE id_prestamo= :id_prestamo", nativeQuery = true)
    PrestamoEntity darPrestamo(@Param("id_prestamo") long id_prestamo);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO PRESTAMO (id_prestamo, monto, interes, numero_cuotas, dia_pago, valor_cuota, estado_prestamo) VALUES(id_prestamo.nextval, :monto, :interes, :numero_cuotas, :dia_pago, :valor_cuota, :estado_prestamo)", nativeQuery =true)
    void insertarPrestamo(@Param("monto")int monto, @Param("interes")int interes, @Param("numero_cuotas")int numero_cuotas, @Param("dia_pago")Date dia_pago, @Param("valor_cuota")int valor_cuota, @Param("estado_prestamo") String estado_prestamo);


    @Modifying
    @Transactional
    @Query(value = "UPDATE PRESTAMO SET monto=:monto, interes=:interes, numero_cuotas=:numero_cuotas, dia_pago=:dia_pago, valor_cuota=:valor_cuota, estado_prestamo=:estado_prestamo WHERE id_prestamo=:id_prestamo", nativeQuery =true)
    void actualizarPrestamo(@Param("id_prestamo") long id_prestamo, @Param("monto")int monto, @Param("interes")int interes, @Param("numero_cuotas")int numero_cuotas, @Param("dia_pago")Date dia_pago, @Param("valor_cuota")int valor_cuota, @Param("estado_prestamo") String estado_prestamo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PRESTAMO WHERE id_prestamo = :id_prestamo", nativeQuery = true)
    void eliminarPrestamo(@Param("id_prestamo") long id_prestamo);
}
  