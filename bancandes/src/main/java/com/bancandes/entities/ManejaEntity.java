package com.bancandes.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="maneja")
public class ManejaEntity {
    
    @EmbeddedId
    private ManejaPK pk;
    public ManejaEntity(GerenteOficina idGerenteOficina, OficinaEntity idOficinaEntity) {
        this.pk = new ManejaPK(idGerenteOficina, idOficinaEntity);
    }
    public ManejaEntity() {
        ;
    }
    public ManejaPK getPk() {
        return pk;
    }

    public void setPk(ManejaPK pk) {
        this.pk = pk;
    }

}
