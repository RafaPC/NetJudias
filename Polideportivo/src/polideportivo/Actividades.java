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

    private int plazaslibres;

    private int plazas;

    private float precio;

    private Horario horario;
    
    private Afiliados[] afiliados;
    
    

    public boolean meterAfil(Afiliados a) {
        boolean ok = false;
        if (plazaslibres > 0) {
            this.afiliados[this.plazas - this.plazaslibres] = a;
            this.plazaslibres--;
            ok = true;
        }
        return ok;
    }

    public void sacarAfil(Afiliados a) {
        
    }
    
    public void reciboActividades(){
        
        for(int i = 0; i<11;i++){
            
            
            
        }
        
    }
    public Actividades(String tipo, int plazas, int plazaslibres, float precio, Horario horario) {

        this.tipo = tipo;

        this.plazas = plazas;

        this.plazaslibres = plazaslibres;

        this.precio = precio;

        this.horario = horario;

        this.plazaslibres = plazas;
        
        this.afiliados = new Afiliados[plazas];

    }

    public int getPlazaslibres() {
        return plazaslibres;
    }

    public void setPlazaslibres(int plazaslibres) {
        this.plazaslibres = plazaslibres;
    }

    /*public Afiliados[] getAfiliadosx() {
        return afiliadosx;
    }

    public void setAfiliadosx(Afiliados[] afiliadosx) {
        this.afiliadosx = afiliadosx;
    }*/

    @Override
    public String toString() {
        return tipo + "\nPlazas libres: " + plazaslibres + "\nPrecio: " + precio + "\n" + horario;
    }
 
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
