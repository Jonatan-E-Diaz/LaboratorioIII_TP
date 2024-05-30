package ar.edu.utn.frbb.tup.Clientes;

import java.time.LocalDate;
import java.util.Scanner;

public class MenuClientes {
    //Atributos
    private ClienteLista clienteLista;
    private Scanner scanner;
    //Constructor
    public MenuClientes(ClienteLista clienteLista) {
        this.clienteLista = clienteLista;
        this.scanner = new Scanner(System.in);
    }
    //Método para mostrar el menú de clientes
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n-- Menú Clientes --");
            System.out.println("1. Crear cliente");
            System.out.println("2. Modificar cliente");
            System.out.println("3. Eliminar cliente");
            System.out.println("4. Mostrar todos los clientes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearCliente();
                    break;
                case 2:
                    modificarCliente();
                    break;
                case 3:
                    eliminarCliente();
                    break;
                case 4:
                    mostrarClientes();
                    break;
                case 5:
                    System.out.println("Saliendo del menú de clientes...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 5);
    }
    //Método para crear un cliente
    public void crearCliente() {
        System.out.println("\n-- Crear Cliente --");
        ValidacionesClientes validaciones = new ValidacionesClientes();
        String nombre = validaciones.validarNombre();
        String apellido = validaciones.validarApellido();
        long dni = validaciones.validarDNI();
        String direccion = validaciones.validarDireccion();
        LocalDate fechaNacimiento = validaciones.validarFechaNacimiento();
        String telefono = validaciones.validarTelefono();
        String email = validaciones.validarEmail();
        TipoPersona tipoPersona = validaciones.validarTipoPersona();
        String banco = validaciones.validarBanco();
    
        Cliente cliente = new Cliente(null, nombre, apellido, dni, direccion, fechaNacimiento, telefono, email, tipoPersona, banco);
        clienteLista.agregarCliente(cliente);
        System.out.println("Cliente creado con éxito");
    }
    //Método para modificar un cliente
    private void modificarCliente() {
        System.out.println("\n-- Modificar Cliente --");
        System.out.print("ID del cliente a modificar: ");
        int id = scanner.nextInt();
        if (clienteLista.buscarCliente(id) != null) {
            scanner.nextLine();
            System.out.print("Nuevo nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Nuevo apellido: ");
            String apellido = scanner.nextLine();
            System.out.print("Nueva dirección: ");
            String direccion = scanner.nextLine();
            System.out.print("Nuevo teléfono: ");
            String telefono = scanner.nextLine();
            clienteLista.modificarCliente(id, nombre, apellido, direccion, telefono);
            System.out.println("Cliente modificado con éxito.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }
    //Método para eliminar un cliente
    private void eliminarCliente() {
        System.out.println("\n-- Eliminar Cliente --");
        System.out.print("ID del cliente a eliminar: ");
        int id = scanner.nextInt();
        if (clienteLista.buscarCliente(id) != null) {
            clienteLista.eliminarCliente(id);
            System.out.println("Cliente eliminado con éxito.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }
   //Método para mostrar todos los clientes
    private void mostrarClientes() {
    System.out.println("\n-- Lista de Clientes --");
    for (Cliente cliente : clienteLista.getClientes()) {
        System.out.println("ID: " + cliente.getIdCliente());
        System.out.println("Nombre: " + cliente.getNombre());
        System.out.println("Apellido: " + cliente.getApellido());
        System.out.println("DNI: " + cliente.getDni());
        System.out.println("Dirección: " + cliente.getDireccion());
        System.out.println("Fecha de Nacimiento: " + cliente.getFechaNacimiento());
        System.out.println("Teléfono: " + cliente.getTelefono());
        System.out.println("Email: " + cliente.getEmail());
        System.out.println("Tipo de Persona: " + cliente.getTipoPersona());
        System.out.println("Banco: " + cliente.getBanco());
        System.out.println("Fecha de Alta: " + cliente.getFechaAlta());
        System.out.println();
    }
    }
}

/*package ar.edu.utn.frbb.tup.Clientes;

import java.time.LocalDate;
import java.util.Scanner;

public class MenuClientes {
    //Atributos
    private ClienteLista clienteLista;
    private Scanner scanner;
    //Constructor
    public MenuClientes(ClienteLista clienteLista) {
        this.clienteLista = clienteLista;
        this.scanner = new Scanner(System.in);
    }
    //Método para mostrar el menú de clientes
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n-- Menú Clientes --");
            System.out.println("1. Crear cliente");
            System.out.println("2. Modificar cliente");
            System.out.println("3. Eliminar cliente");
            System.out.println("4. Mostrar todos los clientes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearCliente();
                    break;
                case 2:
                    modificarCliente();
                    break;
                case 3:
                    eliminarCliente();
                    break;
                case 4:
                    mostrarClientes();
                    break;
                case 5:
                    System.out.println("Saliendo del menú de clientes...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 5);
    }
    //Método para crear un cliente
    public void crearCliente() {
        System.out.println("\n-- Crear Cliente --");
        ValidacionesClientes validaciones = new ValidacionesClientes();
        String nombre = validaciones.validarNombre();
        String apellido = validaciones.validarApellido();
        long dni = validaciones.validarDNI();
        String direccion = validaciones.validarDireccion();
        LocalDate fechaNacimiento = validaciones.validarFechaNacimiento();
        String telefono = validaciones.validarTelefono();
        String email = validaciones.validarEmail();
        TipoPersona tipoPersona = validaciones.validarTipoPersona();
        String banco = validaciones.validarBanco();
        LocalDate fechaAlta = validaciones.validarFechaAlta();
    
        Cliente cliente = new Cliente(null, nombre, apellido, dni, direccion, fechaNacimiento, telefono, email, tipoPersona, banco, fechaAlta);
        clienteLista.agregarCliente(cliente);
        System.out.println("Cliente creado con éxito");
    }
    //Método para modificar un cliente
    private void modificarCliente() {
        System.out.println("\n-- Modificar Cliente --");
        System.out.print("ID del cliente a modificar: ");
        int id = scanner.nextInt();
        if (clienteLista.buscarCliente(id) != null) {
            scanner.nextLine();
            System.out.print("Nuevo nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Nuevo apellido: ");
            String apellido = scanner.nextLine();
            System.out.print("Nueva dirección: ");
            String direccion = scanner.nextLine();
            System.out.print("Nuevo teléfono: ");
            String telefono = scanner.nextLine();
            clienteLista.modificarCliente(id, nombre, apellido, direccion, telefono);
            System.out.println("Cliente modificado con éxito.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }
    //Método para eliminar un cliente
    private void eliminarCliente() {
        System.out.println("\n-- Eliminar Cliente --");
        System.out.print("ID del cliente a eliminar: ");
        int id = scanner.nextInt();
        if (clienteLista.buscarCliente(id) != null) {
            clienteLista.eliminarCliente(id);
            System.out.println("Cliente eliminado con éxito.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }
   //Método para mostrar todos los clientes
    private void mostrarClientes() {
    System.out.println("\n-- Lista de Clientes --");
    for (Cliente cliente : clienteLista.getClientes()) {
        System.out.println("ID: " + cliente.getIdCliente());
        System.out.println("Nombre: " + cliente.getNombre());
        System.out.println("Apellido: " + cliente.getApellido());
        System.out.println("DNI: " + cliente.getDni());
        System.out.println("Dirección: " + cliente.getDireccion());
        System.out.println("Fecha de Nacimiento: " + cliente.getFechaNacimiento());
        System.out.println("Teléfono: " + cliente.getTelefono());
        System.out.println("Email: " + cliente.getEmail());
        System.out.println("Tipo de Persona: " + cliente.getTipoPersona());
        System.out.println("Banco: " + cliente.getBanco());
        System.out.println("Fecha de Alta: " + cliente.getFechaAlta());
        System.out.println();
    }
    }
}
*/