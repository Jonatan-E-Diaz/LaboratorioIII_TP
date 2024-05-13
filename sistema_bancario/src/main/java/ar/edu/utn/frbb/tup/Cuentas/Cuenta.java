package ar.edu.utn.frbb.tup.Cuentas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ar.edu.utn.frbb.tup.Movimientos.*;
import ar.edu.utn.frbb.tup.Clientes.*;

public class Cuenta {
    // Atributos
    private int numeroCuenta;
    private Cliente cliente;
    private TipoCuenta tipoCuenta;
    private double saldo;
    private Date fechaApertura;
    private List<Movimiento> movimientos;

    // Constructor
  
    public Cuenta(int numeroCuenta, Cliente cliente, TipoCuenta tipoCuenta, double saldo, Date fechaApertura) {
        this.numeroCuenta = numeroCuenta;
        this.cliente = cliente;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
        this.movimientos = new ArrayList<>();
    }

    // Getters y setters
    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }
    @Override
    public String toString() {
        return "Cuenta{" +
                "numeroCuenta=" + numeroCuenta +
                ", cliente=" + cliente +
                ", tipoCuenta=" + tipoCuenta +
                ", saldo=" + saldo +
                ", fechaApertura=" + fechaApertura +
                '}';
    }
}
