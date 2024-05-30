package ar.edu.utn.frbb.tup.Clientes;

import java.util.ArrayList;
import java.util.List;

public class ClienteLista {
    //Atributos
    private List<Cliente> lista_clientes;
    private int ultimoIdGenerado = 0;

    // Constructor
    public ClienteLista() {
        this.lista_clientes = new ArrayList<>();
    }
    // Método para agregar un cliente
    public void agregarCliente(Cliente cliente) {
        cliente.setIdCliente(++ultimoIdGenerado);
        lista_clientes.add(cliente);
    }
    // Método para buscar un cliente por su ID
    public Cliente buscarCliente(Integer id) {
        for (Cliente cliente : lista_clientes) {
            if (cliente.getIdCliente().equals(id)) {
                return cliente;
            }
        }
        return null;
    }
    // Método para modificar los datos de un cliente
    public void modificarCliente(int id, String nombre, String apellido, String direccion, String telefono) {
        Cliente cliente = buscarCliente(id);
        if (cliente != null) {
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setDireccion(direccion);
            cliente.setTelefono(telefono);
        } else {
            System.out.println("Cliente no encontrado");
        }
    }
    // Método para eliminar un cliente
    public void eliminarCliente(int id) {
        Cliente cliente = buscarCliente(id);
        if (cliente != null) {
            lista_clientes.remove(cliente);
        } else {
            System.out.println("Cliente no encontrado");
        }
    }
    // Método para obtener la lista de clientes
    public List<Cliente> getClientes() {
        return lista_clientes;
    }
}
