/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuerpodeelite;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.Recurso;
import modelo.RecursoHumano;

/**
 *
 * @author daw
 */
public class CuerpoDeElite {

    public Scanner sc = new Scanner(System.in);
    private ArrayList<Recurso> recursos = new ArrayList<>();

    public CuerpoDeElite() {
    }

    public void crearMision() {
        int opcion = 0;
        int expGanada;
        String lugar;
        System.out.println("Lugar de la misión: ");
        lugar = sc.next();
        System.out.println("Experiencia ganada: ");
        expGanada = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Tipo de misión"
                + "\n1.-De reconocimiento"
                + "\n2.-De combate");
        opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1:
                crearMision();
                break;
            case 2:
                break;
        }
    }

    private void crearMisionDeCombate() {
        boolean estresado;
        int fuerzaLetal = 0;
        int numRecurso = 0;
        do {
            for (Recurso recurso : recursos) {
                estresado = false;
                if (recurso instanceof RecursoHumano) {
                    if (((RecursoHumano) recurso).getStress() > 20) {
                        estresado = true;
                    }
                }
                if (!estresado) {
                    recurso.toString();
                }
            }
            System.out.println("Elige el recurso");
            numRecurso = sc.nextInt();
            sc.nextLine();
            
            fuerzaLetal += recursos.get(numRecurso).getPotenciaDeMuerte();
            
        } while (numRecurso != -1);

    }

    private void crearMisionDeReconocimiento() {

    }
}
