/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author daw
 */
public class Freelance {

    private String dni;
    private String nombre;
    private int precioHora;
    protected Map<String, Lenguaje> experiencia = new LinkedHashMap<>();

    public Freelance(String dni, String nombre, int precioHora) {
        this.dni = dni;
        this.nombre = nombre;
        this.precioHora = precioHora;
    }

    public int getPrecioHora() {
        return precioHora;
    }

    

    public void addExperiencia(String clave, int exp) {

        experiencia.put(clave, new Lenguaje(clave, exp));
    }

    @Override
    public String toString() {
        return "\n-------------\nFreelance{" + "dni=" + dni + ", nombre=" + nombre + ", precioHora=" + precioHora + ", experiencia=" + experiencia + '}';
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
        final Freelance other = (Freelance) obj;
        if (this.precioHora != other.precioHora) {
            return false;
        }
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.experiencia, other.experiencia)) {
            return false;
        }
        return true;
    }

}
