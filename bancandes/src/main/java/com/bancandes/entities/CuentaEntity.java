package com.bancandes.entities;


import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "cuentas")
public class CuentaEntity {

    @Id
    private Integer numero_cuenta;
    private Integer saldo;
    private Date fecha_ultima_transaccion;
    private Date fecha_creacion;
    private TipoCuenta tipo_cuenta;
    private EstadoCuenta estado_cuenta;

    public CuentaEntity(Integer numero_cuenta, Integer saldo, Date fecha_ultima_transaccion, Date fecha_creacion,
    TipoCuenta tipo_cuenta, EstadoCuenta estado_cuenta) {
        this.numero_cuenta = numero_cuenta;
        this.saldo = saldo;
        this.fecha_ultima_transaccion = fecha_ultima_transaccion;
        this.fecha_creacion = fecha_creacion;
        this.tipo_cuenta = tipo_cuenta;
        this.estado_cuenta = estado_cuenta;
    }

    public CuentaEntity()
    {;}

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

    public TipoCuenta getTipo_cuenta() {
        return tipo_cuenta;
    }

    public void setTipo_cuenta(TipoCuenta tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }

    public EstadoCuenta getEstado_cuenta() {
        return estado_cuenta;
    }

    public void setEstado_cuenta(EstadoCuenta estado_cuenta) {
        this.estado_cuenta = estado_cuenta;
    }

    public enum EstadoCuenta {
        ACTIVA,
        CERRADA,
        DESACTIVADA
    }

    public enum TipoCuenta {
        AHORROS,
        CORRIENTE,
        AFC
    }

}