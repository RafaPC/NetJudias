/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package media;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author daw
 */
public class SieteMedia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);
        int cartas[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        float jugador = 0;
        float maquina = 0;
        barajarArray(cartas);

        int respuesta;
        int i = 0;
        System.out.println("Has sacado un " + cartas[i]);
        //Aquí se podría poner if(cartas[i]>7) pero asi queda más claro 
        if (cartas[i] == 8 || cartas[i] == 9 || cartas[i] == 10) {
            jugador += 0.5;
        } else {
            jugador += cartas[i];
        }
        i++;

        for (i = 1; jugador < 7.5; i++) {

            System.out.println("Tienes " + jugador + " puntos");
            System.out.println("¿Quiéres coger carta?");
            System.out.println("(1) Sí\n(2) Me planto");
            respuesta = sc.nextInt();

            if (respuesta == 1) {
                System.out.println("Has sacado un " + cartas[i]);
                if (cartas[i] == 8 || cartas[i] == 9 || cartas[i] == 10) {
                    jugador += 0.5;
                } else {
                    jugador += cartas[i];
                }
            } else {
                break;
            }

        }
        //si ha acabado de jugar porque se ha pasado le dice por cuanto se ha pasado
        if (jugador > 7.5) {
            System.out.println("Te has pasado por " + (jugador - 7.5));
        }

        System.out.println("------------------\nTurno de la máquina\n------------------");
        System.out.println("La máquina ha sacado un " + cartas[i]);
        if (cartas[i] == 8 || cartas[i] == 9 || cartas[i] == 10) {
            maquina += 0.5;
        } else {
            maquina += cartas[i];
        }
        i++;
        System.out.println("La máquina tiene " + maquina + " puntos");

        for (; maquina < 7.5; i++) {
            if (maquina > jugador || maquina == jugador) {
                System.out.println("La máquina se planta");
                break;
            }

            if (cartas[i] == 8 || cartas[i] == 9 || cartas[i] == 10) {
                maquina += 0.5;
            } else {
                maquina += cartas[i];
            }
            System.out.println("La máquina ha sacado un " + cartas[i]);
            System.out.println("La máquina tiene " + maquina + " puntos");
            
            i++;
        }

        if (jugador > 7.5 && maquina > 7.5) {
            System.out.println("Perdéis ambos");
        } else if (jugador > 7.5) {
            System.out.println("Ha ganado la máquina");
        } else if (maquina > 7.5) {
            System.out.println("Has ganado tú");
        } else {
            if ((jugador - 7.5) > (maquina - 7.5)) {
                System.out.println("Has ganado porque te has quedado más cerca");
            } else {
                System.out.println("Ha ganado la máquina porque se ha quedado más cerca");
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
