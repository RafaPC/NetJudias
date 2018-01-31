/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca;

import java.util.Scanner;

/**
 *
 * @author daw
 */
public class Biblioteca {

    public Usuario[] usuarios;

    private Libro[] libros;

    public int numUsuarios = 0;

    Scanner sc = new Scanner(System.in);

    public Biblioteca() {

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
        libros[12] = new Libro("40-3675-007-1", "Libro de Belén Esteban", "Algiuen que sí que sabe escribir", 2);

        usuarios = new Usuario[20];
        usuarios[0] = new Usuario("Kiko");
        usuarios[1] = new Usuario("Rafa");
        usuarios[2] = new Usuario("Jesucristo");
        usuarios[3] = new Usuario("Oski");

    }

    public void darAltaLibro() {
        System.out.println("Procede a rellenar los datos para dar de alta el libro");
        System.out.println("ISBN: ");
        String isbn = sc.next();
        System.out.println("Título de la obra: ");
        String titulo = sc.next();
        System.out.println("Autor de la obra: ");
        String autor = sc.next();
        System.out.println("Número de páginas: ");
        int numPaginas = sc.nextInt();

        libros[0] = new Libro(isbn, titulo, autor, numPaginas);
    }

    public void darAltaUsuario() {

        System.out.println("Nombre del usuario: ");
        String nombre = sc.next();
        
        Usuario temp = new Usuario(nombre);
        for (int i = 0; i < numUsuarios; i++) {
            if(temp.equals(usuarios[i])){
                System.out.println("Ya hay un usuario con ese nombre");
                System.out.println("En esta biblioteca no admitimos personas con el mismo nombre");
            }
        }
        usuarios[numUsuarios] = new Usuario(nombre);
        numUsuarios++;

    }

    public void darBajaUsuario() {
        System.out.println("Nombre del usuario: ");
        String nombre = sc.next();

        Usuario temp = new Usuario(nombre);
        for (int i = 0; i < numUsuarios; i++) {
            temp.equals(usuarios[i]);
        }

    }

    public void prestarLibro() {

    }

    public void devolverLibro() {

    }

    public int numLibrosPrestados() {
        int librosprestados = 0;

        return librosprestados;
    }

    public void listadoLibros() {

    }

    public void listadoRevistas() {

    }

    public void listadoUsuarios() {

    }

}
