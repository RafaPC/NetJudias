/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zanalcar;

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
                    + "\n1.-Comprar Vehículo"
                    + "\n2.-Ver vehículo en stock"
                    + "\n3.-Vender vehículo"
                    + "\n4.-Facturación total"
                    + "\n5.-Probar vehículo"
                    + "\n8.-Salir");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    concesionario.comprarVehiculo();
                    break;
                case 2:
                    concesionario.cochesEnStock();
                    break;
                case 3:
                    concesionario.venderVehiculo();
                    break;
                case 4:
                    concesionario.facturacion();
                    break;
                case 5:
                    concesionario.probarVehiculo();
                    break;
                case 8:
                    salir = true;
                default:
                    System.out.println("Has introducido un número no válido, venga, inténtalo otra vez");
            }

        } while (!salir);
    }

}
