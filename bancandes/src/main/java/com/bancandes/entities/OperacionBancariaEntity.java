package com.bancandes.entities;

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
    private String fecha;
    
    @Enumerated(EnumType.STRING)
    private Producto producto;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    
    public OperacionBancariaEntity(Integer id, int valor, String hora, String fecha, Producto producto, Tipo tipo) {
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

    public enum Tipo {
        CONSIGNACION,
        RETIRO,
        PEDIR_PRESTAMO,
        PAGAR_PRESTAMO,
        CERRAR_PRESTAMO
    }
    
    
    public enum Producto {
        CUENTA,
        CDT
    }

}



