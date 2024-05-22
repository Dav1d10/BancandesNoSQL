package com.bancandes.servicios;

import org.springframework.beans.factory.annotation.Autowired;

import com.bancandes.entities.CajeroEntity;
import com.bancandes.entities.PersonaEntity.TipoDocumento;
import com.bancandes.repository.CajeroRepository;

public class CajerosServicio {
    @Autowired
    private CajeroRepository cajeroRepository;
    public CajeroEntity insertarCliente(String num_documento, String telefono, String nombre, String nacionalidad,
    String direccion_fisica, String direccion_electronica, String departamento, String codigo_postal,
    String ciudad, TipoDocumento tipo_documento) {
        CajeroEntity nuevoCliente = new CajeroEntity(num_documento, telefono, nombre, nacionalidad, direccion_fisica, direccion_electronica, departamento, codigo_postal, ciudad, tipo_documento);
        return cajeroRepository.save(nuevoCliente);
    }
}


