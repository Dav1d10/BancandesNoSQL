package com.bancandes.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="puntos_de_atencion")
public class PuntoAtencionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id_punto_atencion;
    private String localizacion;
    @Enumerated(EnumType.STRING)
    private TipoPuntoAtencion tipo_punto_atencion;

    public PuntoAtencionEntity(Integer id_punto_atencion, String localizacion, TipoPuntoAtencion tipo_punto_atencion,
            Integer id_op_bancaria) {
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
