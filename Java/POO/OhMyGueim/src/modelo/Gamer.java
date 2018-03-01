/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author daw
 */
public abstract class Gamer {

    private int ranking;
    private String nombre;
    private int numtorneos;
    private ArrayList<String> trofeos = new ArrayList<>();

    public Gamer(int ranking, String nombre, int numtorneos) {
        this.ranking = ranking;
        this.nombre = nombre;
        this.numtorneos = numtorneos;
    }

    public void addTrofeo(String trofeo) {
        trofeos.add(trofeo);
    }

    @Override
    public String toString() {
        String tostring;
        tostring = "Jugador: " + nombre + "\nELO: " + ranking + "\nNº torneos jugados: " + numtorneos + "\nTrofeos: ";
        for(String trophy : trofeos){
            tostring += "\n" + trophy.toString();
        }
        return tostring;
    }

    public int getRanking() {
        return ranking;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumtorneos() {
        return numtorneos;
    }

    public ArrayList<String> getTrofeos() {
        return trofeos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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
        final Gamer other = (Gamer) obj;
        if (this.ranking != other.ranking) {
            return false;
        }
        if (this.numtorneos != other.numtorneos) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.trofeos, other.trofeos)) {
            return false;
        }
        return true;
    }
    
}
