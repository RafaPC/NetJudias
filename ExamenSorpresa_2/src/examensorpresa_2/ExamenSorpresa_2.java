/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examensorpresa_2;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author daw
 */
public class ExamenSorpresa_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Elige programa");
        int programa = sc.nextInt();
        switch (programa) {
            case 1:
                ala();
                break;
            case 2:
                ale();
                break;
            case 3:
                olo();
                break;
        }
    }

    public static void ala() {
        int arraynumeros[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int arrayrepeticiones[] = {1, 1, 1, 1, 1, 2, 2, 1, 1, 1};
        int arrayfinal[] = new int[12];
        int k = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < arrayrepeticiones[i]; j++, k++) {
                arrayfinal[k] = arraynumeros[i];
            }

        }
        for (int i = 0; i < 12; i++) {
            System.out.print(arrayfinal[i]+", ");
        }
    }

    public static void ale() {
        int array[]=new int[]{1,2,3,4,5,6,7,8,9,10};
        int suma;
        int swap;
        int swap2;
        /*for(int i=0;i<10;i+=3){
            //suma dos números y los mete en suma
            suma=array[i]+array[i+1];
            //guarda el número en cuya posición irá la suma anterior
            swap=array[i+=2];
            //metemos suma
            array[i+=2]=suma;
            swap2=array[i+=3];
            array[i+=2]=swap;
        }*/
        for(int i=0;i<10;i++){
            System.out.println(array[i]);
        }
    }

    public static void olo() {
        int cartas[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        barajarArray(cartas);

        boolean cartaencontrada;
        for (int i = 1; i <= 10; i++) {
            cartaencontrada = false;
            for (int j = 0; cartaencontrada == false; j++) {
                if (cartas[j] == i) {
                    System.out.println("La posición del primer " + i + " es la número " + j);
                    cartaencontrada = true;
                }

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
