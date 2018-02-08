/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animales.modelo;

import animales.modelo.Animal;

/**
 *
 * @author user
 */
public class Oso extends Animal implements ICazable {

    public Oso() {
        super(100);
    
    }

    @Override
    public void alimentar() {
        if (vivo) {
            hp += 2;
        }
    }

    public void alimentar(Object comida) {
        if (vivo) {
            hp += 200;
        }
        this.alimentar();
    }

    public void alimentar(Persona persona) {
        if (vivo) {
            hp += 200;
        }
        this.alimentar();
    }

    public void alimentar(Rata rata) {
        if (vivo) {
            hp -= 20;
        }

    }

    /*public void cazar(ICazable caza) {
        hp += (caza.satisfaccion() / 5);
    }*/

    public void hibernar() {
        if (vivo) {
            hp += 10;
        }
    }

    public int satisfaccion() {
        vivo = false;
        hp = 0;
        return 50;
    }


}
