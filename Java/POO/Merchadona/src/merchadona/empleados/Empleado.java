/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merchadona.empleados;

/**
 *
 * @author daw
 */
public abstract class Empleado {

    public Empleado(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }
    public String nombre;
    public int id;

    @Override
    public String toString() {
        return nombre + "ID: " + id;
    }
}
