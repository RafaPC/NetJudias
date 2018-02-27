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
    private ArrayList<Gamer> participantes = new ArrayList<>();
    private String premio;
    private int posiciones[];

    public Campeonato(LocalDate fecha, String juego, String premio) {
        this.fecha = fecha;
        this.juego = juego;
        this.premio = premio;
    }

    public void addJugador(Gamer jugador) {
        participantes.add(jugador);
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public ArrayList<Gamer> getParticipantes() {
        return participantes;
    }

    public void addPosiciones(Scanner sc) {
        posiciones = new int[participantes.size()];
        boolean completo, repetido;
        int posicion, numparticipante;

        for (int i = 0; i < posiciones.length; i++) {
            posiciones[i] = 0;
        }
        do {
            completo = true;
            for (int i = 0; i < posiciones.length; i++) {
                if (posiciones[i] == 0) {
                    System.out.print(i + ".- ");
                    System.out.println(participantes.get(i).toString());
                }
            }
            do {
                repetido = false;
                System.out.print("Participante: ");
                numparticipante = sc.nextInt();
                sc.nextLine();
                System.out.print("Posición: ");
                posicion = sc.nextInt();
                sc.nextLine();
                for (int i = 0; i < posiciones.length; i++) {
                    if (posiciones[i] == posicion) {
                        repetido = true;
                        System.out.println("Ya existe un jugador con esa posición");
                    }
                }
            } while (repetido);
            posiciones[numparticipante] = posicion;

            for (int i = 0; i < participantes.size(); i++) {
                if (posiciones[i] == 0) {
                    completo = false;
                }

            }

        } while (!completo);
        System.out.println("Ya has introducido todas las posiciones");
    }

    @Override
    public String toString() {
        String tostring = "Campeonato de " + juego + "\nFecha: " + fecha + "\nPremio: " + premio;
        for (int i = 0; i < posiciones.length; i++) {
            tostring += "\n" + participantes.get(i).toString() + "\nPosición: " + posiciones[i];
        }
        return tostring;
    }
}
