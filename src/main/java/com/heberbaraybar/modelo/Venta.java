package com.heberbaraybar.modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Venta {

    private  Cliente cliente;
    private ArrayList<Ropa> caja;

    public Venta(Cliente cliente){
        this.cliente = cliente;
        this.caja = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void agregarProducto( Ropa producto){
        caja.add(producto);
    }
    public double sumaTotal(){
        double total = 0;
        for(Ropa producto : caja){
            total += producto.getPrecio();
        }
        return total;
    }
    public static void mostrarTodasLasVentas(ArrayList<Venta> ventas){
        if(ventas.isEmpty()){
            System.out.println("No hay ventas registradas");
            return;
        }
        System.out.println("Estas son todas las ventas");
        for(int i = 0; i < ventas.size();i ++){
            System.out.println("com.heberbaraybar.modelo.Venta " + (i+1) + ":");
            Venta v = ventas.get(i);
            v.mostrarVenta();
        }
    }
    public void mostrarVenta(){
        System.out.println("com.heberbaraybar.app.Main.Cliente: " + cliente.getNombre());
        System.out.println("Ha comprado: " );
        for(Ropa producto : caja){
            System.out.println("-" + producto.getProducto()
                    + " | Referencia: " + producto.getReferencia()
                    + " | Talla: " + producto.getTalla()
                    + " | Color: " + producto.getColor()
                    + " | Precio: " + producto.getPrecio());
        }
        System.out.println("El total:  " + sumaTotal());
    }
    public static void mostrarVentaPorCliente(Scanner sc,ArrayList<Cliente> clientes, ArrayList<Venta> ventas){
        if(clientes.isEmpty()){
            System.out.println("No ha clientes con ventas");
            return;
        }
        System.out.println("Clientes diponibles: ");
        for(int i = 0; i < clientes.size(); i ++){
            Cliente indiceCliente = clientes.get(i);
            System.out.println((i + 1) + "Nombre: "  + indiceCliente.getNombre() + "\nApellido: " + indiceCliente.getApellido());
        }
        System.out.println("Ingrese número de cliente: ");
        int opcionCliente = sc.nextInt();sc.nextLine();
        if(opcionCliente < 1 || opcionCliente > clientes.size()){
            System.out.println("El número de clientes inválido");
            return;
        }
        Cliente clienteSeleccionado = clientes.get(opcionCliente - 1);
        System.out.println("Las ventas del cliente: " + clienteSeleccionado.getNombre()
                + " " + clienteSeleccionado.getApellido() + "son: ");

        boolean tieneVentas = false;
        for(Venta v : ventas){
            if(v.getCliente().equals(clienteSeleccionado)){
                v.mostrarVenta();
                tieneVentas = true;
            }
        }
        if(!tieneVentas){
            System.out.println("Este cliente no tiene ventas registradas");
        }
    }
    public static void importeTotalVenta(ArrayList<Venta> ventas){
        int contador = 0;
        for(Venta v : ventas){
            System.out.println("com.heberbaraybar.modelo.Venta " + contador++ + ":" + "\nImporte total: " + v.sumaTotal());
        }
    }

}
