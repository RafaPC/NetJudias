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
public class CombatCartas {

    public static void main(String[] args) {
        //inicializa dos array de 10 cartas
        int []mazo = {1,2,3,4,5,6,7,8,9,10};
        int []mazo2 = {1,2,3,4,5,6,7,8,9,10};

        //inicializa una array de 10 cartas
        
        //barajea los mazos
        barajarArray(mazo);
        barajarArray(mazo2);
        
        for (int i =0;i<mazo.length;i++)
            System.out.println(mazo[i]);
        
        
        //ir sacando una a una las cartas y comparandolas a ver quien gana
        
        
        //sacar el ganador.
    }

    public static void barajarArray(int[] array) {
        Random generadorNumerosAleatorios = new Random();
        int posicion;
        int posicion2;
        int swap;

        for (int i = 0; i < 20; i++) {
            posicion = generadorNumerosAleatorios.nextInt(array.length);
            posicion2 = generadorNumerosAleatorios.nextInt(array.length);
            swap = array[posicion];
            array[posicion] = array[posicion2];
            array[posicion2] = swap;
        }
    }

}
