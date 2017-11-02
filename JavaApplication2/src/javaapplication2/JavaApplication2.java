/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code applicahtion logic here
        Scanner sc = new Scanner(System.in);

        HashMap m = new HashMap();

        int sumando1;
        // primer sumando
        sumando1 = sc.nextInt();

        System.out.print("introduce el primer numero:");
        sumando1 = sc.nextInt();

        //segundo sumando
        int sumando2 = 8;
        System.out.print("introduce el segundo numero:");
        sumando2 = sc.nextInt();

        //la suma
        int suma = sumando1 + sumando2;
        //imprimir el resultado

        System.out.println(sumando1 + "+" + sumando2 + "="
          + (sumando1 + sumando2));
    }

}
