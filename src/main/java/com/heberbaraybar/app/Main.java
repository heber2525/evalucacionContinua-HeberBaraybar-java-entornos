package com.heberbaraybar.app;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Ropa> productos = new ArrayList<>();
    static ArrayList<Venta> ventas = new ArrayList<>();

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int opcion;
    do{
        System.out.println("\n=== MENÚ PRINCIPAL ===");
        System.out.println("1. Gestión de clientes");
        System.out.println("2. Gestión de productos");
        System.out.println("3. Realizar venta");
        System.out.println("4. Mostrar ventas");
        System.out.println("Elige una opcion");
        opcion = sc.nextInt(); sc.nextLine();

        switch (opcion){
            case 1 -> GestorClientes.gestionarClientes(sc, clientes);
            case 2 -> GestorRopa.gestionarRopa(sc, productos);
            case 3 -> GestorVentas.gestionarVenta(sc, clientes, productos, ventas);
            case 4 -> Venta.mostrarTodasLasVentas(ventas);


        }
    }while (opcion != 5);
    }

    public static class Cliente {

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
        public String getNombre(){ return nombre;}
        public String getApellido(){return apellido;}
        public String getTelefono(){return  telefono;}
        public int getDni(){ return dni;}
        public String getCorreo(){ return correo;}

        public void setNombre(String nombre){
            this.nombre = nombre;
        }
        public void  setApellido(String apellido){
            this.apellido = apellido;
        }
        public void setTelefono(String telefono){
            this.telefono = telefono;
        }
        public void setDni(int dni){
            this.dni = dni;
        }
        public void setCorreo(String correo){
            this.correo = correo;
        }

    }
}
