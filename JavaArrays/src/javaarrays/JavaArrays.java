/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaarrays;

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
            /*case 7:
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
                break;*/
            default: System.out.println("Has elegido un programa que no existe");
        }
    }
    public static void ejercicio1(Scanner sc){
        int numeros[]=new int [5];
        for(int i=0;i<5;i++){
            System.out.println("Dame un número: "); 
            numeros[i]=sc.nextInt();
        }
        System.out.println("Ahí van tus números");
        for(int i=0;i<5;i++){
            System.out.println(numeros[i]);
        }
    }
    
    public static void ejercicio2(Scanner sc){
        int numeros[]=new int [5];
        for(int i=0;i<=4;i++){
            System.out.println("Dame un número: "); 
            numeros[i]=sc.nextInt();
        }
        System.out.println("Ahí van tus números al revés");
        for(int i=4;i>=0;i--){
            System.out.println(numeros[i]);
        }
    }
    
    public static void ejercicio3(Scanner sc){
        int numeros[]=new int [5];
        int acumpositivos=0; int acumnegativos=0; int ceros=0;
        int npositivos=0; int nnegativos=0;
        for(int i=0;i<5;i++){
            System.out.println("Dame un número: "); 
            numeros[i]=sc.nextInt();
        }
        for(int i=0;i<=4;i++){
            if (numeros[i]>0){
               acumpositivos+=numeros[i]; 
               npositivos++;
            }else if(numeros[i]<0){
                acumnegativos+=numeros[i];
                nnegativos++;
            }else{
                ceros++;
            }
        }
        
        if(npositivos>0){
            System.out.println("La media de los positivos es "+acumpositivos/npositivos);
        }
        if(nnegativos>0){
            System.out.println("La media de los negativos es "+acumnegativos/nnegativos);
        }
        if (ceros>0){
            System.out.println("Has introducido "+ceros+" ceros");
        }
    }
    
    public static void ejercicio4 (Scanner sc){
        int array[]=new int [10];
        for(int i=0;i<10;i++){
            array[i]=sc.nextInt();
        }
       
        for(int i=0,j =9;i<5;i++,j--){
            System.out.println(array[i]);
            System.out.println(array[j]);
        }
    }
    
    public static void ejercicio5 (Scanner sc){
        int array1[]=new int[10];
        int array2[]=new int[10];
        int array3[]=new int[20];
        System.out.println("Introduce los números del primer array");
        for (int i=0;i<10;i++){
            array1[i]=sc.nextInt();
        }
        System.out.println("Ahora los del segundo");
        for (int i=0;i<10;i++){
            array2[i]=sc.nextInt();
        }
        for(int i=0,j=0;i<10;i++,j++){
            array3[j]=array1[i];
            j++;
            array3[j]=array2[i];
        }
        System.out.println("Este es el tercer array");
        for(int i=0;i<20;i++){
            System.out.println(array3[i]);
        }
    }
    
    public static void ejercicio6 (Scanner sc){
        int array1[]=new int[12];
        int array2[]=new int[12];
        int array3[]=new int[24];
        System.out.println("Introduce los 12 números del primer array");
        for (int i=0;i<12;i++){
            array1[i]=sc.nextInt();
        }
        System.out.println("Ahora los del segundo");
        for (int i=0;i<12;i++){
            array2[i]=sc.nextInt();
        }
        int x=3;
        for(int i=0;i<24;i+=3){
            for(int j=i;j<x;j++,i++){
                array3[i]=array1[j];
            }
            for(int j=i-3;j<x;j++,i++){
                array3[i]=array2[j];
            }
        x+=3;
        }
    System.out.println("Primer array:");
        for(int i=0;i<12;i++){
        System.out.print(array1[i]+" ,");
    }
    System.out.println("\nSegundo array:");
        for(int i=0;i<12;i++){
        System.out.print(array2[i]+" ,");
    }
    System.out.println("\nTercer array:");
        for(int i=0;i<24;i++){
        System.out.print(array3[i]+" ,");
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

        
        
    
       
    
}
    
