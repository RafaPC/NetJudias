/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author daw
 */
public class RecursoMaterial extends Recurso{
    private int habilidadMinima;
    private int rangoAccion;

    public RecursoMaterial(int habilidadMinima, int rangoAccion) {
        this.habilidadMinima = habilidadMinima;
        this.rangoAccion = rangoAccion;
    }
    
}
