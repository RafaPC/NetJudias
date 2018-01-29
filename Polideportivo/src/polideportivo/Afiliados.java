/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polideportivo;

import java.util.Objects;

/**
 *
 * @author daw
 */
public class Afiliados {
    
    private String nombre;
    
    private String apellidos;
    
    private float pago;
    
    private int plazaslibres;
    
    private int plazas = 35;



    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Afiliados other = (Afiliados) obj;
        if (Float.floatToIntBits(this.pago) != Float.floatToIntBits(other.pago)) {
            return false;
        }
        if (this.plazaslibres != other.plazaslibres) {
            return false;
        }
        if (this.plazas != other.plazas) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidos, other.apellidos)) {
            return false;
        }
        return true;
    }


    
    public Afiliados(String nombre, String apellidos){
        
        this.nombre = nombre;
        
        this.apellidos = apellidos;
        
        this.pago = 0;
    }

    @Override
    public String toString(){
        return nombre + apellidos + "\nRecibo: " + pago;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public float getPago() {
        return pago;
    }
    
    public void setPago(float pago) {
        this.pago = pago;
    }
        
    public int getPlazaslibres() {
        return plazaslibres;
    }

    public void setPlazaslibres(int plazaslibres) {
        this.plazaslibres = plazaslibres;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }
    
}
