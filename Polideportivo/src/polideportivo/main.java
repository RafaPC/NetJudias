/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polideportivo;

import java.util.Scanner;

/**
 *
 * @author daw
 */
public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Polideportivo polideportivo = new Polideportivo();

        boolean salir = false;
        do {

            System.out.println("Elige la funcionalidad");
            System.out.println("1.- Dar de alta a un afiliado");
            System.out.println("2.- Matricular a un afiliado en un grupo de una determinada actividad (si hay plazas)");
            System.out.println("3.- Dar de baja afiliado");
            System.out.println("4.- Generar el recibo de pago de todos los afiliados");
            System.out.println("5.- Generar el dinero recaudado por cada actividad");
            int funcion = sc.nextInt();
            sc.nextLine();

            switch (funcion) {
                case 1:
                    polideportivo.darAltaAfiliado();
                    break;

                case 2:
                    polideportivo.matricular();
                    break;

                case 3:
                    polideportivo.darBajaAfiliado();
                    break;

                case 4:
                    polideportivo.recibo();
                    break;

                case 8:
                    salir = true;
                default:
                    System.out.println("hola");
            }
        } while (salir == false);
    }

}
