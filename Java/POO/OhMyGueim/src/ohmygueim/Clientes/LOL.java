/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohmygueim.Clientes;

/**
 *
 * @author daw
 */
public class LOL extends Gamer{

    public LOL(String linea, String especialidad, int ranking, String nombre, int numtorneos) {
        super(ranking, nombre, numtorneos);
        this.linea = linea;
        this.especialidad = especialidad;
    }
    private String linea;
    private String especialidad;

    
    
}
