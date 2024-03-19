package com.bancandes.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="pertenece")
public class PerteneceEntity {

    @EmbeddedId
    private PertenecePK pk;

    public PerteneceEntity(PuntoAtencionEntity id_punto_atencion, OficinaEntity id_oficina) {
        this.pk = new PertenecePK(id_punto_atencion, id_oficina);
    }

    public PerteneceEntity() {
        ;
    }

    public PertenecePK getPk() {
        return pk;
    }

    public void setPk(PertenecePK pk) {
        this.pk = pk;
    }

    
    
}