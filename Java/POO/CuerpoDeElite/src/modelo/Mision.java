/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author daw
 */
public class Mision {
    private LocalDate fecha;
    private String lugar;
    private int expGanada;
    private boolean exito;
    private ArrayList <RecursoMision> recursosMision = new ArrayList <>();

    public Mision(LocalDate fecha, String lugar, int expGanada, boolean exito) {
        this.fecha = fecha;
        this.lugar = lugar;
        this.expGanada = expGanada;
        this.exito = false;
    }
    
}
