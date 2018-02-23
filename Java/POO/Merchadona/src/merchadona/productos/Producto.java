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
    private float preciobase;
    private int cantidad;
    private String nombre;

    public float getPreciobase() {
        return preciobase;
    }

    public void setPreciobase(float preciobase) {
        this.preciobase = preciobase;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Producto(float preciobase, int stock, String nombre) {
        this.preciobase = preciobase;
        this.cantidad = stock;
        this.nombre = nombre;
    }   

    @Override
    public String toString() {
        return nombre + "\nCantidad en stock: " + cantidad + "\nPrecio unitario: " + preciobase + "\n";
    }

    public void sumarStock(int cantidad) {
        this.cantidad += cantidad;
    }
    public void restarStock(int cantidad){
        this.cantidad -= cantidad;
    }
}
