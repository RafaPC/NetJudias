/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nautilus.main.controllers;

import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLNautilusController implements Initializable {

    @FXML
    private ListView<File> fxFiles;
    
    @FXML
    private Label fxRutaActual;

    @FXML
    private Button fxBotonSubir;

    @FXML
    private Button fxBotonEntrar;

    
    private String rutaActual;

    private File seleccionado;

    
    
    @FXML
    public void handleEntrar(MouseEvent event) {
        if (event.getClickCount() > 1) {
            seleccionado = fxFiles.getSelectionModel().getSelectedItem();

            fxRutaActual.setText(seleccionado.getAbsolutePath());
            cargarFiles();
            checkBotones();
        }
    }
    
    @FXML
    public void handleSubir(ActionEvent event) {

        fxRutaActual.setText(seleccionado.getParent());
        seleccionado = seleccionado.getParentFile();
        cargarFiles();
        fxRutaActual.setText(seleccionado.getAbsolutePath());
    }

    public void checkDirectory(ActionEvent event) {
        if (fxFiles.getSelectionModel().getSelectedItem().isFile()) {
            fxBotonEntrar.setDisable(true);
        } else if (fxFiles.getSelectionModel().getSelectedItem().isDirectory()) {
            fxBotonEntrar.setDisable(false);
        }
    }

    

    public void checkBotones() {
        if (fxRutaActual.getText() == "/") {
            fxBotonSubir.setDisable(true);
        } else {
            fxBotonSubir.setDisable(false);
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rutaActual = "/";
        fxRutaActual.setText(rutaActual);
        cargarFiles();
    }

    private void cargarFiles() {
        checkBotones();
        File f = new File(fxRutaActual.getText());
        fxFiles.getItems().clear();
        fxFiles.getItems().addAll(f.listFiles());
    }
}
