/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merchadona.productos;

import java.time.LocalDate;

/**
 *
 * @author daw
 */
public class Perecedero extends Producto {

    public LocalDate fechaReposicion;

    public Perecedero(LocalDate fechaReposicion, float preciobase, int stock, String nombre) {
        super(preciobase, stock, nombre);
        this.fechaReposicion = fechaReposicion;
    }

    @Override
    public String toString() {
        return nombre + "\nCantidad en stock: " + stock + "\nCaduca en: " + fechaReposicion + "\n";
    }

    public void bajaPrecio() {
        
    }
}
