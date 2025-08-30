package com.heberbaraybar.modelo;

public class Cliente {

    private String nombre;
    private String apellido;
    private String telefono;
    private int dni;
    private String correo;

    public Cliente(String nombre, String apellido, String telefono, int dni, String correo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.dni = dni;
        this.correo = correo;
    }

    public String getNombre(){ return nombre; }
    public String getApellido(){ return apellido; }
    public String getTelefono(){ return telefono; }
    public int getDni(){ return dni; }
    public String getCorreo(){ return correo; }

    public void setNombre(String nombre){ this.nombre = nombre; }
    public void setApellido(String apellido){ this.apellido = apellido; }
    public void setTelefono(String telefono){ this.telefono = telefono; }
    public void setDni(int dni){ this.dni = dni; }
    public void setCorreo(String correo){ this.correo = correo; }
}
