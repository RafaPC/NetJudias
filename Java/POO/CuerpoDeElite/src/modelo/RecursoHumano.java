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
public class RecursoHumano extends Recurso {

    private int stress;
    private int numBajasCuchillo;
    private int habilidadMaquinas;
    private int exp;

    public RecursoHumano(int stress, int numBajasCuchillo, int habilidadMaquinas, int exp, int potenciaDeMuerte, String nombre) {
        super(potenciaDeMuerte, nombre);
        this.stress = stress;
        this.numBajasCuchillo = numBajasCuchillo;
        this.habilidadMaquinas = habilidadMaquinas;
        this.exp = exp;
    }

    public int getStress() {
        return stress;
    }

    @Override
    public String toString() {
        return "RecursoHumano{" + "stress=" + stress + ", numBajasCuchillo=" + numBajasCuchillo + ", habilidadMaquinas=" + habilidadMaquinas + ", exp=" + exp + '}';
    }

}
