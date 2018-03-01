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
public class CSGO extends Gamer{

    private String equipo;
    private int numkills;
    private String mapafavorito;

    public CSGO(String equipo, int numkills, String mapafavorito, int ranking, String nombre, int numtorneos) {
        super(ranking, nombre, numtorneos);
        this.equipo = equipo;
        this.numkills = numkills;
        this.mapafavorito = mapafavorito;
    }

    public String getEquipo() {
        return equipo;
    }

    public int getNumkills() {
        return numkills;
    }

    public String getMapafavorito() {
        return mapafavorito;
    }
}
