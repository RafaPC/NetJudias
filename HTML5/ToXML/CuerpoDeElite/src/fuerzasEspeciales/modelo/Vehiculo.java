
package fuerzasEspeciales.modelo;


public class Vehiculo extends Material{
     int capacidad;

    public Vehiculo(){
        
    }
     public Vehiculo(int potenciaMuerte, String nombre, int nvlHabilidadMinimo, int rangoAccion,int capacidad) {
        super(potenciaMuerte, nombre, nvlHabilidadMinimo, rangoAccion);
        this.capacidad=capacidad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    
    
    
    
    @Override
    public String toString() {
        return "Vehiculo{"+super.toString() + "capacidad=" + capacidad + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Vehiculo other = (Vehiculo) obj;
        if (this.capacidad != other.capacidad) {
            return false;
        }
        return true;
    }


    
    
}
