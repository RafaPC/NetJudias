/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zanalcar;

import Vehiculos.Quad;
import Vehiculos.Coche;
import Vehiculos.Moto;
import Vehiculos.Bicicleta;
import java.util.Scanner;

/**
 *
 * @author daw
 */
public class ZanalCar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Concesionario concesionario = new Concesionario();
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        do {
            System.out.println("He aquí las opciones"
                    + "\n1.-Comprar coche"
                    + "\n2.-Ver coches en stock"
                    + "\n8.-Salir");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    concesionario.comprarVehiculo();
                    break;
                case 2:
                    concesionario.cochesEnStock();
                    break;
                case 8:
                    salir = true;
            }

        } while (!salir);
    }

}
