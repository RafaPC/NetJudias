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
public class Cajero extends Empleado {

    private float preciototal;

    public float getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(float preciototal) {
        this.preciototal = preciototal;
    }

    public Cajero(String nombre, int id, float preciototal) {
        super(nombre, id);
        this.preciototal = preciototal;
    }

    @Override
    public String toString() {
        return  "\nNombre: " + nombre + "\nID: " + id + "\nDinero recaudado: " + preciototal;
    }
 
}
