/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.AsignaturaDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import model.Asignatura;

/**
 *
 * @author daw
 */
public class AsignaturaService {

    public List getAllAsignaturas() {
        AsignaturaDAO dao = new AsignaturaDAO();
        return dao.getAllAlumnosJDBCTemplate();
    }

    public boolean insertAsignatura(Asignatura a) {
        AsignaturaDAO dao = new AsignaturaDAO();
        return dao.addUserJDBCTemplate(a);
    }

    public boolean updateAsignatura(Asignatura a) {
        AsignaturaDAO dao = new AsignaturaDAO();
        return dao.updateJDBCTemplate(a);
    }

    public boolean deleteAsignatura(Asignatura a) throws SQLException {
        boolean deleteado = false;
        AsignaturaDAO dao = new AsignaturaDAO();
        int respuesta;
        if (dao.existNotaFromAsignaturaDBUtils(a)) {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Aviso de integridad referencial");
            alerta.setContentText("Si borras esta asignatura se borrarán las notas referenciadas a esta");
            Optional<ButtonType> resulta = alerta.showAndWait();

            if (resulta.get() == ButtonType.OK) {
                deleteado = dao.delNotaAndAsigJDBCTemplate(a);
            }

        } else {
            deleteado = dao.deleteAsignaturaJDBC(a);
        }
        return deleteado;
    }
}
