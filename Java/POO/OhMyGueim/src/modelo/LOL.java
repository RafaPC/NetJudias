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
public class LOL extends Gamer{

    private String linea;
    private String especialidad;
    
    public LOL(String linea, String especialidad, int ranking, String nombre, int numtorneos) {
        super(ranking, nombre, numtorneos);
        this.linea = linea;
        this.especialidad = especialidad;
    }

    public String getLinea() {
        return linea;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}
