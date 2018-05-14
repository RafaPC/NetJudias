/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.AlumnoDAO;
import dao.AsignaturaDAO;
import dao.NotaDAO;
import java.util.List;
import model.Nota;

/**
 *
 * @author Los Prieto
 */
public class NotaService {
    public List getAllAsignaturas() {
        AsignaturaDAO x = new AsignaturaDAO();
        return x.getAllAsignaturasJDBC();
    }
    
    public List getAllAlumnosFromAsignatura(long idWhere) {
        NotaDAO x = new NotaDAO();
        return x.getAllAlumnosFromAsignatura(idWhere);
    }
    
    public void updateNota(Nota a) {
        NotaDAO x = new NotaDAO();
         x.updateNotas(a);
    }
    
}
