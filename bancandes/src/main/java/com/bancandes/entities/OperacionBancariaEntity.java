package com.bancandes.entities;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "operaciones_bancarias")
public class OperacionBancariaEntity {

    @Id
    private int id;
    private int valor;
    private String hora;
    private Date fecha;
    private Producto producto;
    private Tipo tipo;

    
    
    public OperacionBancariaEntity(int id, int valor, String hora, Date fecha, Producto producto, Tipo tipo) {
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
        CERRAR_PRESTAMO,
        TRANSFERENCIA
    }
    
    
    public enum Producto {
        CUENTA,
        CDT,
        PRESTAMO
    }

}



