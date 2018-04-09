/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merchadona.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author daw
 */
public class Perecedero extends Producto {

    private LocalDateTime fecha_reposicion;

    public Perecedero(String nombre, double precio_base, int stock) {
        super(nombre, precio_base, stock);
        this.fecha_reposicion = LocalDateTime.now();
    }

    public LocalDateTime getFecha_reposicion() {
        return fecha_reposicion;
    }

    public void setFecha_reposicion(LocalDateTime fecha_reposicion) {
        this.fecha_reposicion = fecha_reposicion;
    }

}
