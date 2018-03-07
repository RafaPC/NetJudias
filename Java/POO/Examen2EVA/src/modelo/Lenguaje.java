/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author daw
 */
public class Lenguaje {
    private String leng;
    private int exp;

    public Lenguaje(String leng, int exp) {
        this.leng = leng;
        this.exp = exp;
    }

    public String getLeng() {
        return leng;
    }

    public void setLeng(String leng) {
        this.leng = leng;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "Lenguaje{" + "leng=" + leng + ", exp=" + exp + '}';
    }

}
