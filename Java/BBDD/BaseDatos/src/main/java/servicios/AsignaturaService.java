/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.AsignaturaDAO;
import java.util.List;
import model.Asignatura;

/**
 *
 * @author daw
 */
public class AsignaturaService {
    public List getAllAsignaturas() {
        AsignaturaDAO x = new AsignaturaDAO();
        return x.getAllAsignaturasJDBC();
    }
    
    public boolean insertAsignatura(Asignatura a) {
        AsignaturaDAO x = new AsignaturaDAO();
        return x.insertAsignaturaJDBC(a);
    }

    public boolean updateAsignatura(Asignatura a) {
        AsignaturaDAO x = new AsignaturaDAO();
        return x.updateAsignaturaJDBC(a);
    }

    public boolean deleteAsignatura(long idWhere) {
        AsignaturaDAO x = new AsignaturaDAO();
        return x.deleteAsignaturaJDBC(idWhere);
    }
}
