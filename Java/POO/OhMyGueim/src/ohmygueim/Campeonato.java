/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohmygueim;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import ohmygueim.Clientes.Gamer;

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
            if(participante.getPosicion() == -1){
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
            tostring += "\n" + participantes.get(i).getPersona().toString() + "\nPosición: " + participantes.get(i).getPosicion();
        }
        return tostring;
    }
}
