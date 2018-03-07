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
public class Analista extends Freelance{
    private int precioHoraAnalista;
    private int lvlExp;

    public Analista(int precioHoraAnalista, int lvlExp, String dni, String nombre, int precioHora) {
        super(dni, nombre, precioHora);
        this.precioHoraAnalista = precioHoraAnalista;
        this.lvlExp = lvlExp;
    }

    public int getPrecioHoraAnalista() {
        return precioHoraAnalista;
    }

    public boolean tieneEXP(int exppuesto, String languaje) {
        boolean apto = false;
        if(experiencia.get(languaje)!= null && experiencia.get(languaje).getExp() >= exppuesto){
            apto = true;
        }
        return apto;
    }
}
