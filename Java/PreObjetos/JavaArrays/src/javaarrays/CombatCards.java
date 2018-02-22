/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaarrays;

import java.util.Random;

/**
 *
 * @author daw
 */
public class CombatCards {
   public static void main(String[] args) {
        //inicializa dos array de 10 cartas
        int []mazo = {1,2,3,4,5,6,7,8,9,10};
        int []mazo2 = {1,2,3,4,5,6,7,8,9,10};
        int puntos1=0; int puntos2=0;
        
        //barajea los mazos
        barajarArray(mazo);
        barajarArray(mazo2);
        
        /*for (int i =0;i<mazo.length;i++)
            System.out.println(mazo[i]);*/
            
        
        //ir sacando una a una las cartas y comparandolas a ver quien gana
        for(int i=0;i<10;i++){
            System.out.println("Jugador 1: "+mazo[i]);
            System.out.println("Jugador 2: "+mazo2[i]);
            if(mazo[i]>mazo2[i]){
            System.out.println("Jugador1 gana");
            puntos1++;
            }else if(mazo2[i]>mazo[i]){
                System.out.println("Jugador2 gana");
            puntos2++;
                    }else{
                System.out.println("Ambas cartas son iguales");
            }
            }
        
        //sacar el ganador.
        if(puntos1>puntos2){
            System.out.println("Jugador 1 ha ganado");
        }
        else if(puntos2>puntos1){
            System.out.println("Jugador 2 ha ganado");
        }
        else{
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
 

