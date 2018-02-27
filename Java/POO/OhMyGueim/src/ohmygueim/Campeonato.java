/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohmygueim;

import java.time.LocalDate;
import java.util.ArrayList;
import ohmygueim.Clientes.Gamer;

/**
 *
 * @author daw
 */
public class Campeonato {

    private LocalDate fecha;
    private String juego;
    private ArrayList <Gamer> participantes = new ArrayList <>();
    private String premio;

    public Campeonato(LocalDate fecha, String juego, String premio) {
        this.fecha = fecha;
        this.juego = juego;
        this.premio = premio;
    }
    public void addJugador(Gamer jugador){
        participantes.add(jugador);
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public ArrayList<Gamer> getParticipantes() {
        return participantes;
    }

}
