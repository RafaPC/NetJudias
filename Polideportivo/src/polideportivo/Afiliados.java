/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polideportivo;

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


    
    public Afiliados(String nombre, String apellidos){
        
        this.nombre = nombre;
        
        this.apellidos = apellidos;
        
        this.pago = 0;
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
