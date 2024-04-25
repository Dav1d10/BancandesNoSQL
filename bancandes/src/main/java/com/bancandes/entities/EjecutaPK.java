package com.bancandes.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class EjecutaPK implements Serializable {

    @ManyToOne
    @JoinColumn(name="idOperacionBancaria", referencedColumnName = "id")
    private OperacionBancariaEntity idOperacionBancaria;

    @ManyToOne
    @JoinColumn(name="idCliente", referencedColumnName = "num_documento")
    private ClienteEntity idCliente;


    

    public EjecutaPK(OperacionBancariaEntity idOperacionBancaria, ClienteEntity idCliente) {
        super();
        this.idOperacionBancaria = idOperacionBancaria;
        this.idCliente = idCliente;
    }




    public OperacionBancariaEntity getIdOperacionBancaria() {
        return idOperacionBancaria;
    }




    public void setIdOperacionBancaria(OperacionBancariaEntity idOperacionBancaria) {
        this.idOperacionBancaria = idOperacionBancaria;
    }




    public ClienteEntity getIdCliente() {
        return idCliente;
    }




    public void setIdCliente(ClienteEntity idCliente) {
        this.idCliente = idCliente;
    }

    
}
