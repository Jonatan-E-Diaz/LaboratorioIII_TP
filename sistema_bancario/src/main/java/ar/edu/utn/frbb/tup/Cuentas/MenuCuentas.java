package ar.edu.utn.frbb.tup.Cuentas;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import ar.edu.utn.frbb.tup.Clientes.*;
import ar.edu.utn.frbb.tup.Movimientos.Movimiento;

public class MenuCuentas {

    private CuentaLista cuentaLista;
    private ClienteLista clienteLista;
    private Scanner scanner;
    private int ultimoNumeroCuenta;

    public MenuCuentas(CuentaLista cuentaLista, ClienteLista clienteLista) {
        this.cuentaLista = cuentaLista;
        this.clienteLista = clienteLista;
        this.scanner = new Scanner(System.in);
        this.ultimoNumeroCuenta = 0;
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n-- Menú Cuentas --");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Consultar saldo");
            System.out.println("3. Mostrar movimientos de una cuenta");
            System.out.println("4. Mostrar todas las cuentas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearCuenta();
                    break;
                case 2:
                    consultarSaldo();
                    break;
                case 3:
                    mostrarMovimientos();
                    break;
                case 4:
                    mostrarTodasCuentas();
                    break;
                case 5:
                    System.out.println("Saliendo del menú de cuentas...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 5);
    }

    private int generarNumeroCuenta() {
        return ++ultimoNumeroCuenta;
    }

    private void crearCuenta() {
        System.out.println("\n-- Crear Cuenta --");
        int numeroCuenta = generarNumeroCuenta(); 
        scanner.nextLine(); 

        System.out.print("ID del cliente: ");
        int idCliente = scanner.nextInt();
        Cliente cliente = clienteLista.buscarCliente(idCliente);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Tipo de cuenta (1 - Caja de Ahorro, 2 - Cuenta Corriente): ");
        int tipoCuentaInt = scanner.nextInt();
        TipoCuenta tipoCuenta;
        if (tipoCuentaInt == 1) {
            tipoCuenta = TipoCuenta.Caja_Ahorro;
        } else if (tipoCuentaInt == 2) {
            tipoCuenta = TipoCuenta.Cuenta_Corriente;
        } else {
            System.out.println("Tipo de cuenta inválido. Se asignará Caja de Ahorros por defecto.");
            tipoCuenta = TipoCuenta.Caja_Ahorro;
        }

        System.out.print("Saldo inicial: ");
        double saldo = scanner.nextDouble();

        Date fechaApertura = new Date();

        Cuenta cuenta = new Cuenta(numeroCuenta, cliente, tipoCuenta, saldo, fechaApertura);
        cuentaLista.agregarCuenta(cuenta);
        System.out.println("Cuenta creada con éxito:");
        System.out.println(cuenta); 
    }

    private void consultarSaldo() {
        System.out.println("\n-- Consultar Saldo --");
        System.out.print("Número de cuenta: ");
        int numeroCuenta = scanner.nextInt();
        Cuenta cuenta = cuentaLista.buscarCuenta(numeroCuenta);
        if (cuenta != null) {
            System.out.println("Saldo de la cuenta " + numeroCuenta + ": " + cuenta.getSaldo());
        } else {
            System.out.println("Cuenta no encontrada.");
        }
    }

    private void mostrarMovimientos() {
        System.out.println("\n-- Mostrar Movimientos --");
        System.out.print("Número de cuenta: ");
        int numeroCuenta = scanner.nextInt();
        Cuenta cuenta = cuentaLista.buscarCuenta(numeroCuenta);
        if (cuenta != null) {
            System.out.println("Movimientos de la cuenta " + numeroCuenta + ":");
            for (Movimiento movimiento : cuenta.getMovimientos()) {
                System.out.println(movimiento);
            }
        } else {
            System.out.println("Cuenta no encontrada.");
        }
    }
    
    private void mostrarTodasCuentas() {
    System.out.println("\n-- Mostrar Todas las Cuentas --");
    List<Cuenta> cuentas = cuentaLista.getCuentas();
    if (cuentas.isEmpty()) {
        System.out.println("No hay cuentas registradas.");
    } else {
        System.out.println("Número de Cuenta | Cliente | Tipo de Cuenta | Saldo | Fecha de Apertura");
        System.out.println("-------------------------------------------------------------------------------");
        for (Cuenta cuenta : cuentas) {
            try {
                System.out.printf("%-17d | %-7s | %-15s | %-6.2f | %tF%n",
                        cuenta.getNumeroCuenta(),
                        cuenta.getCliente().getNombre(),
                        cuenta.getTipoCuenta(),
                        cuenta.getSaldo(),
                        cuenta.getFechaApertura());
            } catch (NullPointerException e) {
                System.out.println("Error: Datos de cuenta incompletos.");
            }
        }
    }
}

}

