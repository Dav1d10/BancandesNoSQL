package com.bancandes.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="puntos_de_atencion")
public class PuntoAtencionEntity {

    private Integer id_punto_atencion;
    private String localizacion;
    private String tipo_punto_atencion;
    private Integer id_op_bancaria;

    public PuntoAtencionEntity(Integer id_punto_atencion, String localizacion, String tipo_punto_atencion,
            Integer id_op_bancaria) {
        this.id_punto_atencion = id_punto_atencion;
        this.localizacion = localizacion;
        this.tipo_punto_atencion = tipo_punto_atencion;
        this.id_op_bancaria = id_op_bancaria;
    }

    public Integer getId_punto_atencion() {
        return id_punto_atencion;
    }

    public void setId_punto_atencion(Integer id_punto_atencion) {
        this.id_punto_atencion = id_punto_atencion;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getTipo_punto_atencion() {
        return tipo_punto_atencion;
    }

    public void setTipo_punto_atencion(String tipo_punto_atencion) {
        this.tipo_punto_atencion = tipo_punto_atencion;
    }

    public Integer getId_op_bancaria() {
        return id_op_bancaria;
    }

    public void setId_op_bancaria(Integer id_op_bancaria) {
        this.id_op_bancaria = id_op_bancaria;
    }

}
