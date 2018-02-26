/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohmygueim;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import ohmygueim.Clientes.CSGO;
import ohmygueim.Clientes.ClashRoyale;
import ohmygueim.Clientes.Gamer;
import ohmygueim.Clientes.LOL;

/**
 *
 * @author daw
 */
public class OhMyGueim {

    private Scanner sc = new Scanner(System.in);
    private ArrayList<Gamer> gamers = new ArrayList<>();
    private Map<LocalDate, Campeonato> campeonatos = new LinkedHashMap<>();

    public OhMyGueim() {

        gamers.add(new CSGO("Cloud9", 567, "Dust 2", 2000, "PashaBiceps", 56));
        gamers.get(0).addTrofeo("Pìston Cup");

        gamers.add(new LOL("Mid", "Asesino", 2300, "xPeke", 72));
        gamers.get(1).addTrofeo("DreamHack 2016");

        gamers.add(new ClashRoyale(2000, "Ocelote", 64));
        ((ClashRoyale) gamers.get(2)).addCarta("Gigante", 1);
        ((ClashRoyale) gamers.get(2)).addCarta("Mago", 2);
        ((ClashRoyale) gamers.get(2)).addCarta("Mago eléctrico", 4);
        ((ClashRoyale) gamers.get(2)).addCarta("Monta Puercos", 1);
        ((ClashRoyale) gamers.get(2)).addCarta("P.E.K.K.A.", 3);
        ((ClashRoyale) gamers.get(2)).addCarta("Bruja", 4);
        ((ClashRoyale) gamers.get(2)).addCarta("Arqueras", 1);
        campeonatos.put(LocalDate.of(2018, 3, 27), new Campeonato(LocalDate.of(2018, 3, 27), "LOL", "El Mejor Premio del Mundo"));

    }

    public void crearCampeonato() {
        int dia, mes, año;
        String juego, premio;
        System.out.println("¿Que día va a ser?");
        System.out.print("Día: ");
        dia = sc.nextInt();
        sc.nextLine();
        System.out.print("Mes: ");
        mes = sc.nextInt();
        sc.nextLine();
        System.out.print("Año: ");
        año = sc.nextInt();
        sc.nextLine();
        
        System.out.println("¿De qué juego va a ser?");
        System.out.println("1.- CSGO"
                + "\n2.- LOL"
                + "\n3.- Clash Royale");
        int opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1:
                juego = "CSGO";
                break;
            case 2:
                juego = "LOL";
                break;
            case 3:
                juego = "Clash Royale";
                break;
            default:
                juego = "ninguno";
        }
        System.out.println("¿Cuál es el premio?");
        premio = sc.next();

        int numjugador = 0;
        campeonatos.put(LocalDate.of(año, mes, dia), new Campeonato(LocalDate.of(año, mes, dia), juego, premio));

        do {
            if (opcion == 1) {
                for (int i = 0; i < gamers.size(); i++) {
                    if (gamers.get(i) instanceof CSGO) {
                        System.out.println(i + ".- " + gamers.get(i).toString());
                    }
                }
            } else if (opcion == 2) {
                for (int i = 0; i < gamers.size(); i++) {
                    if (gamers.get(i) instanceof LOL) {
                        System.out.println(i + ".- " + gamers.get(i).toString());
                    }
                }
            } else if (opcion == 3) {
                for (int i = 0; i < gamers.size(); i++) {
                    if (gamers.get(i) instanceof ClashRoyale) {
                        System.out.println(i + ".- " + gamers.get(i).toString());
                    }
                }
            }
            System.out.println("¿Quién va a participar?");
            numjugador = sc.nextInt();
            sc.nextLine();
            campeonatos.get(LocalDate.of(año, mes, dia)).addJugador(gamers.get(numjugador));
        } while (numjugador != -1);
    }
}
