package com.bancandes.entities;

public class GerenteGeneral extends PersonaEntity{
    public GerenteGeneral(Integer numDocumento, String telefono, String nombre, String nacionalidad,
            String direccionFisica, String direccionElectronica, String departamento, String codigoPostal,
            String ciudad, com.bancandes.entities.TipoDocumento tipoDocumento, int id) {
        super(numDocumento, telefono, nombre, nacionalidad, direccionFisica, direccionElectronica, departamento,
                codigoPostal, ciudad, tipoDocumento);
    }
}
