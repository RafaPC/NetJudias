/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author user
 */
public class Arrays {

    public static void main(String[] args) {
        int[] numeros = new int[10];
        numeros[0] = 1;
        numeros[4] = 3;
        for (int i = 0; i < 10; i++) {
            numeros[i] = i + 1;
        }
        // esto falla
        //numeros[10] = 11;

        boolean[] codigoRojo = new boolean[3];

        int[] cartas = new int[40];

        boolean[] valores = {true,false,true};
        
        int numeroCartas = 40;
        
        int []cartas2 = new int[numeroCartas];
        int []cartasMitad = new int[numeroCartas/2];
        
        
        for (int i=0;i<numeroCartas;i+=2)
        {
            cartasMitad[i/2]= cartas2[i];
        }
        for (int i=0;i<cartasMitad.length;i++)
        {
            System.out.println(cartasMitad[i]);
        }
        
        
        
    }

}
