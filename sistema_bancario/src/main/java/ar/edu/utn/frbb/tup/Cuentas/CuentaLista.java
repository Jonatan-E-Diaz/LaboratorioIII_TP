package ar.edu.utn.frbb.tup.Cuentas;

import java.util.ArrayList;
import java.util.List;

public class CuentaLista {
    
    private List<Cuenta> lista_cuentas;

    // Constructor
    public CuentaLista() {
        this.lista_cuentas = new ArrayList<>();
    }
    
    // Método para agregar una cuenta
    public void agregarCuenta(Cuenta cuenta) {
        lista_cuentas.add(cuenta);
    }

    // Método para buscar una cuenta por su número
    public Cuenta buscarCuenta(int numeroCuenta) {
        for (Cuenta cuenta : lista_cuentas) {
            if (cuenta.getNumeroCuenta() == numeroCuenta) {
                return cuenta;
            }
        }
        return null;
    }

    // Método para eliminar una cuenta
    public void eliminarCuenta(int numeroCuenta) {
        Cuenta cuenta = buscarCuenta(numeroCuenta);
        if (cuenta != null) {
            lista_cuentas.remove(cuenta);
        } else {
            System.out.println("Cuenta no encontrada");
        }
    }
    
    // Método para obtener la lista de cuentas
    public List<Cuenta> getCuentas() {
        return lista_cuentas;
    }
}
