package com.bancandes.entities;



import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="prestamo")
public class PrestamoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Integer id_prestamo;
    private int monto;
    private int interes;
    private int numero_cuotas;
    private Date dia_pago;
    private int valor_cuota;
    @Enumerated(EnumType.STRING)
    private EstadoPrestamo estado_prestamo;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    
    public PrestamoEntity(Integer id_prestamo, int monto, int interes, int numero_cuotas, Date dia_pago,
    int valor_cuota, EstadoPrestamo estado_prestamo) {
        this.id_prestamo = id_prestamo;
        this.monto = monto;
        this.interes = interes;
        this.numero_cuotas = numero_cuotas;
        this.dia_pago = dia_pago;
        this.valor_cuota = valor_cuota;
        this.estado_prestamo = estado_prestamo;
    }

    public PrestamoEntity()
    {;}

    
    public Integer getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(Integer id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getInteres() {
        return interes;
    }

    public void setInteres(int interes) {
        this.interes = interes;
    }

    public int getNumero_cuotas() {
        return numero_cuotas;
    }

    public void setNumero_cuotas(int numero_cuotas) {
        this.numero_cuotas = numero_cuotas;
    }

    public Date getDia_pago() {
        return dia_pago;
    }

    public void setDia_pago(Date dia_pago) {
        this.dia_pago = dia_pago;
    }

    public int getValor_cuota() {
        return valor_cuota;
    }

    public void setValor_cuota(int valor_cuota) {
        this.valor_cuota = valor_cuota;
    }

    public EstadoPrestamo getEstado_prestamo() {
        return estado_prestamo;
    }

    public void setEstado_prestamo(EstadoPrestamo estado_prestamo) {
        this.estado_prestamo = estado_prestamo;
    }

    
    public enum EstadoPrestamo {
        SOLICITADO,
        APROBADO,
        RECHAZADO,
        PAGADO
    }

    
    public enum Categoria {
        ACTIVO,
        CERRADO,
        DESACTIVADO
    }
}
