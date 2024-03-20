package com.bancandes.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Embeddable
public class TienePK implements Serializable {

    @ManyToOne
    @JoinColumn(name="numero_cuenta", referencedColumnName = "numero_cuenta")
    private CuentaEntity numero_cuenta;

    @ManyToOne
    @JoinColumn(name="id_cliente", referencedColumnName = "id")
    private ClienteEntity id_cliente;

    public TienePK(CuentaEntity numero_cuenta, ClienteEntity id_cliente) {
        super();
        this.numero_cuenta = numero_cuenta;
        this.id_cliente = id_cliente;
    }

    public CuentaEntity getNumero_cuenta() {
        return numero_cuenta;
    }

    public ClienteEntity getId_cliente() {
        return id_cliente;
    }

    public void setNumero_cuenta(CuentaEntity numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    public void setId_cliente(ClienteEntity id_cliente) {
        this.id_cliente = id_cliente;
    }

    

    
    
}
