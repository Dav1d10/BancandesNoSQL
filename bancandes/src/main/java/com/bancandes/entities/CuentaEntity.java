package com.bancandes.Entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="cuentas")
public class CuentaEntity {

    private Integer numero_cuenta;
    private Integer saldo;
    private Date fecha_ultima_transaccion;
    private Date fecha_creacion;
    private String tipo_cuenta;
    private String estado_cuenta;
    private Integer id_cliente;
    private Integer id_op_bancaria;

    public CuentaEntity(Integer numero_cuenta, Integer saldo, Date fecha_ultima_transaccion, Date fecha_creacion,
            String tipo_cuenta, String estado_cuenta, Integer id_cliente, Integer id_op_bancaria) {
        this.numero_cuenta = numero_cuenta;
        this.saldo = saldo;
        this.fecha_ultima_transaccion = fecha_ultima_transaccion;
        this.fecha_creacion = fecha_creacion;
        this.tipo_cuenta = tipo_cuenta;
        this.estado_cuenta = estado_cuenta;
        this.id_cliente = id_cliente;
        this.id_op_bancaria = id_op_bancaria;
    }

    public Integer getNumero_cuenta() {
        return numero_cuenta;
    }

    public void setNumero_cuenta(Integer numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public Date getFecha_ultima_transaccion() {
        return fecha_ultima_transaccion;
    }

    public void setFecha_ultima_transaccion(Date fecha_ultima_transaccion) {
        this.fecha_ultima_transaccion = fecha_ultima_transaccion;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getTipo_cuenta() {
        return tipo_cuenta;
    }

    public void setTipo_cuenta(String tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }

    public String getEstado_cuenta() {
        return estado_cuenta;
    }

    public void setEstado_cuenta(String estado_cuenta) {
        this.estado_cuenta = estado_cuenta;
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