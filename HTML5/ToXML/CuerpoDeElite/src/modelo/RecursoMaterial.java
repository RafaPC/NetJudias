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
public class RecursoMaterial extends Recurso {

    protected int habilidadMinima;
    protected int rangoAccion;

    public RecursoMaterial() {
    }

    public RecursoMaterial(int habilidadMinima, int rangoAccion, int potenciaDeMuerte, String nombre) {
        super(potenciaDeMuerte, nombre);
        this.habilidadMinima = habilidadMinima;
        this.rangoAccion = rangoAccion;
    }
    
    
    @Override
    public String toString() {
        return "Vehículo: " + nombre + "\nHabilidad mínima: " + habilidadMinima + "\nRango de acción: " + rangoAccion + "\nPotencia de muerte: " + potenciaDeMuerte ;
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
        final RecursoMaterial other = (RecursoMaterial) obj;
        if (this.habilidadMinima != other.habilidadMinima) {
            return false;
        }
        if (this.rangoAccion != other.rangoAccion) {
            return false;
        }
        return true;
    }

    public void setHabilidadMinima(int habilidadMinima) {
        this.habilidadMinima = habilidadMinima;
    }

    public void setRangoAccion(int rangoAccion) {
        this.rangoAccion = rangoAccion;
    }

    public void setPotenciaDeMuerte(int potenciaDeMuerte) {
        this.potenciaDeMuerte = potenciaDeMuerte;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHabilidadMinima() {
        return habilidadMinima;
    }

    public int getRangoAccion() {
        return rangoAccion;
    }

    public int getPotenciaDeMuerte() {
        return potenciaDeMuerte;
    }

    public String getNombre() {
        return nombre;
    }

}
