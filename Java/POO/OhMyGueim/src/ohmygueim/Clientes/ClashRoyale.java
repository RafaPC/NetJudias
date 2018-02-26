/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohmygueim.Clientes;

import java.util.ArrayList;

/**
 *
 * @author daw
 */
public class ClashRoyale extends Gamer {

    private ArrayList <Carta> mazo = new ArrayList<>();

    public ClashRoyale(int ranking, String nombre, int numtorneos) {
        super(ranking, nombre, numtorneos);
    }
    public void addCarta(String nombre, int nivel){
        mazo.add(new Carta(nombre,nivel));
    }
}
