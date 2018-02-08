/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zanalcar;

import Vehiculos.Bicicleta;
import Vehiculos.Coche;
import Vehiculos.Moto;
import Vehiculos.Quad;

/**
 *
 * @author daw
 */
public class Concesionario {
    
    
    public Concesionario(){
        String x = "hola";
        Quad temp = new Quad(x, 35, 1000, x, x);
        System.out.println(temp.precioventa);
        Coche temp1 = new Coche(x, 35, 5350, x, x);
        System.out.println(temp1.precioventa);
        Moto temp2 = new Moto(x, 35, 2672.5f, x, x);
        System.out.println(temp2.precioventa);
        Bicicleta temp3 = new Bicicleta(80.8f, x, x);
        System.out.println(temp3.precioventa);
    }
}
