/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package surprais;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author daw
 */
public class Surprais {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Elige ejercicio");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                hola();
                break;
            case 2:
                holo();
                break;
            case 3:
                ale();
                break;
        }
    }

    public static void hola() {
        int array1[] = {1, 3, 4, 5, 11, 13, 18, 29, 30, 31};
        int array2[] = {2, 8, 9, 10, 12, 15, 16, 40, 52, 53};
        int array3[] = {0, 23, 24, 25, 27, 101, 111, 223, 336, 445, 556,};
        int array4[] = new int[30];

        //Para array1
        int i = 0;
        //Para array2
        int j = 0;
        //Para array3
        int k = 0;
        //Para array4
        int l = 0;

        for (; i < 10 && j < 10 && k < 10; l++) {
            if (array1[i] < array2[j] && array1[i] < array3[k]) {
                array4[l] = array1[i];
                i++;
            } else if (array2[j] < array1[i] && array2[j] < array3[k]) {
                array4[l] = array2[j];
                j++;
            } else {
                array4[l] = array3[k];
                k++;
            }
        }

        if (i == 10 && j < 10 && k < 10) {
            while (j < 10 && k < 10) {
                if (array2[j] < array3[k]) {
                    array4[l] = array2[j];
                    j++;
                    l++;
                } else {
                    array4[l] = array3[k];
                    k++;
                    l++;
                }
            }
            if (j == 10) {
                while (k < 10) {
                    array4[l] = array3[k];
                    k++;
                    l++;
                }
            } else {
                while (j < 10) {
                    array4[l] = array2[j];
                    j++;
                    l++;
                }
            }
        } else if (j == 10 && i < 10 && k < 10) {
            while (i < 10 && k < 10) {
                if (array1[i] < array3[k]) {
                    array4[l] = array1[i];
                    i++;
                    l++;
                } else {
                    array4[l] = array3[k];
                    k++;
                    l++;
                }
            }
            if (i == 10) {
                while (k < 10) {
                    array4[l] = array3[k];
                    k++;
                    l++;
                }
            } else {
                while (i < 10) {
                    array4[l] = array1[i];
                    i++;
                    l++;
                }
            }
        } else {
            while (i < 10 && j < 10) {
                if (array1[i] < array2[j]) {
                    array4[l] = array1[i];
                    i++;
                    l++;
                } else {
                    array4[l] = array2[j];
                    j++;
                    l++;
                }

            }
            if (i == 10) {
                while (j < 10) {
                    array4[l] = array2[j];
                    j++;
                    l++;
                }
            } else {
                while (i < 10) {
                    array4[l] = array1[i];
                    i++;
                    l++;
                }
            }

        }

        //prueba para ver que todos los arrays estaban bien
        //System.out.println(i);
        //System.out.println(j);
        //System.out.println(k);
        //System.out.println(l);
        for (int x = 0; x < 30; x++) {
            System.out.print(array4[x] + ", ");
        }

    }

    public static void holo() {
        float arraynumeros[] = {1, 2, 3, 4, 0, 6, 7, 8, 9, 10};
        int arrayoperaciones[] = {1, 1, 1, 4, 1, 1, 1, 1, 1};
        int i = 0;
        float resultado = 0;
        switch (arrayoperaciones[i]) {
            case 1:
                resultado = arraynumeros[i] + arraynumeros[i + 1];
                break;
            case 2:
                resultado = arraynumeros[i] - arraynumeros[i + 1];
                break;
            case 3:
                resultado = arraynumeros[i] * arraynumeros[i + 1];
                break;
            case 4:
                resultado = arraynumeros[i] / arraynumeros[i + 1];
                break;
        }
        i++;
        for (; i < 9; i++) {
            //Para evitar hacer 0 entre 0
            if (arrayoperaciones[i] == 4 && arraynumeros[i + 1] == 0) {
                System.out.println("No se puede hacer una operación");
                break;
            }
            switch (arrayoperaciones[i]) {
                case 1:
                    resultado += arraynumeros[i + 1];
                    break;
                case 2:
                    resultado -= arraynumeros[i + 1];
                    break;
                case 3:
                    resultado *= arraynumeros[i + 1];
                    break;
                case 4:
                    resultado /= arraynumeros[i + 1];
                    break;
            }
        }
        //Para que no diga el resultado si no se ha podido hacer todo
        if (i == 9) {
            System.out.println(resultado);
        }
    }

    public static void ale() {
        int cartas[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        barajarArray(cartas);
        
        int carta;
        boolean cartaencontrada;
        for (int i = 1; i <= 10; i++) {
            carta=0;
            cartaencontrada=false;
            for (int j = 0; cartaencontrada==false; j++) {
                if (cartas[j] == i) {
                    carta++;
                }
                if (carta == 4) {
                    System.out.println("La posición del último " + i + " es la número " + j);
                    cartaencontrada=true;
                }
                //Esto era para ver si eso fallaba
                //System.out.println(j);
                //System.out.println(carta);
            
            }
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
