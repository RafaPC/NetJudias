/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author daw
 */
public class ProyectoDesarrollo extends Proyecto{
    private String lenguaje;

    public ProyectoDesarrollo(String lenguaje, String nombre, String lugar) {
        super(nombre, lugar);
        this.lenguaje = lenguaje;
    }

    @Override
    public String toString() {
        return "\n-------------------------------\nProyectoDesarrollo: " + nombre + ", lugar=" + lugar + ", puestos=" + puestos + "lenguaje=" + lenguaje + '}';
    }

    public String getLenguaje() {
        return lenguaje;
    }

}
