/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.Random;

/**
 *
 * @author user
 */
public class AdviniaNumero {

    public static void main(String[] args) {
        //elegir numero aleatorio
        Random generadorNumerosAleatorios = new Random();
        int rangoMax = 8;
        int rangoMin = 3;
        int num = 0;

        int aleatorio = generadorNumerosAleatorios.nextInt(rangoMax-rangoMin+1) + rangoMin;
         int contador = 0;
         do {
           contador  ++;
            //pedir numero al usuario 
            num = 20;
            //comprobar si es igual, mayor o menor
            String mensaje = "";
            if (num == aleatorio) {
                mensaje = "ok acertaste." + "hoih";
            } else if (num > aleatorio) {
                mensaje = "mayor";
            } else if (num < aleatorio) {
                mensaje = "menor";
            } else {
            }//sacar por pantalla lo que pasa
            System.out.println(mensaje);
        }while ( (num != aleatorio)
           && 
           (contador !=5));
        // volver a pedir numero si no esta bien, ir arriba
    }

}
