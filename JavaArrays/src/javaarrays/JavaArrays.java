/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaarrays;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author daw
 */
public class JavaArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Elige programa: ");
        int programa;
        programa = sc.nextInt();
        switch (programa) {

            case 1:
                ejercicio1(sc);
                break;
            case 2:
                ejercicio2(sc);
                break;
            case 3:
                ejercicio3(sc);
                break;
            case 4:
                ejercicio4(sc);
                break;
            case 5:
                ejercicio5(sc);
                break;
            case 6:
                ejercicio6(sc);
                break;
            case 7:
                ejercicio7(sc);
                break;
            case 8:
                ejercicio8(sc);
                break;
            case 9:
                ejercicio9(sc);
                break;
            case 10:
                ejercicio10(sc);
                break;
            case 11:
                ejercicio11(sc);
                break;
            case 12:
                ejercicio12(sc);
                break;
            case 13:
                ejercicio13(sc);
                break;
            case 14:
                ejercicio14(sc);
                break;
            case 15:
                ejercicio15(sc);
                break;
            case 16:
                ejercicio16(sc);
                break;
            case 17:
                ejercicio17(sc);
                break;
            default:
                System.out.println("Has elegido un programa que no existe");
        }
    }

    public static void ejercicio1(Scanner sc) {
        int numeros[] = new int[5];
        System.out.println("Dame 5 números enteros ");
        for (int i = 0; i < 5; i++) {
            System.out.print("Introduce un número: ");
            numeros[i] = sc.nextInt();
        }
        System.out.println("Ahí van tus números:");
        for (int i = 0; i < 5; i++) {
            System.out.print(numeros[i]+", ");
        }
    }

    public static void ejercicio2(Scanner sc) {
        int numeros[] = new int[5];
        System.out.println("Dame 5 números enteros ");
        for (int i = 0; i < 5; i++) {
            System.out.print("Introduce un número: ");
            numeros[i] = sc.nextInt();
        }
        System.out.println("Ahí van tus números al revés");
        for (int i = 4; i >= 0; i--) {
            System.out.print(numeros[i]+", ");
        }
    }

    public static void ejercicio3(Scanner sc) {
        int numeros[] = new int[5];
        int acumpositivos = 0;
        int acumnegativos = 0;
        int ceros = 0;
        int npositivos = 0;
        int nnegativos = 0;
        System.out.println("Dame 5 números enteros ");
        for (int i = 0; i < 5; i++) {
            System.out.print("Introduce un número: ");
            numeros[i] = sc.nextInt();
        }
        for (int i = 0; i < 5; i++) {
            if (numeros[i] > 0) {
                acumpositivos += numeros[i];
                npositivos++;
            } else if (numeros[i] < 0) {
                acumnegativos += numeros[i];
                nnegativos++;
            } else {
                ceros++;
            }
        }

        if (npositivos > 0) {
            System.out.println("La media de los positivos es " + acumpositivos / npositivos);
        }
        if (nnegativos > 0) {
            System.out.println("La media de los negativos es " + acumnegativos / nnegativos);
        }
        if (ceros > 0) {
            System.out.println("Has introducido " + ceros + " ceros");
        }
    }

    public static void ejercicio4(Scanner sc) {
        int array[] = new int[10];
        System.out.println("Dame 10 números enteros ");
        for (int i = 0; i < 10; i++) {
            System.out.print("Introduce un número: ");
            array[i] = sc.nextInt();
        }

        for (int i = 0, j = 9; i < 5; i++, j--) {
            System.out.println(array[i]);
            System.out.println(array[j]);
        }
    }

    public static void ejercicio5(Scanner sc) {
        int array1[] = new int[10];
        int array2[] = new int[10];
        int array3[] = new int[20];
        System.out.println("Introduce los 10 números del primer array");
        for (int i = 0; i < 10; i++) {
            System.out.print("Introduce un número: ");
            array1[i] = sc.nextInt();
        }
        System.out.println("Ahora los 10 del segundo");
        for (int i = 0; i < 10; i++) {
            System.out.print("Introduce un número: ");
            array2[i] = sc.nextInt();
        }
        for (int i = 0, j = 0; i < 10; i++, j++) {
            array3[j] = array1[i];
            j++;
            array3[j] = array2[i];
        }
        System.out.println("Este es el tercer array");
        for (int i = 0; i < 20; i++) {
            System.out.print(array3[i]+", ");
        }
    }

    public static void ejercicio6(Scanner sc) {
        int array1[] = new int[12];
        int array2[] = new int[12];
        int array3[] = new int[24];
        System.out.println("Introduce los 12 números del primer array");
        for (int i = 0; i < 12; i++) {
            System.out.print("Introduce un número: ");
            array1[i] = sc.nextInt();
        }
        System.out.println("Ahora los 12 del segundo");
        for (int i = 0; i < 12; i++) {
            System.out.print("Introduce un número: ");
            array2[i] = sc.nextInt();
        }

        int posicion = 0;

        for (int i = 0; i < 12; i += 3) {
            for (int j = 0; j < 3; j++) {
                array3[posicion] = array1[i + j];
                posicion++;
            }
            for (int j = 0; j < 3; j++) {
                array3[posicion] = array2[i + j];
                posicion++;
            }
        }
        System.out.println("\nTercer array:");
        for (int i = 0; i < 24; i++) {
            System.out.print(array3[i] + ", ");
        }
    }

    public static void ejercicio7(Scanner sc) {
        int array[] = new int[10];
        System.out.println("Dame 10 números enteros ");
        for (int i = 0; i < 10; i++) {
            System.out.print("Introduce un número: ");
            array[i] = sc.nextInt();
        }
        boolean creciente = true;
        boolean decreciente = true;
        for (int i = 1; i < 10; i++) {
            if (array[i] > array[i - 1]) {
                decreciente = false;
            } else if (array[i] < array[i - 1]) {
                creciente = false;
            } else {
                creciente = false;
                decreciente = false;
            }

        }

        if (creciente == true) {
            System.out.println("El array es creciente");
        } else if (decreciente == true) {
            System.out.println("El array es decreciente");
        } else {
            System.out.println("El array está desordenado");
        }
    }

    public static void ejercicio8(Scanner sc) {

        int array[] = new int[10];
        System.out.println("Dame 8 números enteros ");
        for (int i = 0; i < 8; i++) {
            System.out.print("Introduce un número: ");
            array[i] = sc.nextInt();
        }
        int num;
        int posicion;
        System.out.println("Dime otro número que quieras introducir");
        num = sc.nextInt();
        System.out.println("Y la posición donde quieres introducirlo (recuerda que tiene que ser entre 1 y 10, ambos inclusive)");
        posicion = sc.nextInt() - 1;

        for (int i = 7; i >= posicion; i--) {
            array[i + 1] = array[i];
        }
        array[posicion] = num;

        System.out.println("Este es tu array ahora");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
    }

    public static void ejercicio9(Scanner sc) {
        int array[] = new int[10];
        System.out.println("Dame 11 números enteros ");
        for (int i = 0; i < 10; i++) {
            System.out.print("Introduce un número: ");
            array[i] = sc.nextInt();
        }
        System.out.println("Ese era tu array inicial");
        for (int i = 0; i < 10; i++) {
            System.out.print(array[i] + ", ");
        }

        int ayuda1 = array[9];
        int ayuda2;

        for (int i = 9; i > 0; i--) {

            ayuda2 = array[i - 1];
            array[i - 1] = ayuda1;
            ayuda1 = ayuda2;

            if (i == 1) {
                array[9] = ayuda2;

            }
        }

        System.out.println("\nY este es tu array ahora");
        for (int i = 0; i < 10; i++) {
            System.out.print(array[i] + ", ");
        }
    }

    public static void ejercicio10(Scanner sc) {
        int array[] = new int[10];
        int ayuda;
        System.out.println("Dame 10 números enteros ");
        for (int i = 0; i < 10; i++) {
            System.out.print("Introduce un número: ");
            array[i] = sc.nextInt();
        }
        System.out.println("¿Cuántas posiciones quieres mover los valores del array?");
        int posiciones = sc.nextInt();
        for (int i = 1; i <= posiciones; i++) {
            ayuda = array[9];
            for (int j = 8; j >= 0; j--) {
                array[j + 1] = array[j];
            }
            array[0] = ayuda;
        }

        System.out.println("Este es tu array ahora");
        for (int i = 0; i < 10; i++) {
            System.out.print(array[i] + ", ");
        }
    }

    public static void ejercicio11(Scanner sc) {
        int array[] = new int[10];
        System.out.println("Dame 5 números enteros ");
        for (int i = 0; i < 5; i++) {
            System.out.print("Introduce un número: ");
            array[i] = sc.nextInt();
        }
        System.out.println("Ahora dime que número quieres insertar");
        int num = sc.nextInt();

        int j = 0;
        int posicion = 0;
        while (array[j] < num && j <= 4) {
            posicion++;
            j++;
        }
        for (int i = 4; i >= posicion; i--) {
            array[i + 1] = array[i];
        }
        array[posicion] = num;
        System.out.println("Este es tu array ahora");

        for (int i = 0; i < 10; i++) {
            System.out.print(array[i] + ", ");
        }

    }

    public static void ejercicio12(Scanner sc) {
        int array[] = new int[10];
        System.out.println("Dame 10 números enteros ");
        for (int i = 0; i < 10; i++) {
            System.out.print("Introduce un número: ");
            array[i] = sc.nextInt();
        }
        System.out.println("Ahora dime que posicion quieres borrar");
        int posicion = sc.nextInt() - 1;
        for (int i = posicion; i < 9; i++) {
            array[i] = array[i + 1];
        }
        System.out.println("Este es tu array ahora");
        for (int i = 0; i < 9; i++) {
            System.out.print(array[i]+", ");
        }
    }

    public static void ejercicio13(Scanner sc) {
        int array[] = new int[10];
        System.out.println("Dame 10 números enteros ");
        for (int i = 0; i < 10; i++) {
            System.out.print("Introduce un número: ");
            array[i] = sc.nextInt();
        }
        int pares = 0;
        int impares = 0;
        for (int i = 0; i < 10; i++) {
            if ((array[i] % 2) == 0) {
                pares++;
            } else {
                impares++;
            }
        }
        int arraypares[] = new int[pares];
        int arrayimpares[] = new int[impares];
        int j = 0;
        int k = 0;
        //Versión utilizando los valores
        System.out.println("Hecho con valores:");
        for (int i = 0; i < 10; i++) {
            if ((array[i] % 2) == 0) {
                arraypares[j] = array[i];
                j++;
            } else {
                arrayimpares[k] = array[i];
                k++;
            }
        }
        System.out.println("Ahí va tu array de pares");
        for (int i = 0; i < pares; i++) {
            System.out.print(arraypares[i] + ", ");
        }
        System.out.println("\nAhí va tu array de impares");
        for (int i = 0; i < impares; i++) {
            System.out.print(arrayimpares[i] + ", ");
        }
        //Versión utilizando los índices
        j = 0;
        k = 0;
        System.out.println("\n---------------\nHecho con índices:");
        for (int i = 0; i < 10; i++) {
            if ((array[i] % 2) == 0) {
                arraypares[j] = i;
                j++;
            } else {
                arrayimpares[k] = i;
                k++;
            }

        }
        System.out.println("Ahí va tu array de pares");
        for (int i = 0; i < pares; i++) {
            System.out.print(array[arraypares[i]] + ", ");
        }
        System.out.println("\nAhí va tu array de impares");
        for (int i = 0; i < impares; i++) {
            System.out.print(array[arrayimpares[i]] + ", ");
        }
    }

    public static void ejercicio14(Scanner sc) {
        int array1[] = new int[10];
        int array2[] = new int[10];
        int array3[] = new int[20];

        System.out.println("Dame los 10 números del primer array, tienen que ser crecientes");
        for (int i = 0; i < 10; i++) {
            System.out.print("Introduce un número: ");
            array1[i] = sc.nextInt();
            if (i > 0) {
                if (!(array1[i] > array1[i - 1])) {
                    System.out.println("El número tiene que ser mayor que el anterior (" + array1[i - 1] + ")");
                    i--;
                }
            }
        }
        System.out.println("Dame los 10 números del segundo array, tienen que ser crecientes");
        for (int i = 0; i < 10; i++) {
            System.out.print("Introduce un número: ");
            array2[i] = sc.nextInt();
            if (i > 0) {
                if (!(array2[i] > array2[i - 1])) {
                    System.out.println("El número tiene que ser mayor que el anterior (" + array2[i - 1] + ")");
                    i--;
                }

            }
        }
        int i = 0;
        int j = 0;
        int k = 0;
        for (;i < 10 && j < 10;k++) {
            if (array1[i] < array2[j]) {
                array3[k] = array1[i];
                i++;
            } else {
                array3[k] = array2[j];
                j++;
            }
        }
        if (j == 10) {
            while (i < 10) {
                array3[k] = array1[i];
                i++;
                k++;
            }
        } else {
            while (j < 10) {
                array3[k] = array2[j];
                j++;
                k++;
            }
        }
        for (int x = 0; x < 20; x++) {
            System.out.print(array3[x] + ", ");
        }
    }

    public static void ejercicio15(Scanner sc) {

        int array[] = new int[10];
        System.out.println("Dame 10 números enteros ");
        for (int i = 0; i < 10; i++) {
            System.out.print("Introduce un número: ");
            array[i] = sc.nextInt();
        }
        System.out.println("¿Qué número quieres que encuentre?");
        int numero = sc.nextInt();
        int posicion = 0;
        boolean num = false;
        for (int i = 0; i < 10; i++) {
            if (array[i] == numero) {
                num = true;
                posicion = i + 1;
            }
        }
        if (num == true) {
            System.out.println("El número " + numero + " estaba en la posición " + posicion);
        } else {
            System.out.println("No se ha encontrado ese número");
        }
    }

    public static void ejercicio16(Scanner sc) {
        int trimestre1[] = new int[5];
        int trimestre2[] = new int[5];
        int trimestre3[] = new int[5];

        for (int i = 1; i <= 3; i++) {
            System.out.println("Introduce las notas del trimestre " + i);
            switch (i) {

                case 1:
                    for (int j = 0; j < 5; j++) {
                        System.out.println("Del alumno " + (j + 1));
                        trimestre1[j] = sc.nextInt();
                    }
                    break;
                case 2:
                    for (int j = 0; j < 5; j++) {
                        System.out.println("Del alumno " + (j + 1));
                        trimestre2[j] = sc.nextInt();
                    }
                    break;
                case 3:
                    for (int j = 0; j < 5; j++) {
                        System.out.println("Del alumno " + (j + 1));
                        trimestre3[j] = sc.nextInt();
                    }
                    break;
            }

        }
        int acum;
        System.out.println("La media de los trimestres es");
        for (int i = 1; i <= 3; i++) {
            acum = 0;
            switch (i) {

                case 1:
                    for (int j = 0; j < 5; j++) {
                        acum += trimestre1[j];
                    }
                    System.out.println("Primer trimestre: " + acum / 5);
                    break;
                case 2:
                    for (int j = 0; j < 5; j++) {
                        acum += trimestre2[j];
                    }
                    System.out.println("Segundo trimestre: " + acum / 5);
                    break;
                case 3:
                    for (int j = 0; j < 5; j++) {
                        acum += trimestre3[j];
                    }
                    System.out.println("Tercer trimestre: " + acum / 5);
                    break;
            }
        }

        System.out.println("Elige el alumno del que quieras saber la nota");
        int posicion = sc.nextInt() - 1;
        acum = trimestre1[posicion] + trimestre2[posicion] + trimestre3[posicion];
        posicion++;
        System.out.println("La media del alumno " + posicion + " es " + acum / 3);
    }

    public static void ejercicio17(Scanner sc) {
        //inicializa dos array de 10 cartas
        int[] mazo = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] mazo2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int puntos1 = 0;
        int puntos2 = 0;

        //barajea los mazos
        barajarArray(mazo);
        barajarArray(mazo2);

        /*for (int i =0;i<mazo.length;i++)
            System.out.println(mazo[i]);*/
        //ir sacando una a una las cartas y comparandolas a ver quien gana
        for (int i = 0; i < 10; i++) {
            System.out.println("Jugador 1: " + mazo[i]);
            System.out.println("Jugador 2: " + mazo2[i]);
            if (mazo[i] > mazo2[i]) {
                System.out.println("Jugador1 gana");
                puntos1++;
            } else if (mazo2[i] > mazo[i]) {
                System.out.println("Jugador2 gana");
                puntos2++;
            } else {
                System.out.println("Ambas cartas son iguales");
            }
        }

        //sacar el ganador.
        if (puntos1 > puntos2) {
            System.out.println("Jugador 1 ha ganado");
        } else if (puntos2 > puntos1) {
            System.out.println("Jugador 2 ha ganado");
        } else {
            System.out.println("Empate");
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
