package ar.edu.utn.frbb.tup.Operaciones;

import ar.edu.utn.frbb.tup.Cuentas.Cuenta;
import ar.edu.utn.frbb.tup.Cuentas.CuentaLista;
import ar.edu.utn.frbb.tup.Movimientos.Movimiento;

import java.util.Date;
import java.util.Scanner;

public class Operaciones {

    private CuentaLista cuentaLista;
    private Scanner scanner;

    public Operaciones(CuentaLista cuentaLista) {
        this.cuentaLista = cuentaLista;
        this.scanner = new Scanner(System.in);
    }

    public void depositar() {
        System.out.println("\n-- Depósito --");
        System.out.print("Número de cuenta: ");
        int numeroCuenta = scanner.nextInt();
        Cuenta cuenta = cuentaLista.buscarCuenta(numeroCuenta);
        if (cuenta != null) {
            System.out.print("Monto a depositar: ");
            double monto = scanner.nextDouble();
            double saldoActual = cuenta.getSaldo();
            cuenta.setSaldo(saldoActual + monto);
            registrarMovimiento(cuenta, "Depósito", monto);
            System.out.println("Depósito realizado con éxito. Nuevo saldo: " + cuenta.getSaldo());
        } else {
            System.out.println("Cuenta no encontrada.");
        }
    }

    public void retirar() {
        System.out.println("\n-- Retiro --");
        System.out.print("Número de cuenta: ");
        int numeroCuenta = scanner.nextInt();
        Cuenta cuenta = cuentaLista.buscarCuenta(numeroCuenta);
        if (cuenta != null) {
            System.out.print("Monto a retirar: ");
            double monto = scanner.nextDouble();
            double saldoActual = cuenta.getSaldo();
            if (monto <= saldoActual) {
                cuenta.setSaldo(saldoActual - monto);
                registrarMovimiento(cuenta, "Retiro", -monto);
                System.out.println("Retiro realizado con éxito. Nuevo saldo: " + cuenta.getSaldo());
            } else {
                System.out.println("Saldo insuficiente.");
            }
        } else {
            System.out.println("Cuenta no encontrada.");
        }
    }

    public void transferir() {
        System.out.println("\n-- Transferencia --");
        System.out.print("Número de cuenta de origen: ");
        int numeroCuentaOrigen = scanner.nextInt();
        System.out.print("Número de cuenta de destino: ");
        int numeroCuentaDestino = scanner.nextInt();
        Cuenta cuentaOrigen = cuentaLista.buscarCuenta(numeroCuentaOrigen);
        Cuenta cuentaDestino = cuentaLista.buscarCuenta(numeroCuentaDestino);
        if (cuentaOrigen != null && cuentaDestino != null) {
            System.out.print("Monto a transferir: ");
            double monto = scanner.nextDouble();
            double saldoOrigen = cuentaOrigen.getSaldo();
            if (monto <= saldoOrigen) {
                cuentaOrigen.setSaldo(saldoOrigen - monto);
                cuentaDestino.setSaldo(cuentaDestino.getSaldo() + monto);
                registrarMovimiento(cuentaOrigen, "Transferencia enviada", -monto);
                registrarMovimiento(cuentaDestino, "Transferencia recibida", monto);
                System.out.println("Transferencia realizada con éxito.");
            } else {
                System.out.println("Saldo insuficiente.");
            }
        } else {
            System.out.println("Cuenta de origen o cuenta de destino no encontrada.");
        }
    }

    private void registrarMovimiento(Cuenta cuenta, String tipoOperacion, double monto) {
        Date fechaHora = new Date();
        Movimiento movimiento = new Movimiento(fechaHora, tipoOperacion, monto, cuenta.getNumeroCuenta());
        cuenta.getMovimientos().add(movimiento);
    }
}
