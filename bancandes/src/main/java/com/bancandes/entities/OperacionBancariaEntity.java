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
@Table(name="operacion bancaria")
public class OperacionBancariaEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer id;
    private int valor;
    private String hora;
    private Date fecha;
    
    @Enumerated(EnumType.STRING)
    private Producto producto;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    
    
    public OperacionBancariaEntity(Integer id, int valor, String hora, Date fecha, Producto producto, Tipo tipo) {
        this.id = id;
        this.valor = valor;
        this.hora = hora;
        this.fecha = fecha;
        this.producto = producto;
        this.tipo = tipo;
    }

    
    public OperacionBancariaEntity() {
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


    public String getHora() {
        return hora;
    }


    public void setHora(String hora) {
        this.hora = hora;
    }


    public Date getFecha() {
        return fecha;
    }


    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public Producto getProducto() {
        return producto;
    }


    public void setProducto(Producto producto) {
        this.producto = producto;
    }


    public Tipo getTipo() {
        return tipo;
    }


    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }


    public enum Tipo {
        CONSIGNACION,
        RETIRO,
        PEDIR_PRESTAMO,
        PAGAR_PRESTAMO,
        CERRAR_PRESTAMO
    }
    
    
    public enum Producto {
        CUENTA,
        CDT,
        PRESTAMO
    }

}



