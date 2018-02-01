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

        this.librosprestados = new Libro[3];

        this.numlibrosprestados = 0;
    }

    @Override
    public String toString() {
        String mensaje;
        mensaje = nombre + "\nLibros prestados: ";
        for (int i = 0; i < numlibrosprestados; i++) {
            mensaje += "\n" + librosprestados[i].toString();
        }
        mensaje += "\n";
        return mensaje;
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

        System.out.println("Elige"
                + "\n1.- Mostrar actividades y elegir número"
                + "\n2.- Buscar por isbn,titulo,autor");
        int opcion = sc.nextInt();
        sc.nextLine();
        //Posicion del libro en el array de libros de biblioteca
        int posicionLibro = -1;
        //Muestra todos los libros y coge la posición introducida por el usuario
        if (opcion == 1) {

            //Muestra libros
            for (int i = 0; i < numLibros; i++) {
                System.out.println(i + ".-");
                System.out.println(libros[i].toString());
            }
            //Elige libro
            System.out.println("¿Y qué libro quieres coger?");
            posicionLibro = sc.nextInt();
            sc.nextLine();

            //Evita introducir un número donde no haya un libro
        } else if (opcion == 2) {
            System.out.println("¿Cómo quieres buscar el libro?"
                    + "\n1.- Por isbn"
                    + "\n2.- Por título"
                    + "\n3.- Por autor");
            opcion = sc.nextInt();
            sc.nextLine();
            String campo;
            boolean encontrado = false;
            switch (opcion) {
                case 1:
                    System.out.println("Dame el isbn:");
                    campo = sc.next();
                    for (int i = 0; i < numLibros && !encontrado; i++) {
                        if (libros[i].getIsbn().equalsIgnoreCase(campo)) {
                            posicionLibro = i;
                            encontrado = true;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Dame el título");
                    campo = sc.next();
                    for (int i = 0; i < numLibros && !encontrado; i++) {
                        if(libros[i].getTitulo().equalsIgnoreCase(campo)) {
                            posicionLibro = i;
                            encontrado = true;
                        }
                    }
                    break;
                /*case 3:
                    System.out.println("Dame el autor");
                    campo = sc.next();
                    for (int i = 0; i < numLibros; i++) {
                        if (libros[i].getAutor().equalsIgnoreCase(campo)) {
                            System.out.println(i + ".-");
                            System.out.println(libros[i].toString());
                        }
                    }
                    System.out.println("Ahora elige que libro quieres escoger");
                    
                    for(int i = 0;encontrado;i++){
                        
                    }*/
            }

        }
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
            for (int i = 0; i < numLibros; i++) {
                if (temp.equals(libros[i])) {
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

    public void devolverTodosLosLibros(Libro[] libros) {
        boolean cambiado;
        for (int i = 0; i < numlibrosprestados; i++) {
            cambiado = false;
            for (int j = 0; !cambiado; j++) {
                if (librosprestados[i].equals(libros[j])) {
                    libros[j].setPrestado(false);
                    cambiado = true;
                }
            }
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
