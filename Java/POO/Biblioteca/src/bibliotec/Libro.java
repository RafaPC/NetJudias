/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotec;

import java.util.Objects;

/**
 *
 * @author daw
 */
public class Libro {
    
    private String isbn;
    
    private String titulo;
    
    private String autor;
    
    private int numPaginas;
    
    private boolean prestado;


public Libro(String isbn, String titulo, String autor, int numPaginas){

    this.isbn = isbn;
    
    this.titulo = titulo;
    
    this.autor = autor;
    
    this.numPaginas = numPaginas;
    
    this.prestado = false;
}

    @Override
    public String toString() {
        return "Título: " + titulo + "\nAutor: " + autor + "\n";
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
        final Libro other = (Libro) obj;
        if (this.numPaginas != other.numPaginas) {
            return false;
        }
        if (this.prestado != other.prestado) {
            return false;
        }
        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.autor, other.autor)) {
            return false;
        }
        return true;
    }


}