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
public class Cuatroenraya {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Hacer el tablero
        char[][] tresenraya = new char[7][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                tresenraya[j][i] = '-';
            }

        }
        char turnoX = 'X';
        char turnoO = 'O';
        char turno = turnoX;
        int x;
        int y;
        boolean repetido;
        boolean ganar = false;
        // Jugar
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 42 && ganar == false; i++) {

            do {
                repetido = false;
                System.out.println("En qué columna quieres poner la " + turno);
                x = sc.nextInt();
                System.out.println("Y en qué fila?");
                y = sc.nextInt();

                if (tresenraya[x][y] == turnoX || tresenraya[x][y] == turnoO) {
                    repetido = true;
                    System.out.println("Ya hay un " + tresenraya[x][y] + " en esa posición");
                } else {
                    for (int k = 5; k >= 0; k--) {
                        if (tresenraya[x][k] == '-') {
                            tresenraya[x][k] = turno;
                            k = 0;
                        }
                    }
                    ganar = comprobarTresEnRaya(tresenraya, turno);
                    if (turno == turnoX) {
                        turno = 'O';
                    } else {
                        turno = 'X';
                    }
                }
            } while (repetido == true);

            //HECHO for de 9 veces, se sale si hay 3 en raya
            //HECHO se pide celda a poner, comprobar que no estaba ocupada
            //HECHO si esta ocupada pedir otra.
            //HECHO comprobar 3 en raya en funcion
            //HECHO dentro de la funcion llamar a funcion comprobarfila, comprobarcolumna
            //HECHO y comprobar diagonales.
            //HECHO misma fila
            imprimirTablero(tresenraya);

            if (ganar == true) {
                System.out.println("CUATRO EN RAYA");
            }

        }

    }

    public static boolean comprobarCol(char[][] tablero, char turno, int x) {
        boolean tresEnRaya = false;
        int contadorX = 0;
        int contadorO = 0;

        for (int j = 5; j >= 0 && tresEnRaya == false; j--) {
            switch (tablero[x][j]) {
                case 'X':
                    contadorX++;
                    contadorO = 0;
                    break;
                case 'O':
                    contadorO++;
                    contadorX = 0;
                    break;
                case '-':
                    contadorX = 0;
                    contadorO = 0;
                    break;
            }
            if (contadorO == 4 || contadorX == 4) {
                j = -1;
                tresEnRaya = true;
            }
        }
        return tresEnRaya;
    }

    public static boolean comprobarRow(char[][] tablero, char turno, int y) {
        boolean tresEnRaya = false;
        int contadorX = 0;
        int contadorO = 0;

        for (int j = 0; j <= 6 && tresEnRaya == false; j++) {
            switch (tablero[j][y]) {
                case 'X':
                    contadorX++;
                    contadorO = 0;
                    break;
                case 'O':
                    contadorO++;
                    contadorX = 0;
                    break;
                case '-':
                    contadorX = 0;
                    contadorO = 0;
                    break;
            }
            if (contadorO == 4 || contadorX == 4) {
                tresEnRaya = true;
            }
        }

        return tresEnRaya;
    }

   /*public static boolean comprobarDiagonal(char[][] tablero, char turno) {
        boolean tresEnRaya = false;
        if (tablero[0][0] == turno) {
            if (tablero[1][1] == turno) {
                if (tablero[2][2] == turno) {
                    tresEnRaya = true;
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
    }*/

    public static boolean comprobarTresEnRaya(char[][] tablero, char turno) {

        boolean tresEnRaya = false;

        for (int i = 0; i <= 6 && tresEnRaya == false; i++) {
            if (i < 6) {
                tresEnRaya = comprobarRow(tablero, turno, i);
            }
            if (tresEnRaya == false && i < 6) {
                tresEnRaya = comprobarCol(tablero, turno, i);
            }
            if (tresEnRaya == false) {
                //tresEnRaya = comprobarDiagonal(tablero, turno);
            }

        }

        return tresEnRaya;
    }

    public static void imprimirTablero(char[][] tablero) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(tablero[j][i]);
            }
            System.out.println("");
        }

    }

}
