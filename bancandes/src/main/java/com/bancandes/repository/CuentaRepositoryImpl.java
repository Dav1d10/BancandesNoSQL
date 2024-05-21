package com.bancandes.repository;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.bancandes.entities.CuentaEntity;

@Component
public class CuentaRepositoryImpl implements CuentaRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void actualizarCuenta(int numeroCuenta, int saldo, Date fechaUltimaTransaccion, Date fechaCreacion, String tipoCuenta, String estadoCuenta) {
        Query query = new Query(Criteria.where("numero_cuenta").is(numeroCuenta));
        Update update = new Update()
                .set("saldo", saldo)
                .set("fecha_ultima_transaccion", fechaUltimaTransaccion)
                .set("fecha_creacion", fechaCreacion)
                .set("tipo_cuenta", tipoCuenta)
                .set("estado_cuenta", estadoCuenta);
        mongoTemplate.updateFirst(query, update, CuentaEntity.class);
    }
    
}
