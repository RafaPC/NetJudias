/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dao.ConexionSimpleBD;
import java.util.List;
import model.Alumno;
import model.Asignatura;

/**
 *
 * @author user
 */
public class Main {

    public static void main(String[] args) {
        ConexionSimpleBD c = new ConexionSimpleBD();

         List<Asignatura> asignaturas = c.getAllAsignaturasJDBC();
        for (Asignatura a : asignaturas) {
            System.out.println("ID: " + a.getId());
            System.out.println("Nombre: " + a.getNombre());
            System.out.println("Curso: " + a.getCurso());
            System.out.println("Ciclo: " + a.getCiclo());
            System.out.println("-------------------------");
        }
    }
}
