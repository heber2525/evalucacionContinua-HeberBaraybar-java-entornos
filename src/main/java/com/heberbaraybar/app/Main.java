package com.heberbaraybar.app;

import com.heberbaraybar.modelo.Cliente;
import com.heberbaraybar.modelo.Ropa;
import com.heberbaraybar.modelo.Venta;
import com.heberbaraybar.servicio.GestorClientes;
import com.heberbaraybar.servicio.GestorRopa;
import com.heberbaraybar.servicio.GestorVentas;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase principal del programa de gestión de tienda de ropa.
 * Permite gestionar clientes, productos y ventas desde un menú.
 * @author Heber
 * @version 1.0
 */
public class Main {

    /** Lista de clientes registrados */
    static ArrayList<Cliente> clientes = new ArrayList<>();
    /** Lista de productos disponibles */
    static ArrayList<Ropa> productos = new ArrayList<>();
    /** Lista de ventas realizadas */
    static ArrayList<Venta> ventas = new ArrayList<>();

    /**
     * Método principal que inicia el programa y muestra el menú principal.
     * @param args argumentos
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Gestión de clientes");
            System.out.println("2. Gestión de productos");
            System.out.println("3. Realizar venta");
            System.out.println("4. Mostrar ventas");
            System.out.println("Elige una opción");
            opcion = sc.nextInt(); sc.nextLine();

            switch (opcion) {
                case 1 -> GestorClientes.gestionarClientes(sc, clientes);
                case 2 -> GestorRopa.gestionarRopa(sc, productos);
                case 3 -> GestorVentas.gestionarVenta(sc, clientes, productos, ventas);
                case 4 -> Venta.mostrarTodasLasVentas(ventas);
            }

        } while (opcion != 5);
    }
}
