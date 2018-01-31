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

        this.librosprestados = new Libro[10];

        numlibrosprestados = 0;
    }

    @Override
    public String toString() {
        return nombre;
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

        //Evita introducir un número donde no haya un libro
        if (posicionLibro < 0 || posicionLibro >= numLibros) {
            System.out.println("Has introducido un número no válido");
        //No se podrá prestar un libro ya prestado
        } else if (libros[posicionLibro].isPrestado()) {
            System.out.println("Ese libro ya está cogido");
        //Mete el libro en el array de libros prestados del usuario seleccionado y lo pone como prestado
        } else {
            libros[posicionLibro].setPrestado(true);
            librosprestados[numlibrosprestados] = libros[posicionLibro];
            numlibrosprestados++;
        }

    }

    public void devolverLibro(Libro[] libros, int numUsuarios, int numLibros) {
        int posicionLibro = -1;
        for (int i = 0; i < numlibrosprestados; i++) {
            System.out.println(i + ".-");
            System.out.println(librosprestados[i].toString());
        }
        System.out.println("¿Y qué libro quieres devolver?");
        posicionLibro = sc.nextInt();
        sc.nextLine();
        if (posicionLibro > -1 || posicionLibro < numlibrosprestados) {
            
            //Buscamos el libro en el array de libros para volver a ponerlo como disponible (boolean prestado = false)
            Libro temp = librosprestados[posicionLibro];
            for (int i = 0; i < numLibros; i++){
                if(temp.equals(libros[i])){
                    libros[i].setPrestado(false);
                }
            }
            
            //Quitamos el libro del array de libros prestados y ordenamos el array
            librosprestados[posicionLibro] = librosprestados[numlibrosprestados - 1];
            librosprestados[numlibrosprestados - 1] = null;
            numlibrosprestados--;
        } else {
            System.out.println("Has introducido un número no válido");
        }
    }

    public void librosPrestadosUsuario() {
        for (int i = 0; i < numlibrosprestados; i++) {
            System.out.println(librosprestados[i].toString());
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumlibrosprestados() {
        return numlibrosprestados;
    }

}
