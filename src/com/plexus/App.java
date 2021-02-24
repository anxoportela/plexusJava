package com.plexus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.InputMismatchException;

public class App {

    static ArrayList<Cliente> listaClientes = new ArrayList<>();
    static ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
    static ArrayList<Reparacion> listaReparaciones = new ArrayList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int idCliente = 0;
    static int idVehiculo = 0;

    public static void main(String[] args) {

        generaMenu();

    }

    public static void generaMenu() {
        int opt;
        try {
            System.out.print("\nMenú de opciones\n\n1. Gestionar clientes\n2. Gestionar vehículos\n3. Gestionar reparaciones\n4. Salir\n\nIngrese la opción deseada: ");
            opt = Integer.parseInt(br.readLine());
            if (opt == 4) {
                cleanUp();
                menuPrinc(opt);
            } else {
                menuPrinc(opt);
            }
        } catch (InputMismatchException e) {
            System.out.println("Debes insertar un número.");
            generaMenu();
        } catch (IOException e) {
            System.out.println("\nSe produjo un error: " + e.getMessage());
            generaMenu();
        }
    }

    public static void menuPrinc(int opcion) {

        switch (opcion) {
            case 1:
                generaMenuCliente();
                generaMenu();
                break;

            case 2:
                generaMenuVehiculos();
                generaMenu();
                break;

            case 3:
                generaMenuReparaciones();
                generaMenu();
                break;

            case 4:
                System.out.println("\n\nSalir\n");
                break;

            default:
                generaMenu();
                break;
        }

    }

    public static void generaMenuCliente() {
        int opt;
        try {
            System.out.print("\nMenú clientes\n\n1. Insertar cliente\n2. Buscar cliente\n3. Modificar cliente\n4. Listar clientes\n5. Borrar cliente\n6. Salir menú principal\n\nIngrese la opción deseada: ");
            opt = Integer.parseInt(br.readLine());
            if (opt == 6) {
                generaMenu();
            } else {
                menuCliente(opt);
            }
        } catch (InputMismatchException e) {
            System.out.println("Debes insertar un número.");
            generaMenuCliente();
        } catch (IOException e) {
            System.out.println("\nSe produjo un error: " + e.getMessage());
            generaMenuCliente();
        }
    }

    public static void menuCliente(int opcion) throws IOException {

        switch (opcion) {
            case 1:
                insertaCliente();
                generaMenuCliente();
                break;

            case 2:
                generaMenuBusCliente();
                generaMenuCliente();
                break;

            case 3:
                modificaCliente();
                generaMenuCliente();
                break;

            case 4:
                listarClientes();
                generaMenuCliente();
                break;

            case 5:
                borraCliente();
                generaMenuCliente();
                break;

            case 6:
                generaMenu();
                break;

            default:
                generaMenuCliente();
                break;
        }

    }

    public static void insertaCliente() throws IOException {

        System.out.print("Introduzca el nombre: ");
        var nom = br.readLine();
        System.out.print("Introduzca los apellidos: ");
        var ape = br.readLine();
        System.out.print("Introduzca el DNI: ");
        var dni = br.readLine();
        System.out.print("Introduzca la edad: ");
        var edad = Integer.parseInt(br.readLine());

        listaClientes.add(new Cliente(idCliente++, dni, nom, ape, edad));

    }

    public static void modificaCliente() throws IOException {
        System.out.print("Introduzca el id del cliente a modificar: ");
        var id = Integer.parseInt(br.readLine());
        for (Cliente cliente : listaClientes) {
            if (cliente.getClass().equals(Cliente.class)) {
                if (cliente.getIdCliente() == id) {
                    System.out.print("Introduzca el nuevo nombre: ");
                    var nom = br.readLine();
                    System.out.print("Introduzca los apellidos nuevos: ");
                    var ape = br.readLine();
                    System.out.print("Introduzca el nuevo DNI: ");
                    var dni = br.readLine();
                    System.out.print("Introduzca la nueva edad: ");
                    var edad = Integer.parseInt(br.readLine());
                    cliente.setNombre(nom);
                    cliente.setApellidos(ape);
                    cliente.setDni(dni);
                    cliente.setEdad(edad);
                }
            }
        }
    }

    private static void listarClientes() {
        listaClientes.forEach(System.out::println);
    }

    public static void borraCliente() throws IOException {
        System.out.print("Introduzca el id del cliente: ");
        var id = Integer.parseInt(br.readLine());
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getClass().equals(Cliente.class)) {
                Cliente aux = listaClientes.get(i);
                if (aux.getIdCliente() == id) {
                    listaClientes.remove(i);
                }
            }
        }
    }

    public static void generaMenuBusCliente() {
        int opt;
        try {
            System.out.print("\nBuscar cliente\n\n1. Por DNI\n2. Por nombre\n3. Por apellidos\n4. Salir a menú clientes\n\nIngrese la opción deseada: ");
            opt = Integer.parseInt(br.readLine());
            if (opt == 4) {
                generaMenuCliente();
            } else {
                menuBusCliente(opt);
            }
        } catch (InputMismatchException e) {
            System.out.println("Debes insertar un número.");
            generaMenu();
        } catch (IOException e) {
            System.out.println("\nSe produjo un error: " + e.getMessage());
            generaMenu();
        }
    }

    public static void menuBusCliente(int opcion) throws IOException {

        switch (opcion) {
            case 1:
                buscaDNI();
                generaMenuBusCliente();
                break;

            case 2:
                buscaNom();
                generaMenuBusCliente();
                break;

            case 3:
                buscaApe();
                generaMenuBusCliente();
                break;

            case 4:
                generaMenuCliente();
                break;

            default:
                generaMenuBusCliente();
                break;
        }

    }

    public static void buscaDNI() throws IOException {
        System.out.print("Introduzca el dni del cliente: ");
        var dni = br.readLine();
        for (Cliente cliente : listaClientes) {
            if (cliente.getDni().equals(dni)) {
                System.out.println(cliente);
            }
        }
    }

    private static void buscaNom() throws IOException {
        System.out.print("Introduzca el nombre del cliente: ");
        var nom = br.readLine();
        for (Cliente cliente : listaClientes) {
            if (cliente.getNombre().equals(nom)) {
                System.out.println(cliente);
            }
        }
    }

    private static void buscaApe() throws IOException {
        System.out.print("Introduzca el apellido del cliente: ");
        var ape = br.readLine();
        for (Cliente cliente : listaClientes) {
            if (cliente.getApellidos().contains(ape)) {
                System.out.println(cliente);
            }
        }
    }

    public static void generaMenuVehiculos() {
        int opt;
        try {
            System.out.print("\nMenú vehículos\n\n1. Insertar vehículo\n2. Buscar vehículo\n3. Modificar vehículo\n4. Borrar vehículo\n5. Salir menú principal\n\nIngrese la opción deseada: ");
            opt = Integer.parseInt(br.readLine());
            if (opt == 5) {
                generaMenu();
            } else {
                menuVehiculos(opt);
            }
        } catch (InputMismatchException e) {
            System.out.println("Debes insertar un número.");
            generaMenu();
        } catch (IOException e) {
            System.out.println("\nSe produjo un error: " + e.getMessage());
            generaMenu();
        }
    }

    public static void menuVehiculos(int opcion) throws IOException {

        switch (opcion) {
            case 1:
                insertaVehiculo();
                generaMenuVehiculos();
                break;

            case 2:
                generaMenuBusVehiculos();
                generaMenuVehiculos();
                break;

            case 3:
                modificaVehiculo();
                generaMenuVehiculos();
                break;

            case 4:
                listarVehiculos();
                generaMenuVehiculos();
                break;

            case 5:
                borraVehiculo();
                generaMenuVehiculos();
                break;

            case 6:
                generaMenu();
                break;

            default:
                generaMenuCliente();
                break;
        }

    }

    private static void insertaVehiculo() throws IOException {

        var check = false;
        for (Marcas listaMarcas : EnumSet.allOf(Marcas.class)) {
            System.out.print(listaMarcas + " ");
        }
        System.out.print("\nIntroduzca una de las marcas listadas: ");
        var marca = Marcas.valueOf(br.readLine().toUpperCase());
        System.out.print("Introduzca el modelo: ");
        var modelo = br.readLine();
        System.out.print("Introduzca el color: ");
        var color = br.readLine();
        System.out.print("Introduzca la matrícula: ");
        var matricula = br.readLine();
        System.out.print("Introduzca el año: ");
        var ano = Integer.parseInt(br.readLine());

        for (Marcas listaMarcas : EnumSet.allOf(Marcas.class)) {
            if (listaMarcas.equals(marca)) {
                check = true;
                break;
            }
        }

        if (check) {
            listaVehiculos.add(new Vehiculo(idVehiculo++, matricula, marca, modelo, ano, color));
        } else {
            System.out.println("La marca introducida es incorrecta");
        }
    }

    private static void modificaVehiculo() throws IOException {
        System.out.print("Introduzca el id del vehículo a modificar: ");
        var id = Integer.parseInt(br.readLine());
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getClass().equals(Vehiculo.class)) {
                if (vehiculo.getIdVehiculo() == id) {
                    for (Marcas listaMarcas : EnumSet.allOf(Marcas.class)) {
                        System.out.print(listaMarcas + " ");
                    }
                    System.out.print("\nIntroduzca una de las marcas listadas: ");
                    var marca = Marcas.valueOf(br.readLine().toUpperCase());
                    System.out.print("Introduzca el modelo: ");
                    var modelo = br.readLine();
                    System.out.print("Introduzca el color: ");
                    var color = br.readLine();
                    System.out.print("Introduzca ma matrícula: ");
                    var matricula = br.readLine();
                    System.out.print("Introduzca el año: ");
                    var ano = Integer.parseInt(br.readLine());
                    vehiculo.setMarcaVehiculo(marca);
                    vehiculo.setModelo(modelo);
                    vehiculo.setColor(color);
                    vehiculo.setMatricula(matricula);
                    vehiculo.setAno(ano);
                }
            }
        }
    }

    private static void listarVehiculos() {
        listaVehiculos.forEach(System.out::println);
    }

    private static void borraVehiculo() throws IOException {
        System.out.print("Introduzca el id del vehículo: ");
        var id = Integer.parseInt(br.readLine());
        for (int i = 0; i < listaVehiculos.size(); i++) {
            if (listaVehiculos.get(i).getClass().equals(Vehiculo.class)) {
                Vehiculo aux = listaVehiculos.get(i);
                if (aux.getIdVehiculo() == id) {
                    listaVehiculos.remove(i);
                }
            }
        }
    }


    public static void generaMenuBusVehiculos() {
        int opt;
        try {
            System.out.print("\nMBuscar vehículo\n\n1. Por matrícula\n2. Por marca/modelo\n3. Por marca/modelo/año\n4. Salir menú principal\n\nIngrese la opción deseada: ");
            opt = Integer.parseInt(br.readLine());
            if (opt == 4) {
                generaMenu();
            } else {
                menuBusVehiculos(opt);
            }
        } catch (InputMismatchException e) {
            System.out.println("Debes insertar un número.");
            generaMenu();
        } catch (IOException e) {
            System.out.println("\nSe produjo un error: " + e.getMessage());
            generaMenu();
        }
    }

    public static void menuBusVehiculos(int opcion) throws IOException {

        switch (opcion) {
            case 1:
                buscaMatricula();
                generaMenuBusVehiculos();
                break;

            case 2:
                buscaMarcMod();
                generaMenuBusVehiculos();
                break;

            case 3:
                buscaMarcModAno();
                generaMenuBusVehiculos();
                break;

            case 4:
                generaMenuVehiculos();
                break;

            default:
                generaMenuBusVehiculos();
                break;
        }

    }

    private static void buscaMatricula() {
    }

    private static void buscaMarcMod() {
    }

    private static void buscaMarcModAno() {
    }

    public static void generaMenuReparaciones() {
        int opt;
        try {
            System.out.print("\nMenú reparaciones\n\n1. Insertar reparación\n2. Buscar reparación\n3. Borrar reparación\n4. Salir menú principal\n\nIngrese la opción deseada: ");
            opt = Integer.parseInt(br.readLine());
            if (opt == 4) {
                generaMenu();
            } else {
                menuPrinc(opt);
            }
        } catch (InputMismatchException e) {
            System.out.println("Debes insertar un número.");
            generaMenu();
        } catch (IOException e) {
            System.out.println("\nSe produjo un error: " + e.getMessage());
            generaMenu();
        }
    }


    public static void generaMenuBusReparaciones() {
        int opt;
        try {
            System.out.print("\nBuscar reparación\n\n1. Por cliente\n2. Por vehículo\n3. Por fecha\n4. Salir menú principal\n\nIngrese la opción deseada: ");
            opt = Integer.parseInt(br.readLine());
            if (opt == 4) {
                generaMenu();
            } else {
                menuPrinc(opt);
            }
        } catch (InputMismatchException e) {
            System.out.println("Debes insertar un número.");
            generaMenu();
        } catch (IOException e) {
            System.out.println("\nSe produjo un error: " + e.getMessage());
            generaMenu();
        }
    }

    public static void cleanUp() throws IOException {
        br.close();
    }

}
