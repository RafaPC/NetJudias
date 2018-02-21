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

    public int preciototal;

    public Cajero(String nombre, int id) {
        super(nombre, id);
        this.preciototal = 0;
    }

    
}
