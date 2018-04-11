
package fuerzasEspeciales.modelo;

public class Arma extends Material{
    
    public Arma(){
        
    }
    public Arma(int potenciaMuerte, String nombre, int nvlHabilidadMinimo, int rangoAccion) {
        super(potenciaMuerte, nombre, nvlHabilidadMinimo, rangoAccion);
    }

    @Override
    public String toString() {
        return "Arma{" +super.toString()+ '}';
    }


    
    
}
