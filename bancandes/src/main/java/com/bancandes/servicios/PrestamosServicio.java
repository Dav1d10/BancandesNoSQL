package com.bancandes.servicios;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.bancandes.entities.PrestamoEntity;
import com.bancandes.repository.OperacionPrestamoRepository;
import com.bancandes.repository.PrestamoRepository;

@Service
public class PrestamosServicio {

    private PrestamoRepository prestamoRepository;

    private OperacionPrestamoRepository operacionPrestamoRepository;


    public PrestamosServicio(PrestamoRepository prestamoRepository,
            OperacionPrestamoRepository operacionPrestamoRepository) {
        this.prestamoRepository = prestamoRepository;
        this.operacionPrestamoRepository = operacionPrestamoRepository;
    }

    public void pagoMensual(int numero_prestamo, int cantidad_pago) {
        try {
            LocalDate fechaActual = LocalDate.now();
            Date fechaSql = Date.valueOf(fechaActual);
            PrestamoEntity prestamoActual = prestamoRepository.darPrestamo(numero_prestamo);
            prestamoRepository.actualizarPrestamo(numero_prestamo, prestamoActual.getMonto() - cantidad_pago, prestamoActual.getInteres(), prestamoActual.getNumero_cuotas() - 1, fechaSql, prestamoActual.getValor_cuota(), prestamoActual.getEstado_prestamo().name(), prestamoActual.getCategoria().name());
            operacionPrestamoRepository.insertarOperacionPrestamo(cantidad_pago, fechaSql, numero_prestamo, "PAGO_ORDINARIO", "PAGO_DE_LA_CUOTA_MENSUAL");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void pagoExtraordinario(int numero_prestamo, int cantidad_pago) {
        try {
            LocalDate fechaActual = LocalDate.now();
            Date fechaSql = Date.valueOf(fechaActual);
            PrestamoEntity prestamoActual = prestamoRepository.darPrestamo(numero_prestamo);
            prestamoRepository.actualizarPrestamo(numero_prestamo, prestamoActual.getMonto() - cantidad_pago, prestamoActual.getInteres(), prestamoActual.getNumero_cuotas(), fechaSql, prestamoActual.getValor_cuota(), prestamoActual.getEstado_prestamo().name(), prestamoActual.getCategoria().name());
            operacionPrestamoRepository.insertarOperacionPrestamo(cantidad_pago, fechaSql, numero_prestamo, "PAGO_EXTRAORDINARIO", "PAGO_DE_LA_CUOTA_EXTRAORDINARIA");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    
    
}
