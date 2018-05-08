/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.ConexionSimpleBD;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private TextField fxEdad;

    @FXML
    private ListView<Alumno> fxListAlumnos;
    
    
    

    @FXML
    public void handleInsert(ActionEvent event) {

    }

    @FXML
    public void handleUpdate(ActionEvent event) {

    }

    @FXML
    public void handleDelete(ActionEvent event) {

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
               conex.getAllAlumnosJDBC() );

    }

}
