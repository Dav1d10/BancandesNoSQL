package com.bancandes.Entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Embeddable
public class TienePK implements Serializable {

    @ManyToOne
    @JoinColumn(name="numero_cuenta", referencedColumnName = "id")
    private CuentaEntity numero_cuenta;

    @OneToMany
    @JoinColumn(name="id_cliente", referencedColumnName = "id")
    private ClienteEntity id_cliente;
    
}
