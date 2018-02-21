/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merchadona;

import java.util.Scanner;

/**
 *
 * @author daw
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        Estrines estrines = new Estrines();
        Merchadona merchadona = new Merchadona();
        int opcion = 0;
        int tipo = 0;
        do {
            if (tipo == 0) {
                System.out.println(estrines.menu);
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        tipo = merchadona.log();
                        break;
                    case 2:
                        merchadona.darDeAlta();
                        break;
                    case 3:
                        merchadona.darDeBaja();
                        break;
                }
            } else if (tipo == 1) {
                System.out.println("funciones de cajero");
            System.out.println("f1.- funcion 1"
                        + "\n2.- funcion2"
                        + "\n3.- Deslog");
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 3:
                        merchadona.deslog();
                        break;
                }
            } else if (tipo == 2) {
                System.out.println("f1.- funcion 1"
                        + "\n2.- funcion2"
                        + "\n3.- Deslog");
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 3:
                        merchadona.deslog();
                        break;
                }
            }

        } while (opcion != 10000);

    }

}
