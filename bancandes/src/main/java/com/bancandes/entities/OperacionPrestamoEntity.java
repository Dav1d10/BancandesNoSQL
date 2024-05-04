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
@Table(name = "operacion prestamo")
public class OperacionPrestamoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private int valor;
    private Date fecha;
    private int prestamo_afectado;
    
    @Enumerated(EnumType.STRING)
    private TipoOperacion tipo_operacion;

    @Enumerated(EnumType.STRING)
    private ProductoPrestamo producto_prestamo;


    public OperacionPrestamoEntity(Integer id, int valor, Date fecha, int prestamo_afectado,
            TipoOperacion tipo_operacion, ProductoPrestamo producto_prestamo) {
        this.id = id;
        this.valor = valor;
        this.fecha = fecha;
        this.prestamo_afectado = prestamo_afectado;
        this.tipo_operacion = tipo_operacion;
        this.producto_prestamo = producto_prestamo;
    }


    public OperacionPrestamoEntity() {
        ;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public int getValor() {
        return valor;
    }


    public void setValor(int valor) {
        this.valor = valor;
    }


    public Date getFecha() {
        return fecha;
    }


    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public int getPrestamo_afectado() {
        return prestamo_afectado;
    }


    public void setPrestamo_afectado(int prestamo_afectado) {
        this.prestamo_afectado = prestamo_afectado;
    }


    public TipoOperacion getTipo_operacion() {
        return tipo_operacion;
    }


    public void setTipo_operacion(TipoOperacion tipo_operacion) {
        this.tipo_operacion = tipo_operacion;
    }


    public ProductoPrestamo getProducto_prestamo() {
        return producto_prestamo;
    }


    public void setProducto_prestamo(ProductoPrestamo producto_prestamo) {
        this.producto_prestamo = producto_prestamo;
    }


    public enum TipoOperacion {
        PAGO_EXTRAORDINARIO,
        PAGO_ORDINARIO
    }
    
    
    public enum ProductoPrestamo {
        PAGO_DE_LA_CUOTA_MENSUAL,
        PAGO_DE_LA_CUOTA_EXTRAORDINARIA
    }


    

    

    


    
}
