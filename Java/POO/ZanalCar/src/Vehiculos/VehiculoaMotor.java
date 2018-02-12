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
public abstract class VehiculoaMotor extends Vehiculo {

    public String matricula;
    protected int km;

    /*public VehiculoaMotor(String matricula,int km, String color, String marca,float preciocompra){
        this.marca = marca;
        this.color = color;
        this.matricula = matricula;
        this.km = km;
    }*/

    public VehiculoaMotor(String matricula, int km, float preciocompra, String color, String marca) {
        super(preciocompra, color, marca);
        this.matricula = matricula;
        this.km = km;
    }

    @Override
    public String toString() {
        String mensaje = super.toString();
        mensaje += "\nMatrícula: " + matricula + "\nKilometraje: " + km;
        return mensaje;
    }

}
