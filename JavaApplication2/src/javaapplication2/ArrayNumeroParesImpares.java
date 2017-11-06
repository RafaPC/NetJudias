/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class ArrayNumeroParesImpares {

    public static void main(String[] args) {
        int[] pares = null;
        int n=0;
        //declarar scanner 
        Scanner sc = new Scanner(System.in);

        //pedir numero de numeros a leer
        System.out.println("dame numeros a leer");
        int numeroDeNumeros = sc.nextInt();
        //declarar array de numeros a leer
        int[] numeros = new int[numeroDeNumeros];
        //pedir numeros y meterlos en el array
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("dame otro numero");
            numeros[i] = sc.nextInt();
        }

        //recorrer array buscando los pares e impares
        int numPares = 0;
        int numImpares = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 == 0) {
                numPares++;
            } else {
                numImpares++;
            }
        }
        //declarar array pares e impares
        pares = new int[numPares];
        int[] impares = new int[numImpares];

        //recorrer array para meter los pares e impares en su array
        int indicePares = 0;
        int indiceImpares = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 == 0) {
                pares[indicePares] = numeros[i];
                indicePares++;
            } else {
                impares[indiceImpares] = numeros[i];
                indiceImpares++;
            }

        }
        //recorrer array de pares dar media
        double mediaPares = 0;
        for (int i = 0; i < pares.length; i++) {
            mediaPares += pares[i];
        }
        //recorrer array de impares dar media   
        double mediaImpares = 0;
        for (int i = 0; i < impares.length; i++) {
            mediaImpares += impares[i];
        }
        System.out.println("media de pares es " + mediaPares / numPares);
        System.out.println("media de impares es " + mediaImpares / numImpares);
    }
}
