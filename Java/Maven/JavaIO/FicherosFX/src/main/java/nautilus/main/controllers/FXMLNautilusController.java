/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nautilus.main.controllers;

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
    public void handleSubir(ActionEvent event) {

        if (fxRutaActual.getText().equalsIgnoreCase("/")) {
            fxBotonSubir.setDisable(true);
        } else {
            fxRutaActual.setText(seleccionado.getParent());
            
        }

    }
    
    @FXML
    public void checkDirectory(ActionEvent event){
        if(fxFiles.getSelectionModel().getSelectedItem().isFile()){
            fxBotonEntrar.setDisable(true);
        }else if(fxFiles.getSelectionModel().getSelectedItem().isDirectory()){
            fxBotonEntrar.setDisable(false);
        }
    }

    @FXML
    public void handleEntrar(ActionEvent event) {

        File seleccionado
                = fxFiles.getSelectionModel().getSelectedItem();

        fxRutaActual.setText(seleccionado.getAbsolutePath());
        fxBotonSubir.setDisable(false);
        cargarFiles();

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rutaActual = "/";
        fxRutaActual.setText(rutaActual);
        cargarFiles();

        // TODO
    }

    private void cargarFiles() {
        File f = new File(fxRutaActual.getText());
        fxFiles.getItems().clear();
        fxFiles.getItems().addAll(f.listFiles());
    }
}
