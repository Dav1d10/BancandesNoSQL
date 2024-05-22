package com.bancandes.servicios;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancandes.entities.CuentaEntity;
import com.bancandes.entities.CuentaEntity.EstadoCuenta;
import com.bancandes.entities.CuentaEntity.TipoCuenta;
import com.bancandes.entities.OficinaEntity;
import com.bancandes.repository.OficinaRepository;

@Service
public class OficinasServicio {

    @Autowired
    private OficinaRepository oficinaRepository;

    public OficinaEntity insertarOficina(Integer id_oficina, String nombre, String direccion, Integer puntos_atencion) {
        OficinaEntity nuevaOficina = new OficinaEntity(id_oficina, nombre, direccion, puntos_atencion);
        return oficinaRepository.save(nuevaOficina);
    }
    
}
