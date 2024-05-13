package ar.edu.utn.frbb.tup.Clientes;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ValidacionesClientes {
    private Scanner scanner;

    public ValidacionesClientes() {
        this.scanner = new Scanner(System.in);
    }

    public String validarNombre() {
        String nombre;
        do {
            System.out.print("Nombre: ");
            nombre = scanner.nextLine();
            if (nombre.isEmpty()) {
                System.out.println("El nombre no puede estar vacío.");
            }
        } while (nombre.isEmpty());
        return nombre;
    }

    public String validarApellido() {
        String apellido;
        do {
            System.out.print("Apellido: ");
            apellido = scanner.nextLine();
            if (apellido.isEmpty()) {
                System.out.println("El apellido no puede estar vacío.");
            }
        } while (apellido.isEmpty());
        return apellido;
    }

    public long validarDNI() {
        long dni;
        do {
            System.out.print("DNI: ");
            while (!scanner.hasNextLong()) {
                System.out.println("Por favor, ingrese un número válido.");
                System.out.print("DNI: ");
                scanner.next();
            }
            dni = scanner.nextLong();
            if (dni <= 0) {
                System.out.println("El DNI no puede ser negativo o cero.");
            }
            scanner.nextLine();
        } while (dni <= 0);
        return dni;
    }
    

    public String validarDireccion() {
        String direccion;
        do {
            System.out.print("Dirección: ");
            direccion = scanner.nextLine();
            if (direccion.isEmpty()) {
                System.out.println("La dirección no puede estar vacía.");
            }
        } while (direccion.isEmpty());
        return direccion;
    }

    public LocalDate validarFechaNacimiento() {
        LocalDate fechaNacimiento;
        do {
            System.out.print("Fecha de Nacimiento (YYYY-MM-DD): ");
            try {
                fechaNacimiento = LocalDate.parse(scanner.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha incorrecto. Por favor, ingrese la fecha en formato YYYY-MM-DD.");
                fechaNacimiento = null;
            }
        } while (fechaNacimiento == null);
        return fechaNacimiento;
    }

    public String validarTelefono() {
        String telefono;
        do {
            System.out.print("Teléfono: ");
            telefono = scanner.nextLine();
            if (telefono.isEmpty()) {
                System.out.println("El teléfono no puede estar vacío.");
            }
        } while (telefono.isEmpty());
        return telefono;
    }

    public String validarEmail() {
        String email;
        do {
            System.out.print("Email: ");
            email = scanner.nextLine();
            if (email.isEmpty()) {
                System.out.println("El email no puede estar vacío.");
            } else if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                System.out.println("El email ingresado no es válido.");
                email = "";
            }
        } while (email.isEmpty());
        return email;
    }

    public TipoPersona validarTipoPersona() {
        TipoPersona tipoPersona = null;
        do {
            try {
                System.out.print("Tipo de Persona (F - Persona Física, J - Persona Jurídica): ");
                String tipoPersonaStr = scanner.nextLine().toUpperCase();
                tipoPersona = TipoPersona.fromString(tipoPersonaStr);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (tipoPersona == null);
        return tipoPersona;
    }

    public String validarBanco() {
        String banco;
        do {
            System.out.print("Banco: ");
            banco = scanner.nextLine();
            if (banco.isEmpty()) {
                System.out.println("El nombre del banco no puede estar vacío.");
            }
        } while (banco.isEmpty());
        return banco;
    }

    public LocalDate validarFechaAlta() {
        LocalDate fechaAlta;
        do {
            System.out.print("Fecha de Alta (YYYY-MM-DD): ");
            try {
                fechaAlta = LocalDate.parse(scanner.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha incorrecto. Por favor, ingrese la fecha en formato YYYY-MM-DD.");
                fechaAlta = null;
            }
        } while (fechaAlta == null);
        return fechaAlta;
    }
}
    
