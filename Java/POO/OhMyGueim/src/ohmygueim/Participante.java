/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohmygueim;

import java.util.Objects;
import ohmygueim.Clientes.CSGO;
import ohmygueim.Clientes.ClashRoyale;
import ohmygueim.Clientes.Gamer;
import ohmygueim.Clientes.LOL;

/**
 *
 * @author daw
 */
public class Participante {

    private Gamer persona;
    private int posicion;

    public Participante(Gamer persona) {
        this.persona = persona;
        this.posicion = -1;
    }

    public Gamer getPersona() {
        return persona;
    }

    public void setPersona(Gamer persona) {
        this.persona = persona;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        String tostring;
        tostring = "Jugador: " + persona.getNombre() + "\nELO: " + persona.getRanking() + "\nNº torneos jugados: " + persona.getNumtorneos() + "\nTrofeos: ";
        for (String trophy : persona.getTrofeos()) {
            tostring += "\n" + trophy.toString();
        }
        tostring += "\n---\nJuego: ";
        if (persona instanceof LOL) {
            tostring += "LOL";
            tostring += "\nRol: " + ((LOL) persona).getEspecialidad();
            tostring += "\nLínea: " + ((LOL) persona).getLinea();
        } else if (persona instanceof CSGO) {
            tostring += "CSGO";
            tostring += "\nEquipo: : " + ((CSGO) persona).getEquipo();
            tostring += "\nMapa favorito: " + ((CSGO) persona).getMapafavorito();
            tostring += "\nKills total: " + ((CSGO) persona).getNumkills();
        } else if (persona instanceof ClashRoyale) {
            tostring += "Clash Royale";
        }

        return tostring;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Participante other = (Participante) obj;
        if (!Objects.equals(this.persona, other.persona)) {
            return false;
        }
        return true;
    }

}
