/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merchadona;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import merchadona.empleados.Cajero;
import merchadona.empleados.Empleado;
import merchadona.empleados.Reponedor;
import merchadona.productos.Perecedero;
import merchadona.productos.Producto;

/**
 *
 * @author daw
 */
public class Merchadona {

    public Scanner sc = new Scanner(System.in);
    Estrines estrines = new Estrines();
    private Map<Integer, Empleado> empleados = new LinkedHashMap<>();
    private ArrayList<Producto> stock = new ArrayList<>();
    private int id;

    public Merchadona() {
        Scanner sc = new Scanner(System.in);
        empleados.put(2896, new Cajero("Happy", 2896, 0));
        empleados.put(7203, new Cajero("HappySon", 7203, 0));
        empleados.put(1102, new Reponedor("HappyDaughter", 1102));
        empleados.put(2342, new Reponedor("Happy", 2896));
        stock.add(new Perecedero(LocalDate.of(2018, 1, 10), 19.99f, 3, "Plátanos"));
        stock.add(new Producto(7.99f, 25, "Papel higiénico"));
        stock.add(new Producto(6.99f, 20, "Fairy"));
        int id;
    }

    public int login() {
        int tipo = 0;
        System.out.println("Introduce tu ID");
        int id = sc.nextInt();
        if (id == Constantes.ADMIN_ID) {
            System.out.println("Te has logeado como admin");
            tipo = 1;
        } else if (empleados.get(id) == null) {
            System.out.println("No existe ningún empleado con ese ID");
        } else {
            if (empleados.get(id) instanceof Cajero) {
                System.out.println("Te has logeado como\n" + empleados.get(id).nombre + "\nPuesto: Cajero");
                tipo = 2;
            }
            if (empleados.get(id) instanceof Reponedor) {
                System.out.println("Te has logeado como\n" + empleados.get(id).nombre + "\nPuesto: Reponedor");
                tipo = 3;
            }
        }
        return tipo;
    }

    public int logout() {
        int tipo = 0;
        System.out.println(estrines.msgLogout);
        return tipo;
    }

    public void darDeAlta() {
        System.out.println(estrines.msgLogin);
        System.out.println("Nombre:");
        String nombre = sc.next();
        System.out.println("ID:");
        id = sc.nextInt();
        sc.nextLine();
        System.out.println("Va a ser cajero (1) o reponedor (2)");
        int opcion = sc.nextInt();
        sc.nextLine();
        if (opcion == 1) {
            empleados.put(id, new Cajero(nombre, id, 0));
        } else if (opcion == 2) {
            empleados.put(id, new Reponedor(nombre, id));
        }
    }

    public void darDeBaja() {
        System.out.println("¿Qué empleado quieres dar de baja?");
        System.out.print("ID:");
        id = sc.nextInt();
        sc.nextLine();
        if (empleados.get(id) == null) {
            System.out.println("No existe ningún empleado con ese id");
        } else {
            empleados.remove(id);
        }
    }

    public void listaCajeras() {
        for (Empleado empleado : empleados.values()) {
            if (empleado instanceof Cajero) {
                System.out.println(empleado.toString());
            }
        }
    }

    public void reponerProducto() {
        System.out.println("¿Qué producto quieres reponer?");
        int i = 0;
        for (Producto producto : stock) {
            System.out.println(i + ".- " + producto.toString());
            i++;
        }
        int producto = sc.nextInt();
        sc.nextLine();

        System.out.println("¿Cuánto vas a reponer?");
        int cantidad = sc.nextInt();
        sc.nextLine();

        if (stock.get(producto) instanceof Perecedero) {

        } else {
            stock.get(producto).sumarStock(cantidad);
        }
    }

    public void listaProductos() {
        stock.forEach((producto) -> {
            System.out.println(producto.toString());
        });
    }

    public void venderProductos() {
        int numproducto = 0;
        do {
            System.out.println("¿Qué producto quieres vender?");
            int i = 0;
            for (Producto producto : stock) {
                System.out.println(i + ".- " + producto.toString());
                i++;
            }
            System.out.println("00.-Salir y facturar");
            numproducto = sc.nextInt();
            sc.nextLine();

            System.out.println("¿Y qué cantidad?");
            int cantidad = sc.nextInt();
            sc.nextLine();

            Cajero temp = (Cajero) empleados.get(id);
            temp.preciototal += cantidad * stock.get(numproducto).preciobase;
            empleados.replace(id, new Cajero(temp.nombre, id, temp.preciototal));
        } while (numproducto != 00);
        Cajero temp = (Cajero) empleados.get(id);
        System.out.println("El precio total ahora es de " + temp.preciototal);
    }
}
