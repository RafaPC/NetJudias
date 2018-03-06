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
        this.nombre = nombre;
    }

    public void addRecurso(Recurso recurso, String uso) {
        recursosMision.add(new RecursoMision(recurso, uso));
    }

    /*public void crearMision(ArrayList<Recurso> recursos, Scanner sc) {
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
    }*/
    public ArrayList<RecursoMision> getRecursosMision() {
        return recursosMision;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public boolean requisitoVehiculos() {
        boolean requisito = false;
        for (int i = 0; i < recursosMision.size() && !requisito; i++) {
            if (recursosMision.get(i).getRecurso() instanceof RecursoMaterialVehiculo) {
                requisito = true;
            }
        }
        return requisito;
    }

    public boolean requisitoPersonas() {
        boolean requisito = false;
        int numPersonas = 0;
        int capacidad = 0;
        for (int i = 0; i < recursosMision.size() && !requisito; i++) {
            Recurso temp = recursosMision.get(i).getRecurso();
            if (temp instanceof RecursoMaterialVehiculo) {
                capacidad += ((RecursoMaterialVehiculo) temp).getCapacidad();
            } else if (temp instanceof RecursoHumano) {
                numPersonas++;
            }
        }
        if (capacidad >= numPersonas) {
            requisito = true;

        } else {
            System.out.println("Tienes " + numPersonas + " personas y solo " + capacidad + " plazas totales de los vehículos");
            System.out.println("Tienes que coger vehículos hasta llegar a " + numPersonas + " plazas o más");
        }
        return requisito;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isExito() {
        return exito;
    }

    public void esExito() {
        this.exito = true;
        for (RecursoMision ressource : recursosMision) {
            if (ressource.getRecurso() instanceof RecursoHumano) {
                RecursoHumano temp = ((RecursoHumano) ressource.getRecurso());
                temp.sumarExp(this.expGanada);
                temp.sumarStress(this.expGanada / 2);
            }
        }
    }

    public void esFracaso() {
        this.exito = false;
        for (RecursoMision ressource : recursosMision) {
            if (ressource.getRecurso() instanceof RecursoHumano) {
                RecursoHumano temp = ((RecursoHumano) ressource.getRecurso());
                temp.sumarStress(this.expGanada);
            }
        }
    }

    @Override
    public String toString() {
        return "Mision - " + "Nombre: " + nombre + ", Fecha: " + fecha + ", Lugar: " + lugar + ", ExpGanada: " + expGanada + ", Exito: " + exito;
    }
    public void toStringRecursos(){
        for(RecursoMision resource : recursosMision){
            System.out.println("-----");
            System.out.println(resource.toString());
        }
    }
}
