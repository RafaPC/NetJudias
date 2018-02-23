/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merchadona;

import java.time.LocalDateTime;
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

    private Scanner sc = new Scanner(System.in);
    Estrines estrines = new Estrines();
    private Map<Integer, Empleado> empleados = new LinkedHashMap<>();
    private ArrayList<Producto> stock = new ArrayList<>();
    private int id;

    public Merchadona() {
        Scanner sc = new Scanner(System.in);
        empleados.put(2896, new Cajero("Happy", 2896, 0));
        empleados.put(7203, new Cajero("HappySon", 7203, 0));
        empleados.put(1102, new Reponedor("HappyDaughter", 1102));
        empleados.put(2342, new Reponedor("HappyReponedor", 2342));
        stock.add(new Perecedero(2.99f, 8, "Plátanos"));
        stock.add(new Perecedero(19.99f, 6, "Aceite de girasol virgen super mega extra"));
        stock.add(new Perecedero(2.99f, 10, "Manzanas"));
        stock.add(new Producto(7.99f, 25, "Papel del culo"));
        stock.add(new Producto(6.99f, 20, "Fairy"));
        stock.add(new Producto(9.99f, 7, "Whisky"));
        stock.add(new Producto(4.99f, 20, "Nuka-Cola Quantum"));

        int id;
    }

    public int login() {
        int tipo = 0;
        System.out.println("Introduce tu ID");
        id = sc.nextInt();
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
        System.out.print("Nombre:");
        String nombre = sc.next();
        System.out.print("ID:");
        id = sc.nextInt();
        sc.nextLine();
        boolean idrepetida = false;
        for (Empleado emp : empleados.values()) {
            if (emp.id == id) {
                idrepetida = true;
            }
        }
        if (!idrepetida) {
            System.out.println("Va a ser cajero (1) o reponedor (2)");
            int opcion = sc.nextInt();
            sc.nextLine();
            if (opcion == 1) {
                empleados.put(id, new Cajero(nombre, id, 0));
            } else if (opcion == 2) {
                empleados.put(id, new Reponedor(nombre, id));
            }
        } else {
            System.out.println("Ya existe un empleado con esa ID");
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

    public void darAltaProducto() {
        System.out.print("Nombre del producto: ");
        String nombre = sc.next();
        boolean repetido = false;
        for (Producto producto : stock) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                repetido = true;
            }
        }
        if (repetido) {
            System.out.println("Ese producto ya existe");
        } else {
            System.out.print("Precio base: ");
            float preciobase = sc.nextFloat();
            sc.nextLine();
            System.out.print("Cantidad:");
            int cantidad = sc.nextInt();
            sc.nextLine();
            System.out.println("¿Va a tener caducidad?"
                    + "\nSí (1)"
                    + "\nNo (2)");
            int opcion = sc.nextInt();
            sc.nextLine();
            if (opcion == 2) {
                stock.add(new Producto(preciobase, cantidad, nombre));
            } else {
                stock.add(new Perecedero(preciobase, cantidad, nombre));
            }
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
            if (producto instanceof Perecedero) {
                ((Perecedero) producto).bajaPrecio();
            }
            System.out.println(i + ".- " + producto.toString());
            i++;
        }
        int producto = sc.nextInt();
        sc.nextLine();

        System.out.println("¿Cuánto vas a reponer?");
        int cantidad = sc.nextInt();
        sc.nextLine();

        if (stock.get(producto) instanceof Perecedero) {
            stock.get(producto).setCantidad(stock.get(producto).getCantidad()+cantidad);
            ((Perecedero)stock.get(producto)).setFechaReposicion(LocalDateTime.now());
            //stock.set(producto, new Perecedero(stsock.get(producto).getPreciobase(), stock.get(producto).getCantidad() + cantidad, stock.get(producto).getNombre()));
        } else {
            stock.get(producto).sumarStock(cantidad);
        }
        if (stock.get(producto) instanceof Perecedero) {
            System.out.println("Has roto las leyes de la física y has hecho volver esos " + stock.get(producto).getNombre() + " al pasado y han recuperado su frescura");
        }
    }

    public void listaProductos() {
        stock.forEach((producto) -> {
            if (producto instanceof Perecedero) {
                ((Perecedero) producto).bajaPrecio();
            }
            System.out.println(producto.toString());
        });
    }

    public void venderProductos() {
        int numproducto = 0;
        int cantidad = 0;
        float preciocompra = 0;
        do {
            System.out.println("¿Qué producto quieres vender?");
            int i = 0;
            for (Producto producto : stock) {
                if (producto instanceof Perecedero) {
                    ((Perecedero) producto).bajaPrecio();
                }
                System.out.println(i + ".- " + producto.toString());
                i++;
            }
            System.out.println("¿Qué producto quieres vender?");
            System.out.println("Escribe \"-1\" si quieres salir y facturar");
            numproducto = sc.nextInt();
            sc.nextLine();
            boolean caducado = false;

            if (numproducto == -1) {

            } else {
                if (stock.get(numproducto).getCantidad() == 0) {
                    System.out.println("No puedes comprar ese producto porque ya no hay en stock");
                } else {
                    if (stock.get(numproducto) instanceof Perecedero) {
                        caducado = ((Perecedero) stock.get(numproducto)).comprobarCaducado();
                    }
                    if (caducado) {
                        System.out.println("No puedes comprar " + stock.get(numproducto).getNombre() + "porque está caducado"
                                + "\nSi tantas ganas tienes de venderlo primero deberás reponerlo para que se recupere mágicamente");
                    } else {

                        System.out.println("¿Y qué cantidad?");
                        cantidad = sc.nextInt();
                        sc.nextLine();
                        //Por si se quieren vender más unidades de un producto de las que tiene
                        //Se venden las máximas que tiene
                        if (cantidad > stock.get(numproducto).getCantidad()) {
                            System.out.println("Solo puedes comprar " + stock.get(numproducto).getCantidad() + " unidades de ese producto, ya que no quedan más");
                            cantidad = stock.get(numproducto).getCantidad();
                        }

                        preciocompra += cantidad * stock.get(numproducto).getPreciobase();
                        stock.get(numproducto).restarStock(cantidad);
                    }

                }
            }
        } while (numproducto != -1);
        System.out.println("La compra ha sido de " + preciocompra + " euros");
        Cajero temp = (Cajero) empleados.get(id);
        temp.setPreciototal(temp.getPreciototal() + preciocompra); 
        empleados.replace(id, new Cajero(temp.nombre, id, temp.getPreciototal()));
        System.out.println("El precio total ahora es de " + temp.getPreciototal());

    }
}
