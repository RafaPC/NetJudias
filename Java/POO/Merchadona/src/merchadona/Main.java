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
            //Menú principal cuando no estás logueado
            //Solo puedes elegir loguearte
            if (tipo == 0) {
                System.out.println(estrines.menu0);
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        tipo = merchadona.login();
                        break;
                }
            } else if (tipo == 1) {
                //Menú de admin, puede dar de alta y baja y esas cosas
                System.out.println(estrines.menuadmin);
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        merchadona.darDeAlta();
                        break;
                    case 2:
                        merchadona.darDeBaja();
                        break;
                    case 3:
                        merchadona.logout();
                        break;
                    case 4:
                        merchadona.listaCajeras();
                        break;
                    case 5:
                        tipo = merchadona.logout();
                        break;
                }
            } else if (tipo == 2) {
                System.out.println(estrines.menucajero);
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        merchadona.venderProductos();
                        break;
                    case 2:
                        tipo = merchadona.logout();
                        break;
                }
            } else {
                System.out.println(estrines.menureponedor);
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        merchadona.reponerProducto();
                        break;
                    case 2:
                        merchadona.listaProductos();
                        break;
                    case 3:
                        tipo = merchadona.logout();
                        break;
                }
            }

        } while (opcion != 8);

    }

}
