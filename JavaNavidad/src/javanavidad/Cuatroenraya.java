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
        boolean tresEnRaya = false;
        int contador = 0;

        for (int j = 5; j >= 0 && !tresEnRaya; j--) {
            if (tablero[x][j] == turno) {
                contador++;
                System.out.println("++");
            } else if (tablero[x][j] != turno) {
                contador = 0;
            }

            if (contador == 4) {
                tresEnRaya = true;
            }
        }
        System.out.println(tresEnRaya);
        return tresEnRaya;
    }

    public static boolean comprobarRow(char[][] tablero, char turno, int y) {
        boolean tresEnRaya = false;
        int contador = 0;

        for (int j = 5; j >= 0 && !tresEnRaya; j--) {
            if (tablero[j][y] == turno) {
                contador++;
                System.out.println("++");
            } else if (tablero[j][y] != turno) {
                contador = 0;
            }

            if (contador == 4) {
                tresEnRaya = true;
            }
        }
        System.out.println(tresEnRaya);
        return tresEnRaya;
    }

    public static boolean comprobarDiagonal(char[][] tablero, char turno, int x, int y) {
        
        int cont1 = 0;
        int cont2 = 0;
        
        boolean entablero = entablero(tablero, x, y);
        
        while (tablero[x][y] == turno && entablero){
        for(int i=0, j=0;tablero[x-i][y-i]==turno;i++,j++){
            cont1++;
        }
        for(int i=0, j=0;tablero[x+i][y+i]==turno;i++,j++){
            cont1++;
        }
        for(int i=0, j=0;tablero[x-i][y+i]==turno;i++,j++){
            cont2++;
        }
        for(int i=0, j=0;tablero[x+i][y-i]==turno;i++,j++){
            cont2++;
        }
        
        }
        return tresEnRaya;
    }

    public static boolean entablero(char[] [] tablero, int i, int j){
        boolean entablero = true;
        if((i<0 || i>5)||(j<0||j>6)){
            entablero = false;
        }
        return entablero;
    }
    
    public static boolean comprobarTresEnRaya(char[][] tablero, char turno, int x, int y) {

        boolean tresEnRaya = false;

        tresEnRaya = comprobarCol(tablero, turno, x);

        if (tresEnRaya == false) {
            tresEnRaya = comprobarRow(tablero, turno, y);
        }
        if (tresEnRaya == false) {
            tresEnRaya = comprobarDiagonal(tablero, turno, x, y);
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
