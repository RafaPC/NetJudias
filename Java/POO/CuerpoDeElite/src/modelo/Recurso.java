/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Map;
import modelo.Mision;
/**
 *
 * @author daw
 */
public abstract class Recurso {

    protected int potenciaDeMuerte;
    protected String nombre;
    private ArrayList<Mision> misiones = new ArrayList<>();

    public Recurso(int potenciaDeMuerte, String nombre) {
        this.potenciaDeMuerte = potenciaDeMuerte;
        this.nombre = nombre;
    }

    public int getPotenciaDeMuerte() {
        return potenciaDeMuerte;
    }

    public void addMision(Mision mision){
        misiones.add(mision);
    }
    
    
    @Override
    public String toString() {
        return "Recurso{" + "potenciaDeMuerte=" + potenciaDeMuerte + ", nombre=" + nombre;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Recurso other = (Recurso) obj;
        if (this.potenciaDeMuerte != other.potenciaDeMuerte) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.misiones, other.misiones)) {
            return false;
        }
        return true;
    }

    public ArrayList<Mision> getMisiones() {
        return misiones;
    }
    
    public void toStringMisiones(HashMap <String,Mision> misiones){
        for(String key : misiones.keySet()){
            System.out.println(misiones.get(key).toString());
        }
    }

}
