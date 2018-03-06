/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuerpodeelite;

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
        CuerpoDeElite cosa = new CuerpoDeElite();
        int opcion = 0;
        do {
            System.out.println("1.- Crear misión"
                    + "\n2.- Relajar soldados"
                    + "\n3.- Lista de misiones"
                    + "\n4.- Lista de recursos");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    cosa.crearMision();
                    break;
                case 2:
                    cosa.bajarStress();
                    break;
                case 3:
                    cosa.listadoMisiones();
                    break;
                case 4:
                    cosa.listadoRecursos();
                    break;
            }
        } while (opcion != 8);

    }

}
