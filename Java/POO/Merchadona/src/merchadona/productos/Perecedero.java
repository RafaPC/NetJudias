/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merchadona.productos;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import merchadona.Constantes;

/**
 *
 * @author daw
 */
public class Perecedero extends Producto {

    public LocalDateTime fechaReposicion;
    public float preciocaducado;

    public Perecedero(float preciobase, int stock, String nombre) {
        super(preciobase, stock, nombre);
        this.fechaReposicion = LocalDateTime.now();
        this.preciocaducado = super.preciobase;
    }

    @Override
    public String toString() {
        LocalDateTime time = LocalDateTime.now();
        Duration d = Duration.between(fechaReposicion, time);
        return nombre + "\nCantidad en stock: " + stock + "\nCaduca en: " + (60 - d.getSeconds()) + "\nPrecio unitario: " + preciocaducado;
    }

    public void bajaPrecio(ArrayList stock) {
        LocalDateTime time = LocalDateTime.now();
        Duration d = Duration.between(fechaReposicion, time);
        long tiemporestante = 60 - d.getSeconds();
        if (d.getSeconds() >= 60) {

        }
        long tiempocaducado = d.getSeconds();
        do {
            if (d.getSeconds() >= Constantes.NUM_SEGUNDOS_BAJA_PRECIO) {
                preciocaducado = super.preciobase - (super.preciobase * Constantes.FACTOR_BAJA_PRECIO);
                tiempocaducado -= 10;
            }
        } while (tiempocaducado >= 10);
    }
}
