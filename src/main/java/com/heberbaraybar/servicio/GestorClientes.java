package com.heberbaraybar.servicio;

import com.heberbaraybar.modelo.Cliente;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase para gestionar clientes en la aplicación.
 * Permite dar de alta, modificar, eliminar, mostrar y buscar clientes.
 * @author Heber
 * @version 1.6
 */
public class GestorClientes {

    /**
     * Muestra el menú de gestión de clientes y permite elegir una opción.
     * @param sc Scanner para leer la entrada del usuario
     * @param clientes Lista de clientes existentes
     */
    public static void gestionarClientes(Scanner sc, ArrayList<Cliente> clientes){
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE CLIENTES ---");
            System.out.println("1. Dar de alta un cliente");
            System.out.println("2. Modificar un cliente");
            System.out.println("3. Eliminar un cliente");
            System.out.println("4. Mostrar clientes");
            System.out.println("5. Buscar cliente por su dni");
            System.out.println("6. Volver al menú principal");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt(); sc.nextLine();

            switch (opcion){
                case 1 -> altaCliente(sc, clientes);
                case 2 -> modificarCliente(sc, clientes);
                case 3 -> eliminarCliente(sc, clientes);
                case 4 -> mostrarClientes(clientes);
                case 5 -> buscarCliente(sc, clientes);
                case 6 -> System.out.println("Volviendo al menu principal");
                default -> System.out.println("Opción no válida");
            }

        } while (opcion != 6);
    }

    /**
     * Da de alta un nuevo cliente pidiendo sus datos al usuario.
     * @param sc Scanner para leer la entrada del usuario
     * @param clientes Lista de clientes donde se agregará el nuevo cliente
     */
    public static void altaCliente(Scanner sc, ArrayList<Cliente> clientes){
        System.out.println("Ingrese el nombre: ");
        String nombre = sc.nextLine();

        System.out.println("Ingrese el apellido: ");
        String apellido = sc.nextLine();

        System.out.println("Ingrese el dni: ");
        int dni = sc.nextInt(); sc.nextLine();

        System.out.println("Ingrese el telefono: ");
        String telefono = sc.nextLine();

        System.out.println("Ingrese el correo: ");
        String correo = sc.nextLine();

        Cliente nuevoCliente = new Cliente(nombre, apellido, telefono, dni, correo);
        clientes.add(nuevoCliente);
        System.out.println("Cliente agregado correctamente.");
    }

    /**
     * Muestra todos los clientes existentes.
     * @param clientes Lista de clientes a mostrar
     */
    public static void mostrarClientes(ArrayList<Cliente> clientes){
        if (clientes.isEmpty()){
            System.out.println("No hay clientes dados de alta");
        } else {
            System.out.println("Listado de clientes:");
            for(int i = 0; i < clientes.size(); i++){
                Cliente cliente = clientes.get(i);
                System.out.println("\nCliente " + (i + 1) +
                        "\n- Nombre: " + cliente.getNombre() +
                        "\n- Apellido: " + cliente.getApellido() +
                        "\n- DNI: " + cliente.getDni() +
                        "\n- Teléfono: " + cliente.getTelefono() +
                        "\n- Correo: " + cliente.getCorreo());
            }
        }
    }

    /**
     * Modifica los datos de un cliente existente.
     * @param sc Scanner para leer la entrada del usuario
     * @param clientes Lista de clientes donde se buscará el cliente a modificar
     */
    public static void modificarCliente(Scanner sc, ArrayList<Cliente> clientes){
        if(clientes.isEmpty()){
            System.out.println("No hay clientes a modificar");
            return;
        }
        mostrarClientes(clientes);

        System.out.println("\nIngrese el número de cliente a modificar:");
        int indexCliente = sc.nextInt(); sc.nextLine();

        if(indexCliente < 1 || indexCliente > clientes.size()){
            System.out.println("Cliente inválido");
            return;
        }

        Cliente cliente = clientes.get(indexCliente - 1);
        boolean continuar;
        do{
            System.out.println("Qué datos quieres modificar?");
            System.out.println("1. Nombre");
            System.out.println("2. Apellido");
            System.out.println("3. Teléfono");
            System.out.println("4. DNI");
            System.out.println("5. Correo");
            int opcion = sc.nextInt(); sc.nextLine();

            switch (opcion){
                case 1 -> {
                    System.out.println("Nuevo nombre:");
                    cliente.setNombre(sc.nextLine());
                }
                case 2 -> {
                    System.out.println("Nuevo apellido:");
                    cliente.setApellido(sc.nextLine());
                }
                case 3 -> {
                    System.out.println("Nuevo teléfono:");
                    cliente.setTelefono(sc.nextLine());
                }
                case 4 -> {
                    System.out.println("Nuevo DNI:");
                    cliente.setDni(sc.nextInt()); sc.nextLine();
                }
                case 5 -> {
                    System.out.println("Nuevo correo:");
                    cliente.setCorreo(sc.nextLine());
                }
                default -> System.out.println("Opción no válida");
            }

            System.out.println("¿Quieres modificar otro dato más? (s/n)");
            continuar = sc.nextLine().equalsIgnoreCase("s");
        } while (continuar);

        System.out.println("¡Cambios modificados correctamente!");
    }

    /**
     * Elimina un cliente de la lista.
     * @param sc Scanner para leer la entrada del usuario
     * @param clientes Lista de clientes donde se eliminará el cliente
     */
    public static void eliminarCliente(Scanner sc, ArrayList<Cliente> clientes){
        if (clientes.isEmpty()){
            System.out.println("No hay clientes para borrar");
            return;
        }
        mostrarClientes(clientes);

        System.out.println("Qué cliente deseas borrar? Ingresa el número:");
        int indice = sc.nextInt(); sc.nextLine();

        if(indice < 1 || indice > clientes.size()) {
            System.out.println("No corresponde a ningún cliente");
        } else {
            Cliente eliminado = clientes.remove(indice - 1);
            System.out.println("El cliente " + eliminado.getNombre() + " " + eliminado.getApellido() + " se ha eliminado correctamente");
        }
    }

    /**
     * Busca un cliente por su DNI.
     * @param sc Scanner para leer la entrada del usuario
     * @param clientes Lista de clientes donde se realizará la búsqueda
     */
    public static void buscarCliente(Scanner sc, ArrayList<Cliente> clientes){
        if(clientes.isEmpty()){
            System.out.println("No hay clientes de alta");
            return;
        }

        int intentos = 0;
        boolean encontrado = false;

        while (!encontrado && intentos < 3){
            System.out.println("Ingrese el DNI del cliente que desea buscar:");
            int clienteBuscado = sc.nextInt(); sc.nextLine();

            for(Cliente cl : clientes){
                if(clienteBuscado == cl.getDni()){
                    System.out.println("El cliente es: " + cl.getNombre() + " " + cl.getApellido());
                    encontrado = true;
                    break;
                }
            }

            if(!encontrado){
                intentos++;
                if(intentos < 3){
                    System.out.println("DNI no encontrado, intenta de nuevo.");
                }
            }
        }

        if(!encontrado){
            System.out.println("Intentos superados, no se encontró el cliente.");
        }
    }
}
