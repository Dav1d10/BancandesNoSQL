package com.bancandes.Entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="prestamos")
public class PrestamoEntity {
    
    private Integer id_prestamo;
    private Integer monto;
    private Integer interes;
    private Integer num_cuotas;
    private Date dia_pago;
    private Integer valor_cuota;
    private String estado_prestamo;
    private Integer id_cliente;
    private Integer id_op_bancaria;
    
    public PrestamoEntity(Integer id_prestamo, Integer monto, Integer interes, Integer num_cuotas, Date dia_pago,
            Integer valor_cuota, String estado_prestamo, Integer id_cliente, Integer id_op_bancaria) {
        this.id_prestamo = id_prestamo;
        this.monto = monto;
        this.interes = interes;
        this.num_cuotas = num_cuotas;
        this.dia_pago = dia_pago;
        this.valor_cuota = valor_cuota;
        this.estado_prestamo = estado_prestamo;
        this.id_cliente = id_cliente;
        this.id_op_bancaria = id_op_bancaria;
    }

    public Integer getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(Integer id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public Integer getInteres() {
        return interes;
    }

    public void setInteres(Integer interes) {
        this.interes = interes;
    }

    public Integer getNum_cuotas() {
        return num_cuotas;
    }

    public void setNum_cuotas(Integer num_cuotas) {
        this.num_cuotas = num_cuotas;
    }

    public Date getDia_pago() {
        return dia_pago;
    }

    public void setDia_pago(Date dia_pago) {
        this.dia_pago = dia_pago;
    }

    public Integer getValor_cuota() {
        return valor_cuota;
    }

    public void setValor_cuota(Integer valor_cuota) {
        this.valor_cuota = valor_cuota;
    }

    public String getEstado_prestamo() {
        return estado_prestamo;
    }

    public void setEstado_prestamo(String estado_prestamo) {
        this.estado_prestamo = estado_prestamo;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Integer getId_op_bancaria() {
        return id_op_bancaria;
    }

    public void setId_op_bancaria(Integer id_op_bancaria) {
        this.id_op_bancaria = id_op_bancaria;
    }
    
}
