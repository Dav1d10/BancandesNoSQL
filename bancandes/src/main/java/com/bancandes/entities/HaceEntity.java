package com.bancandes.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="hace")
public class HaceEntity {
    @EmbeddedId
    private HacePK pk;
    public HaceEntity(OperacionBancariaEntity idOperacionBancariaEntity, CuentaEntity idCuentaEntity) {
        this.pk = new HacePK(idOperacionBancariaEntity, idCuentaEntity);
    }
    public HaceEntity() {
        ;
    }
}
