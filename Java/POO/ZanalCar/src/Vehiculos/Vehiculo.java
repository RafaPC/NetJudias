/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehiculos;

/**
 *
 * @author daw
 */
public abstract class Vehiculo {

    public float preciocompra;
    public float precioventa;
    public String color;
    public String marca;

    public Vehiculo(float preciocompra, String color, String marca) {
        this.preciocompra = preciocompra;
        this.precioventa = preciocompra * 1.25f;
        this.color = color;
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + "\nColor: " + color + "\nPrecio de venta: "+precioventa;
    }

}
