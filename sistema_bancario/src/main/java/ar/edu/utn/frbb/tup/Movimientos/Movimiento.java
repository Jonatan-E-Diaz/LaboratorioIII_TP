package ar.edu.utn.frbb.tup.Movimientos;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Movimiento {
    // Atributos
    private Date fechaHora;
    private String tipoOperacion;
    private Double monto;
    private Integer numeroCuenta;

    // Constructor
    public Movimiento() {
    }

    public Movimiento(Date fechaHora, String tipoOperacion, Double monto, Integer numeroCuenta) {
        this.fechaHora = fechaHora;
        this.tipoOperacion = tipoOperacion;
        this.monto = monto;
        this.numeroCuenta = numeroCuenta;
    }

    // Getters & Setters
    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public Integer getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Integer numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    // Método toString
    @Override
    public String toString() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fechaFormateada = formatoFecha.format(fechaHora);
        return "Movimiento: " +
                "\nFecha y Hora: " + fechaFormateada +
                "\nTipo de Operación: " + tipoOperacion +
                "\nMonto: $" + monto +
                "\nNúmero de Cuenta: " + numeroCuenta;
    }
}
