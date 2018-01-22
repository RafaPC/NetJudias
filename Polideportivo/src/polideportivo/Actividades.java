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
public class Actividades {
    
    private String tipo;
    
    private int plazas;
    
    private float precio = 35;
    
    private Horario horario;
    
    
    public Actividades (String tipo, int plazas, float precio, Horario horario ){
        
        this.plazas = plazas;
        
        this.tipo = tipo;      
        
        this.precio = precio;
        
        this.horario = horario;
        
    }
    
//    public String toString() {
//        return tipo + "Plazas libres: " + plazas + "\nPrecio: " + precio + "\nHorario: "
//    }
//   
    
    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
    
    
    
}
