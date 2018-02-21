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
    public String nombre;

    public Producto(float preciobase, int stock, String nombre) {
        this.preciobase = preciobase;
        this.stock = stock;
        this.nombre = nombre;
    }   

    @Override
    public String toString() {
        return nombre + "\nCantidad en stock: " + stock + "\n";
    }

    public void sumarStock(int cantidad) {
        this.stock += cantidad;
    }
    public void restarStock(int cantidad){
        this.stock -= cantidad;
    }
}
