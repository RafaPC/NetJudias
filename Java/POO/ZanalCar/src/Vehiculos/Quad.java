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
public class Quad extends VehiculoaMotor {

    public Quad(String matricula, int km, float preciocompra, String color, String marca) {
        super(matricula, km, preciocompra, color, marca);
    }

    public int prueba(int kmprueba) {
        km += kmprueba;
        return km;
    }
}
