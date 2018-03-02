/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author daw
 */
public abstract class Recurso {
    private int potenciaDeMuerte;
    private String nombre;
    private ArrayList <Mision> misiones = new ArrayList<>();

    public int getPotenciaDeMuerte() {
        return potenciaDeMuerte;
    }
    
}
