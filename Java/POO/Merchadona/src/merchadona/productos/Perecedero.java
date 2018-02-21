/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merchadona.productos;

import java.time.LocalDate;

/**
 *
 * @author daw
 */
public class Perecedero extends Producto{
    public LocalDate fechaReposicion;

    public Perecedero(LocalDate fechaReposicion, float preciobase, int stock) {
        super(preciobase, stock);
        this.fechaReposicion = fechaReposicion;
    }

   

}
