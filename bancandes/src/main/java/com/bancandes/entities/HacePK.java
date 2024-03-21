package com.bancandes.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Embeddable
public class HacePK implements Serializable{
    @ManyToOne
    @JoinColumn(name="idOperacionBancaria", referencedColumnName = "id")
    private OperacionBancariaEntity idOperacionBancaria;

    @ManyToOne
    @JoinColumn(name="idCuenta", referencedColumnName = "numDocumento")
    private CuentaEntity idCuenta;


    

    public HacePK(OperacionBancariaEntity idOperacionBancaria, CuentaEntity idCuenta) {
        super();
        this.idOperacionBancaria = idOperacionBancaria;
        this.idCuenta = idCuenta;
    }




    public OperacionBancariaEntity getIdOperacionBancaria() {
        return idOperacionBancaria;
    }




    public void setIdOperacionBancaria(OperacionBancariaEntity idOperacionBancaria) {
        this.idOperacionBancaria = idOperacionBancaria;
    }




    public CuentaEntity getIdCuenta() {
        return idCuenta;
    }




    public void setIdCuenta(CuentaEntity idCuenta) {
        this.idCuenta = idCuenta;
    }
    
}
