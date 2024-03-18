package com.bancandes.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;


@Entity
@Table(name="personas")
public class PersonaEntity {

    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer numDocumento;
    private String telefono;
    private String nombre;
    private String nacionalidad;
    private String direccionFisica;
    private String direccionElectronica;
    private String departamento;
    private String codigoPostal;
    private String ciudad;

    @Enumerated(EnumType.STRING)
    private TipoDocumento TipoDocumento;

    public PersonaEntity(String telefono, String nombre, String nacionalidad, String direccionFisica, String direccionElectronica, String departamento, String codigoPostal, String ciudad) {
        this.telefono = telefono;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.direccionFisica = direccionFisica;
        this.direccionElectronica = direccionElectronica;
        this.departamento = departamento;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
    }

    public PersonaEntity() {
        ;
    }

    public Integer getNumDocumento() {
        return numDocumento;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getDireccionFisica() {
        return direccionFisica;
    }

    public String getDireccionElectronica() {
        return direccionElectronica;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public TipoDocumento getTipoDocumento() {
        return TipoDocumento;
    }

    public void setNumDocumento(Integer numDocumento) {
        this.numDocumento = numDocumento;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setDireccionFisica(String direccionFisica) {
        this.direccionFisica = direccionFisica;
    }

    public void setDireccionElectronica(String direccionElectronica) {
        this.direccionElectronica = direccionElectronica;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        TipoDocumento = tipoDocumento;
    }
}

enum TipoDocumento {
    CC,
    NIT
}