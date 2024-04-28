package com.bancandes.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Embeddable
public class HacePK implements Serializable{

    @ManyToOne
    @JoinColumn(name="id_cuenta", referencedColumnName = "numero_cuenta")
    private CuentaEntity id_cuenta;

    @ManyToOne
    @JoinColumn(name="id_operacionbancaria", referencedColumnName = "id")
    private OperacionBancariaEntity id_operacionbancaria;


    public HacePK(OperacionBancariaEntity id_operacionbancaria, CuentaEntity id_cuenta) {
        super();
        this.id_operacionbancaria = id_operacionbancaria;
        this.id_cuenta = id_cuenta;
    }


    public CuentaEntity getId_cuenta() {
        return id_cuenta;
    }


    public void setId_cuenta(CuentaEntity id_cuenta) {
        this.id_cuenta = id_cuenta;
    }


    public OperacionBancariaEntity getId_operacionbancaria() {
        return id_operacionbancaria;
    }


    public void setId_operacionbancaria(OperacionBancariaEntity id_operacionbancaria) {
        this.id_operacionbancaria = id_operacionbancaria;
    }


    
    
}
