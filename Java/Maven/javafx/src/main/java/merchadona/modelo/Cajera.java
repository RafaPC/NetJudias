/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merchadona.modelo;

import java.util.ArrayList;

/**
 *
 * @author daw
 */
public class Cajera extends Empleado{
    
    private double precio_total_vendidos;

    public Cajera(String nombre, int id_empleado) {
        super(nombre, id_empleado);
        this.precio_total_vendidos = precio_total_vendidos;
    }

    

    public double getPrecio_total_vendidos() {
        return precio_total_vendidos;
    }

    public void sumPrecio_total_vendidos(double precio_total_vendidos) {
        this.precio_total_vendidos += precio_total_vendidos;
    }
    

    @Override
    public String toString() {
        return "Cajera{" + super.toString() + "precio_total_vendidos=" + precio_total_vendidos + '}';
    }

    
    
}
