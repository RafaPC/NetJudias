
package fuerzasEspeciales.modelo;

import fuerzasEspeciales.modelo.RecursoMilitar;

public class Material extends RecursoMilitar{
    protected int nvlHabilidadMinimo;
    protected int rangoAccion;

    public Material(){
        
    }
    public Material(int potenciaMuerte, String nombre,int nvlHabilidadMinimo,int rangoAccion) {
        super(potenciaMuerte, nombre);
        this.nvlHabilidadMinimo=nvlHabilidadMinimo;
        this.rangoAccion=rangoAccion;
    }

    public int getNvlHabilidadMinimo() {
        return nvlHabilidadMinimo;
    }

    public void setNvlHabilidadMinimo(int nvlHabilidadMinimo) {
        this.nvlHabilidadMinimo = nvlHabilidadMinimo;
    }

    public int getRangoAccion() {
        return rangoAccion;
    }

    public void setRangoAccion(int rangoAccion) {
        this.rangoAccion = rangoAccion;
    }

    
    
    
    @Override
    public String toString() {
        return "Material{" +super.toString()+ "nvlHabilidadMinimo=" + nvlHabilidadMinimo + ", rangoAccion=" + rangoAccion + '}';
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
        final Material other = (Material) obj;
        if (this.nvlHabilidadMinimo != other.nvlHabilidadMinimo) {
            return false;
        }
        if (this.rangoAccion != other.rangoAccion) {
            return false;
        }
        return true;
    }


 
    
}
