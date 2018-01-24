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
//        System.out.println("Elige la funcionalidad");
//        System.out.println("1.- Dar de alta a un afiliado");
//        System.out.println("2.- Matricular a un afiliado en un grupo de una determinada actividad (si hay plazas)");
//        System.out.println("3.- Dar de baja afiliado");
//        System.out.println("4.- Generar el recibo de pago de todos los afiliados");
//        System.out.println("5.- Generar el dinero recaudado por cada actividad");
        int numAfil = 0;

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
                    afiliados[numAfil] = darAltaAfiliado(sc, numAfil);
                    numAfil++;
                    break;

                case 2:
                    matricular(sc, afiliados, actividades, numAfil);
                    break;

                case 3:
                    darBajaAfiliado(afiliados, sc, numAfil);
                    break;

                case 4:
                    recibo(afiliados, actividades, numAfil);
                    break;

                default:
                    System.out.println("hola");
            }
        } while (numAfil != -1);
    }

    public static Afiliados darAltaAfiliado(Scanner sc, int numAfil) {

        if (numAfil == 35) {
            System.out.println("No puedes dar de alta otro usuario");
            System.out.println("Siempre puedes dar de baja un usuario");
            numAfil--;
            return null;
        } else {

            System.out.println("Dame el nombre");
            String nombre = sc.next();

            System.out.println("Ahora el apellido");
            String apellido = sc.next();

            return new Afiliados(nombre, apellido);
        }
    }

    public static void darBajaAfiliado(Afiliados[] afiliados, Scanner sc, int numAfil) {

        if (numAfil == 0) {
            System.out.println("No puedes dar de baja un usuario si no hay ninguno dado de alta");
        } else {
            System.out.println("¿Qué alumno quieres borrar?");

            System.out.print("Nombre: ");
            String nombre = sc.next();

            System.out.print("Apellido: ");
            String apellido = sc.next();

            //encontrar Alumno
            int posicion = encontrarAfil(afiliados, nombre, apellido, numAfil);

            //Dar de baja de las actividades, aumentar plaza
            //reordenar array para no dejar huecos
            afiliados[posicion] = afiliados[numAfil - 1];
            afiliados[numAfil - 1] = null;
            numAfil--;
        }

    }

    public static int encontrarAfil(Afiliados[] afiliados, String nombre, String apellido, int numAfil) {
        int posicion = -1;

        Afiliados temp = new Afiliados(nombre, apellido);
        for (int i = 0; i < numAfil && posicion == -1; i++) {

            temp.equals(afiliados[i]);

            //if ((afiliados[i].getNombre().equals(nombre)) && (afiliados[i].getApellidos().equals(apellido))) {
            posicion = i;

            i = afiliados.length;

        }
        if (posicion == -1) {
            System.out.println("No se ha encontrado ningún afiliado con ese nombre y apellido");
        }

        return posicion;
    }

    public static void matricular(Scanner sc, Afiliados[] afiliados, Actividades[] actividades, int numAfil) {

        if (numAfil == 0) {
            System.out.println("No puedes dar de baja un usuario si no hay ninguno dado de alta");
        } else {
            System.out.println("A continuación tendrás que escribir los datos del alumno al que quieres matricular");
            //pedir alumno
            System.out.print("Nombre: ");
            String nombre = sc.next();

            System.out.print("Apellido: ");
            String apellido = sc.next();

            int numafiliado = encontrarAfil(afiliados, nombre, apellido, numAfil);

            if (numafiliado != -1) {
                System.out.println("En que actividad quieres matricularlo");
                for (int i = 0; i < 11; i++) {
                    System.out.print(i + ".- ");
                    System.out.println(actividades[i].toString() + "\n");

                    /*System.out.println(
                    "\n   Plazas: " + actividades[i].getPlazas()
                    + "\n   Precio: " + actividades[i].getPrecio()
                    + "\n   Días: " + actividades[i].getHorario().getDias()
                    + "\n   Horas: " + actividades[i].getHorario().getStarthour()
                    + ":00 - " + actividades[i].getHorario().getEndhour()
                    + ":00");*/
                }
                //encontrar actividad
                int numactividad = sc.nextInt();

                //quitar plaza
                actividades[numactividad].setPlazas(actividades[numactividad].getPlazas() - 1);

                // aumentar el dinero del alumno
                afiliados[numafiliado].setPago(afiliados[numafiliado].getPago() + actividades[numactividad].getPrecio());
            }
        }
    }

    public static void recibo(Afiliados[] afiliados, Actividades[] actividades, int nAfil) {

        double recibo = 0;

        for (int i = 0; i < nAfil; i++) {

            recibo += afiliados[i].getPago();// aumentar el dinero del alumno

        }

        System.out.println("El recibo total es " + recibo);

    }

}
