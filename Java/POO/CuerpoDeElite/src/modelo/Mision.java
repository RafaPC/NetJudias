/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author daw
 */
public class Mision {

    private String nombre;
    private LocalDate fecha;
    private String lugar;
    private int expGanada;
    protected boolean exito;
    private ArrayList<RecursoMision> recursosMision = new ArrayList<>();

    public Mision(LocalDate fecha, String lugar, int expGanada, String nombre) {
        this.fecha = fecha;
        this.lugar = lugar;
        this.expGanada = expGanada;
        this.exito = false;
        this.nombre = nombre;
    }

    protected void addRecurso(Recurso recurso) {
        recursosMision.add(new RecursoMision(recurso));
    }

    public void crearMision(ArrayList<Recurso> recursos, Scanner sc) {
        String uso;
        boolean estresado;
        int fuerzaLetal = 0;
        int numRecurso = 0;
        do {

            for (int i = 0; i < recursos.size(); i++) {
                estresado = false;
                if (i > 0 && recursosMision.contains(recursos.get(i))) {
                } else {
                    if (recursos.get(i) instanceof RecursoHumano) {
                        if (((RecursoHumano) recursos.get(i)).getStress() > 20) {
                            estresado = true;
                        }
                    }
                    if (!estresado) {
                        if (recursos.get(i) instanceof RecursoMaterialVehiculo) {
                            System.out.println(i + ".- " + ((RecursoMaterialVehiculo) recursos.get(i)).toString());
                        } else if (recursos.get(i) instanceof RecursoMaterial) {
                            System.out.println(i + ".- " + ((RecursoMaterial) recursos.get(i)).toString());
                        } else if (recursos.get(i) instanceof RecursoHumano) {
                            System.out.println(i + ".- " + ((RecursoHumano) recursos.get(i)).toString());
                        }
                    }
                }
            }
            System.out.println("Elige el recurso");
            numRecurso = sc.nextInt();
            sc.nextLine();
            addRecurso(recursos.get(numRecurso));
            System.out.println("¿Y cuál va a ser su uso?");
            uso = sc.next();
            
            fuerzaLetal += recursos.get(numRecurso).getPotenciaDeMuerte();
            recursos.get(numRecurso).addMision(this);
        } while (numRecurso != -1);
    }
}
