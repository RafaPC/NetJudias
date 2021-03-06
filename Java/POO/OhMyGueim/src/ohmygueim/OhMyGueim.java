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
import modelo.CSGO;
import modelo.ClashRoyale;
import modelo.Gamer;
import modelo.LOL;

/**
 *
 * @author daw
 */
public class OhMyGueim {

    private Scanner sc = new Scanner(System.in);
    private ArrayList<Gamer> gamers = new ArrayList<>();
    private Map<LocalDate, Campeonato> campeonatos = new LinkedHashMap<>();

    public OhMyGueim() {

        gamers.add(new CSGO("Cloud9", 870, "Dust 2", 2225, "PashaBiceps", 83));
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

        gamers.add(new CSGO("Nube9", 567, "Dust 23", 2000, "Germansooo", 56));
        gamers.get(3).addTrofeo("Pìston Cup of café con leche");
        gamers.add(new CSGO("Equipo1", 100, "Mapa1", 2000, "Jugador1", 100));
        gamers.get(4).addTrofeo("Trofeo1");

        campeonatos.put(LocalDate.of(2018, 3, 27), new Campeonato(LocalDate.of(2018, 3, 27), "LOL", "El Mejor Premio del Mundo"));
        campeonatos.get(LocalDate.of(2018, 3, 27)).addJugador(gamers.get(3));
        campeonatos.get(LocalDate.of(2018, 3, 27)).addJugador(gamers.get(4));
        campeonatos.get(LocalDate.of(2018, 3, 27)).getParticipantes().get(0).setPosicion(1);
        campeonatos.get(LocalDate.of(2018, 3, 27)).getParticipantes().get(1).setPosicion(2);

    }

    public void crearCampeonato() {
        int dia, mes, año;
        String juego, premio;
        boolean repetido;
        do {
            repetido = false;
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
            LocalDate temp = LocalDate.of(año, mes, dia);
            if (campeonatos.get(temp) != null) {
                System.out.println("Ya existe un campeonato ese día");
                repetido = true;
            }
        } while (repetido);
        LocalDate temp = LocalDate.of(año, mes, dia);
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
        campeonatos.put(temp, new Campeonato(temp, juego, premio));
        boolean metido;
        do {
            int i = 0;
            metido = false;
            switch (opcion) {
                case 1:
                    campeonatos.get(temp).imprimirCSGO(gamers, metido, campeonatos, temp);
                    break;
                case 2:
                    campeonatos.get(temp).imprimirLOL(gamers, metido, campeonatos, temp);
                    break;
                case 3:
                    campeonatos.get(temp).imprimirClashRoyale(gamers, metido, campeonatos, temp);
                    break;
                default:
                    break;
            }

            System.out.println("¿Quién va a participar?");
            System.out.println("Pulsa -1 si quieres dejar de meter jugador");
            numjugador = sc.nextInt();
            sc.nextLine();
            if (numjugador != -1) {
                campeonatos.get(temp).addJugador(gamers.get(numjugador));
            }
        } while (numjugador != -1);
    }

    public void modificarPosiciones() {
        int dia, mes, año;
        boolean repetido;
        System.out.println("¿Qué campeonato quieres modificar?");

        do {
            repetido = false;
            System.out.print("Día: ");
            dia = sc.nextInt();
            sc.nextLine();
            System.out.print("Mes: ");
            mes = sc.nextInt();
            sc.nextLine();
            System.out.print("Año: ");
            año = sc.nextInt();
            sc.nextLine();
            if (campeonatos.get(LocalDate.of(año, mes, dia)) == null) {
                System.out.println("No existe un campeonato ese día");
                repetido = true;
            }

        } while (repetido);

        campeonatos.get(LocalDate.of(año, mes, dia)).addPosiciones(sc);
    }

    public void showCampeonatos() {
        System.out.println("PENE");
        for (Campeonato camp : campeonatos.values()) {
            System.out.println(camp.toString());
            System.out.println("------------------");
        }
    }
}
