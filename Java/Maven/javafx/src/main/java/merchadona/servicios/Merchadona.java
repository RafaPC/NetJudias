/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merchadona.servicios;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import merchadona.constantes.Constantes;
import merchadona.modelo.Cajera;
import merchadona.modelo.Empleado;
import merchadona.modelo.Perecedero;
import merchadona.modelo.Producto;
import merchadona.modelo.Reponedor;

/**
 *
 * @author daw
 */
public class Merchadona {

    Scanner sc = new Scanner(System.in);
    Map<Integer, Empleado> empleados = new LinkedHashMap<>();
    ArrayList<Producto> productos = new ArrayList<>();

    public Merchadona() {

        Empleado victor = new Reponedor("Victor", 1234);
        Empleado alvaro = new Cajera("Alvaro", 1235);
        Empleado andrea = new Reponedor("Andrea", 1236);
        Producto chocolate = new Producto("Chocolate", 2.34);
        Producto leche = new Perecedero(LocalDateTime.now(), "Leche", 5.2);
        Producto latas = new Producto("Latas", 3.4);

        empleados.put(victor.getId_empleado(), victor);
        empleados.put(alvaro.getId_empleado(), alvaro);
        empleados.put(andrea.getId_empleado(), andrea);
        productos.add(chocolate);
        productos.add(leche);
        productos.add(latas);

    }

    public void imprimirEmpleados() {
        for (Empleado empleado1 : empleados.values()) {
            System.out.println(empleado1);
        }
    }

    public void imprimirProductos() {
        int contador = 0;
        for (Producto producto1 : productos) {
            System.out.println("-" + contador + ". " + producto1);
            contador++;
        }
        System.out.println("------------------------------------------------");
    }

    public int login(int id) {
        int tipo = 0;

        if (id == Constantes.ADMIN_ID) {
            tipo = 1;
        } else if (empleados.get(id) instanceof Reponedor) {
            tipo = 2;
        } else if (empleados.get(id) instanceof Cajera) {
            tipo = 3;
        }
        return tipo;
    }

    public boolean darAltaEmpleado(String nombre, int id,
      int opcion) {
        boolean altaOK = false;
        if (empleados.get(id) == null) {
            switch (opcion) {
                case 1:
                    empleados.put(id, new Cajera(nombre, id));
                    break;
                case 2:
                    empleados.put(id, new Reponedor(nombre, id));
                    break;

            }
            altaOK = true;
        }
        return altaOK;
    }

    public void darAltaProducto() {
        int opcion;
        boolean comprobar = false;
        double precio;
        String nombre;
        System.out.println("Seleccione el tipo de Producto:");
        System.out.println("-1. Perecedero");
        System.out.println("-2. No Perecedero");
        opcion = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduce el Nombre del Producto:");
        nombre = sc.nextLine();
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getNombre().equalsIgnoreCase(nombre)) {
                comprobar = true;
                System.out.println("ya esta creado");
            }
        }
        if (!comprobar) {
            System.out.println("Introduce el Precio base del Producto:");
            precio = sc.nextDouble();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    productos.add(new Perecedero(LocalDateTime.now(), nombre, precio));
                    break;
                case 2:
                    productos.add(new Producto(nombre, precio));
                    break;
                default:
                    System.out.print("OPCION NO VALIDA\n");
                    break;
            }
        }
    }

    public void darBajaEmpleado() {
        int id;
        System.out.println("Introduce el ID del Empleado:");
        id = sc.nextInt();
        sc.nextLine();
        empleados.remove(id);
    }

    public void darBajaProducto() {
        String nombre;
        System.out.println("Introduce el Nombre del producto:");
        nombre = sc.nextLine();
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getNombre().equalsIgnoreCase(nombre)) {
                productos.remove(i);
            }
        }
    }

    public void listaCajeras() {
        for (Empleado empleado1 : empleados.values()) {
            if (empleado1 instanceof Cajera) {
                System.out.println(empleado1);
            }
        }
    }

    public void reponerProducto(int id) {
        int producto, cantidad;
        int totalRepos = ((Reponedor) empleados.get(id)).getNum_reposiciones();
        imprimirProductos();
        producto = sc.nextInt();
        sc.nextLine();

        System.out.println("Introduce la cantidad a reponer:");
        cantidad = sc.nextInt();
        productos.get(producto).setStock(productos.get(producto).getStock() + cantidad);
        totalRepos = totalRepos + cantidad;
        ((Reponedor) empleados.get(id)).setNum_reposiciones(totalRepos);
        if (productos.get(producto) instanceof Perecedero) {
            ((Perecedero) productos.get(producto)).setFecha_reposicion(LocalDateTime.now());
        }
    }

    private double caducacion(int producto) {
        LocalDateTime reposicion = ((Perecedero) productos.get(producto)).getFecha_reposicion();
        LocalDateTime actual = LocalDateTime.now();
        Duration d = Duration.between(reposicion, actual);
        long segundos = d.getSeconds();
        double precioBase = productos.get(producto).getPrecio_base();
        System.out.println("Han pasado " + segundos + " segundos");
        double descuento = segundos / Constantes.NUM_SEGUNDOS_BAJA_PRECIO * Constantes.FACTOR_BAJA_PRECIO * precioBase;
        double precioFinal;
        if (segundos > Constantes.NUM_SEGUNDOS_CADUCA) {
            System.out.println("El producto esta caducado no es posible su venta");
            precioFinal = 0;
        } else {
            precioFinal = precioBase - descuento;
            System.out.println("El precio a pagar por unidad es : " + precioFinal);
        }
        return precioFinal;
    }

    public void venderProducto(int id) {
        int producto, cantidad, siNo;
        boolean salir = false;
        double total = 0;
        do {
            System.out.println("Selecione el producto:");
            imprimirProductos();
            producto = sc.nextInt();
            sc.nextLine();
            double precioProducto = productos.get(producto).getPrecio_base();
            if (productos.get(producto) instanceof Perecedero) {
                precioProducto = caducacion(producto);
            }
            if (precioProducto != 0) {
                System.out.println("Introduce la cantidad:");
                cantidad = sc.nextInt();
                sc.nextLine();
                if (productos.get(producto).getStock() > cantidad) {
                    productos.get(producto).setStock(productos.get(producto).getStock() - cantidad);
                    total = total + precioProducto * cantidad;
                } else {
                    System.out.println("No hay esa cantidad en stock");
                }
            }
            System.out.println("Seguir vendiendo SI(1), NO(2)");
            siNo = sc.nextInt();
            sc.nextLine();
            if (siNo == 2) {
                System.out.println("El precio total de la venta son:" + total);
                ((Cajera) empleados.get(id)).setPrecio_total_vendidos(total);
                salir = true;
            }
        } while (!salir);

    }
}
