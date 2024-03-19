package com.bancandes.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="pide")
public class PideEntity {
    
    @EmbeddedId
    private PidePK pk;


    public PideEntity(PrestamoEntity id_prestamo, ClienteEntity id_cliente) {
        this.pk = new PidePK(id_prestamo, id_cliente);
    }

    public PideEntity() {
        ;
    }

    public PidePK getPk() {
        return pk;
    }

    public void setPk(PidePK pk) {
        this.pk = pk;
    }

    

    
}
