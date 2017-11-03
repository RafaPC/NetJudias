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
        // TODO code application logic here
    System.out.println("Cuántos números quieres introducir");
    Scanner sc = new Scanner(System.in);
    int i;
    int numerodenumeros=sc.nextInt();
    int [] numeros= new int [numerodenumeros];
    int numerodepares=0; int numerodeimpares=0;
    int contadorpares=0; int contadorimpares=0;
    for( i=0;i<numerodenumeros;i++){
        System.out.println("Escribe un número: ");
        numeros[i] =sc.nextInt();   
    }
    
    for(i=0;i<numerodenumeros;i++){
        if ((numeros[i]%2)==0){
            numerodepares++;
        }
        else{
            numerodeimpares++;
        }
    }
    int [] pares= new int [numerodepares];
    int [] impares= new int [numerodeimpares];
    
    for(i=0;i<numerodenumeros;i++){
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
    for(i=0;i<pares.length;i++){
        acum+=pares[i];
    }
    System.out.println("La media de los pares es "+(acum/pares.length));
    acum=0;
    for (i=0;i<impares.length;i++){
    acum+=impares[i];
    }
    System.out.print("La media de los impares es "+(acum/impares.length));

        
        
    
    
    
    }
    
}
