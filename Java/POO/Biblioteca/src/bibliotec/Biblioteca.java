/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotec;

import java.util.Scanner;

/**
 *
 * @author daw
 */
public class Biblioteca {

    public Usuario[] usuarios;

    private Libro[] libros;

    public int numUsuarios = 4;

    public int numLibros = 13;

    /**
     * Variable que indica en que posición se encuentra el usuario requerido
     * despues de llamar a encontrarUsuario().
     */
    public int posicionUsuario;

    /**
     * Variable que cambia cada vez que se llama a encontrarUsuario() y que
     * indica si el método ha tenido éxito o no.
     */
    public boolean encontrado;

    Scanner sc = new Scanner(System.in);

    public Biblioteca() {

        encontrado = false;
        posicionUsuario = 0;
        numUsuarios = 4;
        numLibros = 13;

        libros = new Libro[30];

        libros[0] = new Libro("76-9374-845-0", "Pipo", "Alexelcapo", 328);
        libros[1] = new Libro("23-9824-963-1", "Wigetta", "Willyrex", 100);
        libros[2] = new Libro("27-1923-453-2", "Aprovecha el bug", "Willyrex", 70);
        libros[3] = new Libro("82-2039-423-3", "Pipo", "Vegetta", 50);
        libros[4] = new Libro("01-4362-450-4", "Pipo", "Jesucristo", 1328);
        libros[5] = new Libro("09-7896-741-5", "Putalocura.com", "Torbe", 20);
        libros[6] = new Libro("98-1470-852-6", "OtroLibro", "Alexelcapo", 328);
        libros[7] = new Libro("71-7860-123-7", "Libro2", "Alexelcapo", 328);
        libros[8] = new Libro("46-6975-654-8", "Historia de un algo", "Paquito Folguera", 50);
        libros[9] = new Libro("87-7767-987-9", "El codigo Da Vinci", "Alexelcapo", 3141523);
        libros[10] = new Libro("91-0101-789-5", "Kamasutra", "Mahatma Gandhi", 10000);
        libros[11] = new Libro("70-7808-002-4", "Nombre Libro Genérico", "Alexelcapo", 100);
        libros[12] = new Libro("40-3675-007-1", "Libro de Belén Esteban", "Alguien que sí que sabe escribir", 2);

        usuarios = new Usuario[20];
        usuarios[0] = new Usuario("Kiko");
        usuarios[1] = new Usuario("Rafa");
        usuarios[2] = new Usuario("Jesucristo");
        usuarios[3] = new Usuario("Oski");

    }

    /**
     * Pregunta por los campos que necesita el constructor de Libro y crea uno.
     */
    public void darAltaLibro() {
        System.out.println("Procede a rellenar los datos para dar de alta el libro");
        System.out.println("ISBN: ");
        String isbn = sc.next();
        System.out.println("Título de la obra: ");
        String titulo = sc.next();
        System.out.println("Autor de la obra: ");
        String autor = sc.next();
        System.out.println("N�mero de p�ginas: ");
        
        boolean numeroCorrecto = true;
        int numPaginas = 0;
        
        try {
            numPaginas = sc.nextInt();
        } catch (Exception ex) {
            numeroCorrecto = false;
        }
        
        if (numeroCorrecto) {
            libros[numLibros] = new Libro(isbn, titulo, autor, numPaginas);
            numLibros++;
        }
    }

    /**
     * Pregunta por el nombre de usuario, despu�s checkea si existe alg�n
     * usuario con ese nombre, y finalmente crea un Usuario con ese nombre.
     */
    public void darAltaUsuario() {

        System.out.println("Nombre del usuario: ");
        boolean nombreCorrecto = true;

        String nombre = sc.next();

        if (nombreCorrecto) {

            Usuario temp = new Usuario(nombre);
            for (int i = 0; i < numUsuarios; i++) {
                if (temp.equals(usuarios[i])) {
                    System.out.println("Ya hay un usuario con ese nombre");
                    System.out.println("En esta biblioteca no admitimos personas con el mismo nombre");
                }
            }
            usuarios[numUsuarios] = new Usuario(nombre);
            numUsuarios++;
        }
    }

    /**
     * Llama a encontrarUsuario y, si existe el usuario introducido, devuelve
     * sus libros prestados y despu�s borra al usuario.
     */
    public void darBajaUsuario() {
        encontrarUsuario();
        if (encontrado) {
            //Si el usuario tiene algun libro prestado los devolverá primero
            if (usuarios[posicionUsuario].getNumlibrosprestados() > 0) {

                usuarios[posicionUsuario].devolverTodosLosLibros(libros);
            }
            usuarios[posicionUsuario] = usuarios[numUsuarios - 1];
            usuarios[numUsuarios - 1] = null;
            numUsuarios--;
        }
    }

    /**
     * Llama a encontrarUsuario y, si existe el usuario introducido, llama a la
     * funci�n prestarLibro del usuario.
     */
    public void prestarLibro() {
        encontrarUsuario();
        if (encontrado) {
            if (usuarios[posicionUsuario].getNumlibrosprestados() == 3) {
                System.out.println("Este usuario ya tiene 3 libros\n"
                        + "Deberá devolver antes un libro para poder coger prestado otro");
            } else {
                usuarios[posicionUsuario].prestarLibro(libros, numLibros);
            }
        }

    }

    /**
     * Llama a encontrarUsuario y, si existe el usuario introducido, llama a la
     * funci�n devolverLibro del usuario.
     */
    public void devolverLibro() {
        encontrarUsuario();
        if (encontrado) {
            if (usuarios[posicionUsuario].getNumlibrosprestados() == 0) {
                System.out.println("Ese usuario no tiene ningún libro prestado");
            } else {
            }
        }
    }

    /**
     * Lista todos los libros mostrando cuales est�n disponibles y cuales no.
     */
    public void listadoLibros() {
        for (int i = 0; i < numLibros; i++) {
            System.out.println(libros[i].toString() + "\n");
        }
    }

    /**
     * Lista todos los libros de un usuario.
     */
    public void listadoLibrosUsuario() {
        encontrarUsuario();
        if (encontrado) {
            if (usuarios[posicionUsuario].getNumlibrosprestados() == 0) {
                System.out.println("Ese usuario no tiene ningún libro prestado actualmente");
            } else {
                usuarios[posicionUsuario].librosPrestadosUsuario();
            }
        }
    }

    /**
     * Muestra una lista de todos los usuarios enumerados.
     */
    public void listadoUsuarios() {
        for (int i = 0; i < numUsuarios; i++) {

            System.out.print("Usuario " + i + ".- ");
            System.out.println(usuarios[i].toString());
        }
    }

    /**
     * Busca a un usuario con un nombre introducido por teclado y cambia la
     * variable global "encontrado" a true o false si lo ha encontrado o no
     */
    public void encontrarUsuario() {
        encontrado = true;
        System.out.print("Nombre del usuario: ");
        String nombre = sc.next();

        Usuario temp = new Usuario(nombre);
        posicionUsuario = -1;
        for (int i = 0; i < numUsuarios; i++) {
            if (temp.equals(usuarios[i])) {
                posicionUsuario = i;
                i = numUsuarios;
            }
        }
        if (posicionUsuario == -1) {
            System.out.println("No se ha encontrado ese usuario");
            encontrado = false;
        }

    }

}
