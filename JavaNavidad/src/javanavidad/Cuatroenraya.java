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
        char turno = 'X';
        int x;
        int y = 0;
        boolean ganar = false;
        // Jugar
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 42 && ganar == false; i++) {

            System.out.println("En qué columna quieres poner la " + turno);
            x = sc.nextInt();

            boolean colocada = false;

            for (int j = 5; j >= 0 && !colocada; j--) {
                if (tresenraya[x][j] == '-') {
                    tresenraya[x][j] = turno;
                    colocada = true;
                    y = j;
                }
            }

            ganar = comprobarTresEnRaya(tresenraya, turno, x, y);
            if (turno == 'X') {
                turno = 'O';
            } else {
                turno = 'X';
            }

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
        boolean cuatroEnRaya = false;
        int contador = 0;

        for (int j = 5; j >= 0 && !cuatroEnRaya; j--) {
            if (tablero[x][j] == turno) {
                contador++;
            } else if (tablero[x][j] != turno) {
                contador = 0;
            }

            if (contador == 4) {
                cuatroEnRaya = true;
            }
        }
        return cuatroEnRaya;
    }

    public static boolean comprobarRow(char[][] tablero, char turno, int y) {
        boolean cuatroEnRaya = false;
        int contador = 0;

        for (int j = 5; j >= 0 && !cuatroEnRaya; j--) {
            if (tablero[j][y] == turno) {
                contador++;
            } else if (tablero[j][y] != turno) {
                contador = 0;
            }

            if (contador == 4) {
                cuatroEnRaya = true;
            }
        }
        return cuatroEnRaya;
    }

    public static boolean comprobarDiagonal(char[][] tablero, char turno, int x, int y) {

        int cont1 = 0;
        int cont2 = 0;
        boolean cuatroEnRaya = false;
        boolean entablero = true;

        int i = 1;
        int j = 1;
        while (tablero[x][y] == turno && entablero) {
            //arribaizq
            entablero = entablero(tablero, x, y, -i, -j);
            if(entablero){
            if (tablero[x - i][y - j] == turno) {
                cont1++;
            }
            }
            //abajderecha
            entablero = entablero(tablero, x, y, i, j);
            if(entablero){
            if (tablero[x + i][y + j] == turno) {
                cont1++;
            }
            }
            //abajizq
            entablero = entablero(tablero, x, y, -i, j);
            if(entablero){
            if (tablero[x - i][y + j] == turno) {
                cont2++;
            }
            }
            //arribaderech
            entablero = entablero(tablero, x, y, i, -j);
            if(entablero){
            if (tablero[x + i][y - j] == turno) {
                cont2++;
            }
            }
            i++;
            j++;
            System.out.println("Contador 1= " + cont1);
            System.out.println("Contador 2= " + cont2);
        }
        if (cont1 >= 3 || cont2 >= 3) {
            cuatroEnRaya = true;
        }
        return cuatroEnRaya;
    }

    public static boolean entablero(char[][] tablero, int x, int y, int i, int j) {
        boolean entablero = true;
        int posicion1 = x + i;
        int posicion2 = y + j;
     System.out.println("X es " + posicion1 + "   Y es " + posicion2);
        if ((x + i < 0 || x + i > 6) || (y + j < 0 || y + j > 5)) {
            entablero = false;
            System.out.println("entablerofalse");
        } else {
            System.out.println("entablerotrue");
            
        }
        return entablero;
    }

    public static boolean comprobarTresEnRaya(char[][] tablero, char turno, int x, int y) {

        boolean cuatroEnRaya;

        cuatroEnRaya = comprobarCol(tablero, turno, x);

        if (cuatroEnRaya == false) {
            cuatroEnRaya = comprobarRow(tablero, turno, y);
        }
        if (cuatroEnRaya == false) {
            System.out.println("x" + x + ", y" + y);
            cuatroEnRaya = comprobarDiagonal(tablero, turno, x, y);
        }

        return cuatroEnRaya;
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
