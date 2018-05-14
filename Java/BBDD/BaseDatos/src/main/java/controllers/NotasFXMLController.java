/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.AlumnoDAO;
import dao.ConexionSimpleBD;
import dao.NotaDAO;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Alumno;
import model.Asignatura;
import model.Nota;
import servicios.AlumnoService;
import servicios.NotaService;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class NotasFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private MenuFXMLController controller;

    private NotaService conex;

    @FXML
    private TextField fxNota;
    
    @FXML
    private Label fxLabelNota;

    @FXML
    private ComboBox<Asignatura> fxComboAsignaturas;

    @FXML
    private ListView<Alumno> fxListAlumnos;

    @FXML
    public void handleMouseClick(ActionEvent event) {
        cargarDatosLista(fxComboAsignaturas.getSelectionModel().getSelectedItem().getId());
        
    }
    
    @FXML
    public void handleCambiarNota(ActionEvent event) {
        Integer nota = Integer.parseInt(fxNota.getText());
        Nota a = new Nota(nota,fxListAlumnos.getSelectionModel().getSelectedItem().getId(), (int) fxComboAsignaturas.getSelectionModel().getSelectedItem().getId());
        conex.updateNota(a);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        conex = new NotaService();
        cargarDatosCombo();
    }

    public void cargarDatosCombo() {
        fxComboAsignaturas.getItems().clear();
        fxComboAsignaturas.getItems().addAll(
                conex.getAllAsignaturas());
    }

    public void cargarDatosLista(long idWhere) {

        fxListAlumnos.getItems().clear();
        fxListAlumnos.getItems().addAll(
                conex.getAllAlumnosFromAsignatura(idWhere));

    }

//    private void clearCampos() {
//        fxNombre.setText("");
//        fxEdad.setValue(null);
//        fxMayor.setSelected(false);
//    }
    public void setController(MenuFXMLController controller) {
        this.controller = controller;
    }

}
