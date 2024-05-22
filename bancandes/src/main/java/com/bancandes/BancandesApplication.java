package com.bancandes;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.bancandes.entities.CuentaEntity;
import com.bancandes.entities.CuentaEntity.EstadoCuenta;
import com.bancandes.entities.CuentaEntity.TipoCuenta;
import com.bancandes.repository.CuentaRepository;
import com.bancandes.servicios.CuentasServicio;

@SpringBootApplication
@EnableMongoRepositories
public class BancandesApplication implements CommandLineRunner {


    @Autowired
    CuentaRepository cuentaRepository;

    @Autowired
    CuentasServicio cuentasServicio;
    public static void main( String[] args ) {
        SpringApplication.run(BancandesApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Bancandes fue inicializada correctamente...");
        //crearCuenta();
        mostrarCuentas();
    }

    void crearCuenta() {
        System.out.println("Creacion de cuentas empezada...");
        Date fecha = new Date();
        CuentaEntity nuevaCuenta = new CuentaEntity(32, 10, fecha, fecha, TipoCuenta.AHORROS, EstadoCuenta.ACTIVA);
        cuentaRepository.save(nuevaCuenta);
        System.out.println("Creacion de cuentas completada...");
    }

    void crearCuentas() {
        System.out.println("Creacion de cuentas empezada...");
        Date fecha = new Date();
        //cuentasServicio.insertarCuenta(1, 10, fecha, fecha, TipoCuenta.AHORROS, EstadoCuenta.ACTIVA);
        cuentasServicio.insertarCuenta(2, 10, fecha, fecha, TipoCuenta.AHORROS, EstadoCuenta.ACTIVA);
        cuentasServicio.insertarCuenta(3, 10, fecha, fecha, TipoCuenta.AHORROS, EstadoCuenta.ACTIVA);
        cuentasServicio.insertarCuenta(4, 10, fecha, fecha, TipoCuenta.CORRIENTE, EstadoCuenta.ACTIVA);
        cuentasServicio.insertarCuenta(5, 10, fecha, fecha, TipoCuenta.CORRIENTE, EstadoCuenta.ACTIVA);
        cuentasServicio.insertarCuenta(6, 10, fecha, fecha, TipoCuenta.CORRIENTE, EstadoCuenta.ACTIVA);
        cuentasServicio.insertarCuenta(7, 10, fecha, fecha, TipoCuenta.AFC, EstadoCuenta.ACTIVA);
        cuentasServicio.insertarCuenta(8, 10, fecha, fecha, TipoCuenta.AFC, EstadoCuenta.ACTIVA);
        cuentasServicio.insertarCuenta(9, 10, fecha, fecha, TipoCuenta.AFC, EstadoCuenta.ACTIVA);
        cuentasServicio.insertarCuenta(10, 10, fecha, fecha, TipoCuenta.AHORROS, EstadoCuenta.ACTIVA);
        System.out.println("Creacion de cuentas completada...");
    }

    public void mostrarCuentas() {
        System.out.println("Las cuentas almacenadas en la base de datos son las siguientes -> ");
        System.out.println("----------------------------------------------------------------");
        cuentaRepository.darCuentas().forEach(cuenta -> System.out.println(obtenerInfoCuentas(cuenta)));
    }

    public String obtenerInfoCuentas(CuentaEntity cuenta) {
        System.out.println(
            "Numero cuenta: " + cuenta.getNumero_cuenta() +
            ", \nSaldo: " + cuenta.getSaldo() +
            ", \nFecha de la ultima transaccion: " + cuenta.getFecha_ultima_transaccion() +
            ", \nFecha de creacion: " + cuenta.getFecha_creacion() +
            ", \nTipo de cuenta: " + cuenta.getTipo_cuenta() +
            ", \nEstado de cuenta: " + cuenta.getEstado_cuenta()
        );
        return "";
    }
    
}
