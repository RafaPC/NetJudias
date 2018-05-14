/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author daw
 */
public class Nota {
    
    private int nota;
    
    private int id_alumno;
    
    private int id_asignatura;

    public Nota(int nota, int id_alumno, int id_asignatura) {
        this.nota = nota;
        this.id_alumno = id_alumno;
        this.id_asignatura = id_asignatura;
    }

    public Nota() {
    }    
    
    
    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public int getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(int id_asignatura) {
        this.id_asignatura = id_asignatura;
    }
}
