package com.bancandes.entities;

public class GerenteOficina extends PersonaEntity{
    private int id_oficina;

    public GerenteOficina(Integer numDocumento, String telefono, String nombre, String nacionalidad,
            String direccionFisica, String direccionElectronica, String departamento, String codigoPostal,
            String ciudad, com.bancandes.entities.TipoDocumento tipoDocumento, int id_oficina) {
        super(numDocumento, telefono, nombre, nacionalidad, direccionFisica, direccionElectronica, departamento,
                codigoPostal, ciudad, tipoDocumento);
        this.id_oficina = id_oficina;
    }

    public int getId_oficina() {
        return id_oficina;
    }

    public void setId_oficina(int id_oficina) {
        this.id_oficina = id_oficina;
    }
    
}
