/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Objects;

/**
 *
 * @author daw
 */
public class RecursoMision {

    private Recurso recurso;
    private String uso;

    public RecursoMision(Recurso recurso, String uso) {
        this.recurso = recurso;
        this.uso = uso;
    }

    private void addUso(String uso) {
        this.uso = uso;
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
        final RecursoMision other = (RecursoMision) obj;
        /*if (!Objects.equals(this.uso, other.uso)) {
            return false;
        }*/
        if (!Objects.equals(this.recurso, other.recurso)) {
            return false;
        }
        return true;
    }

}
