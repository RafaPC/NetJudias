/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanavidad;

import java.util.Random;

/**
 *
 * @author Gonzalo
 */
public class Solitario {

    public static void main(String[] args) {
        int cartas[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int palos[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4,};
        int ordenadas[] = new int[40];
        barajarArray(cartas);
        barajarArray(palos);
        boolean solitario = false;
        ordenadas[0] = cartas[0];
        cartas[0] = -99;

        int i=1;
        colocarCarta(cartas, ordenadas, palos, i);
        printArray(ordenadas);
        /*for (int i = 1; i < 40 && solitario == false; i++) {
            if (cartas[i] > ordenadas[i - 1]) {

            }
        }*/
    }

    public static void colocarCarta(int[] cartas, int[] ordenadas, int[] palos, int i) {
        for (int j = i; j < 40; j++) {
            if (cartas[j] > ordenadas[i - 1] && palos[j] == palos[i - 1]) {
                ordenadas[i] = cartas[j];
            }
        }
    }

    public static void printArray(int[] array) {
        for (int x = 0; x < array.length; x++) {
            System.out.println(array[x] + ", ");
        }
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
