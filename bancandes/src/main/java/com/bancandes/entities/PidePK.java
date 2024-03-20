package com.bancandes.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Embeddable
public class PidePK implements Serializable {
    
    @ManyToOne
    @JoinColumn(name="id_prestamo", referencedColumnName = "id_prestamo")
    private PrestamoEntity id_prestamo;

    @ManyToOne
    @JoinColumn(name="id_cliente", referencedColumnName = "id")
    private ClienteEntity id_cliente;


    public PidePK(PrestamoEntity id_prestamo, ClienteEntity id_cliente) {
        super();
        this.id_prestamo = id_prestamo;
        this.id_cliente = id_cliente;
    }


    public PrestamoEntity getId_prestamo() {
        return id_prestamo;
    }


    public void setId_prestamo(PrestamoEntity id_prestamo) {
        this.id_prestamo = id_prestamo;
    }


    public ClienteEntity getId_cliente() {
        return id_cliente;
    }


    public void setId_cliente(ClienteEntity id_cliente) {
        this.id_cliente = id_cliente;
    }

    

    

}
