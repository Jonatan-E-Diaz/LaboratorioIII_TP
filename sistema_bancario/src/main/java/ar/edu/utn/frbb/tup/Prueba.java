package ar.edu.utn.frbb.tup;

import ar.edu.utn.frbb.tup.Clientes.Cliente;
import ar.edu.utn.frbb.tup.Clientes.ClienteLista;
import ar.edu.utn.frbb.tup.Clientes.TipoPersona;
import ar.edu.utn.frbb.tup.Cuentas.Cuenta;
import ar.edu.utn.frbb.tup.Cuentas.CuentaLista;
import ar.edu.utn.frbb.tup.Cuentas.TipoCuenta;


import java.time.LocalDate;
import java.util.Date;

public class Prueba {

    public static void main(String[] args) {
        ClienteLista clienteLista = new ClienteLista();
        CuentaLista cuentaLista = new CuentaLista();

        Cliente cliente1 = new Cliente(1, "Juan", "Pérez", 12345678, "Calle Falsa 123",
                LocalDate.of(1990, 5, 10), "1234567890", "juan@example.com",
                TipoPersona.PERSONA_FISICA, "Banco X", LocalDate.now());
        clienteLista.agregarCliente(cliente1);
        
        Cliente cliente2 = new Cliente(2, "María", "Gómez", 23456789, "Avenida Siempreviva 456",
                        LocalDate.of(1995, 3, 15), "0987654321", "maria@example.com",
                        TipoPersona.PERSONA_FISICA, "Banco Y", LocalDate.now());
        clienteLista.agregarCliente(cliente2);

        Cuenta cuenta1 = new Cuenta(1, cliente1, TipoCuenta.Caja_Ahorro, 1000, new Date());
        Cuenta cuenta2 = new Cuenta(2, cliente1, TipoCuenta.Cuenta_Corriente, 2000, new Date());
        Cuenta cuenta3 = new Cuenta(3, cliente2, TipoCuenta.Caja_Ahorro, 3000, new Date());

        cuentaLista.agregarCuenta(cuenta1);
        cuentaLista.agregarCuenta(cuenta2);
        cuentaLista.agregarCuenta(cuenta3);

        MenuGeneral menuGeneral = new MenuGeneral(clienteLista, cuentaLista);
        menuGeneral.mostrarMenu();
    
    }
}
