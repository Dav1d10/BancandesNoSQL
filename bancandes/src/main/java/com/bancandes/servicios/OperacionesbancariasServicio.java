package com.bancandes.servicios;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.bancandes.entities.OficinaEntity;
import com.bancandes.entities.OperacionBancariaEntity;
import com.bancandes.repository.OperacionBancariaRepository;

@Service
public class OperacionesbancariasServicio {

    @Autowired
    private OperacionBancariaRepository operacionBancariaRepository;

    public OperacionBancariaEntity insertarOperacionBancaria(int id, int valor, String hora, Date fecha, OperacionBancariaEntity.Producto producto, OperacionBancariaEntity.Tipo tipo) {
        OperacionBancariaEntity nuevaOperacionBancaria = new OperacionBancariaEntity(id, valor, hora, fecha, producto, tipo);
        return operacionBancariaRepository.save(nuevaOperacionBancaria);
    }

    

    /* 
    @Transactional(isolation = Isolation.SERIALIZABLE, readOnly = true, rollbackFor = Exception.class)
    public Collection<OperacionBancariaEntity> darOperacionesBancariasPorCuentaEnLosUltimos30Dias(int numero_cuenta) {
        Collection<OperacionBancariaEntity> operacionesBancarias = null;
        try {
            operacionesBancarias = operacionBancariaRepository.darOperacionesBancariasPorCuentaEnLosUltimos30Dias(numero_cuenta);
            Thread.sleep(30000);
        } catch (Exception e) {
            System.out.println("Se realizo rollback dado que la operacion fallo");
        }
        return operacionesBancarias;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true, rollbackFor = Exception.class)
    public Collection<OperacionBancariaEntity> darOperacionesBancariasPorCuentaEnLosUltimos30DiasReadCommitted(int numero_cuenta) {
        Collection<OperacionBancariaEntity> operacionesBancarias = null;
        try {
            operacionesBancarias = operacionBancariaRepository.darOperacionesBancariasPorCuentaEnLosUltimos30Dias(numero_cuenta);
            Thread.sleep(30000);
        } catch (Exception e) {
            System.out.println("Se realizo rollback dado que la operacion fallo");
        }
        return operacionesBancarias;
    }
    */
    
    
}
