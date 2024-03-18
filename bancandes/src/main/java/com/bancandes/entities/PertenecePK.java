package com.bancandes.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Embeddable
public class PertenecePK implements Serializable {

    @ManyToOne
    @JoinColumn(name="id_punto_de_atencion", referencedColumnName = "id")
    private PuntoAtencionEntity id_punto_atencion;

    @OneToMany
    @JoinColumn(name="id_oficina", referencedColumnName = "id")
    private OficinaEntity id_oficina;
    
}
