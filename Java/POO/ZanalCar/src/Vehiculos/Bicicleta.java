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
public class Bicicleta extends Vehiculo{
    private int tamañoderueda;
    private int numdemarchas;
    private String tipodecambio;

    public Bicicleta(int tamañoderueda, int numdemarchas, String tipodecambio, float preciocompra, String color, String marca) {
        super(preciocompra, color, marca);
        this.tamañoderueda = tamañoderueda;
        this.numdemarchas = numdemarchas;
        this.tipodecambio = tipodecambio;
    }
    

    
}
