package com.bancandes;

import java.util.Date;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.bancandes.entities.ClienteEntity;
import com.bancandes.entities.ClienteEntity.TipoDocumento;
import com.bancandes.entities.CuentaEntity;
import com.bancandes.entities.CuentaEntity.EstadoCuenta;
import com.bancandes.entities.CuentaEntity.TipoCuenta;
import com.bancandes.repository.ClienteRepository;
import com.bancandes.repository.CuentaRepository;
import com.bancandes.servicios.ClientesServicio;
import com.bancandes.servicios.CuentasServicio;

@SpringBootApplication
@EnableMongoRepositories
public class BancandesApplication implements CommandLineRunner {


    @Autowired
    CuentaRepository cuentaRepository;

    @Autowired
    CuentasServicio cuentasServicio;

    @Autowired
    ClienteRepository clienteRepository;

    public static void main( String[] args ) {
        SpringApplication.run(BancandesApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Bancandes fue inicializada correctamente...");
        //crearCuenta();
        mostrarClientes();
    }




    
    void crearCuenta() {
        System.out.println("Creacion de cuentas empezada...");
        Date fecha = new Date();
        CuentaEntity nuevaCuenta = new CuentaEntity(32, 10, fecha, fecha, TipoCuenta.AHORROS, EstadoCuenta.ACTIVA);
        cuentaRepository.save(nuevaCuenta);
        System.out.println("Creacion de cuentas completada...");
    }

    private void mostrarClientes() {
        System.out.println("Los clientes almacenados en la base de datos son las siguientes -> ");
        System.out.println("----------------------------------------------------------------");
        clienteRepository.darClientes().forEach(cliente -> System.out.println(obtenerInfoClientes(cliente)));
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



    private void mostrarCuentas() {
        System.out.println("Las cuentas almacenadas en la base de datos son las siguientes -> ");
        System.out.println("----------------------------------------------------------------");
        cuentaRepository.darCuentas().forEach(cuenta -> System.out.println(obtenerInfoCuentas(cuenta)));
    }

    private String obtenerInfoCuentas(CuentaEntity cuenta) {
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

    private String obtenerInfoClientes(ClienteEntity cliente) {
        System.out.println(
            "Numero documento: " + cliente.getNum_documento() +
            ", \nNombre: " + cliente.getNombre() +
            ", \nCiudad: " + cliente.getCiudad() +
            ", \nDepartamento: " + cliente.getDepartamento() +
            ", \nDireccion Electronica: " + cliente.getDireccion_electronica() +
            ", \nDireccion fisica: " + cliente.getDireccion_fisica() +
            ", \nNacionalidad: " + cliente.getNacionalidad() +
            ", \nTelefono: " + cliente.getTelefono() +
            ", \nDepartamento: " + cliente.getTipo_documento().toString()
        );
        return "";
    }

    
    void mostrarOpciones() {
        System.out.println("Bienvenido a Bancandes \\n" + //
                        "Seleccione una de las siguientes opciones: \\n" + //
                        "1. Cajeros: \\n" + //
                        "2. Clientes \\n" + //
                        "3. Cuentas: \\n" + //
                        "4. Gerentes Generales \\n" + //
                        "5. Gerentes Oficinas \\n" + //
                        "6. Oficinas \\n" + //
                        "7. Operaciones Bancarias \\n" + //
                        "8. Puntos De Atencion");
    }
    void insertarCliente(String num_documento, String telefono, String nombre, String nacionalidad, String direccion_fisica, String direccion_electronica, 
                        String departamento, String codigo_postal, String ciudad, TipoDocumento tipo_documento) {
        System.out.println("Creacion de cliente empezada...");
        ClienteEntity nuevoCliente = new ClienteEntity(num_documento, telefono, nombre, nacionalidad, direccion_fisica, direccion_electronica, departamento, 
                                                    codigo_postal, ciudad, tipo_documento);
        clienteRepository.save(nuevoCliente);
        System.out.println("Creacion de cliente completada...");
    }

    void seleccionOpciones() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 9) {
            System.out.print("Ingrese el número de la opción que desea seleccionar: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    gestionarCajeros(scanner);
                    break;
                case 2:
                    opcionesClientes(scanner);
                    break;
                case 3:
                    gestionarCuentas(scanner);
                    break;
                case 4:
                    gestionarGerentesGenerales(scanner);
                    break;
                case 5:
                    gestionarGerentesOficinas(scanner);
                    break;
                case 6:
                    gestionarOficinas(scanner);
                    break;
                case 7:
                    gestionarOperacionesBancarias(scanner);
                    break;
                case 8:
                    gestionarPuntosDeAtencion(scanner);
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción del 1 al 9.");
            }
        }

    void opcionesClientes(Scanner scanner) {
        System.out.println("Usted ha seleccionado: Clientes");
        System.out.println("Eliga una opcion: \n" + //
                        "1. Agregar un cliente \\n" + //
                        "2. Dar un cliente por su numero de documento \\n" + //
                        "3. Dar todos los clientes" );
        int opcion = scanner.nextInt();
        if (opcion == 1){
            System.out.println("Ingrese el numero de documento:");
            String num_documento = scanner.nextLine();
            System.out.println("Ingrese el telefono: ");
            String telefono = scanner.nextLine();
            System.out.println("Ingrese el nombre: ");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese el nacionalidad: ");
            String nacionalidad = scanner.nextLine();
            System.out.println("Ingrese la direccion fisica: ");
            String direccion_fisica = scanner.nextLine();
            System.out.println("Ingrese la direccion electronica: ");
            String direccion_electronica = scanner.nextLine();
            System.out.println("Ingrese el departamento: ");
            String departamento = scanner.nextLine();
            System.out.println("Ingrese el codigo postal: ");
            String codigo_postal = scanner.nextLine();
            System.out.println("Ingrese la ciudad: ");
            String ciudad = scanner.nextLine();
            System.out.println("Ingrese 1 si es CC o 2 si es NIT, si pone algo diferente la opcion por defecto es CC");
            TipoDocumento tipoDocumento = TipoDocumento.CC;
            int opcion2 = scanner.nextInt();
            if (opcion2 == 1){
                tipoDocumento = TipoDocumento.CC;
            }
            else if (opcion2 == 2) {
                tipoDocumento = TipoDocumento.NIT;
            }
            insertarCliente(num_documento, telefono, nombre, nacionalidad, direccion_fisica,
            direccion_electronica, departamento, codigo_postal, ciudad, tipoDocumento);
        }
                    
    }
}
