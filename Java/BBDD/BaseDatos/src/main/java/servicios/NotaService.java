/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.AlumnoDAO;
import dao.AsignaturaDAO;
import java.util.List;

/**
 *
 * @author Los Prieto
 */
public class NotaService {
    public List getAllAsignaturas() {
        AsignaturaDAO x = new AsignaturaDAO();
        return x.getAllAsignaturasJDBC();
    }
    
    public List getAllAlumnos() {
        AlumnoDAO x = new AlumnoDAO();
        return x.getAllAlumnosJDBC();
    }
}
