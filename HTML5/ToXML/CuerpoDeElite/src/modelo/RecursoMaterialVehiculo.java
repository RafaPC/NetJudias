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
public class RecursoMaterialVehiculo extends RecursoMaterial{
   private int capacidad; 

    public RecursoMaterialVehiculo(int capacidad, int habilidadMinima, int rangoAccion, int potenciaDeMuerte, String nombre) {
        super(habilidadMinima, rangoAccion, potenciaDeMuerte, nombre);
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Vehículo: " + nombre + "\nCapacidad: " + capacidad + "\nHabilidad mínima: " + habilidadMinima + "\nRango de acción: " + rangoAccion + "\nPotencia de muerte: " + potenciaDeMuerte ;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
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
        final RecursoMaterialVehiculo other = (RecursoMaterialVehiculo) obj;
        if (this.capacidad != other.capacidad) {
            return false;
        }
        return true;
    }

    public int getHabilidadMinima() {
        return habilidadMinima;
    }

    public void setHabilidadMinima(int habilidadMinima) {
        this.habilidadMinima = habilidadMinima;
    }

    public int getRangoAccion() {
        return rangoAccion;
    }

    public void setRangoAccion(int rangoAccion) {
        this.rangoAccion = rangoAccion;
    }

    public int getPotenciaDeMuerte() {
        return potenciaDeMuerte;
    }

    public void setPotenciaDeMuerte(int potenciaDeMuerte) {
        this.potenciaDeMuerte = potenciaDeMuerte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }
   
}
