package ar.edu.utn.frbb.tup.Clientes;

import java.time.LocalDate;

public class Cliente extends Persona {
    
    //Atributos
    private Integer idCliente;
    private TipoPersona tipoPersona;
    private String banco;
    private LocalDate fechaAlta;
    
    //Constructor
    public Cliente() {
    }
    public Cliente(Integer idCliente, String nombre, String apellido, long dni, String direccion, LocalDate fechaNacimiento,
        String telefono, String email, TipoPersona tipoPersona, String banco) { 
            super(nombre, apellido, dni, direccion, fechaNacimiento, telefono, email);
            this.idCliente = idCliente;
            this.tipoPersona = tipoPersona;
            this.banco = banco;
            this.fechaAlta = LocalDate.now(); // Asigna la fecha actual del sistema
    }
    
    //Getters y Setters
    public Integer getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(Integer string) {
        this.idCliente = string;
    }
    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }
    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }
    public String getBanco() {
        return banco;
    }
    public void setBanco(String banco) {
        this.banco = banco;
    }
    public LocalDate getFechaAlta() {
        return fechaAlta;
    }
    
    // Método toString
    @Override
    public String toString() {
        return "Cliente{" +
            "idCliente=" + idCliente +
            ", tipoPersona=" + tipoPersona +
            ", banco=" + banco +
            ", fechaAlta=" + fechaAlta +
            ", nombre='" + getNombre() + '\'' +
            ", apellido='" + getApellido() + '\'' +
            ", dni='" + getDni() + '\'' +
            ", direccion='" + getDireccion() + '\'' +
            ", fechaNacimiento=" + getFechaNacimiento() +
            ", telefono='" + getTelefono() + '\'' +
            ", email='" + getEmail() + '\'' +
            '}';
    }

}
