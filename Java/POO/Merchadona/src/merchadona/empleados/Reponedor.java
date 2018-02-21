/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merchadona.empleados;

import merchadona.Merchadona;

/**
 *
 * @author daw
 */
public class Reponedor extends Empleado {

    public int numProductosRepuestos;

    public Reponedor(String nombre, int id) {
        super(nombre, id);
        this.numProductosRepuestos = 0;
    }

    @Override
    public String toString() {
        return "Puesto: Reponedor/a" + "\nNombre: " + nombre + "\nID: " + id;
    }
}
