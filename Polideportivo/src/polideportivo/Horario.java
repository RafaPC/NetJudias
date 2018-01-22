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
public class Horario {
    
    private String dias;

    private int starthour;
    
    public int endhour;
    
    
    public Horario ( int starthour, int endhour, String dias){
        this.dias = dias;
        
        this.starthour = starthour;
        
        this.endhour = endhour;
    }
    
    
    
    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public int getStarthour() {
        return starthour;
    }

    public void setStarthour(int starthour) {
        this.starthour = starthour;
    }

    public int getEndhour() {
        return endhour;
    }

    public void setEndhour(int endhour) {
        this.endhour = endhour;
    }
    
}
