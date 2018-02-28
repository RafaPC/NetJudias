/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohmygueim;

import ohmygueim.Clientes.Gamer;

/**
 *
 * @author daw
 */
public class Posicion {
    private Gamer persona;

    public Posicion(Gamer persona, int posicion) {
        this.persona = persona;
        this.posicion = posicion;
    }
    private int posicion;
}
