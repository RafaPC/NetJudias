/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merchadona.productos;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import merchadona.Constantes;

/**
 *
 * @author daw
 */
public class Perecedero extends Producto {

    private LocalDateTime fechaReposicion;
    private float preciocaducado;

    public Perecedero(float preciobase, int stock, String nombre) {
        super(preciobase, stock, nombre);
        this.fechaReposicion = LocalDateTime.now();
        this.preciocaducado = super.preciobase;
    }

    @Override
    public String toString() {
        LocalDateTime time = LocalDateTime.now();
        Duration d = Duration.between(fechaReposicion, time);
        long tiempo = (60 - d.getSeconds());
        String caducidad = "Estado: ";
        if (d.getSeconds() >= Constantes.NUM_SEGUNDOS_CADUCA) {
            caducidad += "Caducado";
        } else {
            caducidad += "Caduca en " + Long.toString(tiempo);
        }

        return nombre + "\nCantidad en stock: " + cantidad + "\n" + caducidad + "\nPrecio unitario: " + preciocaducado + "\n";
    }

    public void bajaPrecio() {
        LocalDateTime time = LocalDateTime.now();
        Duration d = Duration.between(fechaReposicion, time);
        long tiempocaducado = d.getSeconds();

        long veces = tiempocaducado / Constantes.NUM_SEGUNDOS_BAJA_PRECIO;

        if (d.getSeconds() >= 10 || d.getSeconds() < 60) {
            float descuento = 0;
            descuento += (super.preciobase * Constantes.FACTOR_BAJA_PRECIO * veces);
            preciocaducado = super.preciobase - descuento;
        }
    }

    public boolean comprobarCaducado() {
        boolean caducado = false;
        LocalDateTime time = LocalDateTime.now();
        Duration d = Duration.between(fechaReposicion, time);
        long tiempocaducado = d.getSeconds();
        if (tiempocaducado >= Constantes.NUM_SEGUNDOS_CADUCA) {
            caducado = true;
        }
        return caducado;
    }
}
