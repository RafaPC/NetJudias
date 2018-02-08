/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animales.modelo;

import java.util.Random;
import animales.modelo.Oso;
import animales.modelo.Lince;
import animales.modelo.Rata;
import animales.modelo.Ladron;
import animales.modelo.PJ;
import java.util.Scanner;

/**
 *
 * @author Los Prieto
 */
public class Fight {

    public Random probability = new Random(System.currentTimeMillis());
    private Scanner sc = new Scanner(System.in);

    public void pelea(PJ pj) {
        int random = probability.nextInt(100);
        if (random < 25) {
            System.out.println("Te has encontrado con un oso");
            Oso oso = new Oso();
            do {
                System.out.println("Oso tiene " + oso.hp + "de vida");
                System.out.println("Qué quieres hacer?");
                int accion = sc.nextInt();
                switch(accion){
                    case 1:
                        pj.atacar(oso);
                        break;
                }

            
            
            
            
            
            
            
            
            
            
            
            
            
            
            } while (oso.vivo);
            pj.gainXP(oso);
        } else if (random < 50) {
            System.out.println("Te has encontrado con un lince");
        } else if (random < 75) {
            System.out.println("Te has encontrado con una rata");
        } else {
            System.out.println("Te has encontrado con un ladrón");
        }
    }
}
