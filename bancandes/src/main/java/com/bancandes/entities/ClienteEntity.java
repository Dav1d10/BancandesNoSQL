package com.bancandes.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "cliente")
public class ClienteEntity {

    @Id
    private String num_documento;
    private String telefono;
    private String nombre;
    private String nacionalidad;
    private String direccion_fisica;
    private String direccion_electronica;
    private String departamento;
    private String codigo_postal;
    private String ciudad;
    @Enumerated(EnumType.STRING)
    private TipoDocumento tipo_documento;

    
    public ClienteEntity(String num_documento, String telefono, String nombre, String nacionalidad,
            String direccion_fisica, String direccion_electronica, String departamento, String codigo_postal,
            String ciudad, TipoDocumento tipo_documento) {
        this.num_documento = num_documento;
        this.telefono = telefono;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.direccion_fisica = direccion_fisica;
        this.direccion_electronica = direccion_electronica;
        this.departamento = departamento;
        this.codigo_postal = codigo_postal;
        this.ciudad = ciudad;
        this.tipo_documento = tipo_documento;
    }

    


    public String getNum_documento() {
        return num_documento;
    }




    public void setNum_documento(String num_documento) {
        this.num_documento = num_documento;
    }




    public String getTelefono() {
        return telefono;
    }




    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }




    public String getNombre() {
        return nombre;
    }




    public void setNombre(String nombre) {
        this.nombre = nombre;
    }




    public String getNacionalidad() {
        return nacionalidad;
    }




    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }




    public String getDireccion_fisica() {
        return direccion_fisica;
    }




    public void setDireccion_fisica(String direccion_fisica) {
        this.direccion_fisica = direccion_fisica;
    }




    public String getDireccion_electronica() {
        return direccion_electronica;
    }




    public void setDireccion_electronica(String direccion_electronica) {
        this.direccion_electronica = direccion_electronica;
    }




    public String getDepartamento() {
        return departamento;
    }




    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }




    public String getCodigo_postal() {
        return codigo_postal;
    }




    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }




    public String getCiudad() {
        return ciudad;
    }




    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }




    public TipoDocumento getTipo_documento() {
        return tipo_documento;
    }




    public void setTipo_documento(TipoDocumento tipo_documento) {
        this.tipo_documento = tipo_documento;
    }




    public ClienteEntity() {
        ;
    }


    public enum TipoDocumento {
        CC,
        NIT
    }

    
    
}
