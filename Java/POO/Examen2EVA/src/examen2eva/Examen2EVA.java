/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen2eva;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import modelo.Analista;
import modelo.Freelance;
import modelo.Proyecto;
import modelo.ProyectoDesarrollo;
import modelo.Puesto;

/**
 *
 * @author daw
 */
public class Examen2EVA {

    Scanner sc = new Scanner(System.in);
    private Map<String, Proyecto> proyectos = new LinkedHashMap<>();
    private ArrayList<Freelance> freelancers = new ArrayList<>();

    public Examen2EVA() {

        freelancers.add(new Freelance("JHKBGUO9", "Happy", 40));
        freelancers.add(new Freelance("KEGAJHV6", "HappySon", 30));
        freelancers.add(new Analista(40, 60, "KJGVYI8", "HappyAnalisto", 33));
        freelancers.add(new Analista(50, 90, "PMEUYV6", "HappyMum", 40));
        freelancers.get(0).addExperiencia("JAV", 5);
        freelancers.get(0).addExperiencia("SQL", 4);
        freelancers.get(0).addExperiencia("PHP", 8);
        freelancers.get(1).addExperiencia("JAV", 9);
        freelancers.get(1).addExperiencia("C#", 7);
        freelancers.get(2).addExperiencia("C++", 7);
        freelancers.get(2).addExperiencia("C", 6);
        freelancers.get(3).addExperiencia("PYTHON", 8);
        freelancers.get(3).addExperiencia("C++", 8);
        proyectos.put("Página Web de la Comunidad de Madrid", new Proyecto("Página Web de la Comunidad de Madrid", "Getafe"));
        proyectos.get("Página Web de la Comunidad de Madrid").addPuesto("Programador de BBDD", 70, 43);
        proyectos.get("Página Web de la Comunidad de Madrid").addPuesto("Programador FrontEnd", 80, 50);
        proyectos.get("Página Web de la Comunidad de Madrid").addPuesto("Diseñador", 55, 38);
        proyectos.put("EL MARCA", new ProyectoDesarrollo("PHP", "EL MARCA", "Oficinas Centrales Intergalácticas de EL MARCA"));
        proyectos.get("EL MARCA").addPuesto("Programador BackEnd", 8, 43);
        proyectos.get("EL MARCA").addPuesto("Programador FrontEnd", 90, 50);
        proyectos.get("EL MARCA").addPuesto("Diseñador", 55, 38);
        proyectos.get("EL MARCA").addPuesto("Probador de página (Oscar Novillos)", 1, 300);

    }

    public void crearProyecto() {

        String nombre, lugar;
        System.out.print("Nombre del proyecto: ");
        nombre = sc.next();
        System.out.print("Lugar del proyecto: ");
        lugar = sc.next();
        System.out.println("Proyecto:"
                + "\n1.- Normal (análisis)"
                + "\n2.- De desarrollo");
        int opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1:
                proyectos.put(nombre, new Proyecto(nombre, lugar));

                break;
            case 2:
                System.out.print("Cuál va a ser el lenguaje utilizado: ");
                String leng = sc.next();
                proyectos.put(nombre, new ProyectoDesarrollo(leng, nombre, lugar));
                break;
        }
        crearPuestos(nombre);
    }

    private void crearPuestos(String nombre) {
        int expMin, salHora;
        int opcion = 1;
        String nombrePuesto;
        System.out.println("¿Qué puestos va a haber en tu proyecto?");
        do {
            System.out.print("Nombre del puesto: ");
            nombrePuesto = sc.next();
            System.out.print("Experiencia mínima: ");
            expMin = sc.nextInt();
            sc.nextLine();
            System.out.print("Salario/hora: ");
            salHora = sc.nextInt();
            sc.nextLine();
            proyectos.get(nombre).addPuesto(nombrePuesto, expMin, salHora);
            System.out.println("Puesto añadido succesfullymente");
            System.out.println("¿Quierés añadir más?"
                    + "\n1.- Sí"
                    + "\n2.- No");
            opcion = sc.nextInt();
            sc.nextLine();
        } while (opcion == 1);
        System.out.println("El proyecto " + proyectos.get(nombre).getNombre() + " tiene " + proyectos.get(nombre).getPuestos().size() + " puestos");
        llenarPuestos(nombre);
    }

    private void llenarPuestos(String nombre) {

        /*for (int i = 0; i < proyectos.size(); i++) {
            System.out.println(proyectos.get(i).toString());
        }
        int numProyecto = sc.nextInt();
        sc.nextLine();*/
        boolean terminado = false;
        int numPuesto, numFreelancer;
        do {
            int ocupados = 0;
            for (int i = 0; i < proyectos.get(nombre).getPuestos().size(); i++) {

                if (proyectos.get(nombre).getPuestos().get(i).getFreelancer() == null) {
                    System.out.println(i + ".- " + proyectos.get(nombre).getPuestos().get(i).toString());
                } else {
                    ocupados++;
                }
            }
            if (ocupados == proyectos.get(nombre).getPuestos().size()) {
                terminado = true;
            }
            System.out.println("Estos son los puestos libres");
            System.out.print("Elige uno: ");
            numPuesto = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < freelancers.size(); i++) {
                boolean encontrado = false;
                for (int j = 0; j < proyectos.get(nombre).getPuestos().size() && !encontrado; j++) {
                    if (freelancers.get(i).equals(proyectos.get(nombre).getPuestos().get(j).getFreelancer())) {
                        encontrado = true;
                    }
                }
                if (!encontrado) {
                    System.out.println(i + ".- " + freelancers.get(i).toString());
                }
            }
            System.out.println("Estos son todos los freelancers");
            System.out.println("Elige uno: ");
            numFreelancer = sc.nextInt();
            sc.nextLine();
            boolean apto = false;
            //Si el proyecto es de desarrollo y el freelancer analista se tiene en cuenta la experiencia del analista en el lenguaje determinado por el proyecto
            if (proyectos.get(nombre) instanceof ProyectoDesarrollo && freelancers.get(numFreelancer) instanceof Analista) {
                apto = ((Analista) freelancers.get(numFreelancer)).tieneEXP(proyectos.get(nombre).getPuestos().get(numPuesto).getExpMIn(), ((ProyectoDesarrollo) proyectos.get(nombre)).getLenguaje());
                if (!apto) {
                    System.out.println("Ese analista no puede cubrir ese puesto por falta de experiencia en el lenguaje requerido por el proyecto");
                }
            } else {
                apto = true;
            }
            boolean dinero = false;
            //Proyecto normal (analisis) y freelancer analista
            //Se compara el salario del puesto del proyecto con el salario min de analista del freelancer
            if (!(proyectos.get(nombre) instanceof ProyectoDesarrollo) && freelancers.get(numFreelancer) instanceof Analista) {
                if (proyectos.get(nombre).getPuestos().get(numPuesto).getSalHora() >= ((Analista) freelancers.get(numFreelancer)).getPrecioHoraAnalista()) {
                    dinero = true;
                }
                //Si el proyecto es de desarrollo se mira el precio normal
            } else {
                if (proyectos.get(nombre).getPuestos().get(numPuesto).getSalHora() >= freelancers.get(numFreelancer).getPrecioHora()) {
                    dinero = true;
                }
            }
            if (apto && dinero) {
                proyectos.get(nombre).getPuestos().get(numPuesto).addFreelance(freelancers.get(numFreelancer));
                terminado = true;
                terminado = comprobarTerminado(nombre);
            }else{
                System.out.println("No se ha podido añadir ese freelancer por alguna razón que debería de saber pero que desconozco");
                System.out.println(dinero);
                System.out.println(apto);
            }
        } while (!terminado);
        System.out.println("Ya has completado todos los puestos");
    }

    private boolean comprobarTerminado(String nombre) {
        boolean terminado = true;

        for (Puesto pestodiquesto : proyectos.get(nombre).getPuestos()) {
            if (pestodiquesto.getFreelancer() == null) {
                terminado = false;
            }
        }
        return terminado;
    }

    public void listadoProyecto() {
        int dinero;
        for (String key : proyectos.keySet()) {
            dinero = 0;
            for (int i = 0; i < proyectos.get(key).getPuestos().size(); i++) {
                dinero += proyectos.get(key).getPuestos().get(i).getSalHora();
            }
            System.out.println(proyectos.get(key).toString());
            System.out.println("Este proyecto cuesta " + dinero + " por hora");
        }
    }

}
