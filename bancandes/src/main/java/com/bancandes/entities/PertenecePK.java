package com.bancandes.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Embeddable
public class PertenecePK implements Serializable {

    @ManyToOne
    @JoinColumn(name="id_cuenta", referencedColumnName = "numero_cuenta")
    private CuentaEntity id_cuenta;

    @ManyToOne
    @JoinColumn(name="id_oficina", referencedColumnName = "id_oficina")
    private OficinaEntity id_oficina;


    public PertenecePK(CuentaEntity id_cuenta, OficinaEntity id_oficina) {
        super();
        this.id_cuenta = id_cuenta;
        this.id_oficina = id_oficina;
    }


    public CuentaEntity getId_cuenta() {
        return id_cuenta;
    }


    public void setId_cuenta(CuentaEntity id_cuenta) {
        this.id_cuenta = id_cuenta;
    }


    public OficinaEntity getId_oficina() {
        return id_oficina;
    }


    public void setId_oficina(OficinaEntity id_oficina) {
        this.id_oficina = id_oficina;
    }

    

    
    
}
