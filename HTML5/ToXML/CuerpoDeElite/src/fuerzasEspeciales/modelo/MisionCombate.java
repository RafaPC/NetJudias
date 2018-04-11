
package fuerzasEspeciales.modelo;

import fuerzasEspeciales.modelo.Mision;
import java.time.LocalDate;
import java.util.ArrayList;

public class MisionCombate extends Mision {
    protected int nvlMinimoPotencia;

    public MisionCombate(){
        
    }
    public MisionCombate(LocalDate fechaMision, String lugar, String nombre, int nivelExperienciaGanar,int nvlMinimoPotencia) {
        super(fechaMision, lugar, nombre, nivelExperienciaGanar);
         this.nvlMinimoPotencia=nvlMinimoPotencia;
    }

    public int getNvlMinimoPotencia() {
        return nvlMinimoPotencia;
    }

    public void setNvlMinimoPotencia(int nvlMinimoPotencia) {
        this.nvlMinimoPotencia = nvlMinimoPotencia;
    }


    public ArrayList<RecursoMilitar> getRecursos() {
        return recursos;
    }

    public void setRecursos(ArrayList<RecursoMilitar> recursos) {
        this.recursos = recursos;
    }



    @Override
    public String toString() {
        return "MisionCombate{" + "nvlMinimoPotencia=" + nvlMinimoPotencia + '}';
    }

 
    
    
    
}
