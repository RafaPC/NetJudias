/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohmygueim.Clientes;

import java.util.ArrayList;

/**
 *
 * @author daw
 */
public abstract class Gamer {

    private int ranking;
    private String nombre;
    private int numtorneos;
    private ArrayList<String> trofeos;

    public Gamer(int ranking, String nombre, int numtorneos) {
        this.ranking = ranking;
        this.nombre = nombre;
        this.numtorneos = numtorneos;
    }

    /*public Gamer(){
        ArrayList <String> trofeos = new ArrayList<>();
    }*/

    public void addTrofeo(String trofeo) {
        trofeos.add(trofeo);
    }
}
