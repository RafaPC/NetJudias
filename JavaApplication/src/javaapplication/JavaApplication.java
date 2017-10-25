/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author user
 */
public class JavaApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int min;
        int max;
        int numero;
        int contador;
        
        System.out.print("Cuántos intentos quieres tener? ");
        contador= sc.nextInt();
        
        System.out.println("¿Entre que rango de números quieres adivinar?");
        System.out.print("Entre ");
        min= sc.nextInt(); 
        System.out.print("y ");
        max= sc.nextInt();
        
        int random= r.nextInt(max-min)+1+min;
        String mensaje=null;
        System.out.println("Adivina un número del "+min+" al "+max);
        
        do{
            if (contador>1){
                System.out.println("Tienes "+contador+" intentos");
            }else if (contador==1){
                    System.out.println("Sólo te queda 1 intento");}
            
            numero= sc.nextInt();
            
            if (numero > max){
                mensaje= "Te has pasado del máximo, inténta poner un número por debajo de "+max;
            } else if(numero < min){
                mensaje="Te has quedado corto, intenta poner un número por encima de "+min;
            } else if (random > numero){
                mensaje= "El número que intentas adivinar es mayor, inténtalo otra vez";
            } else if(random < numero){
                mensaje="El número que intentas adivinar es menor, inténtalo otra vez";
            }else if(random == numero){
                mensaje="Has acertado!";
                /* el contador de debajo está para que printee el mensaje si ganas en el último turno
                si no, al ganar en el último turno el contador sería 0 y no cumpliría el if de más abajo*/
                contador++;
            }
            
            contador--;
            
            /* este "if" de debajo está puesto para que cuando pierdes en el último turno
            no te diga si es mayor o menor */
            if (contador>0){System.out.println(mensaje);}
        
        }while(random!=numero&&contador>0);
        if (contador==0&&numero!=random){
            System.out.println("Se te han acabado los intentos");
        }
    }
}
    
