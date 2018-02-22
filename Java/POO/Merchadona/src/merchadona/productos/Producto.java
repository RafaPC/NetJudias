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
    public int cantidad;
    public String nombre;

    public Producto(float preciobase, int stock, String nombre) {
        this.preciobase = preciobase;
        this.cantidad = stock;
        this.nombre = nombre;
    }   

    @Override
    public String toString() {
        return nombre + "\nCantidad en stock: " + cantidad + "\nPrecio unitario: " + preciobase;
    }

    public void sumarStock(int cantidad) {
        this.cantidad += cantidad;
    }
    public void restarStock(int cantidad){
        this.cantidad -= cantidad;
    }
}
