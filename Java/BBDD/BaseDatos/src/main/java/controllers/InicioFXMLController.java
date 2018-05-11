/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.AlumnoDAO;
import dao.ConexionSimpleBD;
import java.net.URL;
import java.util.Date;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Alumno;
import servicios.AlumnoService;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class InicioFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private MenuFXMLController controller;

    private AlumnoService conex;

    private AnchorPane sceneAsignaturas;

//    @FXML
//    private AnchorPane fxRoot;
    @FXML
    private TextField fxNombre;

    @FXML
    private DatePicker fxEdad;

    @FXML
    private CheckBox fxMayor;

    @FXML
    private ListView<Alumno> fxListAlumnos;

    @FXML
    public void handleMouseClick(MouseEvent event) {
        Alumno seleccionado = fxListAlumnos.getSelectionModel().getSelectedItem();

        fxNombre.setText(seleccionado.getNombre());
        fxEdad.setValue(new java.sql.Date(seleccionado.getFecha_nacimiento().getTime()).toLocalDate());
        if (seleccionado.getMayor_edad()) {
            fxMayor.setSelected(true);
        } else {
            fxMayor.setSelected(false);
        }
    }

    @FXML
    public void handleInsert(ActionEvent event) {

        boolean ok = true;

        if (fxNombre.getText().trim().length() == 0 && fxEdad.getValue() == null) {
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
            Alumno a = new Alumno(fxNombre.getText(), date, fxMayor.isSelected());
            if (conex.insertAlumno(a)) {
                fxListAlumnos.getItems().add(a);
                Alert b = new Alert(Alert.AlertType.INFORMATION, "Alumno creado correctamente", ButtonType.CLOSE);
                b.showAndWait();
                fxListAlumnos.refresh();
            } else {
                Alert b = new Alert(Alert.AlertType.ERROR, "Ha ocurrido un problema al crear el alumno", ButtonType.CLOSE);
                b.showAndWait();
            }
        }
        clearCampos();
    }

    @FXML
    public void handleUpdate(ActionEvent event) {

        boolean ok = true;

        if (fxListAlumnos.getSelectionModel().getSelectedItem() == null) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Tienes que seleccionar un alumno", ButtonType.CLOSE);
            a.showAndWait();
        } else {

            if (fxNombre.getText() == null && fxEdad.getValue() == null) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Tienes que rellenar el nombre y fecha de nacimiento", ButtonType.CLOSE);
                a.showAndWait();
                ok = false;
            } else {
                if (fxNombre.getText().trim().length() == 0) {
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
                String nombre = fxNombre.getText();
                Date fecha = java.sql.Date.valueOf(fxEdad.getValue());
                boolean mayor = fxMayor.isSelected();

                Alumno original = fxListAlumnos.getSelectionModel().getSelectedItem();

                Alumno a = new Alumno(nombre, fecha, mayor);
                a.setId(fxListAlumnos.getSelectionModel().getSelectedItem().getId());

                if (conex.updateAlumno(a)) {

                    fxListAlumnos.getItems().set(fxListAlumnos.getItems().indexOf(original), a);
                    Alert b = new Alert(Alert.AlertType.INFORMATION, "Alumno actualizado correctamente", ButtonType.CLOSE);
                    b.showAndWait();
                    fxListAlumnos.refresh();
                } else {
                    Alert b = new Alert(Alert.AlertType.ERROR, "Ha ocurrido un problema al actualizar el alumno", ButtonType.CLOSE);
                    b.showAndWait();
                }
            }
        }
        clearCampos();
    }

    @FXML
    public void handleDelete(ActionEvent event) {
        if (fxListAlumnos.getSelectionModel().getSelectedItem() == null) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Tienes que seleccionar un alumno", ButtonType.CLOSE);
            a.showAndWait();
        } else {
            Alumno a = fxListAlumnos.getSelectionModel().getSelectedItem();
            Integer id = a.getId();
            if (conex.deleteAlumno(id.longValue())) {
                fxListAlumnos.getItems().remove(a);
                Alert b = new Alert(Alert.AlertType.INFORMATION, "Alumno borrado correctamente", ButtonType.CLOSE);
                b.showAndWait();
                fxListAlumnos.refresh();
            } else {
                Alert b = new Alert(Alert.AlertType.ERROR, "Ha ocurrido un problema al borrar el alumno", ButtonType.CLOSE);
                b.showAndWait();
            }
        }
        clearCampos();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ConexionSimpleBD c = new ConexionSimpleBD();
        conex = new AlumnoService();
        cargarDatosLista();
    }

    public void cargarDatosLista() {

        fxListAlumnos.getItems().clear();
        fxListAlumnos.getItems().addAll(
                conex.getAllAlumnos());

    }

    private void clearCampos() {
        fxNombre.setText("");
        fxEdad.setValue(null);
        fxMayor.setSelected(false);
    }

    public void setController(MenuFXMLController controller) {
        this.controller = controller;
    }

}
