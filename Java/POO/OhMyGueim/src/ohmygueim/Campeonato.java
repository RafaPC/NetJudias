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

    private LocalDate dia;
    private String juego;
    private ArrayList <Gamer> clientes = new ArrayList <>();
    private String premio;

    public Campeonato(LocalDate dia, String juego, String premio) {
        this.dia = dia;
        this.juego = juego;
        this.premio = premio;
    }
    public void addJugador(Gamer jugador){
        clientes.add(jugador);
    }
}
