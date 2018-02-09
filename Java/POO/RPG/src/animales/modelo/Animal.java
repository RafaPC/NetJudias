/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animales.modelo;

import java.util.Objects;

/**
 *
 * @author user
 */
public abstract class Animal {

    protected int hp;
    protected boolean vivo;

    private String nombre;

    public boolean isVivo() {
        return vivo;
    }

    public int getHp() {
        return hp;
    }

    public Animal(int tiempoVida) {
        this.hp = tiempoVida;
        vivo = true;
    }

    public void herir(int daño) {
        hp -= daño;
        if (hp <= 0) {
            vivo = false;
        }
    }

    public void alimentar() {
        if (vivo) {
            hp++;
        }
    }

    /*public void enfermar() {
        if (vivo) {
            hp -= 5;
        }
    }*/
    public int giveXP(PJ pj, int xp){
        xp+=10;
        
        return xp;
    }

    @Override
    public String toString() {
        return "Animal{" + "tiempoVida=" + hp + ", vivo=" + vivo + ", nombre=" + nombre + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

}
