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
            /*case 4:
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
        int acumpositivos=0; int acumnegativos=0;
        for(int i=0;i<=4;i++){
            System.out.println("Dame un número: "); 
            numeros[i]=sc.nextInt();
        }
        for(int i=0;i<=4;i++){
            if (numeros[i]>0){
               acumpositivos+=numeros[i]; 
            }else if(numeros[i]<0){
                acumnegativos+=numeros[i];
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

        
        
    
       
    
}
    
