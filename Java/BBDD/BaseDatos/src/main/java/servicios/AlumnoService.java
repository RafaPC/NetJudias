/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.AlumnoDAO;
import java.sql.SQLException;
import java.util.List;
import model.Alumno;

/**
 *
 * @author daw
 */
public class AlumnoService {

    public List getAllAlumnos() {
        AlumnoDAO x = new AlumnoDAO();
        return x.getAllAlumnosDBUtils();
    }

    public boolean insertAlumno(Alumno a) {
        AlumnoDAO x = new AlumnoDAO();
        return x.insertAlumnoDBUtils(a);
    }

    public boolean updateAlumno(Alumno a) {
        AlumnoDAO x = new AlumnoDAO();
        return x.updateUserDBUtils(a);
    }

    public boolean deleteAlumno(Alumno a) throws SQLException {
        boolean borrado = false;
        AlumnoDAO x = new AlumnoDAO();
        if (x.existNotaFromAlumno((int) a.getId())) {
            borrado = x.deleteNotaAndAlumnoDBUtils(a);
        } else {
            borrado = x.deleteAlumnoDBUtils(a);
        }
        return borrado;
    }

}
