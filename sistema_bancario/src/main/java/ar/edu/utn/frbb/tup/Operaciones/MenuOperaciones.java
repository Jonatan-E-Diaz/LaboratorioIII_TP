package ar.edu.utn.frbb.tup.Operaciones;
import ar.edu.utn.frbb.tup.Cuentas.CuentaLista;

import java.util.Scanner;

public class MenuOperaciones {

    private Operaciones operaciones;
    private Scanner scanner;

    public MenuOperaciones(CuentaLista cuentaLista) {
        this.operaciones = new Operaciones(cuentaLista);
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n-- Menú Operaciones --");
            System.out.println("1. Realizar depósito");
            System.out.println("2. Realizar retiro");
            System.out.println("3. Realizar transferencia");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    operaciones.depositar();
                    break;
                case 2:
                    operaciones.retirar();
                    break;
                case 3:
                    operaciones.transferir();
                    break;
                case 4:
                    System.out.println("Saliendo del menú de operaciones...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 4);
    }
}
