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
        return "RecursoMaterialVehiculo{" + "capacidad=" + capacidad + '}';
    }
   
}
