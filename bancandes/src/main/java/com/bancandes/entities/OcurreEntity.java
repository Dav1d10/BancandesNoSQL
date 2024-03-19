package com.bancandes.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="ocurre")
public class OcurreEntity {
    @EmbeddedId
    private OcurrePK pk;
    public OcurreEntity(OperacionBancariaEntity idOperacionBancariaEntity, PuntoAtencionEntity idPuntoAtencionEntity) {
        this.pk = new OcurrePK(idOperacionBancariaEntity, idPuntoAtencionEntity);
    }
    public OcurreEntity() {
        ;
    }
    public OcurrePK getPk() {
        return pk;
    }
    public void setPk(OcurrePK pk) {
        this.pk = pk;
    }

    
}
