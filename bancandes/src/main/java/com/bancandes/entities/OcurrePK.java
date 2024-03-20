package com.bancandes.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



@Embeddable
public class OcurrePK implements Serializable{
    @ManyToOne
    @JoinColumn(name="idOperacionBancaria", referencedColumnName = "id")
    private OperacionBancariaEntity idOperacionBancaria;

    @ManyToOne
    @JoinColumn(name="idPuntoAtencion", referencedColumnName = "id_punto_atencion")
    private PuntoAtencionEntity idPuntoAtencion;


    

    public OcurrePK(OperacionBancariaEntity idOperacionBancaria, PuntoAtencionEntity idPuntoAtencion) {
        super();
        this.idOperacionBancaria = idOperacionBancaria;
        this.idPuntoAtencion = idPuntoAtencion;
    }

    public OperacionBancariaEntity getIdOperacionBancaria() {
        return idOperacionBancaria;
    }

    public void setIdOperacionBancaria(OperacionBancariaEntity idOperacionBancaria) {
        this.idOperacionBancaria = idOperacionBancaria;
    }

    public PuntoAtencionEntity getIdPuntoAtencion() {
        return idPuntoAtencion;
    }

    public void setIdPuntoAtencion(PuntoAtencionEntity idPuntoAtencion) {
        this.idPuntoAtencion = idPuntoAtencion;
    }
 
    
    
}
