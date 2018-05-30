/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.AlumnoDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import model.Alumno;

/**
 *
 * @author daw
 */
public class AlumnoService {

    public List getAllAlumnos() {
        AlumnoDAO dao = new AlumnoDAO();
        return dao.getAllAlumnosDBUtils();
    }

    public boolean insertAlumno(Alumno a) {
        AlumnoDAO dao = new AlumnoDAO();
        return dao.insertAlumnoDBUtils(a);
    }

    public boolean updateAlumno(Alumno a) {
        AlumnoDAO dao = new AlumnoDAO();
        return dao.updateUserDBUtils(a);
    }

    public boolean deleteAlumno(Alumno a) throws SQLException {
        boolean borrado = false;
        AlumnoDAO dao = new AlumnoDAO();
        if (dao.existNotaFromAlumnoDBUtils(a)) {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Aviso de integridad referencial");
            alerta.setContentText("Si borras este alumno se borrarán sus notas también");
            Optional<ButtonType> resulta = alerta.showAndWait();

            if (resulta.get() == ButtonType.OK) {
                borrado = dao.deleteNotaAndAlumnoDBUtils(a);
            }
        } else {
            borrado = dao.deleteAlumnoDBUtils(a);
        }
        return borrado;
    }

}
