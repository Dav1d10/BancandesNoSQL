package com.bancandes.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    @Enumerated(EnumType.STRING)
    private EstadoPrestamo estado_prestamo;
    
    public PrestamoEntity(Integer id_prestamo, Integer monto, Integer interes, Integer num_cuotas, Date dia_pago,
            Integer valor_cuota, EstadoPrestamo estado_prestamo, Integer id_cliente, Integer id_op_bancaria) {
        this.id_prestamo = id_prestamo;
        this.monto = monto;
        this.interes = interes;
        this.num_cuotas = num_cuotas;
        this.dia_pago = dia_pago;
        this.valor_cuota = valor_cuota;
        this.estado_prestamo = estado_prestamo;
    }

    public Integer getId_prestamo() {
        return id_prestamo;
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

    public EstadoPrestamo getEstado_prestamo() {
        return estado_prestamo;
    }

    public void setEstado_prestamo(EstadoPrestamo estado_prestamo) {
        this.estado_prestamo = estado_prestamo;
    }
    
    enum EstadoPrestamo {
        SOLICITADO,
        APROBADO,
        RECHAZADO,
        PAGADO
    }
}
