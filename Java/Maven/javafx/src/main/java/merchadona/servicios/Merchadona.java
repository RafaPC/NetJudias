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
import java.util.List;
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
        Producto chocolate = new Producto("Chocolate", 2.34, 20);
        Producto leche = new Perecedero("Leche", 5.2, 7);
        Producto latas = new Producto("Latas", 3.4, 5);

        empleados.put(victor.getId_empleado(), victor);
        empleados.put(alvaro.getId_empleado(), alvaro);
        empleados.put(andrea.getId_empleado(), andrea);
        empleados.put(2, new Reponedor("YO", 2));
        empleados.put(3, new Cajera("TÚ", 3));
        productos.add(leche);
        productos.add(chocolate);

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

    public Empleado login(int id) {

        return empleados.get(id);
    }

    public int tipoEmpleado(int id) {
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

    public boolean darAltaProducto(String nombre, double precio, int stock, int opcion) {
        boolean altaOK = true;

        for (Producto producto1 : productos) {
            if (producto1.getNombre().equalsIgnoreCase(nombre)) {
                altaOK = false;
            }
        }
        if (opcion == 1) {
            productos.add(new Producto(nombre, precio, stock));
        } else {
            productos.add(new Perecedero(nombre, precio, stock));
        }
        return altaOK;

    }

    public boolean darBajaEmpleado(int id) {
        boolean bajaOK = false;
        if (empleados.get(id) != null) {
            bajaOK = true;
            empleados.remove(id);
        }
        return bajaOK;
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

    public List<Cajera> listaCajeras() {
        ArrayList<Cajera> cajeras = new ArrayList<>();
        for (Empleado empleado1 : empleados.values()) {
            if (empleado1 instanceof Cajera) {
                cajeras.add((Cajera) empleado1);
            }
        }
        return cajeras;
    }

    public void reponerProducto(int id, Producto producto, int cantidad) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).equals(producto)) {
                productos.get(i).sumStock(cantidad);
                if (productos.get(i) instanceof Perecedero) {
                    ((Perecedero) productos.get(i)).setFecha_reposicion(LocalDateTime.now());
                }
                ((Reponedor) empleados.get(id)).sumRepuestos(cantidad);
                i = productos.size();
            }

        }
    }

    private double caducacion(Producto producto) {
        LocalDateTime reposicion = ((Perecedero) producto).getFecha_reposicion();
        LocalDateTime actual = LocalDateTime.now();
        Duration d = Duration.between(reposicion, actual);
        long segundos = d.getSeconds();
        double precioBase = producto.getPrecio_base();
        //System.out.println("Han pasado " + segundos + " segundos");
        double descuento = segundos / Constantes.NUM_SEGUNDOS_BAJA_PRECIO * Constantes.FACTOR_BAJA_PRECIO * precioBase;
        double precioFinal;
        if (segundos > Constantes.NUM_SEGUNDOS_CADUCA) {
            //System.out.println("El producto esta caducado no es posible su venta");
            precioFinal = -1;
        } else {
            precioFinal = precioBase - descuento;
            // System.out.println("El precio a pagar por unidad es : " + precioFinal);
        }
        return precioFinal;
    }

    public int venderProducto(int id, int cantidad, Producto producto) {
        int error = 0;
        boolean salir = false;
        double total = 0;
        double precioProducto = producto.getPrecio_base();
        if (producto instanceof Perecedero) {
            precioProducto = caducacion(producto);
        }
        if (precioProducto != 0) {

            /*if (producto.getStock() > cantidad) {
                producto.setStock(producto.getStock() - cantidad);
                total = total + precioProducto * cantidad;
            } */
        } else {

            error = 2;
        }
        ((Cajera) empleados.get(id)).sumPrecio_total_vendidos(precioProducto);

        return error;

    }

    public Map<Integer, Empleado> getEmpleados() {
        return empleados;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

}
