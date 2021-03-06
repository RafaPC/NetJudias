/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.DBConnectionPool;
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
import javafx.scene.control.MenuItem;
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

    private AnchorPane sceneAsignarAlum;
    
    private NotasFXMLController notasController;

    @FXML
    private BorderPane fxRoot;

    @FXML
    private MenuItem fxAsignarAlum;

    @FXML
    private MenuItem fxInsertNota;

    @FXML
    private Menu fxMenuAlumnos;

    @FXML
    private Menu fxMenuAsignaturas;

    @FXML
    public void handleCambiarAlumnos(ActionEvent event) {
        fxMenuAlumnos.setVisible(false);
        fxMenuAsignaturas.setVisible(true);
        fxRoot.setCenter(sceneAlumnos);
        fxAsignarAlum.setVisible(true);
        fxInsertNota.setVisible(true);
    }

    @FXML
    public void handleCambiarAsignaturas(ActionEvent event) {
        //Escena de asignaturas
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/fxml/AsignaturasFXML.fxml"));
        try {
            sceneAsignaturas = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MenuFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        AsignaturasFXMLController controllerAsignaturas = loader.getController();
        controllerAsignaturas.setController(this);
        
        fxMenuAlumnos.setVisible(true);
        fxMenuAsignaturas.setVisible(false);
        fxRoot.setCenter(sceneAsignaturas);
        fxAsignarAlum.setVisible(true);
        fxInsertNota.setVisible(true);
    }

    @FXML
    public void handleCambiarNotas(ActionEvent event) {
        //Escena de updatear 
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/fxml/NotasFXML.fxml"));
        try {
            sceneNotas = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MenuFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        notasController = loader.getController();
        notasController.setController(this);
        
        fxMenuAlumnos.setVisible(true);
        fxMenuAsignaturas.setVisible(true);
        fxAsignarAlum.setVisible(true);
        fxInsertNota.setVisible(false);
        
        notasController.cargarDatosCombo();
        fxRoot.setCenter(sceneNotas);
        
        
    }

    @FXML
    public void handleAsignarAlum(ActionEvent event) {
        //Escena de asignar alumnos a asignaturas
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/fxml/CrearNotasFXML.fxml"));
        try {
            sceneAsignarAlum = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MenuFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        CrearNotasFXMLController controllerAsignarAlum = loader.getController();
        controllerAsignarAlum.setController(this);
        
        fxMenuAlumnos.setVisible(true);
        fxMenuAsignaturas.setVisible(true);
        fxAsignarAlum.setVisible(false);
        fxInsertNota.setVisible(true);
        fxRoot.setCenter(sceneAsignarAlum);
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

        fxMenuAlumnos.setVisible(false);
        fxRoot.setCenter(sceneAlumnos);
    }

}
