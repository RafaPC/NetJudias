/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.AlumnoDAO;
import java.util.List;
import model.Alumno;

/**
 *
 * @author daw
 */
public class AlumnoService {

    public List getAllAlumnos() {
        AlumnoDAO x = new AlumnoDAO();
        return x.getAllAlumnosJDBC();
    }
    
    public boolean insertAlumno(Alumno a) {
        AlumnoDAO x = new AlumnoDAO();
        return x.insertAlumnoJDBC(a);
    }

    public boolean updateAlumno(Alumno a) {
        AlumnoDAO x = new AlumnoDAO();
        return x.updateAlumnoJDBC(a);
    }

    public boolean deleteAlumno(long idWhere) {
        AlumnoDAO x = new AlumnoDAO();
        return x.deleteAlumno(idWhere);
    }
}
