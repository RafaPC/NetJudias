/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author daw
 */
public class MisionDeCombate extends Mision{
    private int potenciaMinima;

    public MisionDeCombate(int potenciaMinima, LocalDate fecha, String lugar, int expGanada, String nombre) {
        super(fecha, lugar, expGanada, nombre);
        this.potenciaMinima = potenciaMinima;
    }
    
}
