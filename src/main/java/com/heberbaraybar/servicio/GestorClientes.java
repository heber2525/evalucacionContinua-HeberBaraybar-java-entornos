package com.heberbaraybar.servicio;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorClientes {

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
                case 2 -> {modificarCliente(sc, clientes);
//                    if(!clientes.isEmpty()){
//                        mostrarClientes(clientes);
//                        System.out.println("Ingrese el dni del cliente a modificar: ");
//                        int indice = sc.nextInt();sc.nextLine();
//                        if(indice >= 1 && indice <= clientes.size()){
//                            modificarCliente(sc,clientes.get(indice - 1));
//                        }else {
//                            System.out.println("Número inválido");
//                        }
//                    }else {
//                        System.out.println("No hay clientes");
//                    }
                }
                case 3 -> eliminarCliente(sc, clientes);
                case 4 -> mostrarClientes(clientes);
                case 5 -> buscarCliente(sc, clientes);
                case 6 -> System.out.println("Volviendo al menu principal");
                default -> System.out.println("Opción no válida");
            }

        }
        while (opcion !=6);

    }
    public static void altaCliente(Scanner sc, ArrayList<Cliente> clientes){
        System.out.println("Ingrese el nombre: ");
        String nombre = sc.nextLine();

        System.out.println("Ingrese el apellido: ");
        String apellido = sc.nextLine();

        System.out.println("Ingrese el dni: ");
        int dni = sc.nextInt();sc.nextLine();

        System.out.println("Ingrese el telefono: ");
        String telefono = sc.nextLine();

        System.out.println("Ingrese el correo: ");
        String correo = sc.nextLine();

        Cliente nuevoCliente = new Cliente(nombre, apellido, telefono, dni, correo);
        clientes.add(nuevoCliente);

    }
    public static void mostrarClientes(ArrayList<Cliente> clientes){

        if (clientes.isEmpty()){
            System.out.println("No hay clientes dados de alta");
        }else{
            System.out.println("Este es el listado de clientes\n");
            for(int i = 0; i < clientes.size();i++){
               Cliente cliente = clientes.get(i);
                System.out.println("\nCliente: " + (i + 1) + "\n- Nombre: " + cliente.getNombre()
                        + "\n- Apellido: "  + cliente.getApellido()
                        + "\n- DNI: " + cliente.getDni()
                        + "\n- Teléfono: " + cliente.getTelefono()
                        + "\n- Correo: " + cliente.getCorreo());
            }
        }
        
    }

        public static void modificarCliente(Scanner sc, ArrayList<Cliente> clientes){
            if(clientes.isEmpty()){
                System.out.println("No hay clientes a modificar");
                return;
            }
            System.out.println("Este es el listado de clientes");
            mostrarClientes(clientes);

            System.out.println("\nIngrese el nro de cliente a modificar");
            int indexCliente = sc.nextInt();sc.nextLine();

            if(indexCliente < 1 || indexCliente > clientes.size()){
                System.out.println("Cliente Inválido");
                return;
            }


            Cliente cliente = clientes.get(indexCliente - 1);
            boolean continuar;
            do{
                System.out.println("Que datos quieres modificar?");
                System.out.println("1. Nombre");
                System.out.println("2. Apellido");
                System.out.println("3. Teléfono");
                System.out.println("4. DNI");
                System.out.println("5. Correo");
                int opcion = sc.nextInt();sc.nextLine();

                switch (opcion){
                    case 1 ->{
                        System.out.println("Nuevo nombre");
                        String nuevoNombre = sc.nextLine();
                        cliente.setNombre(nuevoNombre);
                    }
                    case 2 ->{
                        System.out.println("Nuevo apellido");
                        String nuevoApellido = sc.nextLine();
                        cliente.setApellido(nuevoApellido);
                    }
                    case 3 -> {
                        System.out.println("Nuevo Teléfono");
                    }
                    case 4 -> {
                        System.out.println("Nuevo dni");
                        int nuevoDni = sc.nextInt();
                        sc.nextLine();
                        cliente.setDni(nuevoDni);
                    }
                    case 5 -> {
                        System.out.println("Nuevo correo");
                        String nuevoCorreo = sc.nextLine();
                        cliente.setCorreo(nuevoCorreo);
                    }
                    default -> System.out.println("Opción no valida");
                }
                System.out.println("Quieres modificar otro dato mas ?");
                continuar = sc.nextLine().equalsIgnoreCase("s");
            }while (continuar);
                System.out.println("!!Cambios modificados");


        }
    public static void eliminarCliente(Scanner sc,ArrayList<Cliente> clientes){
        if (clientes.isEmpty()){
            System.out.println("No hay clientes para borrar");
            return;
        }
        mostrarClientes(clientes);

        System.out.println("Que cliente desea borrar, ingrese un número ?");
        int indice = sc.nextInt();sc.nextLine();

        if(indice < 1 || indice > clientes.size()) {
            System.out.println("No corresponde a ningún cliente");
        }else{
            Cliente eliminado = clientes.get(indice - 1);
            clientes.remove(indice - 1);
            System.out.println("El cliente " + " - " + eliminado.getNombre() + "  " + eliminado.getApellido() + "se ha eliminado correctamente");
            System.out.println("Estos son los clientes que quedaron de alta: " );
            mostrarClientes(clientes);
        }
        
    }
    public static void buscarCliente(Scanner sc, ArrayList<Cliente> clientes){
        if(clientes.isEmpty()){
            System.out.println("No hay clientes de alta");
            return;
        }
        int intentos = 0;
        boolean encontrado = false;

        while (!encontrado && intentos < 3){
            System.out.println("Ingrese el dni del cliente que desea buscar: ");
            int clienteBuscado = sc.nextInt();sc.nextLine();

            for(int i = 0; i < clientes.size(); i++){
                Cliente cl = clientes.get(i);
                if(clienteBuscado == cl.getDni()){
                    System.out.println("El cliente es: " + cl.getNombre() + " " + cl.getApellido());
                    encontrado = true;
                    break;
                }
            }
            if(!encontrado){
                intentos++;
                if(intentos < 3){
                    System.out.println("DNI no encontrado");
                }
            }
        }
        if(!encontrado){
            System.out.println("Intentos superados");
        }
    }

}
