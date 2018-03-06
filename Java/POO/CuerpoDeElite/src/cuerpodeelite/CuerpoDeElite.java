/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuerpodeelite;

import java.time.LocalDate;
import java.util.ArrayList;
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
        System.out.print("Nombre de la misión: ");
        nombre = sc.next();
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
                misiones.put(nombre, new Mision(fecha, lugar, expGanada, nombre));
                //misiones.get(nombre).crearMision(recursos, sc);
                crearMisionDeCombate(fecha, nombre, expGanada, lugar);
                break;
            default:
                System.out.println("No existe esa opción");
                break;
        }
    }

    private void crearMisionDeCombate(LocalDate fecha, String nombre, int expGanada, String lugar) {
        misiones.put(nombre, new Mision(fecha, lugar, expGanada, nombre));
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
                    if (!estresado) {
                        if (recursos.get(i).getMisiones().contains(misiones.get(nombre))) {
                        } else {
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
                System.out.println("Si quieres salir elige '-1'");
                numRecurso = sc.nextInt();
                sc.nextLine();

                if (numRecurso != -1) {
                    for (int i = 0; i < recursos.get(numRecurso).getMisiones().size() && !cogido; i++) {
                        if (recursos.get(numRecurso).getMisiones().get(i).getFecha().equals(misiones.get(nombre).getFecha())) {
                            System.out.println("Ese recurso ya está ocupado en otra misión el mismo día");
                            cogido = true;
                        }
                    }
                } else {
                    if (misiones.get(nombre).requisitoVehiculos()) {
                        System.out.println("Tienes que coger al menos un vehículo");
                        if (misiones.get(nombre).requisitoPersonas()) {
                            requisitos = true;
                        }
                    } else {
                        System.out.println("Tienes que coger al menos un vehículo");
                    }
                }
            } while (cogido);
            if (numRecurso != -1) {
                System.out.println("¿Y cuál va a ser su uso?");
                uso = sc.next();
                fuerzaLetal += recursos.get(numRecurso).getPotenciaDeMuerte();
                misiones.get(nombre).addRecurso(recursos.get(numRecurso), uso);
                recursos.get(numRecurso).addMision(misiones.get(nombre));
            }

        } while (numRecurso != -1 || !requisitos);

    }

    private void crearMisionDeReconocimiento() {

    }

    public void bajarStress() {
        for (Recurso resource : recursos) {
            if (resource instanceof RecursoHumano) {
                ((RecursoHumano) resource).setStress(0);
            }
        }
    }
}
