package com.bancandes;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.bancandes.entities.CuentaEntity;
import com.bancandes.entities.OficinaEntity;
import com.bancandes.entities.OperacionBancariaEntity;
import com.bancandes.entities.PuntoAtencionEntity;
import com.bancandes.entities.CuentaEntity.EstadoCuenta;
import com.bancandes.entities.CuentaEntity.TipoCuenta;
import com.bancandes.entities.OperacionBancariaEntity.Producto;
import com.bancandes.entities.OperacionBancariaEntity.Tipo;
import com.bancandes.entities.PuntoAtencionEntity.TipoPuntoAtencion;
import com.bancandes.repository.CuentaRepository;
import com.bancandes.repository.OficinaRepository;
import com.bancandes.repository.OperacionBancariaRepository;
import com.bancandes.repository.PuntoAtencionRepository;
import com.bancandes.servicios.CuentasServicio;
import com.bancandes.servicios.OficinasServicio;
import com.bancandes.servicios.OperacionesbancariasServicio;
import com.bancandes.servicios.PuntosAtencionServicio;

@SpringBootApplication
@EnableMongoRepositories
public class BancandesApplication implements CommandLineRunner {


    @Autowired
    CuentaRepository cuentaRepository;

    @Autowired
    OficinaRepository oficinaRepository;

    @Autowired
    PuntoAtencionRepository puntoAtencionRepository;

    @Autowired
    OperacionBancariaRepository operacionBancariaRepository;

    @Autowired
    CuentasServicio cuentasServicio;

    @Autowired
    OficinasServicio oficinasServicio;

    @Autowired
    PuntosAtencionServicio puntosAtencionServicio;

    @Autowired
    OperacionesbancariasServicio operacionesbancariasServicio;
    public static void main( String[] args ) {
        SpringApplication.run(BancandesApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Bancandes fue inicializada correctamente...");
        poblacionColecciones();
        //crearCuenta();
        //mostrarCuentas();
    }

    void crearCuenta() {
        System.out.println("Creacion de cuentas empezada...");
        Date fecha = new Date();
        CuentaEntity nuevaCuenta = new CuentaEntity(32, 10, fecha, fecha, TipoCuenta.AHORROS, EstadoCuenta.ACTIVA);
        cuentaRepository.save(nuevaCuenta);
        System.out.println("Creacion de cuentas completada...");
    }

    void poblacionColecciones() {
        crearOperacionesBancarias();
        crearPuntosAtencion();
        crearOficinas();
        crearCuentas();
    }

    void crearOperacionesBancarias() {
        System.out.println("Creacion de operaciones bancarias empezada...");
        Date fecha = new Date();
        operacionesbancariasServicio.insertarOperacionBancaria(1, 1, "12", fecha, Producto.CUENTA, Tipo.CONSIGNACION);
        operacionesbancariasServicio.insertarOperacionBancaria(2, 1, "13", fecha, Producto.CUENTA, Tipo.CONSIGNACION);
        operacionesbancariasServicio.insertarOperacionBancaria(3, 1, "12", fecha, Producto.CUENTA, Tipo.CONSIGNACION);
        operacionesbancariasServicio.insertarOperacionBancaria(4, 1, "12", fecha, Producto.CUENTA, Tipo.RETIRO);
        operacionesbancariasServicio.insertarOperacionBancaria(5, 1, "14", fecha, Producto.CUENTA, Tipo.CONSIGNACION);
        operacionesbancariasServicio.insertarOperacionBancaria(6, 1, "12", fecha, Producto.CUENTA, Tipo.RETIRO);
        operacionesbancariasServicio.insertarOperacionBancaria(7, 1, "16", fecha, Producto.CUENTA, Tipo.CONSIGNACION);
        operacionesbancariasServicio.insertarOperacionBancaria(8, 1, "12", fecha, Producto.CUENTA, Tipo.TRANSFERENCIA);
        operacionesbancariasServicio.insertarOperacionBancaria(9, 1, "17", fecha, Producto.CUENTA, Tipo.TRANSFERENCIA);
        operacionesbancariasServicio.insertarOperacionBancaria(10, 1, "12", fecha, Producto.CUENTA, Tipo.CONSIGNACION);
        System.out.println("Creacion de operaciones bancarias completada...");
    }

    void crearPuntosAtencion() {
        System.out.println("Creacion de puntos de atencion empezada...");
        puntosAtencionServicio.insertarPuntoAtencion(1, "cll1", TipoPuntoAtencion.ATENCION_PERSONALIZADA);
        puntosAtencionServicio.insertarPuntoAtencion(2, "cll2", TipoPuntoAtencion.CAJERO_AUTOMATICO);
        puntosAtencionServicio.insertarPuntoAtencion(3, "cll3", TipoPuntoAtencion.ATENCION_PERSONALIZADA);
        puntosAtencionServicio.insertarPuntoAtencion(4, "cll4", TipoPuntoAtencion.ATENCION_PERSONALIZADA);
        puntosAtencionServicio.insertarPuntoAtencion(5, "cll5", TipoPuntoAtencion.CAJERO_AUTOMATICO);
        puntosAtencionServicio.insertarPuntoAtencion(6, "cll6", TipoPuntoAtencion.ATENCION_PERSONALIZADA);
        puntosAtencionServicio.insertarPuntoAtencion(7, "cll7", TipoPuntoAtencion.PUNTO_DE_ATENCION_DIGITAL);
        puntosAtencionServicio.insertarPuntoAtencion(8, "cll8", TipoPuntoAtencion.ATENCION_PERSONALIZADA);
        puntosAtencionServicio.insertarPuntoAtencion(9, "cll9", TipoPuntoAtencion.PUNTO_DE_ATENCION_DIGITAL);
        puntosAtencionServicio.insertarPuntoAtencion(10, "cll10", TipoPuntoAtencion.ATENCION_PERSONALIZADA);
        System.out.println("Creacion de puntos de atencion completada...");
    }

    void crearOficinas() {
        System.out.println("Creacion de oficinas empezada...");
        oficinasServicio.insertarOficina(1, "a", "cll2", 3);
        oficinasServicio.insertarOficina(2, "a", "cll3", 3);
        oficinasServicio.insertarOficina(3, "a", "cll21", 4);
        oficinasServicio.insertarOficina(4, "a", "cll22", 1);
        oficinasServicio.insertarOficina(5, "a", "cll23", 3);
        oficinasServicio.insertarOficina(6, "a", "cll24", 2);
        oficinasServicio.insertarOficina(7, "a", "cll25", 3);
        oficinasServicio.insertarOficina(8, "a", "cll26", 5);
        oficinasServicio.insertarOficina(9, "a", "cll27", 3);
        oficinasServicio.insertarOficina(10, "a", "cll28", 3);
        System.out.println("Creacion de oficinas completada...");

    }

    void crearCuentas() {
        System.out.println("Creacion de cuentas empezada...");
        Date fecha = new Date();
        cuentasServicio.insertarCuenta(1, 10, fecha, fecha, TipoCuenta.AHORROS, EstadoCuenta.ACTIVA);
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

    public void mostrarOficinas() {
        System.out.println("Las oficinas almacenadas en la base de datos son las siguientes -> ");
        System.out.println("----------------------------------------------------------------");
        oficinaRepository.darOficinas().forEach(oficina -> System.out.println(obtenerInfoOficinas(oficina)));
    }

    public void mostrarPuntosAtencion() {
        System.out.println("Los puntos de atencion almacenados en la base de datos son los siguientes -> ");
        System.out.println("----------------------------------------------------------------");
        puntoAtencionRepository.darPuntosAtencion().forEach(puntoAtencion -> System.out.println(obtenerInfoPuntosAtencion(puntoAtencion)));
    }

    public void mostrarOperacionesBancarias() {
        System.out.println("Las operaciones bancarias almacenadas en la base de datos son las siguientes -> ");
        System.out.println("----------------------------------------------------------------");
        operacionBancariaRepository.darOperacionesBancarias().forEach(operacionesBancaria -> System.out.println(obtenerInfoOperacionesBancarias(operacionesBancaria)));
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

    public String obtenerInfoOficinas(OficinaEntity oficina) {
        System.out.println(
        "id: " + oficina.getId_oficina() +
        ", \nNombre: " + oficina.getNombre() +
        ", \nDireccion: " + oficina.getDireccion() +
        ", \nCantidad de Puntos de Atencion: " + oficina.getPuntos_atencion()
        );
        return "";
    }

    public String obtenerInfoPuntosAtencion(PuntoAtencionEntity puntoAtencion) {
        System.out.println(
        "id: " + puntoAtencion.getId_punto_atencion() +
        ", \nLocalizacion: " + puntoAtencion.getLocalizacion() +
        ", \nTipo de Punto de Atencion: " + puntoAtencion.getTipo_punto_atencion() 
        );
        return "";
    }

    public String obtenerInfoOperacionesBancarias(OperacionBancariaEntity operacionBancaria) {
        System.out.println(
        "id: " + operacionBancaria.getId() +
        ", \nValor: " + operacionBancaria.getValor() +
        ", \nHora: " + operacionBancaria.getHora() + 
        ", \nFecha: " + operacionBancaria.getFecha() +
        ", \nProducto: " + operacionBancaria.getProducto() +
        ", \nTipo: " + operacionBancaria.getTipo()
        );
        return "";
    }
    
}
