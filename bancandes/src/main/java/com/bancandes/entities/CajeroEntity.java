package com.bancandes.entities;

public class CajeroEntity extends PersonaEntity{
    public CajeroEntity(Integer numDocumento, String telefono, String nombre, String nacionalidad,
            String direccionFisica, String direccionElectronica, String departamento, String codigoPostal,
            String ciudad, com.bancandes.entities.TipoDocumento tipoDocumento) {
        super(numDocumento, telefono, nombre, nacionalidad, direccionFisica, direccionElectronica, departamento,
                codigoPostal, ciudad, tipoDocumento);
    }

}
