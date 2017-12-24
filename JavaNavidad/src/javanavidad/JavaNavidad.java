/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanavidad;

import java.util.Scanner;

/**
 *
 * @author Los Prieto
 */
public class JavaNavidad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Hacer el tablero
        char[][] tresenraya = new char[3][3];
        imprimirTablero(tresenraya);
        for (int i = 0; i < tresenraya.length; i++) {
            for (int j = 0; j < tresenraya[i].length; j++) {
                tresenraya[j][i] = '-';
            }

        }
        char turno = 'X';
        int x;
        int y;
        boolean repetido;
        // Jugar
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {

            do {
                repetido = false;
                System.out.println("En qué columna quieres poner la X");
                x = sc.nextInt();
                System.out.println("Y en qué fila?");
                y = sc.nextInt();
                if (tresenraya[x][y] == turno) {
                    repetido = true;
                    System.out.println("Ya hay una X en esa posición");
                }
                else tresenraya[x][y] = 'X';
            } while (repetido == true);

            // for de 9 veces, se sale si hay 3 en raya
            //HECHO se pide celda a poner, comprobar que no estaba ocupada
            //HECHO si esta ocupada pedir otra.
            // comprobar 3 en raya en funcion
            // dentro de la funcion llamar a funcion comprobarfila, comprobarcolumna
            // y comprobar diagonales.
            // misma fila
            boolean ganar;

            imprimirTablero(tresenraya);

            ganar = comprobarTresEnRaya(tresenraya, turno);
            if (ganar == true) {
                System.out.println("TRES EN RAYA");
            }
            
        }

    }

    public static boolean comprobarCol(char[][] tablero, char turno, int x) {
        boolean tresEnRaya = true;
        for (int j = 0; j < 3 && tresEnRaya; j++) {
            if (tablero[x][j] != turno) {
                tresEnRaya = false;
            }
        }

        return tresEnRaya;
    }

    public static boolean comprobarRow(char[][] tablero, char turno, int y) {
        boolean tresEnRaya = true;
        for (int j = 0; j < 3 && tresEnRaya; j++) {
            if (tablero[j][y] != turno) {
                tresEnRaya = false;
            }
        }

        return tresEnRaya;
    }

    public static boolean comprobarDiagonal(char[][] tablero, char turno) {
        boolean tresEnRaya = false;
        if (tablero[0][0] == turno) {
            if (tablero[1][1] == turno) {
                if (tablero[2][2] == turno) {
                    tresEnRaya = true;
                    System.out.println("diagonal true");
                }
            }
        } else if (tablero[2][0] == turno) {
            if (tablero[1][1] == turno) {
                if (tablero[0][2] == turno) {
                    tresEnRaya = true;
                }
            }

        }
        return tresEnRaya;
    }

    public static boolean comprobarTresEnRaya(char[][] tablero, char turno) {

        boolean prueba = false;

        for (int i = 0; i < 3 && prueba == false; i++) {
            prueba = comprobarRow(tablero, turno, i);
            if (prueba == false) {
                prueba = comprobarCol(tablero, turno, i);
            }
            /*if (tresEnRaya == false) {
                tresEnRaya = comprobarDiagonal(tablero, turno);
            }*/

        }

        return prueba;
    }

    public static void imprimirTablero(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[j][i]);
            }
            System.out.println("");
        }

    }

}
