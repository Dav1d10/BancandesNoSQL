package com.bancandes.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="ejecuta")
public class EjecutaEntity {
    @EmbeddedId
    private EjecutaPK pk;
    public EjecutaEntity(OperacionBancariaEntity idOperacionBancariaEntity, ClienteEntity idClienteEntity) {
        this.pk = new EjecutaPK(idOperacionBancariaEntity, idClienteEntity);
    }
    public EjecutaEntity() {
        ;
    }
}
