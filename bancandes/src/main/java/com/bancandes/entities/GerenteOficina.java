package com.bancandes.entities;

import jakarta.persistence.Entity;

@Entity
public class GerenteOficina extends PersonaEntity {


    public GerenteOficina(String num_documento, String telefono, String nombre, String nacionalidad,
    String direccion_fisica, String direccion_electronica, String departamento, String codigo_postal,
    String ciudad, TipoDocumento tipo_documento) {
        super(num_documento, telefono, nombre, nacionalidad, direccion_fisica, direccion_electronica, departamento,
        codigo_postal, ciudad, tipo_documento);
   
    }

    public GerenteOficina() {
        ;
    }

    
    
}
