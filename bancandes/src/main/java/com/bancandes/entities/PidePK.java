package com.bancandes.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Embeddable
public class PidePK implements Serializable {
    
    @ManyToOne
    @JoinColumn(name="id_prestamo", referencedColumnName = "id")
    private PrestamoEntity id_prestamo;

    @OneToMany
    @JoinColumn(name="id_cliente", referencedColumnName = "id")
    private ClienteEntity id_cliente;

}
