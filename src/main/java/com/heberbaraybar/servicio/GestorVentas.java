package com.heberbaraybar.servicio;

import com.heberbaraybar.modelo.Cliente;
import com.heberbaraybar.modelo.Ropa;
import com.heberbaraybar.modelo.Venta;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase que gestiona las operaciones de ventas, incluyendo realizar ventas
 * y mostrar ventas registradas.
 * @author Heber
 * @version 1.5
 */
public class GestorVentas {

    /**
     * Muestra el menú de gestión de ventas y ejecuta la opción seleccionada.
     * @param sc Scanner para leer la entrada del usuario
     * @param clientes lista de clientes
     * @param productos lista de productos
     * @param ventas lista de ventas realizadas
     */
    public static void gestionarVenta(Scanner sc, ArrayList<Cliente> clientes, ArrayList<Ropa> productos, ArrayList<Venta> ventas){

        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE VENTAS ---");
            System.out.println("1. Realizar una venta");
            System.out.println("2. Mostrar todas las ventas realizadas");
            System.out.println("3. Mostrar ventas por cliente");
            System.out.println("4. Mostrar importe total de cada venta");
            System.out.println("5. Volver al menú principal");
            System.out.print("Escoge una opción: ");
            opcion = sc.nextInt(); sc.nextLine();

            switch (opcion){
                case 1 -> realizarVenta(sc, clientes, productos, ventas);
                case 2 -> Venta.mostrarTodasLasVentas(ventas);
                case 3 -> Venta.mostrarVentaPorCliente(sc, clientes, ventas);
                case 4 -> Venta.importeTotalVenta(ventas);
                case 5 -> System.out.println("Volviendo al menú principal");
            }

        } while (opcion != 5);

    }

    /**
     * Permite realizar una venta seleccionando un cliente y uno o más productos.
     * @param sc Scanner para leer la entrada del usuario
     * @param clientes lista de clientes
     * @param productos lista de productos disponibles
     * @param ventas lista de ventas donde se agregará la nueva venta
     */
    public static void realizarVenta(Scanner sc, ArrayList<Cliente> clientes, ArrayList<Ropa> productos, ArrayList<Venta> ventas){
        if(clientes.isEmpty()){
            System.out.println("No hay clientes dados de alta");
            return;
        }
        if(productos.isEmpty()){
            System.out.println("No hay productos dados de alta");
            return;
        }

        System.out.println("Clientes disponibles:");
        for(int i = 0; i < clientes.size(); i++){
            Cliente itemCliente = clientes.get(i);
            System.out.println((i + 1) + "- Nombre: " + itemCliente.getNombre() +
                    "\nApellido: " + itemCliente.getApellido());
        }

        System.out.println("Escoja un número de cliente:");
        int indiceCliente = sc.nextInt(); sc.nextLine();
        if(indiceCliente < 1 || indiceCliente > clientes.size()){
            System.out.println("Número cliente inválido");
            return;
        }

        Cliente clienteSeleccionado = clientes.get(indiceCliente - 1);
        Venta venta = new Venta(clienteSeleccionado);

        boolean agregarMasProductos = true;

        while(agregarMasProductos){
            System.out.println("Productos disponibles:");
            for(int i = 0; i < productos.size(); i++){
                Ropa itemRopa = productos.get(i);
                System.out.println((i + 1) + "- Producto: " + itemRopa.getProducto() +
                        "\nColor: " + itemRopa.getColor() +
                        "\nTalla: " + itemRopa.getTalla() +
                        "\nPrecio: " + itemRopa.getPrecio());
            }

            System.out.println("Selecciona un número de producto:");
            int indicePrenda = sc.nextInt(); sc.nextLine();
            if(indicePrenda < 1 || indicePrenda > productos.size()){
                System.out.println("El índice no corresponde a un producto");
                return;
            } else {
                venta.agregarProducto(productos.get(indicePrenda - 1));
                System.out.println("Producto añadido");
            }

            System.out.println("Desea agregar otro producto? (s/n)");
            String respuesta = sc.nextLine();
            agregarMasProductos = respuesta.equalsIgnoreCase("s");
        }

        ventas.add(venta);
        System.out.println("Venta agregada:");
        venta.mostrarVenta();
    }

}