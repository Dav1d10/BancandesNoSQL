package com.bancandes.servicios;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bancandes.entities.PuntoAtencionEntity;
import com.bancandes.repository.PuntoAtencionRepository;

@Service
public class PuntosAtencionServicio {

    @Autowired
    private PuntoAtencionRepository puntoAtencionRepository;

    public PuntoAtencionEntity insertarPuntoAtencion(Integer id_punto_atencion, String localizacion, PuntoAtencionEntity.TipoPuntoAtencion tipo_punto_atencion) {
        PuntoAtencionEntity nuevaPuntoAtencion = new PuntoAtencionEntity(id_punto_atencion, localizacion, tipo_punto_atencion);
        return puntoAtencionRepository.save(nuevaPuntoAtencion);
    }

    @Transactional
    public void eliminarPuntoAtencion(int id_punto_atencion) {
        puntoAtencionRepository.eliminarPuntoAtencion(id_punto_atencion);
    }
    
}
