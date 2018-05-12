/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class MenuFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private AnchorPane sceneAlumnos;

    private AnchorPane sceneAsignaturas;

    private AnchorPane sceneNotas;

    @FXML
    private BorderPane fxRoot;

    @FXML
    private Menu fxMenuAlumnos;

    @FXML
    private Menu fxMenuAsignaturas;

    @FXML
    private Menu fxMenuNotas;

    @FXML
    public void handleCambiarAlumnos(ActionEvent event) {
        fxMenuAlumnos.setVisible(false);
        fxMenuAsignaturas.setVisible(true);
        fxMenuNotas.setVisible(true);
        fxRoot.setCenter(sceneAlumnos);
    }

    @FXML
    public void handleCambiarAsignaturas(ActionEvent event) {
        fxMenuAlumnos.setVisible(true);
        fxMenuNotas.setVisible(true);
        fxMenuAsignaturas.setVisible(false);
        fxRoot.setCenter(sceneAsignaturas);
    }

    @FXML
    public void handleCambiarNotas(ActionEvent event) {
        fxMenuAlumnos.setVisible(true);
        fxMenuAsignaturas.setVisible(true);
        fxMenuNotas.setVisible(false);
        fxRoot.setCenter(sceneNotas);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Escena de alumnos
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/fxml/AlumnosFXML.fxml"));
        try {
            sceneAlumnos = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MenuFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        InicioFXMLController controllerAlum = loader.getController();
        controllerAlum.setController(this);

        //Escena de asignaturas
        loader = new FXMLLoader(
                getClass().getResource("/fxml/AsignaturasFXML.fxml"));
        try {
            sceneAsignaturas = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MenuFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        AsignaturasFXMLController controllerAsignaturas = loader.getController();
        controllerAsignaturas.setController(this);
        
        
        //Escena de notas
        loader = new FXMLLoader(
                getClass().getResource("/fxml/NotasFXML.fxml"));
        try {
            sceneNotas = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MenuFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        NotasFXMLController controllerNotas = loader.getController();
        controllerNotas.setController(this);
        fxMenuAlumnos.setVisible(false);
        fxRoot.setCenter(sceneAlumnos);
    }

}
