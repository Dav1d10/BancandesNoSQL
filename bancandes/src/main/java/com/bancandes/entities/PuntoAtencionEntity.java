package com.bancandes.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "puntos_de_atencion")
public class PuntoAtencionEntity {

    @Id
    private Integer id_punto_atencion;
    private String localizacion;
    private TipoPuntoAtencion tipo_punto_atencion;

    public PuntoAtencionEntity(Integer id_punto_atencion, String localizacion, TipoPuntoAtencion tipo_punto_atencion) {
        this.id_punto_atencion = id_punto_atencion;
        this.localizacion = localizacion;
        this.tipo_punto_atencion = tipo_punto_atencion;
    }

    public PuntoAtencionEntity()
    {;}

    public Integer getId_punto_atencion() {
        return id_punto_atencion;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public TipoPuntoAtencion getTipo_punto_atencion() {
        return tipo_punto_atencion;
    }

    public void setTipo_punto_atencion(TipoPuntoAtencion tipo_punto_atencion) {
        this.tipo_punto_atencion = tipo_punto_atencion;
    }

    
    public enum TipoPuntoAtencion {
        ATENCION_PERSONALIZADA,
        CAJERO_AUTOMATICO,
        PUNTO_DE_ATENCION_DIGITAL
    }
}
