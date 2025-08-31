package com.heberbaraybar.modelo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Representa una venta realizada a un cliente.
 * Contiene los productos comprados y permite mostrar información de la venta.
 * @author Heber
 * @version 1.0
 */
public class Venta {

    private Cliente cliente;
    private ArrayList<Ropa> caja;

    /**
     * Crea una venta para un cliente específico.
     * @param cliente cliente que realiza la compra
     */
    public Venta(Cliente cliente){
        this.cliente = cliente;
        this.caja = new ArrayList<>();
    }

    /** @return el cliente de la venta */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Agrega un producto a la venta.
     * @param producto prenda de ropa a agregar
     */
    public void agregarProducto(Ropa producto){
        caja.add(producto);
    }

    /**
     * Calcula el total de la venta sumando los precios de todos los productos.
     * @return importe total de la venta
     */
    public double sumaTotal(){
        double total = 0;
        for(Ropa producto : caja){
            total += producto.getPrecio();
        }
        return total;
    }

    /**
     * Muestra todas las ventas registradas.
     * @param ventas lista de ventas
     */
    public static void mostrarTodasLasVentas(ArrayList<Venta> ventas){
        if(ventas.isEmpty()){
            System.out.println("No hay ventas registradas");
            return;
        }
        System.out.println("Estas son todas las ventas");
        for(int i = 0; i < ventas.size(); i++){
            System.out.println("Venta " + (i + 1) + ":");
            Venta v = ventas.get(i);
            v.mostrarVenta();
        }
    }

    /** Muestra los detalles de la venta actual */
    public void mostrarVenta(){
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Ha comprado:" );
        for(Ropa producto : caja){
            System.out.println("- " + producto.getProducto()
                    + " | Referencia: " + producto.getReferencia()
                    + " | Talla: " + producto.getTalla()
                    + " | Color: " + producto.getColor()
                    + " | Precio: " + producto.getPrecio());
        }
        System.out.println("Total: " + sumaTotal());
    }

    /**
     * Muestra las ventas realizadas por un cliente específico.
     * @param sc Scanner para leer la entrada del usuario
     * @param clientes lista de clientes
     * @param ventas lista de ventas
     */
    public static void mostrarVentaPorCliente(Scanner sc, ArrayList<Cliente> clientes, ArrayList<Venta> ventas){
        if(clientes.isEmpty()){
            System.out.println("No hay clientes con ventas");
            return;
        }
        System.out.println("Clientes disponibles: ");
        for(int i = 0; i < clientes.size(); i++){
            Cliente indiceCliente = clientes.get(i);
            System.out.println((i + 1) + " Nombre: " + indiceCliente.getNombre() + "\nApellido: " + indiceCliente.getApellido());
        }

        System.out.println("Ingrese número de cliente: ");
        int opcionCliente = sc.nextInt(); sc.nextLine();
        if(opcionCliente < 1 || opcionCliente > clientes.size()){
            System.out.println("Número de cliente inválido");
            return;
        }

        Cliente clienteSeleccionado = clientes.get(opcionCliente - 1);
        System.out.println("Las ventas del cliente " + clienteSeleccionado.getNombre() + " " + clienteSeleccionado.getApellido() + " son: ");

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

    /**
     * Muestra el importe total de cada venta.
     * @param ventas lista de ventas
     */
    public static void importeTotalVenta(ArrayList<Venta> ventas){
        int contador = 0;
        for(Venta v : ventas){
            System.out.println("Venta " + contador++ + ": \nImporte total: " + v.sumaTotal());
        }
    }
}