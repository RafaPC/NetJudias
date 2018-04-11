package fuerzasEspeciales.modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Mision {

    protected LocalDate fechaMision;
    protected String lugar, nombre;
    protected int nivelExperienciaGanar;
    protected boolean exito;
    protected ArrayList<RecursoMilitar> recursos = new ArrayList<>();

    public Mision(){
        
    }
    public Mision(LocalDate fechaMision, String lugar, String nombre, int nivelExperienciaGanar) {
        this.fechaMision = fechaMision;
        this.lugar = lugar;
        this.nombre = nombre;
        this.nivelExperienciaGanar = nivelExperienciaGanar;
        this.exito = false;
    }

    public LocalDate getFechaMision() {
        return fechaMision;
    }

    public void setFechaMision(LocalDate fechaMision) {
        this.fechaMision = fechaMision;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivelExperienciaGanar() {
        return nivelExperienciaGanar;
    }

    public void setNivelExperienciaGanar(int nivelExperienciaGanar) {
        this.nivelExperienciaGanar = nivelExperienciaGanar;
    }

    public boolean isExito() {
        return exito;
    }

    public void setExito(boolean exito) {
        this.exito = exito;
    }

    //añadir recursos
    public void addRecurso(RecursoMilitar recursoUsar,String uso) {
        RecursoUso recursoUso=new RecursoUso(recursoUsar, uso);
       // recursos.add(recursoUso);
    }

    public void addUso(int elegir, RecursoUso uso) {
        recursos.get(elegir).setUso(uso);
        
    }

    public boolean recursoExisteMision(RecursoMilitar a) {
        boolean existe = false;
        for (int i = 0; i < recursos.size(); i++) {
            if (recursos.get(i).equals(a)) {
                existe = true;
            }
        }
        return existe;

    }

    public boolean nivelEstres() {
        Humano humTemp;
        boolean supera = false;
        for (int i = 0; i < recursos.size(); i++) {
            if (recursos.get(i) instanceof Humano) {
                humTemp = (Humano) recursos.get(i);
                //comprobar estres
                if (humTemp.getNvlEstres() > 20) {
                    supera = true;
                    System.out.println("El nivel de estres del recurso " + recursos.get(i).getNombre() + " es mayor de 20, no se puede añadir a la mision, por lo tanto la mision no se puede realizar.");
                }
            }
        }
        return supera;
    }

    public boolean vehiculoMinimo() {
        boolean existe = false;

        for (int i = 0; i < recursos.size(); i++) {
            if (recursos.get(i) instanceof Vehiculo) {
                existe = true;
            }
        }

        return existe;
    }

    public boolean personasPorVehiculo() {
        int numPersonas = 0, capacidad = 0;
        Vehiculo temp;

        boolean caben = false;
        //hallar personas
        for (int i = 0; i < recursos.size(); i++) {
            if (recursos.get(i) instanceof Humano) {
                numPersonas++;
            }
        }
        //hallar capacidad
        for (int i = 0; i < recursos.size(); i++) {
            if (recursos.get(i) instanceof Vehiculo) {
                temp = (Vehiculo) recursos.get(i);

                capacidad += temp.getCapacidad();
            }
        }
        if (capacidad >= numPersonas) {
            caben = true;
        }

        return caben;
    }

    public String leerRecursosMision() {
        String nombre = null;
        for (int i = 0; i < recursos.size(); i++) {
            nombre = recursos.get(i).getNombre();
            System.out.println("recurso" + nombre);
        }
        return nombre;
    }


    public void addExpHumano(int exp) {
        Humano temp = null;
        exp = exp;
        for (int i = 0; i < recursos.size(); i++) {
            if (recursos.get(i) instanceof Humano) {
                temp = (Humano) recursos.get(i);
                temp.addExp(exp);
            }

        }
        System.out.println("nvl exp fin" + temp.getNvlExperiencia());
    }

    public void addEstresHumano(int estres) {
        Humano temp = null;
        estres = estres / 2;
        for (int i = 0; i < recursos.size(); i++) {
            if (recursos.get(i) instanceof Humano) {
                temp = (Humano) recursos.get(i);
                temp.addEstres(estres);
            }

        }
        System.out.println("nvlestres fin" + temp.getNvlEstres());
    }

    public void addMision(Mision temp) {
        RecursoMilitar recursoTemp;
        for (int i = 0; i < recursos.size(); i++) {
            recursoTemp = recursos.get(i);
            recursoTemp.addMision(temp);
        }

    }

    public boolean fuerzaMinima(Mision temp, int fuerzaMinima) {

        boolean sumaFuerza = false;
        int sumaFuerzaRecursos=0;

        for (int i = 0; i < recursos.size(); i++) {
            sumaFuerzaRecursos+=recursos.get(i).getPotenciaMuerte();
        }
        if(sumaFuerzaRecursos>fuerzaMinima){
            sumaFuerza=true;
        }
        return sumaFuerza;
    }

    @Override
    public String toString() {
        return "Mision{" + "fechaMision=" + fechaMision + ", lugar=" + lugar + ", nombre=" + nombre + ", nivelExperienciaGanar=" + nivelExperienciaGanar + ", exito=" + exito + '}';
    }

}
