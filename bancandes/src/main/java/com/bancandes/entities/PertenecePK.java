package com.bancandes.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Embeddable
public class PertenecePK implements Serializable {

    @ManyToOne
    @JoinColumn(name="id_punto_atencion", referencedColumnName = "id_punto_atencion")
    private PuntoAtencionEntity id_punto_atencion;

    @ManyToOne
    @JoinColumn(name="id_oficina", referencedColumnName = "id_oficina")
    private OficinaEntity id_oficina;


    public PertenecePK(PuntoAtencionEntity id_punto_atencion, OficinaEntity id_oficina) {
        super();
        this.id_punto_atencion = id_punto_atencion;
        this.id_oficina = id_oficina;
    }


    public PuntoAtencionEntity getId_punto_atencion() {
        return id_punto_atencion;
    }


    public void setId_punto_atencion(PuntoAtencionEntity id_punto_atencion) {
        this.id_punto_atencion = id_punto_atencion;
    }


    public OficinaEntity getId_oficina() {
        return id_oficina;
    }


    public void setId_oficina(OficinaEntity id_oficina) {
        this.id_oficina = id_oficina;
    }

    

    
    
}
