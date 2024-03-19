package com.bancandes.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="tiene")
public class TieneEntity {

    @EmbeddedId
    private TienePK pk;

    public TieneEntity(CuentaEntity numero_cuenta, ClienteEntity id_cliente) {
        this.pk = new TienePK(numero_cuenta, id_cliente);
    }

    public TieneEntity() {
        ;
    }

    public TienePK getPk() {
        return pk;
    }

    public void setPk(TienePK pk) {
        this.pk = pk;
    }

    
}
