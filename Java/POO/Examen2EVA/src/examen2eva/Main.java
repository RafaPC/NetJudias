/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen2eva;

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
        Scanner sc = new Scanner(System.in);
        Examen2EVA cosa = new Examen2EVA();
        // TODO code application logic here
        int opcion;
        do {
            System.out.println("1.- Crear Proyecto"
                    + "\n2.- Listado de proyectos"
                    + "\n999.- Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    cosa.crearProyecto();
                    break;
                case 2:
                    cosa.listadoProyecto();
                    break;
            }

        } while (opcion != 999);
    }
}
