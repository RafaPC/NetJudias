/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohmygueim;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import modelo.CSGO;
import modelo.ClashRoyale;
import modelo.Gamer;
import modelo.LOL;
import ohmygueim.Participante;

/**
 *
 * @author daw
 */
public class Campeonato {

    private LocalDate fecha;
    private String juego;
    //private ArrayList<Gamer> participantes = new ArrayList<>();
    private String premio;
    private ArrayList<Participante> participantes = new ArrayList<>();

    public Campeonato(LocalDate fecha, String juego, String premio) {
        this.fecha = fecha;
        this.juego = juego;
        this.premio = premio;
    }

    public void addJugador(Gamer jugador) {
        participantes.add(new Participante(jugador));
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    public void addPosiciones(Scanner sc) {

        boolean completo = true, repetido;
        int posicion = 0, numparticipante;
        for (Participante participante : participantes) {
            if (participante.getPosicion() == -1) {
                completo = false;
            }
        }
        while (!completo) {
            completo = true;

            do {
                repetido = false;

                for (int i = 0; i < participantes.size(); i++) {
                    if (-1 == participantes.get(i).getPosicion()) {
                        System.out.println("------------------");
                        System.out.println(i + ".- " + participantes.get(i).getPersona().toString());
                        System.out.println("------------------");
                    }
                }
                System.out.print("Participante: ");
                numparticipante = sc.nextInt();
                sc.nextLine();
                if (numparticipante < 0 && numparticipante > participantes.size()) {
                    System.out.println("No existe ese participante");
                    repetido = true;
                } else {
                    System.out.print("Posición: ");
                    posicion = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < participantes.size(); i++) {
                        if (participantes.get(i).getPosicion() == posicion) {
                            repetido = true;
                            System.out.println("Ya existe un jugador con esa posición");
                        }
                    }
                }
            } while (repetido);
            participantes.get(numparticipante).setPosicion(posicion);
            for (Participante person : participantes) {
                if (-1 == person.getPosicion()) {
                    completo = false;
                }
            }
        }
        System.out.println("Ya has asignado una posición a cada participante");
    }

    @Override
    public String toString() {
        String tostring = "Campeonato de " + juego + "\nFecha: " + fecha + "\nPremio: " + premio;
        for (int i = 0; i < participantes.size(); i++) {
            tostring += "\n---";
            tostring += "\n" + participantes.get(i).getPersona().toString() + "\nPosición: " + participantes.get(i).getPosicion();
        }
        return tostring;
    }

    public void imprimirCSGO(ArrayList <Gamer> gamers, boolean metido, Map campeonatos,LocalDate temp) {
        int i = 0;
        metido = false;
        for (i = 0; i < gamers.size(); i++) {
            metido = false;
            if (gamers.get(i) instanceof CSGO) {
                if (getParticipantes().size() > 0) {
                    if (getParticipantes().contains(new Participante(gamers.get(i)))) {
                        metido = true;
                    }
                }
                if (!metido) {
                    System.out.println(i + ".- " + gamers.get(i).toString());
                }
            }
        }
    }
    public void imprimirLOL(ArrayList <Gamer>gamers, boolean metido, Map campeonatos,LocalDate temp) {
        int i = 0;
        metido = false;
        for (i = 0; i < gamers.size(); i++) {
            metido = false;
            if (gamers.get(i) instanceof LOL) {
                if (getParticipantes().size() > 0) {
                    if (getParticipantes().contains(new Participante(gamers.get(i)))) {
                        metido = true;
                    }
                }
                if (!metido) {
                    System.out.println(i + ".- " + gamers.get(i).toString());
                }
            }
        }
    }
    public void imprimirClashRoyale(ArrayList <Gamer> gamers, boolean metido, Map campeonatos,LocalDate temp) {
        int i = 0;
        metido = false;
        for (i = 0; i < gamers.size(); i++) {
            metido = false;
            if (gamers.get(i) instanceof ClashRoyale) {
                if (getParticipantes().size() > 0) {
                    if (getParticipantes().contains(new Participante(gamers.get(i)))) {
                        metido = true;
                    }
                }
                if (!metido) {
                    System.out.println(i + ".- " + gamers.get(i).toString());
                }
            }
        }
    }
}
