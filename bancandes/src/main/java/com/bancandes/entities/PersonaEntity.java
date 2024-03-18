package com.bancandes.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;


@Entity
@Table(name="personas")
public class PersonaEntity {
    private int numDocumento;
    private int telefono;
    private String nombre;
    private String nacionalidad;
    private String direccionFisica;
    private String direccionElectronica;
    private String departamento;
    private String codigoPostal;
    private String ciudad;
    @Enumerated(EnumType.STRING)
    private TipoDocumento TipoDocumento;
}
enum TipoDocumento {
    CC,
    NIT
}