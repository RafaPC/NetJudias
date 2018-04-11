
package fuerzasEspeciales.modelo;

import fuerzasEspeciales.modelo.RecursoMilitar;

public class Humano extends RecursoMilitar{
    protected int nvlEstres;
    protected int muertesCuchillo;
    protected int nvlHabilidadManejo;
    protected int nvlExperiencia;

    public Humano(){
        
    }
    public Humano(int potenciaMuerte, String nombre,int nvlEstres,int muertesCuchillo,int nvlHabilidadManejo,int nvlExperiencia) {
        super(potenciaMuerte, nombre);
        this.nvlEstres=nvlEstres;
        this.muertesCuchillo=muertesCuchillo;
        this.nvlHabilidadManejo=nvlHabilidadManejo;
        this.nvlExperiencia=nvlExperiencia;
    }

    public int getNvlEstres() {
        return nvlEstres;
    }

    public void setNvlEstres(int nvlEstres) {
        this.nvlEstres = nvlEstres;
    }

    public int getMuertesCuchillo() {
        return muertesCuchillo;
    }

    public void setMuertesCuchillo(int muertesCuchillo) {
        this.muertesCuchillo = muertesCuchillo;
    }

    public int getNvlHabilidadManejo() {
        return nvlHabilidadManejo;
    }

    public void setNvlHabilidadManejo(int nvlHabilidadManejo) {
        this.nvlHabilidadManejo = nvlHabilidadManejo;
    }

    public int getNvlExperiencia() {
        return nvlExperiencia;
    }

    public void setNvlExperiencia(int nvlExperiencia) {
        this.nvlExperiencia = nvlExperiencia;
    }
    
    public void addExp(int exp){
        nvlExperiencia+=exp;
    }
    
    public void addEstres(int estres){
        nvlEstres+=estres;
    }
    
  
    
    

    @Override
    public String toString() {
        return "Humano{"+super.toString() + "nvlEstres=" + nvlEstres + ", muertesCuchillo=" + muertesCuchillo + ", nvlHabilidadManejo=" + nvlHabilidadManejo + ", nvlExperiencia=" + nvlExperiencia + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Humano other = (Humano) obj;
        if (this.nvlEstres != other.nvlEstres) {
            return false;
        }
        if (this.muertesCuchillo != other.muertesCuchillo) {
            return false;
        }
        if (this.nvlHabilidadManejo != other.nvlHabilidadManejo) {
            return false;
        }
        if (this.nvlExperiencia != other.nvlExperiencia) {
            return false;
        }
        return true;
    }


    
    
    
    
}
