package com.bancandes.servicios;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.bancandes.entities.OperacionBancariaEntity;
import com.bancandes.repository.OperacionBancariaRepository;

@Service
public class OperacionesbancariasServicio {

    private OperacionBancariaRepository operacionBancariaRepository;

    public OperacionesbancariasServicio(OperacionBancariaRepository operacionBancariaRepository) {
        this.operacionBancariaRepository = operacionBancariaRepository;
    }

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

    
    
}
