package com.bancandes.servicios;

import org.springframework.beans.factory.annotation.Autowired;

import com.bancandes.entities.GerenteOficina;
import com.bancandes.entities.PersonaEntity.TipoDocumento;
import com.bancandes.repository.GerenteOficinaRepository;

public class GerentesOficinasServicio {
    @Autowired
    private GerenteOficinaRepository gerenteOficinaRepository;
    public GerenteOficina insertarGerenteOficina(String num_documento, String telefono, String nombre, String nacionalidad,
    String direccion_fisica, String direccion_electronica, String departamento, String codigo_postal,
    String ciudad, TipoDocumento tipo_documento) {
        GerenteOficina nuevoGerenteOficina = new GerenteOficina(num_documento, telefono, nombre, nacionalidad, direccion_fisica, direccion_electronica, departamento, codigo_postal, ciudad, tipo_documento);
        return gerenteOficinaRepository.save(nuevoGerenteOficina);
    }
}
