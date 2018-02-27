/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohmygueim;

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
        OhMyGueim cosa = new OhMyGueim();
        int opcion;
        do {
            System.out.println("1.- Crear campeonato ó 2.- meter posiciones ó 3.-lista de campeonatos");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    cosa.crearCampeonato();
                    break;
                case 2:
                    cosa.modificarPosiciones();
                    break;
                case 3:
                    cosa.showCampeonatos();
                    break;
            }
        } while (opcion != 8);
    }

}
