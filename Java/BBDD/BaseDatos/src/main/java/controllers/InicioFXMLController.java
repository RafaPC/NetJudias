/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.ConexionSimpleBD;
import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Alumno;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class InicioFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private ConexionSimpleBD conex;

    @FXML
    private AnchorPane fxRoot;

    @FXML
    private TextField fxNombre;

    @FXML
    private DatePicker fxEdad;

    @FXML
    private CheckBox fxMayor;

    @FXML
    private ListView<Alumno> fxListAlumnos;

    @FXML
    public void handleInsert(ActionEvent event) {

        boolean ok = true;

        if (fxNombre.getText() == null && fxEdad.getValue() == null) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Tienes que rellenar el nombre y fecha de nacimiento", ButtonType.CLOSE);
            a.showAndWait();
            ok = false;
        } else {
            if (fxNombre.getText() == null) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Tienes que rellenar el nombre", ButtonType.CLOSE);
                a.showAndWait();
                ok = false;
            }
            if (fxEdad.getValue() == null) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Tienes que rellenar la fecha de nacimiento", ButtonType.CLOSE);
                a.showAndWait();
                ok = false;
            }
        }
        if (ok) {

            java.util.Date date = java.sql.Date.valueOf(fxEdad.getValue());
            conex.insertAlumnoJDBC(new Alumno(fxNombre.getText(), date, fxMayor.isSelected()));
            fxListAlumnos.refresh();
            cargarDatosLista();
        }

    }

    @FXML
    public void handleUpdate(ActionEvent event) {
        String nombre = fxListAlumnos.getSelectionModel().getSelectedItem().getNombre();
        Date fecha = fxListAlumnos.getSelectionModel().getSelectedItem().getFecha_nacimiento();
        boolean mayor = fxListAlumnos.getSelectionModel().getSelectedItem().getMayor_edad();

        if (fxNombre.getText().trim().length() > 0) {
            nombre = fxNombre.getText();
        }
        if (fxEdad.getValue() != null) {
            fecha = java.sql.Date.valueOf(fxEdad.getValue());
        }

        if (fxMayor.isSelected()) {
            mayor = true;
        }
        Alumno a = new Alumno(nombre, fecha, mayor);
        a.setId(fxListAlumnos.getSelectionModel().getSelectedItem().getId());
        conex.updateAlumnoJDBC(a);
    }

    @FXML
    public void handleDelete(ActionEvent event) {
        Integer id = fxListAlumnos.getSelectionModel().getSelectedItem().getId();
        conex.deleteAlumno(id.longValue());
        cargarDatosLista();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ConexionSimpleBD c = new ConexionSimpleBD();
        conex = new ConexionSimpleBD();

        List<Alumno> alumnos = c.getAllAlumnosJDBC();
        for (Alumno a : alumnos) {
            System.out.println(a.getNombre());
            System.out.println(a.getId());
        }
        Alumno a = c.getAlumnoJDBC(403);
        a.setNombre("Salah");
        c.updateAlumnoJDBC(a);
        System.out.println(a.getNombre());
        a = c.getAlumnoJDBC(403);
        System.out.println("despues " + a.getNombre());
        cargarDatosLista();
    }

    public void cargarDatosLista() {

        fxListAlumnos.getItems().clear();
        fxListAlumnos.getItems().addAll(
                conex.getAllAlumnosJDBC());

    }

}
