package com.bancandes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.bancandes.entities.CajeroEntity;
import com.bancandes.entities.ClienteEntity;
import com.bancandes.entities.PersonaEntity.TipoDocumento;

import com.bancandes.entities.PuntoAtencionEntity.TipoPuntoAtencion;
import com.bancandes.entities.CuentaEntity;
import com.bancandes.entities.GerenteGeneral;
import com.bancandes.entities.GerenteOficina;
import com.bancandes.entities.OficinaEntity;
import com.bancandes.entities.OperacionBancariaEntity;
import com.bancandes.entities.CuentaEntity.EstadoCuenta;
import com.bancandes.entities.CuentaEntity.TipoCuenta;
import com.bancandes.entities.PuntoAtencionEntity;
import com.bancandes.entities.OperacionBancariaEntity.Producto;
import com.bancandes.entities.OperacionBancariaEntity.Tipo;


import com.bancandes.repository.CajeroRepository;
import com.bancandes.repository.ClienteRepository;
import com.bancandes.repository.CuentaRepository;
import com.bancandes.repository.GerenteGeneralRepository;
import com.bancandes.repository.GerenteOficinaRepository;
import com.bancandes.repository.OficinaRepository;
import com.bancandes.repository.OperacionBancariaRepository;
import com.bancandes.repository.PuntoAtencionRepository;
import com.bancandes.servicios.ClientesServicio;
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
    CuentasServicio cuentasServicio;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    CajeroRepository cajeroRepository;

    @Autowired
    GerenteGeneralRepository gerenteGeneralRepository;

    @Autowired
    PuntosAtencionServicio puntosAtencionServicio;

    @Autowired
    OficinasServicio oficinasServicio;


    @Autowired
    PuntoAtencionRepository puntoAtencionRepository;

    @Autowired
    OperacionesbancariasServicio operacionesbancariasServicio;

    @Autowired
    OficinaRepository oficinaRepository;

    @Autowired
    GerenteOficinaRepository gerenteOficinaRepository;

    @Autowired
    OperacionBancariaRepository operacionBancariaRepository;

    public static void main(String[] args) {
        SpringApplication.run(BancandesApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Bancandes fue inicializada correctamente...");
        //poblacionColecciones();
        //crearCuenta();
        //mostrarCuentas();
        mostrarOpciones();
        seleccionOpciones();
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

    void borrarPuntoAtencion(int id_punto_atencion) {
        puntosAtencionServicio.eliminarPuntoAtencion(id_punto_atencion);
        System.out.println("El punto de atencion seleccionado fue eliminado exitosamente...");
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

    void crearCuentas() {
        System.out.println("Creacion de cuentas empezada...");
        Date fecha = new Date();
        // cuentasServicio.insertarCuenta(1, 10, fecha, fecha, TipoCuenta.AHORROS,
        // EstadoCuenta.ACTIVA);
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

    
    

    
    

    void mostrarOpciones() {
        System.out.println("Bienvenido a Bancandes " + 
                "\n Seleccione una de las siguientes opciones: " + 
                "\n1. Cajeros: " + 
                "\n2. Clientes " +
                "\n3. Cuentas: " + 
                "\n4. Gerentes Generales: " + 
                "\n5. Gerentes Oficinas: " + 
                "\n6. Oficinas:" + 
                "\n7. Operaciones Bancarias: " + 
                "\n8. Puntos De Atencion");
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
                    opcionesCajeros(scanner);
                    break;
                case 2:
                    opcionesClientes(scanner);
                    break;
                case 3:
                    opcionesCuenta(scanner);
                    break;
                case 4:
                    opcionesGerenteGeneral(scanner);
                    break;
                case 5:
                    opcionesGerenteOficina(scanner);
                    break;
                case 6:
                    opcionesOficina(scanner);
                    break;
                case 7:
                    opcionesOperacionBancaria(scanner);
                    break;
                case 8:
                    opcionesPuntoAtencion(scanner);
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción del 1 al 9.");
            }
        }
    }

    private void mostrarClientes() {
        System.out.println("Los clientes almacenados en la base de datos son las siguientes -> ");
        System.out.println("----------------------------------------------------------------");
        clienteRepository.darClientes().forEach(cliente -> System.out.println(obtenerInfoClientes(cliente)));
    }

    void insertarCliente(String num_documento, String telefono, String nombre, String nacionalidad,
            String direccion_fisica, String direccion_electronica,
            String departamento, String codigo_postal, String ciudad, TipoDocumento tipo_documento) {
        System.out.println("Creacion de cliente empezada...");
        ClienteEntity nuevoCliente = new ClienteEntity(num_documento, telefono, nombre, nacionalidad, direccion_fisica,
                direccion_electronica, departamento,
                codigo_postal, ciudad, tipo_documento);
        clienteRepository.save(nuevoCliente);
        System.out.println("Creacion de cliente completada...");
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
                        ", \nTipo Documento: " + cliente.getTipo_documento());
        return "";
    }

    void opcionesClientes(Scanner scanner) {
        System.out.println("Usted ha seleccionado: Clientes");
        System.out.println("\nEliga una opcion: " + 
                "\n1. Agregar un cliente " + 
                "\n2. Dar un cliente por su numero de documento " + 
                "\n3. Dar todos los clientes");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        if (opcion == 1) {
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
            if (opcion2 == 1) {
                tipoDocumento = TipoDocumento.CC;
            } else if (opcion2 == 2) {
                tipoDocumento = TipoDocumento.NIT;
            }
            insertarCliente(num_documento, telefono, nombre, nacionalidad, direccion_fisica,
                    direccion_electronica, departamento, codigo_postal, ciudad, tipoDocumento);
        } else if (opcion == 2) {
            System.out.println("Ingrese el numero de documento:");
            String num_documento = scanner.nextLine();
            ClienteEntity cliente = clienteRepository.darCliente(num_documento);
            obtenerInfoClientes(cliente);
        } else if (opcion == 3) {
            mostrarClientes();
        }
        else {
            System.out.println("NO EXISTE ESA OPCION!");
        }
    }

    void insertarCajero(String num_documento, String telefono, String nombre, String nacionalidad,
            String direccion_fisica, String direccion_electronica,
            String departamento, String codigo_postal, String ciudad, TipoDocumento tipo_documento) {
        System.out.println("Creacion de cajero empezada...");
        CajeroEntity nuevoCajero = new CajeroEntity(num_documento, telefono, nombre, nacionalidad, direccion_fisica,
                direccion_electronica, departamento,
                codigo_postal, ciudad, tipo_documento);
        cajeroRepository.save(nuevoCajero);
        System.out.println("Creacion de cajero completada...");
    }

    private String obtenerInfoCajeros(CajeroEntity cajero) {
        System.out.println(
                "Numero documento: " + cajero.getNum_documento() +
                        ", \nNombre: " + cajero.getNombre() +
                        ", \nCiudad: " + cajero.getCiudad() +
                        ", \nDepartamento: " + cajero.getDepartamento() +
                        ", \nDireccion Electronica: " + cajero.getDireccion_electronica() +
                        ", \nDireccion fisica: " + cajero.getDireccion_fisica() +
                        ", \nNacionalidad: " + cajero.getNacionalidad() +
                        ", \nTelefono: " + cajero.getTelefono() +
                        ", \nTipo Documento:" + cajero.getTipo_documento());
        return "";
    }

    private void mostrarCajeros() {
        System.out.println("Los cajeros almacenados en la base de datos son las siguientes -> ");
        System.out.println("----------------------------------------------------------------");
        cajeroRepository.darCajeros().forEach(cajero -> System.out.println(obtenerInfoCajeros(cajero)));
    }

    void opcionesCajeros(Scanner scanner) {
        System.out.println("Usted ha seleccionado: Cajeros");
        System.out.println("Eliga una opcion: " + 
                "\n1. Agregar un cajero " + 
                "\n2. Dar un cajero por su numero de documento " + 
                "\n3. Dar todos los cajeros");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        if (opcion == 1) {
            System.out.println("Ingrese el numero de documento:");
            String num_documento = scanner.nextLine();
            System.out.println("Ingrese el telefono: ");
            String telefono = scanner.nextLine();
            System.out.println("Ingrese el nombre: ");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese la nacionalidad: ");
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
            scanner.nextLine();
            if (opcion2 == 1) {
                tipoDocumento = TipoDocumento.CC;
            } else if (opcion2 == 2) {
                tipoDocumento = TipoDocumento.NIT;
            }
            insertarCajero(num_documento, telefono, nombre, nacionalidad, direccion_fisica,
                    direccion_electronica, departamento, codigo_postal, ciudad, tipoDocumento);
        } else if (opcion == 2) {
            System.out.println("Ingrese el numero de documento:");
            String num_documento = scanner.nextLine();
            CajeroEntity cajero = cajeroRepository.darCajero(num_documento);
            obtenerInfoCajeros(cajero);
        } else if (opcion == 3) {
            mostrarCajeros();
        }
        else {
            System.out.println("NO EXISTE ESA OPCION!");
        }
    }

    void insertarGerentesGenerales(String num_documento, String telefono, String nombre, String nacionalidad,
            String direccion_fisica, String direccion_electronica,
            String departamento, String codigo_postal, String ciudad, TipoDocumento tipo_documento) {
        System.out.println("Creacion de Gerente empezada...");
        GerenteGeneral nuevoGeneral = new GerenteGeneral(num_documento, telefono, nombre, nacionalidad,
                direccion_fisica, direccion_electronica, departamento,
                codigo_postal, ciudad, tipo_documento);
        gerenteGeneralRepository.save(nuevoGeneral);
        System.out.println("Creacion de Gerente completada...");
    }

    private String obtenerInfoGerenteGeneral(GerenteGeneral general) {
        System.out.println(
                "Numero documento: " + general.getNum_documento() +
                        ", \nNombre: " + general.getNombre() +
                        ", \nCiudad: " + general.getCiudad() +
                        ", \nDepartamento: " + general.getDepartamento() +
                        ", \nDireccion Electronica: " + general.getDireccion_electronica() +
                        ", \nDireccion fisica: " + general.getDireccion_fisica() +
                        ", \nNacionalidad: " + general.getNacionalidad() +
                        ", \nTelefono: " + general.getTelefono() +
                        ", \nTipo Documento: " + general.getTipo_documento());
        return "";
    }

    private void mostrarGerenteGeneral() {
        System.out.println("Los gerentes generales almacenados en la base de datos son las siguientes -> ");
        System.out.println("----------------------------------------------------------------");
        gerenteGeneralRepository.darGerenteGenerales()
                .forEach(gerenteOficina -> System.out.println(obtenerInfoGerenteGeneral(gerenteOficina)));
    }

    void opcionesGerenteGeneral(Scanner scanner) {
        System.out.println("Usted ha seleccionado: Gerente General");
        System.out.println("\nEliga una opcion: " + 
                "\n1. Agregar un gerente " + 
                "\n2. Dar un cajero por su numero de documento " + 
                "\n3. Dar todos los gerentes");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        if (opcion == 1) {
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
            if (opcion2 == 1) {
                tipoDocumento = TipoDocumento.CC;
            } else if (opcion2 == 2) {
                tipoDocumento = TipoDocumento.NIT;
            }
            insertarGerentesGenerales(num_documento, telefono, nombre, nacionalidad, direccion_fisica,
                    direccion_electronica, departamento, codigo_postal, ciudad, tipoDocumento);
        } else if (opcion == 2) {
            System.out.println("Ingrese el numero de documento:");
            String num_documento = scanner.nextLine();
            GerenteGeneral general = gerenteGeneralRepository.darGerenteGeneral(num_documento);
            obtenerInfoGerenteGeneral(general);
        } else if (opcion == 3) {
            mostrarGerenteGeneral();
        }
        else {
            System.out.println("NO EXISTE ESA OPCION!");
        }
    }


    void insertarGerentesOficina(String num_documento, String telefono, String nombre, String nacionalidad,
            String direccion_fisica, String direccion_electronica,
            String departamento, String codigo_postal, String ciudad, TipoDocumento tipo_documento) {
        System.out.println("Creacion de Gerente empezada...");
        GerenteOficina nuevoOficina = new GerenteOficina(num_documento, telefono, nombre, nacionalidad,
                direccion_fisica, direccion_electronica, departamento,
                codigo_postal, ciudad, tipo_documento);
        gerenteOficinaRepository.save(nuevoOficina);
        System.out.println("Creacion de Gerente completada...");
    }

    private String obtenerInfoGerenteOficina(GerenteOficina oficina) {
        System.out.println(
                "Numero documento: " + oficina.getNum_documento() +
                        ", \nNombre: " + oficina.getNombre() +
                        ", \nCiudad: " + oficina.getCiudad() +
                        ", \nDepartamento: " + oficina.getDepartamento() +
                        ", \nDireccion Electronica: " + oficina.getDireccion_electronica() +
                        ", \nDireccion fisica: " + oficina.getDireccion_fisica() +
                        ", \nNacionalidad: " + oficina.getNacionalidad() +
                        ", \nTelefono: " + oficina.getTelefono() +
                        ", \nTipo Documento: " + oficina.getTipo_documento());
        return "";
    }

    private void mostrarGerenteOficina() {
        System.out.println("Los gerentes almacenados en la base de datos son las siguientes -> ");
        System.out.println("----------------------------------------------------------------");
        gerenteOficinaRepository.darGerentesOficinas()
                .forEach(gerenteOficina -> System.out.println(obtenerInfoGerenteOficina(gerenteOficina)));
    }

    void opcionesGerenteOficina(Scanner scanner) {
        System.out.println("Usted ha seleccionado: Gerente Oficina");
        System.out.println("\nEliga una opcion: " + 
                "\n1. Agregar un gerente " + 
                "\n2. Dar un cajero por su numero de documento " + 
                "\n3. Dar todos los gerentes");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        if (opcion == 1) {
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
            if (opcion2 == 1) {
                tipoDocumento = TipoDocumento.CC;
            } else if (opcion2 == 2) {
                tipoDocumento = TipoDocumento.NIT;
            }
            insertarGerentesOficina(num_documento, telefono, nombre, nacionalidad, direccion_fisica,
                    direccion_electronica, departamento, codigo_postal, ciudad, tipoDocumento);
        } else if (opcion == 2) {
            System.out.println("Ingrese el numero de documento:");
            String num_documento = scanner.nextLine();
            GerenteOficina oficina = gerenteOficinaRepository.darGerenteOficina(num_documento);
            obtenerInfoGerenteOficina(oficina);
        } else if (opcion == 3) {
            mostrarGerenteOficina();
        }
        else {
            System.out.println("NO EXISTE ESA OPCION!");
        }
    }



    void crearCuenta(Integer numero_cuenta, Integer saldo, Date fecha_ultima_transaccion, Date fecha_creacion, TipoCuenta tipo_cuenta, EstadoCuenta estadoCuenta) {
        System.out.println("Creacion de cuentas empezada...");
        CuentaEntity nuevaCuenta = new CuentaEntity(numero_cuenta, saldo, fecha_ultima_transaccion, fecha_creacion,tipo_cuenta , estadoCuenta);
        cuentaRepository.save(nuevaCuenta);
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
                        ", \nEstado de cuenta: " + cuenta.getEstado_cuenta());
        return "";
    }

    void opcionesCuenta(Scanner scanner) {
        System.out.println("Usted ha seleccionado: Cuenta");
        System.out.println("\nEliga una opcion: " + 
                "\n1. Agregar una cuenta " + 
                "\n2. Dar una cuenta por su numero " + 
                "\n3. Dar todas las cuentas");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        if (opcion == 1) {
            System.out.println("Ingrese el numero de cuenta:");
            Integer num_cuenta = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese el saldo: ");
            Integer saldo = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Ingrese la fecha de creacion en formato: (dd/MM/yyyy): ");
            String fechaString = scanner.nextLine();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaC = new Date();
            Date fechaU = new Date();
            try {
                fechaC = dateFormat.parse(fechaString);
            } catch (ParseException e) {
                System.out.println("Fecha inválida. Por favor, use el formato dd/MM/yyyy.");
            }
            System.out.print("Ingrese la fecha de ultima transferencia en formato: (dd/MM/yyyy): ");
            String fecha2String = scanner.nextLine();
            SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
            try {
                fechaU = dateFormat2.parse(fecha2String);
            } catch (ParseException e) {
                System.out.println("Fecha inválida. Por favor, use el formato dd/MM/yyyy.");
            }

            System.out.println("Ingrese 1 si es ACTIVA o 2 si es CERRADA o 3 si es DESACTIVADA, si pone algo diferente la opcion por defecto es ACTIVA");
            EstadoCuenta estadoCuenta = EstadoCuenta.ACTIVA;
            int opcion2 = scanner.nextInt();
            if (opcion2 == 1) {
                estadoCuenta = EstadoCuenta.ACTIVA;
            } else if (opcion2 == 2) {
                estadoCuenta = EstadoCuenta.CERRADA;
            } else if (opcion2 == 3) {
                estadoCuenta = EstadoCuenta.DESACTIVADA;
            }

            System.out.println("Ingrese 1 si es AHORROS o 2 si es CORRIENTE o 3 si es AFC, si pone algo diferente la opcion por defecto es AHORROS");
            TipoCuenta tipoCuenta = TipoCuenta.AHORROS;
            int opcion3 = scanner.nextInt();
            if (opcion3 == 1) {
                tipoCuenta = TipoCuenta.AHORROS;
            } else if (opcion3 == 2) {
                tipoCuenta = TipoCuenta.CORRIENTE;
            } else if (opcion3 == 3) {
                tipoCuenta = TipoCuenta.AFC;
            }

            crearCuenta(num_cuenta, saldo, fechaC, fechaU, tipoCuenta, estadoCuenta);
        } else if (opcion == 2) {
            System.out.println("Ingrese el numero de cuenta:");
            int num_cuenta = scanner.nextInt();
            CuentaEntity cuenta = cuentaRepository.darCuenta(num_cuenta);
            obtenerInfoCuentas(cuenta);
        } else if (opcion == 3) {
            mostrarCuentas();
        }
        else {
            System.out.println("NO EXISTE ESA OPCION!");
        }
    }


    void insertarOficina(Integer id_oficina, String nombre, String direccion, Integer puntos_atencion) {
        System.out.println("Creacion de Oficina empezada...");
        OficinaEntity nuevaOficina = new OficinaEntity(id_oficina, nombre, direccion, puntos_atencion);
        oficinaRepository.save(nuevaOficina);
        System.out.println("Creacion de Oficina completada...");
    }

    private String obtenerInfoOficina(OficinaEntity oficina) {
        System.out.println(
                "ID: " + oficina.getId_oficina() +
                        ", \nNombre: " + oficina.getNombre() +
                        ", \nDireccion: " + oficina.getDireccion() +
                        ", \nPuntos de Atencion: " + oficina.getPuntos_atencion());
        return "";
    }

    private void mostrarOficina() {
        System.out.println("Las oficinas almacenadas en la base de datos son las siguientes -> ");
        System.out.println("----------------------------------------------------------------");
        oficinaRepository.darOficinas()
                .forEach(oficina -> System.out.println(obtenerInfoOficina(oficina)));
    }

    void opcionesOficina(Scanner scanner) {
        System.out.println("Usted ha seleccionado: Oficina");
        System.out.println("\nEliga una opcion: " + 
                "\n1. Agregar una oficina " +
                "\n2. Dar un cajero por su numero de documento " + 
                "\n3. Dar todas las oficinas");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        if (opcion == 1) {
            System.out.println("Ingrese el ID:");
            Integer num_cuenta = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese el nombre: ");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese la direccion: ");
            String direccion = scanner.nextLine();
            System.out.println("Ingrese la cantidad de puntos de atencion: ");
            Integer puntos_atencion = scanner.nextInt();
            scanner.nextLine();
            
            insertarOficina(num_cuenta, nombre, direccion, puntos_atencion);
        } else if (opcion == 2) {
            System.out.println("Ingrese el numero ID:");
            int id_oficina = scanner.nextInt();
            scanner.nextLine();
            OficinaEntity oficina = oficinaRepository.darOficina(id_oficina);
            obtenerInfoOficina(oficina);
        } else if (opcion == 3) {
            mostrarOficina();
        }
        else {
            System.out.println("NO EXISTE ESA OPCION!");
        }
    }
    


    void insertarOperacionBancaria(int id_operacion, int valor, String hora, Date fecha, Producto producto, Tipo tipo) {
        System.out.println("Creacion de Operacion Bancaria empezada...");
        OperacionBancariaEntity nuevaOperacion = new OperacionBancariaEntity(id_operacion, valor, hora, fecha, producto, tipo);
        operacionBancariaRepository.save(nuevaOperacion);
        System.out.println("Creacion de Operacion Bancaria completada...");
    }

    void opcionesOperacionBancaria(Scanner scanner) {
        System.out.println("Usted ha seleccionado: Operacion Bancaria");
        System.out.println("\nEliga una opcion: " + 
                "\n1. Agregar una Operacion Bancaria " + 
                "\n2. Dar una operacion Bancaria por su numero de documento " + 
                "\n3. Dar todas las operaciones Bancarias");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        if (opcion == 1) {
            System.out.println("Ingrese el ID:");
            int id_operacion = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese el valor: ");
            int valor = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese la hora: ");
            String hora = scanner.nextLine();

            System.out.println("Ingrese 1 si es CUENTA o 2 si es CDT , si pone algo diferente la opcion por defecto es CUENTA");
            Producto producto = Producto.CUENTA;
            int opcion3 = scanner.nextInt();
            scanner.nextLine();
            if (opcion3 == 1) {
                producto = Producto.CUENTA;
            } else if (opcion3 == 2) {
                producto = Producto.CDT;
            }



            System.out.println("Ingrese 1 si es CONSIGNACION o 2 si es RETIRO o 3 si es transferencia,si pone algo diferente la opcion por defecto es CONSIGNACION");
            Tipo tipo = Tipo.CONSIGNACION;
            int opcion4 = scanner.nextInt();
            scanner.nextLine();
            if (opcion4 == 1) {
                tipo = Tipo.CONSIGNACION;
            } else if (opcion4 == 2) {
                tipo = Tipo.RETIRO;
            } else if (opcion4 == 3) {
                tipo = Tipo.TRANSFERENCIA;
            
            }

            System.out.print("Ingrese la fecha de ultima transferencia en formato: (dd/MM/yyyy): ");
            String fecha2String = scanner.nextLine();
            SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = new Date();
            try {
                fecha = dateFormat2.parse(fecha2String);
            } catch (ParseException e) {
                System.out.println("Fecha inválida. Por favor, use el formato dd/MM/yyyy.");
            }
            insertarOperacionBancaria(id_operacion, valor, hora, fecha, producto, tipo);


        } else if (opcion == 2) {
            System.out.println("Ingrese el numero ID:");
            int id_operacion = scanner.nextInt();
            scanner.nextLine();
            OperacionBancariaEntity operacion = operacionBancariaRepository.darOperacionBancaria(id_operacion);
            obtenerInfoOperacionesBancarias(operacion);
        } else if (opcion == 3) {
            mostrarOperacionesBancarias();
        }
        else {
            System.out.println("NO EXISTE ESA OPCION!");
        }
    }



    void insertarPuntoAtencion(int id_punto_atencion, String localizacion, TipoPuntoAtencion tipo) {
        System.out.println("Creacion de Punto de Atencion empezada...");
        PuntoAtencionEntity nuevoPunto = new PuntoAtencionEntity(id_punto_atencion, localizacion, tipo);
        puntoAtencionRepository.save(nuevoPunto);
        System.out.println("Creacion de Punto de Atencion completada...");
    }

    void opcionesPuntoAtencion(Scanner scanner) {
        System.out.println("Usted ha seleccionado: Punto de Atencion");
        System.out.println("\nEliga una opcion: " + //
                "\n1. Agregar un Punto de Atencion " + //
                "\n2. Dar un Punto de Atencion por su ID" + //
                "\n3. Dar todos los Puntos de Atencion");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        if (opcion == 1) {
            System.out.println("Ingrese el ID:");
            int id_punto_atencion = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese la localizacion: ");
            String localizacion = scanner.nextLine();
            System.out.println("Ingrese 1 si es ATENCION PERSONALIZADA o 2 si es CAJERO AUTOMATICO o 3 si es ATENCION DIGITAL, si pone algo diferente la opcion por defecto es ATENCION PERSONALIZADA");
            TipoPuntoAtencion tipo = TipoPuntoAtencion.ATENCION_PERSONALIZADA;
            int opcion4 = scanner.nextInt();
            scanner.nextLine();
            if (opcion4 == 1) {
                tipo = TipoPuntoAtencion.ATENCION_PERSONALIZADA;
            } else if (opcion4 == 2) {
                tipo = TipoPuntoAtencion.CAJERO_AUTOMATICO;
            } else if (opcion4 == 3) {
                tipo = TipoPuntoAtencion.PUNTO_DE_ATENCION_DIGITAL;
            }

            insertarPuntoAtencion(id_punto_atencion, localizacion, tipo);
        } else if (opcion == 2) {
            System.out.println("Ingrese el numero ID:");
            int id_punto_atencion = scanner.nextInt();
            scanner.nextLine();
            PuntoAtencionEntity punto = puntoAtencionRepository.darPuntoAtencion(id_punto_atencion);
            obtenerInfoPuntosAtencion(punto);
        } else if (opcion == 3) {
            mostrarPuntosAtencion();
        }
        else {
            System.out.println("NO EXISTE ESA OPCION!");
        }
    }
}
