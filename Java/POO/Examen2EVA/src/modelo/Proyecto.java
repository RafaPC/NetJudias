/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author daw
 */
public class Proyecto {
    protected String nombre;
    protected String lugar;
    protected ArrayList <Puesto> puestos = new ArrayList();

    public Proyecto(String nombre, String lugar) {
        this.nombre = nombre;
        this.lugar = lugar;
    }
    public void addPuesto(String puesto, int expMin, int salHora){
        puestos.add(new Puesto(expMin,puesto, salHora));
    }

    public ArrayList<Puesto> getPuestos() {
        return puestos;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "\n-------------------------------\nProyecto: " + nombre + ", lugar=" + lugar + ", puestos=" + puestos + '}';
    }

}
