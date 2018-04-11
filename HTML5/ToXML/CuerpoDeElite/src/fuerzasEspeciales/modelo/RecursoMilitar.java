
package fuerzasEspeciales.modelo;

import java.util.ArrayList;
import java.util.Objects;

public class RecursoMilitar {
   
    protected int potenciaMuerte;
    protected String nombre;
    RecursoUso uso;
    protected ArrayList<Mision> misionesParticipado = new ArrayList<>();
 

    public RecursoMilitar(){
        
    }
    public RecursoMilitar(int potenciaMuerte, String nombre) {
        this.potenciaMuerte = potenciaMuerte;
        this.nombre = nombre;
    }
    
    public Mision addMision(Mision misionParticipa){
        misionesParticipado.add(misionParticipa);
        return misionParticipa;
    }

    public int getPotenciaMuerte() {
        return potenciaMuerte;
    }

    public void setPotenciaMuerte(int potenciaMuerte) {
        this.potenciaMuerte = potenciaMuerte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Mision> getMisionesParticipado() {
        return misionesParticipado;
    }

    public void setMisionesParticipado(ArrayList<Mision> misionesParticipado) {
        this.misionesParticipado = misionesParticipado;
    }

    public RecursoUso getUso() {
        return uso;
    }

    public void setUso(RecursoUso uso) {
        this.uso = uso;
    }

  
    
    
    @Override
    public String toString() {

        return "" + "Nombre=" + nombre + ", potencia de muerte=" + potenciaMuerte+ '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RecursoMilitar other = (RecursoMilitar) obj;
        if (this.potenciaMuerte != other.potenciaMuerte) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.misionesParticipado, other.misionesParticipado)) {
            return false;
        }
        return true;
    }
    
    
    
}
