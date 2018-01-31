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
    private Actividades[] actividades;
    private Afiliados[] afiliados;
    private int numAfil = 0;
    private int posicion = -1;
    Scanner sc = new Scanner(System.in);

    public Polideportivo() {
        //creo array de actividades
        actividades = new Actividades[11];

        //creo array de afiliados
        afiliados = new Afiliados[35];

        //creo actividad con un horario y la meto en un array 
        actividades[0] = new Actividades("Aerobic", 35, 35, 47.60f, new Horario(10, 11, "L, X, V"));

        actividades[1] = new Actividades("Aerobic", 35, 35, 47.60f, new Horario(11, 12, "L, X, V"));

        actividades[2] = new Actividades("Aerobic", 35, 35, 47.60f, new Horario(19, 20, "L, X, V"));

        actividades[3] = new Actividades("Aerobic", 35, 35, 35.70f, new Horario(9, 10, "M, J"));

        actividades[4] = new Actividades("Aerobic", 35, 35, 35.70f, new Horario(10, 11, "M, J"));

        actividades[5] = new Actividades("Aerobic", 35, 35, 35.70f, new Horario(18, 19, "M, J"));

        actividades[6] = new Actividades("Artes marciales", 15, 15, 45f, new Horario(19, 20, "L, X, V"));

        actividades[7] = new Actividades("Artes marciales", 15, 15, 34f, new Horario(18, 19, "M, J"));

        actividades[8] = new Actividades("Artes marciales", 15, 15, 34f, new Horario(19, 20, "M, J"));

        actividades[9] = new Actividades("Natación", 35, 35, 47.60f, new Horario(18, 19, "L, X, V"));

        actividades[10] = new Actividades("Natación", 35, 35, 35.70f, new Horario(17, 18, "M, J"));

    }

    public void darAltaAfiliado() {

        if (numAfil == 35) {
            System.out.println("No puedes dar de alta otro usuario");
            System.out.println("Si quieres introducir uno nuevo tendrás que dar de baja otro");
        } else {
            String nombre, apellido;
            boolean repetido;

            do {
                repetido = false;
                System.out.println("Dame el nombre");
                nombre = sc.next();

                System.out.println("Ahora el apellido");
                apellido = sc.next();

                Afiliados temp = new Afiliados(nombre, apellido);

                //crea un afiliado con el nombre y apellido introducidos y lo compara con los demas afiliados creados para ver si ya hay alguno con el mismo nombre y apellido
                for (int i = 0; i < numAfil; i++) {

                    if (temp.equals(afiliados[i])) {

                        repetido = true;

                        System.out.println("Ya existe un afiliado con ese nombre y apellido");
                    }

                }

            } while (repetido);

            afiliados[numAfil] = new Afiliados(nombre, apellido);
            numAfil++;
        }
    }

    public void darBajaAfiliado() {

        //Si "numAfil" no ha subido de cero es porque no se ha dado de alta ningún afiliado
        if (numAfil == 0) {
            System.out.println("No puedes dar de baja un usuario si no hay ninguno dado de alta");
        } else {
            System.out.println("¿Qué alumno quieres borrar?");
            //encontrar Alumno
            encontrarAfil();

            //Dar de baja de las actividades, aumentar plaza
            for (int i = 0; i < 11; i++) {
                actividades[i].sacarAfil(afiliados[posicion]);
            }

            //reordenar array para no dejar huecos
            afiliados[posicion] = afiliados[numAfil - 1];
            afiliados[numAfil - 1] = null;
            numAfil--;

        }

    }

    public void encontrarAfil() {

        do {
            posicion = -1;

            System.out.print("Nombre: ");
            String nombre = sc.next();

            System.out.print("Apellido: ");
            String apellido = sc.next();

            Afiliados temp = new Afiliados(nombre, apellido);
            //crea un afiliado y lo compara con los demas, he tenido que cambiar el "equals" para que no comparase el pago
            for (int i = 0; i < numAfil && posicion == -1; i++) {

                if (temp.equals(afiliados[i])) {

                    posicion = i;

                }

            }
            if (posicion == -1) {
                System.out.println("No se ha encontrado ningún afiliado con ese nombre y apellido");
            }

        } while (posicion == -1);

    }

    public void matricular() {

        if (numAfil == 0) {
            System.out.println("No puedes matricular un usuario si no hay ninguno dado de alta");
        } else {
            System.out.println("A continuación tendrás que escribir los datos del alumno al que quieres matricular");

            //pedir alumno
            encontrarAfil();

            int numactividad;
            //System.out.println("En que actividad quieres matricularlo");
            for (int i = 0; i < 11; i++) {
                System.out.print(i + ".- ");
                System.out.println(actividades[i].toString() + "\n");
            }
            do {
                System.out.println("En que actividad quieres matricularlo");
                //encontrar actividad
                numactividad = sc.nextInt();
                sc.nextLine();
                if (numactividad < 0 || numactividad > 10) {
                    System.out.println("Has puesto el número de una actividad que no existe");
                }
            } while (numactividad < 0 || numactividad > 10);

            actividades[numactividad].meterAfil(afiliados[posicion]);

            afiliados[posicion].setPago(afiliados[posicion].getPago() + actividades[numactividad].getPrecio());
        }
    }

    public void recibo1Afiliado() {

        double recibo = 0;

        encontrarAfil();

        recibo += afiliados[posicion].getPago();

        System.out.println("El recibo total es " + recibo);

    }

    public void reciboTodosAfiliados() {

        for (int i = 0; i < numAfil; i++) {

            System.out.println(afiliados[i].toString());
        }

    }

    public void reciboTodasActividades() {

        for (int i = 0; i < 11; i++) {

            //El precio de cada actividad es el número de gente apuntada a ella
            int nafil = actividades[i].getPlazas() - actividades[i].getPlazaslibres();

            //por el precio de la actividad
            float recibo = nafil * actividades[i].getPrecio();

            System.out.println(i + ".- " + actividades[i].getTipo() + "\n" + actividades[i].getHorario() + "\nDinero recaudado: " + recibo + "\n");
        }

    }

    public void recibo1Actividad() {

        for (int i = 0; i < 11; i++) {
            System.out.print(i + ".- ");
            System.out.println(actividades[i].toString() + "\n");
        }

        int numactividad;
        do {
            System.out.println("¿De qué actividad quieres sacar el recibo?");
            numactividad = sc.nextInt();
            sc.nextLine();
            if (numactividad < 0 || numactividad > 10) {
                System.out.println("Has puesto el número de una actividad que no existe");
            }
        } while (numactividad < 0 || numactividad > 10);

        //El precio total de la actividad es el numero de gente apuntada a ella
        int nafil = actividades[numactividad].getPlazas() - actividades[numactividad].getPlazaslibres();

        //por el precio de la actividad
        float recibo = nafil * actividades[numactividad].getPrecio();

        System.out.println("La actividad:\n" + actividades[numactividad].toString() + "\nHa recaudado " + recibo + " euros");
    }

}
