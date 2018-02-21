/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merchadona.productos;

/**
 *
 * @author daw
 */
public class Producto {
    public float preciobase;
    public int stock;

    public Producto(float preciobase, int stock) {
        this.preciobase = preciobase;
        this.stock = stock;
    }
}
