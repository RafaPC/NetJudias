/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import model.Alumno;
import model.Asignatura;
import servicios.CrearNotaService;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class CrearNotasFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private MenuFXMLController controller;

    private CrearNotaService conex;

    @FXML
    private ListView<Asignatura> fxListAsignaturas;

    @FXML
    private ListView<Alumno> fxListAlumnos;

    @FXML
    public void handleAsignar(ActionEvent event) {
        int idAsig = (int) fxListAsignaturas.getSelectionModel().getSelectedItem().getId();
        int idAlum = fxListAlumnos.getSelectionModel().getSelectedItem().getId();
        if(conex.insertNota(idAlum, idAsig)){
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Alumno y asignatura asignados correctamente", ButtonType.CLOSE);
            a.showAndWait();
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR, "Ha ocurrido algún problema", ButtonType.CLOSE);
            a.showAndWait();
        }
        fxListAlumnos.getSelectionModel().select(null);
        fxListAsignaturas.getSelectionModel().select(null);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        conex = new CrearNotaService();
        cargarDatosAlum();
        cargarDatosAsig();
    }

    public void cargarDatosAlum() {
        fxListAlumnos.getItems().clear();
        fxListAlumnos.getItems().addAll(
                conex.getAllAlumnos());

    }
    
    public void cargarDatosAsig(){
       fxListAsignaturas.getItems().addAll(
       conex.getAllAsignaturas());
    }

    public void setController(MenuFXMLController controller) {
        this.controller = controller;
    }

}
