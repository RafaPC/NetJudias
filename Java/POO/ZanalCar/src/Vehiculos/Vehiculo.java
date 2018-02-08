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
    protected float preciocompra;
    public float precioventa;
    protected String color;
    protected String marca;    

    public Vehiculo(float preciocompra, String color, String marca) {
        this.preciocompra = preciocompra;
        this.precioventa = preciocompra * 1.25f;
        this.color = color;
        this.marca = marca;
    }


}
