/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuerpodeelite;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import modelo.Mision;
import modelo.MisionDeCombate;
import modelo.Recurso;
import modelo.RecursoHumano;
import modelo.RecursoMaterial;
import modelo.RecursoMaterialVehiculo;

/**
 *
 * @author daw
 */
public class CuerpoDeElite {

    public Scanner sc = new Scanner(System.in);
    private ArrayList<Recurso> recursos = new ArrayList<>();
    private Map<String, Mision> misiones = new LinkedHashMap<>();

    public CuerpoDeElite() {
        recursos.add(new RecursoMaterialVehiculo(8, 35, 300, 20, "Furgón"));
        recursos.add(new RecursoMaterialVehiculo(3, 90, 700, 95, "Tanque"));
        recursos.add(new RecursoMaterialVehiculo(6, 40, 2000, 0, "Lancha"));
        recursos.add(new RecursoMaterialVehiculo(6, 80, 10000, 40, "Helicóptero"));
        recursos.add(new RecursoMaterialVehiculo(2, 35, 400, 5, "Moto"));
        recursos.add(new RecursoMaterial(65, 2000, 10, "Jetpack"));
        recursos.add(new RecursoMaterial(20, 50, 0, "Granada PEM"));
        recursos.add(new RecursoMaterial(70, 10, 70, "C4"));
        recursos.add(new RecursoMaterial(10, 0, 0, "Visión nocturna"));
        recursos.add(new RecursoHumano(0, 57, 45, 0, 87, "Romero"));
        recursos.add(new RecursoHumano(0, 0, 97, 0, 53, "RoboPrimo"));
        recursos.add(new RecursoHumano(0, 25, 50, 7, 47, "Kiko"));
        recursos.add(new RecursoHumano(15, 0, 65, 700, 93, "Sgt. Ripley"));
    }

    public void crearMision() {
        int opcion = 0;
        int expGanada, dia, mes, año;
        String lugar, nombre;
        boolean repetido;
        do {
            repetido = false;
            System.out.print("Nombre de la misión: ");
            nombre = sc.next();
            for (String key : misiones.keySet()) {
                if (misiones.get(key).getNombre().equalsIgnoreCase(nombre)) {
                    System.out.println("Ya existe otra misión con el mismo nombre");
                    repetido = true;
                }
            }
        } while (repetido);
        System.out.print("Lugar de la misión: ");
        lugar = sc.next();
        System.out.print("Experiencia ganada: ");
        expGanada = sc.nextInt();
        sc.nextLine();
        System.out.println("Fecha de la misión ");
        System.out.print("Día: ");
        dia = sc.nextInt();
        sc.nextLine();
        System.out.print("Mes: ");
        mes = sc.nextInt();
        sc.nextLine();
        System.out.print("Año: ");
        año = sc.nextInt();
        sc.nextLine();
        LocalDate fecha = LocalDate.of(año, mes, dia);
        System.out.println("Tipo de misión"
                + "\n1.-De reconocimiento"
                + "\n2.-De combate");
        opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1:

                break;
            case 2:
                System.out.println("Cuál será la potencia mínima de combate");
                int poten = sc.nextInt();
                sc.nextLine();
                misiones.put(nombre, new MisionDeCombate(poten, fecha, lugar, expGanada, nombre));
                crearMision(fecha, nombre, expGanada);
                break;
            default:
                System.out.println("No existe esa opción");
                break;
        }
    }

    private void crearMision(LocalDate fecha, String nombre, int expGanada) {
        String uso;
        boolean estresado;
        boolean imprimir = true;
        int fuerzaLetal = 0;
        int numRecurso = 0;
        boolean requisitos = false;
        do {
            boolean cogido;
            do {
                cogido = false;
                for (int i = 0; i < recursos.size(); i++) {
                    estresado = false;
                    if (recursos.get(i) instanceof RecursoHumano) {
                        if (((RecursoHumano) recursos.get(i)).getStress() > 20) {
                            estresado = true;
                        }
                    }
                    if (!estresado && imprimir) {
                        if (recursos.get(i).getMisiones().contains(misiones.get(nombre))) {
                        } else {
                            if (recursos.get(i) instanceof RecursoMaterialVehiculo) {
                                System.out.println("------------------");
                                System.out.println("Vehículo");
                                System.out.println(i + ".- " + ((RecursoMaterialVehiculo) recursos.get(i)).toString());
                            } else if (recursos.get(i) instanceof RecursoMaterial) {
                                System.out.println("------------------");
                                System.out.println("Material");
                                System.out.println(i + ".- " + ((RecursoMaterial) recursos.get(i)).toString());
                            } else if (recursos.get(i) instanceof RecursoHumano) {
                                System.out.println("------------------");
                                System.out.println("Soldado");
                                System.out.println(i + ".- " + ((RecursoHumano) recursos.get(i)).toString());

                            }
                        }
                    }
                }
                System.out.println("Elige el recurso");
                System.out.println("Si quieres salir elige '-1'");
                numRecurso = sc.nextInt();
                sc.nextLine();

                if (numRecurso != -1) {
                    for (int i = 0; i < recursos.get(numRecurso).getMisiones().size() && !cogido; i++) {
                        if (recursos.get(numRecurso).getMisiones().get(i).getFecha().equals(misiones.get(nombre).getFecha())) {
                            System.out.println("Ese recurso ya está ocupado en otra misión el mismo día");
                            cogido = true;
                            imprimir = false;
                        }
                    }
                } else {
                    if (misiones.get(nombre).requisitoVehiculos()) {
                        if (misiones.get(nombre).requisitoPersonas()) {
                            requisitos = true;
                        } else {
                            imprimir = false;
                        }
                    } else {
                        System.out.println("Tienes que coger al menos un vehículo");
                        System.out.println("La misión sería un fracaso");
                        imprimir = false;
                    }
                    if (misiones.get(nombre) instanceof MisionDeCombate) {
                        int potencia = 0;
                        for (int i = 0; i < misiones.get(nombre).getRecursosMision().size(); i++) {
                            potencia += misiones.get(nombre).getRecursosMision().get(i).getRecurso().getPotenciaDeMuerte();
                        }
                        /*if  (potencia < ((MisionDeCombate) misiones.get(nombre)).getPotenciaMinima()) {
                            System.out.println("Los recursos no suman lo suficiente para llegar a la potencia mínima de muerte");
                            System.out.println("La misión sería un fracaso");
                            System.out.println("Coge más recursos para no pifiarla");
                            imprimir = false;
                            cogido = true;
                        }*/
                    }
                }
            } while (cogido);
            if (numRecurso != -1) {
                System.out.println("¿Y cuál va a ser su uso?");
                uso = sc.next();
                fuerzaLetal += recursos.get(numRecurso).getPotenciaDeMuerte();
                misiones.get(nombre).addRecurso(recursos.get(numRecurso), uso);
                recursos.get(numRecurso).addMision(misiones.get(nombre));
                imprimir = true;
            }

        } while (numRecurso != -1 || !requisitos);
        System.out.println("Misión creada succesfullymente");
        boolean fracaso = false;
        if (misiones.get(nombre) instanceof MisionDeCombate) {
            int potencia = 0;
            for (int i = 0; i < misiones.get(nombre).getRecursosMision().size(); i++) {
                potencia += misiones.get(nombre).getRecursosMision().get(i).getRecurso().getPotenciaDeMuerte();
            }
            if (((MisionDeCombate) misiones.get(nombre)).getPotenciaMinima() > potencia) {
                System.out.println("La misión ha sido un fracaso porque no ha llegado a la potencia de muerte suficiente");
                misiones.get(nombre).esFracaso();
                fracaso = true;
            }
        }
        if (!fracaso) {
            System.out.println("¿Como ha salido la misión?");
            System.out.println("1.- Éxito rotundo"
                    + "\n2.- Fracaso estrepitoso");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    misiones.get(nombre).esExito();
                    break;
                case 2:
                    misiones.get(nombre).esFracaso();
                    break;
            }
        }
    }

    public void listadoMisiones() {
        for (String key : misiones.keySet()) {
            if (misiones.get(key) instanceof MisionDeCombate) {
                ((MisionDeCombate)misiones.get(key)).toString();
            } else {
                System.out.println(misiones.get(key).toString());
            }
            misiones.get(key).toStringRecursos();
        }
    }

    public void listadoRecursos() {
        for (Recurso resource : recursos) {
            if (resource instanceof RecursoHumano) {
                System.out.println(((RecursoHumano) resource).toString());
            } else if (resource instanceof RecursoMaterialVehiculo) {
                System.out.println(((RecursoMaterialVehiculo) resource).toString());
            } else if (resource instanceof RecursoMaterial) {
                System.out.println(((RecursoMaterial) resource).toString());
            }
            resource.toStringMisiones((HashMap<String, Mision>) misiones);
        }
    }

    public void bajarStress() {
        for (Recurso resource : recursos) {
            if (resource instanceof RecursoHumano) {
                ((RecursoHumano) resource).setStress(0);
            }
        }
    }
}
