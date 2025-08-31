package com.heberbaraybar.modelo;

/**
 * Representa un cliente.
 * Contiene información nombre, apellido, teléfono, DNI y correo electrónico.
 * @author Heber
 * @version 1.1
 */
public class Cliente {

    private String nombre;
    private String apellido;
    private String telefono;
    private int dni;
    private String correo;

    /**
     * Constructor de la clase Cliente.
     * @param nombre Nombre del cliente
     * @param apellido Apellido del cliente
     * @param telefono Teléfono del cliente
     * @param dni Documento del cliente
     * @param correo Correo  del cliente
     */
    public Cliente(String nombre, String apellido, String telefono, int dni, String correo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.dni = dni;
        this.correo = correo;
    }

    /** @return nombre del cliente */
    public String getNombre(){ return nombre; }

    /** @return apellido del cliente */
    public String getApellido(){ return apellido; }

    /** @return teléfono del cliente */
    public String getTelefono(){ return telefono; }

    /** @return DNI del cliente */
    public int getDni(){ return dni; }

    /** @return correo del cliente */
    public String getCorreo(){ return correo; }

    /** @param nombre Nuevo nombre del cliente */
    public void setNombre(String nombre){ this.nombre = nombre; }

    /** @param apellido Nuevo apellido del cliente */
    public void setApellido(String apellido){ this.apellido = apellido; }

    /** @param telefono Nuevo teléfono del cliente */
    public void setTelefono(String telefono){ this.telefono = telefono; }

    /** @param dni Nuevo DNI del cliente */
    public void setDni(int dni){ this.dni = dni; }

    /** @param correo Nuevo del cliente */
    public void setCorreo(String correo){ this.correo = correo; }
}
