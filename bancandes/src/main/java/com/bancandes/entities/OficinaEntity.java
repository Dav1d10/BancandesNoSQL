package com.bancandes.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="oficinas")
public class OficinaEntity {

    private Integer id_oficina;
    private String nombre;
    private String direccion;
    private Integer puntos_atencion;
    private Integer id_gerente_ofi;
    private Integer id_persona;

    public OficinaEntity(Integer id_oficina, String nombre, String direccion, Integer puntos_atencion,
            Integer id_gerente_ofi, Integer id_persona) {
        this.id_oficina = id_oficina;
        this.nombre = nombre;
        this.direccion = direccion;
        this.puntos_atencion = puntos_atencion;
        this.id_gerente_ofi = id_gerente_ofi;
        this.id_persona = id_persona;
    }

    public Integer getId_oficina() {
        return id_oficina;
    }

    public void setId_oficina(Integer id_oficina) {
        this.id_oficina = id_oficina;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getPuntos_atencion() {
        return puntos_atencion;
    }

    public void setPuntos_atencion(Integer puntos_atencion) {
        this.puntos_atencion = puntos_atencion;
    }

    public Integer getId_gerente_ofi() {
        return id_gerente_ofi;
    }

    public void setId_gerente_ofi(Integer id_gerente_ofi) {
        this.id_gerente_ofi = id_gerente_ofi;
    }

    public Integer getId_persona() {
        return id_persona;
    }

    public void setId_persona(Integer id_persona) {
        this.id_persona = id_persona;
    }
    
}
