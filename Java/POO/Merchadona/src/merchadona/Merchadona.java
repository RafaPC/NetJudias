/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merchadona;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import merchadona.empleados.Cajero;
import merchadona.empleados.Empleado;
import merchadona.empleados.Reponedor;
import merchadona.productos.Perecedero;

/**
 *
 * @author daw
 */
public class Merchadona {

    public Scanner sc = new Scanner(System.in);
    Estrines estrines = new Estrines();
    public Map<Integer, Empleado> empleados = new LinkedHashMap<>();

    public Merchadona() {
        Scanner sc = new Scanner(System.in);
        empleados.put(2896, new Cajero("Happy", 2896));
        empleados.put(7203, new Cajero("HappySon", 7203));
        empleados.put(1102, new Reponedor("HappyDaughter", 1102));
        empleados.put(2896, new Reponedor("Happy", 2896));
        Perecedero temp = new Perecedero(LocalDate.of(2018, 1, 10), 19.99f, 3);
    }

    public int log() {
        int tipo = 0;
        System.out.println("Introduce tu ID");
        int id = sc.nextInt();
        if (id == 1) {
            System.out.println("Te has logeado como admin");
            tipo = 1;
        } else if (empleados.get(id) == null) {
            System.out.println("No existe ningún empleado con ese ID");
        } else {
            if (empleados.get(id) instanceof Cajero) {
                System.out.println("Te has logeado como " + empleados.get(id).nombre + "Puesto: Cajero");
                tipo = 2;
            }
            if (empleados.get(id) instanceof Reponedor) {
                System.out.println("Te has logeado como " + empleados.get(id).nombre + "Puesto: Reponedor");
                tipo = 3;
            }
        }
        return tipo;
    }
    public int deslog(){
        int tipo = 0;
        return tipo;
    }

    public void darDeAlta() {
        System.out.println("Dame el nombre del empleado e ID");
        System.out.println("Nombre:");
        String nombre = sc.next();
        System.out.println("ID:");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Va a ser cajero (1) o reponedor (2)");
        int opcion = sc.nextInt();
        sc.nextLine();
        if (opcion == 1) {
            empleados.put(id, new Cajero(nombre, id));
        } else if (opcion == 2) {
            empleados.put(id, new Reponedor(nombre, id));
        }
    }

    public void darDeBaja() {
        System.out.println("¿Qué empleado quieres dar de baja?");
        System.out.print("ID:");
        int id = sc.nextInt();
        sc.nextLine();
        if (empleados.get(id) == null) {
            System.out.println("No existe ningún empleado con ese id");
        } else {
            empleados.remove(id);
        }
    }
}
