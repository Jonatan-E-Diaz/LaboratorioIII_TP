package ar.edu.utn.frbb.tup;

import ar.edu.utn.frbb.tup.Clientes.ClienteLista;
import ar.edu.utn.frbb.tup.Clientes.MenuClientes;
import ar.edu.utn.frbb.tup.Cuentas.CuentaLista;
import ar.edu.utn.frbb.tup.Cuentas.MenuCuentas;
import ar.edu.utn.frbb.tup.Operaciones.MenuOperaciones;

import java.util.Scanner;

public class MenuGeneral {

    private ClienteLista clienteLista;
    private CuentaLista cuentaLista;
    private Scanner scanner;

    public MenuGeneral(ClienteLista clienteLista, CuentaLista cuentaLista) {
        this.clienteLista = clienteLista;
        this.cuentaLista = cuentaLista;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n-- Menú General --");
            System.out.println("1. Menú Clientes");
            System.out.println("2. Menú Cuentas");
            System.out.println("3. Menú Operaciones");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarMenuClientes();
                    break;
                case 2:
                    mostrarMenuCuentas();
                    break;
                case 3:
                    mostrarMenuOperaciones();
                    break;
                case 4:
                    System.out.println("Saliendo del menú general...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 4);
    }

    private void mostrarMenuClientes() {
        MenuClientes menuClientes = new MenuClientes(clienteLista);
        menuClientes.mostrarMenu();
    }

    private void mostrarMenuCuentas() {
        MenuCuentas menuCuentas = new MenuCuentas(cuentaLista, clienteLista);
        menuCuentas.mostrarMenu();
    }

    private void mostrarMenuOperaciones() {
        MenuOperaciones menuOperaciones = new MenuOperaciones(cuentaLista);
        menuOperaciones.mostrarMenu();
    }
}
