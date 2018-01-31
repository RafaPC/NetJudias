/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotec;

import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author daw
 */
public class Usuario {

    private String nombre;

    private Libro[] librosprestados;

    private int numlibrosprestados;

    Scanner sc = new Scanner(System.in);

    public Usuario(String nombre) {

        this.nombre = nombre;
        
        Libro[] librosprestados = new Libro[3];
        
        numlibrosprestados = 0;
    }

    @Override
    public String toString() {
        return  nombre ;
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    public void prestarLibro(Libro[] libros, int numLibros) {
        int posicionLibro = -1;
        for (int i = 0; i < numLibros; i++) {
            System.out.println(i + ".-");
            System.out.println(libros[i].toString());
        }
        System.out.println("¿Y qué libro quieres coger?");
        posicionLibro = sc.nextInt();
        sc.nextLine();
        if (posicionLibro > -1 || posicionLibro < numLibros) {
            librosprestados[numlibrosprestados] = libros[posicionLibro];
            numlibrosprestados++;
        } else {
            System.out.println("Has introducido un número no válido");
        }

    }

    public void devolverLibro(int numUsuarios, int numLibros) {
        int posicionLibro = -1;
        for (int i = 0; i < numLibros; i++) {
            System.out.println(i + ".-");
            librosprestados[i].toString();
        }
        System.out.println("¿Y qué libro quieres devolver?");
        posicionLibro = sc.nextInt();
        sc.nextLine();
        if (posicionLibro > -1 || posicionLibro < numlibrosprestados) {
            librosprestados[posicionLibro] = librosprestados[numlibrosprestados - 1];
            librosprestados[numlibrosprestados - 1] = null;
            numlibrosprestados--;
        } else {
            System.out.println("Has introducido un número no válido");
        }
    }

    public int numLibrosPrestados() {
        int librosprestados = 0;

        return librosprestados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
