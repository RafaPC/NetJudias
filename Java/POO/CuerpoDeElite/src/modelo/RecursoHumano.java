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

    public RecursoHumano(int stress, int numBajasCuchillo, int habilidadMaquinas, int exp) {
        this.stress = stress;
        this.numBajasCuchillo = numBajasCuchillo;
        this.habilidadMaquinas = habilidadMaquinas;
        this.exp = exp;
    }

    public int getStress() {
        return stress;
    }

}
