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
                //ejercicio9(sc);
                break;
            case 10:
                ejercicio10(sc);
                break;
            case 11:
                //ejercicio11(sc);
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
            default:
                System.out.println("Has elegido un programa que no existe");
        }
    }

    public static void ejercicio1(Scanner sc) {
        int numeros[] = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("Dame un número: ");
            numeros[i] = sc.nextInt();
        }
        System.out.println("Ahí van tus números");
        for (int i = 0; i < 5; i++) {
            System.out.println(numeros[i]);
        }
    }

    public static void ejercicio2(Scanner sc) {
        int numeros[] = new int[5];
        for (int i = 0; i <= 4; i++) {
            System.out.println("Dame un número: ");
            numeros[i] = sc.nextInt();
        }
        System.out.println("Ahí van tus números al revés");
        for (int i = 4; i >= 0; i--) {
            System.out.println(numeros[i]);
        }
    }

    public static void ejercicio3(Scanner sc) {
        int numeros[] = new int[5];
        int acumpositivos = 0;
        int acumnegativos = 0;
        int ceros = 0;
        int npositivos = 0;
        int nnegativos = 0;
        for (int i = 0; i < 5; i++) {
            System.out.println("Dame un número: ");
            numeros[i] = sc.nextInt();
        }
        for (int i = 0; i <= 4; i++) {
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
        for (int i = 0; i < 10; i++) {
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
        System.out.println("Introduce los números del primer array");
        for (int i = 0; i < 10; i++) {
            array1[i] = sc.nextInt();
        }
        System.out.println("Ahora los del segundo");
        for (int i = 0; i < 10; i++) {
            array2[i] = sc.nextInt();
        }
        for (int i = 0, j = 0; i < 10; i++, j++) {
            array3[j] = array1[i];
            j++;
            array3[j] = array2[i];
        }
        System.out.println("Este es el tercer array");
        for (int i = 0; i < 20; i++) {
            System.out.println(array3[i]);
        }
    }

    public static void ejercicio6(Scanner sc) {
        int array1[] = new int[12];
        int array2[] = new int[12];
        int array3[] = new int[24];
        System.out.println("Introduce los 12 números del primer array");
        for (int i = 0; i < 12; i++) {
            array1[i] = sc.nextInt();
        }
        System.out.println("Ahora los del segundo");
        for (int i = 0; i < 12; i++) {
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
        /*System.out.println("Primer array:");
        for(int i=0;i<12;i++){
        System.out.print(array1[i]+", ");
        }
        System.out.println("\nSegundo array:");
        for(int i=0;i<12;i++){
        System.out.print(array2[i]+", ");
        }*/
        System.out.println("\nTercer array:");
        for (int i = 0; i < 24; i++) {
            System.out.print(array3[i] + ", ");
        }
    }

    public static void ejercicio7(Scanner sc) {
        int array[] = new int[10];
        for (int i = 0; i < 10; i++) {
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
        System.out.println("Dame 8 números ");
        for (int i = 0; i < 8; i++) {
            array[i] = sc.nextInt();

        }
        int num;
        int posicion;
        int ayuda;
        System.out.println("Dime otro número que quieras introducir");
        num = sc.nextInt();
        System.out.println("Y la posición donde quieres introducirlo (recuerda que tiene que ser entre 0 y 9, ambos inclusive)");
        posicion = sc.nextInt() - 1;

        if (posicion >= 0 && posicion <= 7) {
            for (int i = 7; i >= posicion; i--) {
                array[i + 1] = array[i];
            }
            array[posicion] = num;
        } else {
            array[posicion] = num;
        }
        System.out.println("Este es tu array ahora");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " ");
        }
    }

    public static void ejercicio9(Scanner sc) {
        int array[] = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.println("Introduce un número");
            array[i] = sc.nextInt();
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

        System.out.println("Este es tu array ahora");
        for (int i = 0; i < 10; i++) {
            System.out.print(array[i] + ", ");
        }
    }

    public static void ejercicio10(Scanner sc) {
        int array[] = new int[10];
        int ayuda;
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

    public static void ejercicio12(Scanner sc) {
        int array[] = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println("Ahora dime que posicion quieres borrar");
        int posicion = sc.nextInt();
        for (int i = posicion; i < 9; i++) {
            array[i] = array[i + 1];
        }
        System.out.println("Este es tu array ahora");
        for (int i = 0; i < 10; i++) {
            System.out.println(array[i]);
        }
    }

    public static void ejercicio13(Scanner sc) {
        int array[] = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.print("Dime un num: ");
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
            System.out.print(arraypares[i] + ",");
        }
        System.out.println("\nAhí va tu array de impares");
        for (int i = 0; i < impares; i++) {
            System.out.print(arrayimpares[i] + ",");
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
            System.out.print(array[arraypares[i]] + ",");
        }
        System.out.println("\nAhí va tu array de impares");
        for (int i = 0; i < impares; i++) {
            System.out.print(array[arrayimpares[i]] + ",");
        }
    }

    public static void ejercicio14(Scanner sc) {
        int array1[] = new int[10];
        int array2[] = new int[10];
        int array3[] = new int[20];

        System.out.println("Dame los números del primer array, tienen que ser crecientes");
        for (int i = 0; i < 10; i++) {
            array1[i] = sc.nextInt();
            if (i > 0) {
                if (!(array1[i] > array1[i - 1])) {
                    System.out.println("El número tiene que ser mayor que el anterior (" + array1[i - 1] + ")");
                    i--;
                }
            }
        }
        System.out.println("Dame los números del primer array, tienen que ser crecientes");
        for (int i = 0; i < 10; i++) {
            array2[i] = sc.nextInt();
            if (i > 0) {
                if (!(array2[i] > array2[i - 1])) {
                    System.out.println("El número tiene que ser mayor que el anterior (" + array2[i - 1] + ")");
                    i--;
                }

            }
        }
        int menorfinal = 0;
        int menor1 = 0;
        int menor2 = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    menor1 = array1[0];
                } else if (array1[j] < menor1) {
                    menor1 = array1[j];
                }

            }
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    menor2 = array2[0];
                } else if (array2[j] < menor2) {
                    menor2 = array2[j];

                }
            }
            if (menor1 < menor2) {
                menorfinal = menor1;
                //array3[i] = menor1;
                //array3[i+1]=menor2;
            } else if (menor2 < menor1) {
                menorfinal = menor2;
                //array3[i]=menor2;
                //array3[i+1]=menor1;
            } else {
                System.out.println("Error: el programa no funciona porque hay dos números iguales");
            }
            array3[i] = menorfinal;
        }

        for (int i = 0; i < 20; i++) {
            System.out.println(array3[i]);
        }

    }

    public static void ejercicio15(Scanner sc) {

        int array[] = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println("¿Qué número quieres que encuentre");
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

/*public static void ejercicioX(Scanner sc){
    System.out.println("Cuántos números quieres introducir");
    int numerodenumeros=sc.nextInt();
    int [] numeros= new int [numerodenumeros];
    int numerodepares=0; int numerodeimpares=0;
    int contadorpares=0; int contadorimpares=0;
    for( int i=0;i<numerodenumeros;i++){
        System.out.println("Escribe un número: ");
        numeros[i] =sc.nextInt();   
    }
    
    for(int i=0;i<numerodenumeros;i++){
        if ((numeros[i]%2)==0){
            numerodepares++;
        }
        else{
            numerodeimpares++;
        }
    }
    int [] pares= new int [numerodepares];
    int [] impares= new int [numerodeimpares];
    
    for(int i=0;i<numerodenumeros;i++){
        if ((numeros[i]%2)==0){
           pares[contadorpares]=numeros[i];
           contadorpares++;
        } 
        else{
           impares[contadorimpares]=numeros[i];
        contadorimpares++;
        } 
    }
    float acum=0;
    for(int i=0;i<pares.length;i++){
        acum+=pares[i];
    }
    System.out.println("La media de los pares es "+(acum/pares.length));
    acum=0;
    for (int i=0;i<impares.length;i++){
    acum+=impares[i];
    }
    System.out.print("La media de los impares es "+(acum/impares.length));*/
