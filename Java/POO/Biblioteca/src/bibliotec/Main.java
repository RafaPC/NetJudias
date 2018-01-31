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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Biblioteca biblioteca = new Biblioteca();
        Scanner sc = new Scanner(System.in);
        int numUsuarios = 4;
        int numLibros = 13;
        boolean salir = false;
        do {

            System.out.println("\nElige la funcionalidad");
            System.out.println("1.- Dar de alta libros");
            System.out.println("2.- Dar de alta usuarios");
            System.out.println("3.- Dar de baja usuarios");
            System.out.println("4.- Prestar libro a usuarios");
            System.out.println("5.- Devolver libros de usuarios");
            System.out.println("6.- Listado de libros");
            System.out.println("7.- Listado de usuarios");
            System.out.println("8.- Listado de libros de un usuario");
            System.out.println("9.- Salir");
            int funcion = sc.nextInt();
            sc.nextLine();

            switch (funcion) {
                case 1:
                    biblioteca.darAltaLibro();
                    break;

                case 2:
                    biblioteca.darAltaUsuario();
                    break;

                case 3:
                    biblioteca.darBajaUsuario();
                    break;

                case 4:
                    biblioteca.prestarLibro();
                    break;

                case 5:
                    biblioteca.devolverLibro();
                    break;

                case 6:
                    biblioteca.listadoLibros();
                    break;

                case 7:
                    biblioteca.listadoUsuarios();
                    break;

                case 8:
                    biblioteca.listadoLibrosUsuario();
                    break;
                case 9:
                    salir = true;
                default:
                    System.out.println("Te has inventado el número, anda, prueba otra vez");
            }
        } while (salir == false);

    }

}
