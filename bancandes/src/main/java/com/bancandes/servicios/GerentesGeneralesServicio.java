package com.bancandes.servicios;

import org.springframework.beans.factory.annotation.Autowired;

import com.bancandes.entities.GerenteGeneral;
import com.bancandes.entities.PersonaEntity.TipoDocumento;
import com.bancandes.repository.GerenteGeneralRepository;

public class GerentesGeneralesServicio {
    @Autowired
    private GerenteGeneralRepository gerenteGeneralRepository;
    public GerenteGeneral insertarGerenteGeneral(String num_documento, String telefono, String nombre, String nacionalidad,
    String direccion_fisica, String direccion_electronica, String departamento, String codigo_postal,
    String ciudad, TipoDocumento tipo_documento) {
        GerenteGeneral nuevoGerenteGeneral = new GerenteGeneral(num_documento, telefono, nombre, nacionalidad, direccion_fisica, direccion_electronica, departamento, codigo_postal, ciudad, tipo_documento);
        return gerenteGeneralRepository.save(nuevoGerenteGeneral);
    }
}
