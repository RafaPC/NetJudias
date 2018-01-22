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
public class Polideportivo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        //creo array de actividades
        Actividades[] actividades = new Actividades[11];

        //creo array de afiliados
        Afiliados[] afiliados = new Afiliados[35];

        //creo actividad con un horario y la meto en un array 
        actividades[0] = new Actividades("Aerobic", 35, 47.60f, new Horario(10, 11, "L, X, V"));

        actividades[1] = new Actividades("Aerobic", 35, 47.60f, new Horario(11, 12, "L, X, V"));

        actividades[2] = new Actividades("Aerobic", 35, 47.60f, new Horario(19, 20, "L, X, V"));

        actividades[3] = new Actividades("Aerobic", 35, 35.70f, new Horario(9, 10, "M, J"));

        actividades[4] = new Actividades("Aerobic", 35, 35.70f, new Horario(10, 11, "M, J"));

        actividades[5] = new Actividades("Aerobic", 35, 35.70f, new Horario(18, 19, "M, J"));

        actividades[6] = new Actividades("Artes marciales", 15, 45f, new Horario(19, 20, "L, X, V"));

        actividades[7] = new Actividades("Artes marciales", 15, 34f, new Horario(18, 19, "M, J"));

        actividades[8] = new Actividades("Artes marciales", 15, 34f, new Horario(19, 20, "M, J"));

        actividades[9] = new Actividades("Natación", 35, 47.60f, new Horario(18, 19, "L, X, V"));

        actividades[10] = new Actividades("Natación", 35, 35.70f, new Horario(17, 18, "M, J"));

        //System.out.println("Precio es " + actividades[0].getPrecio() + "Y hay " + actividades[0].getPlazas() + " plazas");
        System.out.println("Elige la funcionalidad");
        System.out.println("Dar de alta a un afiliado");
        System.out.println("Matricular a un afiliado en un grupo de una determinada actividad (si hay plazas)");
        System.out.println("Dar de baja afiliado");
        System.out.println("Generar el recibo de pago de todos los afiliados");
        System.out.println("Generar el dinero recaudado por cada actividad");
        int numAfil = 0;

        do {
            int funcion = sc.nextInt();
            sc.nextLine();

            switch (funcion) {
                case 1:
                    afiliados[numAfil] = darAltaAfil(sc);
                    numAfil++;
                    break;
                case 2:
                    darBajaAfil(afiliados, sc);
                    break;

            }
        } while (numAfil != -1);
    }

    public static Afiliados darAltaAfil(Scanner sc) {

        System.out.println("Dame el nombre");
        String nombre = sc.next();

        System.out.println("Ahora el apellido");
        String apellido = sc.next();

        return new Afiliados(nombre, apellido);
    }

    public static void darBajaAfil(Afiliados[] afiliados, Scanner sc) {

        System.out.println("¿Qué alumno quieres borrar?");
        System.out.print("Nombre: ");
        String nombre = sc.next();

        System.out.print("Apellido: ");
        String apellido = sc.next();

        int posicion = encontrarAfil(afiliados, nombre, apellido);

        //encontrar Alumno
        //Dar de baja de las actividades, aumentar plaza
        //reordenar array para no dejar huecos
    }

    public static int encontrarAfil(Afiliados[] afiliados, String nombre, String apellido) {
        int posicion = 0;
        for (int i = 0; i < afiliados.length; i++) {
            if ((afiliados[i].getNombre().equals(nombre)) && (afiliados[i].getApellidos().equals(apellido))) {

                posicion = i;

                i = afiliados.length;

            }

        }

        return posicion;
    }

    public static void matricularAlumno(Scanner sc, Afiliados[] afiliados, Actividades[] actividades) {
        //pedir alumno
        System.out.println("Nombre del alumno: ");
        String nombre = sc.next();
        //encontrarle en el array
        //encontrar actividad
        //quitar plaza
        // aumentar el dinero del alumno
    }

}
