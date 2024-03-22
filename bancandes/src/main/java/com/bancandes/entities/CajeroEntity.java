package com.bancandes.entities;

import jakarta.persistence.Entity;


@Entity
public class CajeroEntity extends PersonaEntity{

    public CajeroEntity(Integer numDocumento, String telefono, String nombre, String nacionalidad,
            String direccionFisica, String direccionElectronica, String departamento, String codigoPostal,
            String ciudad, TipoDocumento tipoDocumento) {
        super(numDocumento, telefono, nombre, nacionalidad, direccionFisica, direccionElectronica, departamento,
                codigoPostal, ciudad, tipoDocumento);
    }

    public CajeroEntity() {
        ;
    }

}
