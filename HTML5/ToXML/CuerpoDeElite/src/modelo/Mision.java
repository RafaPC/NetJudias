/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlID;

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
    private String id;

    @XmlID
    public String getId() {
        return Integer.toString(System.identityHashCode(this));
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setExito(boolean exito) {
        this.exito = exito;
    }

    public Mision() {

    }

    public Mision(LocalDate fecha, String lugar, int expGanada, String nombre) {
        this.fecha = fecha;
        this.lugar = lugar;
        this.expGanada = expGanada;
        this.nombre = nombre;
    }

    public void addRecurso(Recurso recurso, String uso) {
        recursosMision.add(new RecursoMision(recurso, uso));
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getExpGanada() {
        return expGanada;
    }

    public void setExpGanada(int expGanada) {
        this.expGanada = expGanada;
    }

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

    public void toStringRecursos() {
        for (RecursoMision resource : recursosMision) {
            System.out.println("-----");
            System.out.println(resource.toString());
        }
    }
}
