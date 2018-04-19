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
public class MisionDeCombate extends Mision {

    private int potenciaMinima;

    public MisionDeCombate(int potenciaMinima, LocalDate fecha, String lugar, int expGanada, String nombre) {
        super(fecha, lugar, expGanada, nombre);
        this.potenciaMinima = potenciaMinima;
    }
    
    public MisionDeCombate(){
        
    }

    public void crearMisionDeCombate(ArrayList<Recurso> recursos, Scanner sc) {
        String uso;
        boolean estresado;
        int fuerzaLetal = 0;
        int numRecurso = 0;
        do {
            for (int i = 0; i < recursos.size(); i++) {
                estresado = false;
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
            System.out.println("Elige el recurso");
            numRecurso = sc.nextInt();
            sc.nextLine();
            System.out.println("¿Y cuál va a ser su uso?");
            uso = sc.next();
            fuerzaLetal += recursos.get(numRecurso).getPotenciaDeMuerte();
            addRecurso(recursos.get(numRecurso), uso);
            recursos.get(numRecurso).addMision(this);
        } while (numRecurso != -1);
        if (fuerzaLetal < potenciaMinima) {
            System.out.println("La misión ha fracasado porque no llegaba a la fuerza letal mínima");
            exito = false;
        }
    }

    public int getPotenciaMinima() {
        return potenciaMinima;
    }

    public boolean isExito() {
        return exito;
    }

    public void setExito(boolean exito) {
        this.exito = exito;
    }
    
}
