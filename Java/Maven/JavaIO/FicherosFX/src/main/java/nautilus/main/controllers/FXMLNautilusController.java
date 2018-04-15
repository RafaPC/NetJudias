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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

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
    public void handleMouseEntrar(MouseEvent event) {
        if (event.getClickCount() > 1) {
            if (checkDirectory()) {
                seleccionado = fxFiles.getSelectionModel().getSelectedItem();

                fxRutaActual.setText(seleccionado.getAbsolutePath());
                cargarFiles();
                checkBotones();
            } else {
                Alert b = new Alert(Alert.AlertType.ERROR, "No puedes entrar a un fichero", ButtonType.CLOSE);
                b.showAndWait();
            }
        }
    }

    @FXML
    public void handleSubir(ActionEvent event) {

        fxRutaActual.setText(seleccionado.getParent());
        seleccionado = seleccionado.getParentFile();
        cargarFiles();
        fxRutaActual.setText(seleccionado.getAbsolutePath());
        checkBotones();
    }

    public boolean checkDirectory() {
        boolean directory = false;
        if (fxFiles.getSelectionModel().getSelectedItem().isDirectory()) {
            directory = true;
        }
        return directory;
    }

    public void checkBotones() {
        if (fxRutaActual.getParent() == null) {
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
        fxBotonSubir.setDisable(true);
        File f = new File(fxRutaActual.getText());
        fxFiles.getItems().clear();
        fxFiles.getItems().addAll(f.listFiles());
    }
}
