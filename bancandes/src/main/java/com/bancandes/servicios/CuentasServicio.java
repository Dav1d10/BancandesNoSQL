package com.bancandes.servicios;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.bancandes.entities.CuentaEntity;
import com.bancandes.entities.CuentaEntity.EstadoCuenta;
import com.bancandes.entities.CuentaEntity.TipoCuenta;
import com.bancandes.entities.OperacionBancariaEntity.Producto;
import com.bancandes.entities.OperacionBancariaEntity.Tipo;
import com.bancandes.exceptions.SaldoInsuficienteException;
import com.bancandes.repository.CuentaRepository;
import com.bancandes.repository.OperacionBancariaRepository;

@Service
public class CuentasServicio {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private OperacionesbancariasServicio operacionesbancariasServicio;

    private Random random = new Random();

    //private HaceRepository haceRepository;


    public CuentaEntity insertarCuenta(Integer numero_cuenta, Integer saldo, Date fechaUltimaTransaccion, Date fechaCreacion, TipoCuenta tipoCuenta, EstadoCuenta estadoCuenta) {
        System.out.println("Insertando cuenta: " + numero_cuenta + ", " + saldo + ", " + fechaUltimaTransaccion + ", " + fechaCreacion + ", " + tipoCuenta + ", " + estadoCuenta);
        CuentaEntity nuevaCuenta = new CuentaEntity(numero_cuenta, saldo, fechaUltimaTransaccion, fechaCreacion, tipoCuenta, estadoCuenta);
        return cuentaRepository.save(nuevaCuenta);
    }


    public void actualizarCuenta(int numero_cuenta, int saldo, Date fechaUltimaTransaccion, Date fechaCreacion, TipoCuenta tipoCuenta, EstadoCuenta estadoCuenta) {
        cuentaRepository.actualizarCuenta(numero_cuenta, saldo, fechaUltimaTransaccion, fechaCreacion, tipoCuenta, estadoCuenta);
    }


    public void actualizarEstadoCuenta(int numero_cuenta, EstadoCuenta nuevoEstado) {
        cuentaRepository.actualizarEstadoCuenta(numero_cuenta, nuevoEstado);
    }


    @Transactional
    public void consignacionCuenta(int numero_cuenta, int cantidad_consignacion) {
        int id = random.nextInt(Integer.MAX_VALUE);
        LocalDate fechaActual = LocalDate.now();
        LocalTime horaActual = LocalTime.now();
        LocalDateTime fechaHoraActual = LocalDateTime.of(fechaActual, horaActual);
        Date fecha = Date.from(fechaHoraActual.atZone(ZoneId.systemDefault()).toInstant());
        CuentaEntity cuentaActual = cuentaRepository.darCuenta(numero_cuenta);
        cuentaRepository.actualizarCuenta(numero_cuenta, cuentaActual.getSaldo() + cantidad_consignacion, cuentaActual.getFecha_ultima_transaccion(), cuentaActual.getFecha_creacion(), cuentaActual.getTipo_cuenta(), cuentaActual.getEstado_cuenta());
        operacionesbancariasServicio.insertarOperacionBancaria(id, cantidad_consignacion, horaActual.format(DateTimeFormatter.ofPattern("HH:mm:ss")), fecha, Producto.CUENTA, Tipo.CONSIGNACION);
    }


    @Transactional
    public void retiroCuenta(int numero_cuenta, int cantidad_retiro) {
        int id = random.nextInt(Integer.MAX_VALUE);
        LocalDate fechaActual = LocalDate.now();
        LocalTime horaActual = LocalTime.now();
        LocalDateTime fechaHoraActual = LocalDateTime.of(fechaActual, horaActual);
        Date fecha = Date.from(fechaHoraActual.atZone(ZoneId.systemDefault()).toInstant());
        CuentaEntity cuentaActual = cuentaRepository.darCuenta(numero_cuenta);
        cuentaRepository.actualizarCuenta(numero_cuenta, cuentaActual.getSaldo() - cantidad_retiro, cuentaActual.getFecha_ultima_transaccion(), cuentaActual.getFecha_creacion(), cuentaActual.getTipo_cuenta(), cuentaActual.getEstado_cuenta());
        operacionesbancariasServicio.insertarOperacionBancaria(id, cantidad_retiro, horaActual.format(DateTimeFormatter.ofPattern("HH:mm:ss")), fecha, Producto.CUENTA, Tipo.RETIRO);
    }


    @Transactional
    public void transferenciaCuentas(int numero_cuenta_origen, int numero_cuenta_destino, int cantidad_transferencia) throws SaldoInsuficienteException {
        int id = random.nextInt(Integer.MAX_VALUE);
        LocalDate fechaActual = LocalDate.now();
        LocalTime horaActual = LocalTime.now();
        LocalDateTime fechaHoraActual = LocalDateTime.of(fechaActual, horaActual);
        Date fecha = Date.from(fechaHoraActual.atZone(ZoneId.systemDefault()).toInstant());
        CuentaEntity cuentaOrigen = cuentaRepository.darCuenta(numero_cuenta_origen);
        CuentaEntity cuentaDestino = cuentaRepository.darCuenta(numero_cuenta_destino);
        if (cuentaOrigen.getSaldo() >= cantidad_transferencia) {
            cuentaRepository.actualizarCuenta(numero_cuenta_origen, cuentaOrigen.getSaldo() - cantidad_transferencia, cuentaOrigen.getFecha_ultima_transaccion(), cuentaOrigen.getFecha_creacion(), cuentaOrigen.getTipo_cuenta(), cuentaOrigen.getEstado_cuenta());
            cuentaRepository.actualizarCuenta(numero_cuenta_destino, cuentaDestino.getSaldo() + cantidad_transferencia, cuentaDestino.getFecha_ultima_transaccion(), cuentaDestino.getFecha_creacion(), cuentaDestino.getTipo_cuenta(), cuentaDestino.getEstado_cuenta());
            operacionesbancariasServicio.insertarOperacionBancaria(id, cantidad_transferencia, horaActual.format(DateTimeFormatter.ofPattern("HH:mm:ss")), fecha, Producto.CUENTA, Tipo.TRANSFERENCIA);
        } else {
            throw new SaldoInsuficienteException("No hay suficiente saldo en la cuenta origen.");
        }
       
    }

     
    /* 
    public CuentasServicio(CuentaRepository cuentaRepository, OperacionBancariaRepository operacionBancariaRepository, HaceRepository haceRepository) {
        this.cuentaRepository = cuentaRepository;
        this.operacionBancariaRepository = operacionBancariaRepository;
        this.haceRepository = haceRepository;
    }
    */

    /* 
    @Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
    public void consignacionCuentaSerializable(int numero_cuenta, int cantidad_consignacion) {
        try {
            LocalDate fechaActual = LocalDate.now();
            LocalTime horaActual = LocalTime.now();
            Date fechaSql = Date.valueOf(fechaActual);
            CuentaEntity cuentaActual = cuentaRepository.darCuenta(numero_cuenta);
            cuentaRepository.actualizarCuenta(numero_cuenta, cuentaActual.getSaldo() + cantidad_consignacion, cuentaActual.getFecha_ultima_transaccion(), cuentaActual.getFecha_creacion(), cuentaActual.getTipo_cuenta().name(), cuentaActual.getEstado_cuenta().name());
            operacionBancariaRepository.insertarOperacionBancaria(cantidad_consignacion, horaActual.format(DateTimeFormatter.ofPattern("HH:mm:ss")), fechaSql, "CUENTA", "CONSIGNACION");
            int idOperacionBancaria = operacionBancariaRepository.obtenerUltimoId();
            haceRepository.insertarHace(numero_cuenta, idOperacionBancaria);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    */
    

    /* 
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public void consignacionCuentaReadCommited(int numero_cuenta, int cantidad_consignacion) {
        try {
            LocalDate fechaActual = LocalDate.now();
            LocalTime horaActual = LocalTime.now();
            Date fechaSql = Date.valueOf(fechaActual);
            CuentaEntity cuentaActual = cuentaRepository.darCuenta(numero_cuenta);
            cuentaRepository.actualizarCuenta(numero_cuenta, cuentaActual.getSaldo() + cantidad_consignacion, cuentaActual.getFecha_ultima_transaccion(), cuentaActual.getFecha_creacion(), cuentaActual.getTipo_cuenta().name(), cuentaActual.getEstado_cuenta().name());
            operacionBancariaRepository.insertarOperacionBancaria(cantidad_consignacion, horaActual.format(DateTimeFormatter.ofPattern("HH:mm:ss")), fechaSql, "CUENTA", "CONSIGNACION");
            int idOperacionBancaria = operacionBancariaRepository.obtenerUltimoId();
            haceRepository.insertarHace(numero_cuenta, idOperacionBancaria);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    */

    /* 
    @Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
    public void retiroCuentaSerializable(int numero_cuenta, int cantidad_consignacion) {
        try {
            LocalDate fechaActual = LocalDate.now();
            LocalTime horaActual = LocalTime.now();
            Date fechaSql = Date.valueOf(fechaActual);
            CuentaEntity cuentaActual = cuentaRepository.darCuenta(numero_cuenta);
            cuentaRepository.actualizarCuenta(numero_cuenta, cuentaActual.getSaldo() - cantidad_consignacion, cuentaActual.getFecha_ultima_transaccion(), cuentaActual.getFecha_creacion(), cuentaActual.getTipo_cuenta().name(), cuentaActual.getEstado_cuenta().name());
            operacionBancariaRepository.insertarOperacionBancaria(cantidad_consignacion, horaActual.format(DateTimeFormatter.ofPattern("HH:mm:ss")), fechaSql, "CUENTA", "RETIRO");
            int idOperacionBancaria = operacionBancariaRepository.obtenerUltimoId();
            haceRepository.insertarHace(numero_cuenta, idOperacionBancaria);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    */

    /* 
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public void retiroCuentaReadCommitted(int numero_cuenta, int cantidad_consignacion) {
        try {
            LocalDate fechaActual = LocalDate.now();
            LocalTime horaActual = LocalTime.now();
            Date fechaSql = Date.valueOf(fechaActual);
            CuentaEntity cuentaActual = cuentaRepository.darCuenta(numero_cuenta);
            cuentaRepository.actualizarCuenta(numero_cuenta, cuentaActual.getSaldo() - cantidad_consignacion, cuentaActual.getFecha_ultima_transaccion(), cuentaActual.getFecha_creacion(), cuentaActual.getTipo_cuenta().name(), cuentaActual.getEstado_cuenta().name());
            operacionBancariaRepository.insertarOperacionBancaria(cantidad_consignacion, horaActual.format(DateTimeFormatter.ofPattern("HH:mm:ss")), fechaSql, "CUENTA", "RETIRO");
            int idOperacionBancaria = operacionBancariaRepository.obtenerUltimoId();
            haceRepository.insertarHace(numero_cuenta, idOperacionBancaria);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    */

    /* 
    @Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
    public void transferenciaCuentasSerializable(int numero_cuenta_origen, int numero_cuenta_destino, int cantidad_transferencia) throws SaldoInsuficienteException {
        LocalDate fechaActual = LocalDate.now();
        LocalTime horaActual = LocalTime.now();
        Date fechaSql = Date.valueOf(fechaActual);
        CuentaEntity cuentaOrigen = cuentaRepository.darCuenta(numero_cuenta_origen);
        CuentaEntity cuentaDestino = cuentaRepository.darCuenta(numero_cuenta_destino);
        if (cuentaOrigen.getSaldo() >= cantidad_transferencia) {
            cuentaRepository.actualizarCuenta(numero_cuenta_origen, cuentaOrigen.getSaldo() - cantidad_transferencia, fechaSql, cuentaOrigen.getFecha_creacion(), cuentaOrigen.getTipo_cuenta().name(), cuentaOrigen.getEstado_cuenta().name());
            cuentaRepository.actualizarCuenta(numero_cuenta_destino, cuentaDestino.getSaldo() + cantidad_transferencia , fechaSql, cuentaDestino.getFecha_creacion(), cuentaDestino.getTipo_cuenta().name(), cuentaDestino.getEstado_cuenta().name());
            operacionBancariaRepository.insertarOperacionBancaria(cantidad_transferencia, horaActual.format(DateTimeFormatter.ofPattern("HH:mm:ss")), fechaSql, "CUENTA", "TRANSFERENCIA");
            operacionBancariaRepository.insertarOperacionBancaria(cantidad_transferencia, horaActual.format(DateTimeFormatter.ofPattern("HH:mm:ss")), fechaSql, "CUENTA", "CONSIGNACION");
        } else {
            throw new SaldoInsuficienteException("No hay suficiente saldo en la cuenta origen.");
        }
    }
    */

    /* 
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public void transferenciaCuentasReadCommitted(int numero_cuenta_origen, int numero_cuenta_destino, int cantidad_transferencia) throws SaldoInsuficienteException {
        LocalDate fechaActual = LocalDate.now();
        LocalTime horaActual = LocalTime.now();
        Date fechaSql = Date.valueOf(fechaActual);
        CuentaEntity cuentaOrigen = cuentaRepository.darCuenta(numero_cuenta_origen);
        CuentaEntity cuentaDestino = cuentaRepository.darCuenta(numero_cuenta_destino);
        if (cuentaOrigen.getSaldo() >= cantidad_transferencia) {
            cuentaRepository.actualizarCuenta(numero_cuenta_origen, cuentaOrigen.getSaldo() - cantidad_transferencia, fechaSql, cuentaOrigen.getFecha_creacion(), cuentaOrigen.getTipo_cuenta().name(), cuentaOrigen.getEstado_cuenta().name());
            cuentaRepository.actualizarCuenta(numero_cuenta_destino, cuentaDestino.getSaldo() + cantidad_transferencia , fechaSql, cuentaDestino.getFecha_creacion(), cuentaDestino.getTipo_cuenta().name(), cuentaDestino.getEstado_cuenta().name());
            operacionBancariaRepository.insertarOperacionBancaria(cantidad_transferencia, horaActual.format(DateTimeFormatter.ofPattern("HH:mm:ss")), fechaSql, "CUENTA", "TRANSFERENCIA");
            operacionBancariaRepository.insertarOperacionBancaria(cantidad_transferencia, horaActual.format(DateTimeFormatter.ofPattern("HH:mm:ss")), fechaSql, "CUENTA", "CONSIGNACION");
        } else {
            throw new SaldoInsuficienteException("No hay suficiente saldo en la cuenta origen.");
        }
    }
    */
    }


    

    
    

