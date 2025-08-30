package com.heberbaraybar.servicio;

import com.heberbaraybar.modelo.Ropa;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorRopa {

    public static void gestionarRopa(Scanner sc, ArrayList<Ropa> productos){
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE PRODUCTOS ---");
            System.out.println("1. Dar de alta un producto");
            System.out.println("2. Buscar un producto por su referencia");
            System.out.println("3. Mostrar productos");
            System.out.println("4. Volver al menú principal");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt(); sc.nextLine();

            switch (opcion){
                case 1 -> altaProducto(sc, productos);
                case 2 -> buscarProducto(sc, productos);
                case 3 -> mostrarCatalogoProductos(productos);
                case 4 -> System.out.println("Volviendo al menú principal");
            }

        } while (opcion != 4);
    }

    public static void altaProducto(Scanner sc, ArrayList<Ropa> productos){
        System.out.println("Ingrese el nombre del producto: ");
        String producto = sc.nextLine();

        System.out.println("Ingrese la referencia: ");
        int referencia = sc.nextInt(); sc.nextLine();

        System.out.println("Ingrese el color: ");
        String color = sc.nextLine();

        System.out.println("Ingrese la talla: ");
        String talla = sc.nextLine();

        System.out.println("Ingrese el precio: ");
        String precioStr = sc.nextLine().replace(",", ".");
        double precio = Double.parseDouble(precioStr);

        Ropa nuevoProducto = new Ropa(producto, referencia, color, talla, precio);
        productos.add(nuevoProducto);
        System.out.println("Producto dado de alta correctamente");
    }

    public static void mostrarCatalogoProductos(ArrayList<Ropa> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el catálogo");
        } else {
            System.out.println("Los productos disponibles son:");
            for (int i = 0; i < productos.size(); i++) {
                Ropa prod = productos.get(i);
                System.out.println((i + 1) + " Producto: " + prod.getProducto() +
                        "\nReferencia: " + prod.getReferencia() +
                        "\nColor: " + prod.getColor() +
                        "\nTalla: " + prod.getTalla() +
                        "\nPrecio: " + prod.getPrecio());
            }
        }
    }

    public static void buscarProducto(Scanner sc, ArrayList<Ropa> productos){
        boolean productoEncontrado = false;
        int intentos = 0;

        while (!productoEncontrado && intentos < 3){
            System.out.println("Ingrese número de referencia del producto:");
            int productoBuscado = sc.nextInt(); sc.nextLine();

            for (Ropa item : productos){
                if(productoBuscado == item.getReferencia()){
                    System.out.println("El producto es: " + item.getProducto() +
                            "\nColor: " + item.getColor() +
                            "\nTalla: " + item.getTalla() +
                            "\nPrecio: " + item.getPrecio());
                    productoEncontrado = true;
                    break;
                }
            }

            if(!productoEncontrado){
                intentos++;
                if(intentos < 3){
                    System.out.println("Referencia no encontrada, intenta otra.");
                }
            }
        }

        if(!productoEncontrado){
            System.out.println("Intentos superados, producto no encontrado.");
        }
    }
}