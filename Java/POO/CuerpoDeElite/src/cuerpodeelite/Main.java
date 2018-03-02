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
        do{
        System.out.println("1.-Crear misión");
        opcion = sc.nextInt();
        sc.nextLine();
        switch(opcion){
            case 1:
                cosa.crearMision();
                break;
        }
        }while(opcion!=8);
        
    }

}
