/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merchadona.modelo;

/**
 *
 * @author daw
 */
public abstract class Empleado {
    
    protected String nombre;
    protected int id_empleado;

    public Empleado(String nombre, int id_empleado) {
        this.nombre = nombre;
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }
    
    @Override
    public String toString() {
        return "nombre=" + nombre + ", id_empleado=" + id_empleado + ", ";
    }
    
    
    
}
