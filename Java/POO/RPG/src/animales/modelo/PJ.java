/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animales.modelo;

import animales.modelo.Oso;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Los Prieto
 */
public class PJ {

    private Scanner sc = new Scanner(System.in);
    public Random probability = new Random(System.currentTimeMillis());
    public int maxhp = 20;
    public int hp = maxhp;
    public int xp = 0;
    public int lvl = 1;
    private int strength = 1;
    private int stealth = 0;
    private int numPociones = 1;
    public int dmg = 10;

    public void tomarPocion() {
        if (numPociones > 0) {
            this.hp = hp + 10;
            this.numPociones--;
            if (hp > maxhp) {
                hp = maxhp;
            }
        } else {
            System.out.println("No tienes pociones que utilizar");
        }
    }

    public void atacar(Animal animal) {
        int random = probability.nextInt(100);
        if (random < 15) {
            animal.herir(dmg * strength * 2);
            System.out.println("Has inflingido un golpe critico de " + dmg * strength * 2 + " de daño");
        } else {
            animal.herir(dmg * strength);
            System.out.println("Has inflingido " + dmg * strength + " de daño");
        }

    }

    public void gainXP(Animal animal) {
        this.xp = animal.giveXP(this, xp);
        if (xp >= lvl * (9 + lvl)) {
            System.out.println("Has subido de nivel");
            this.lvl = lvl++;
            levelUp();
        }

    }

    public void levelUp() {
        System.out.println("¿Qué atributo quieres subirte?");
        System.out.println("1.- Fuerza \n2.-Sigilo \n3.-Vida máxima");
        int opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1:
                this.strength += 1;
                break;
            case 2:
                this.stealth += 1;
                break;
            case 3:
                this.maxhp += 10;
                break;
        }
    }

    public void xprestante() {
        System.out.println("Te quedan " + ((this.lvl * (9 + this.lvl)) - this.xp) + " puntos de xp hasta el siguiente nivel");
    }

    public int getXp() {
        return this.xp;
    }

}
