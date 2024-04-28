package com.bancandes.entities;

import java.io.Serializable;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class ManejaPK implements Serializable {

    @OneToOne
    @JoinColumn(name="id_gerenteoficina", referencedColumnName = "num_documento")
    private GerenteOficina id_gerenteoficina;

    @OneToOne
    @JoinColumn(name="id_oficina", referencedColumnName = "id_oficina")
    private OficinaEntity id_oficina;


    public ManejaPK(GerenteOficina id_gerenteoficina, OficinaEntity id_oficina) {
        super();
        this.id_gerenteoficina = id_gerenteoficina;
        this.id_oficina = id_oficina;
    }


    public GerenteOficina getId_gerenteoficina() {
        return id_gerenteoficina;
    }


    public void setId_gerenteoficina(GerenteOficina id_gerenteoficina) {
        this.id_gerenteoficina = id_gerenteoficina;
    }


    public OficinaEntity getId_oficina() {
        return id_oficina;
    }


    public void setId_oficina(OficinaEntity id_oficina) {
        this.id_oficina = id_oficina;
    }

}
