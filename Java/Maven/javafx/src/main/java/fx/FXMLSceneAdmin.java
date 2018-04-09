/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx;

import fx.constantes.Constantes;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLSceneAdmin implements Initializable {

    private FXMLMenuController controller;

    private AnchorPane scene2;

    @FXML
    private Button fxListaProductos;

    @FXML
    private void handleAltaEmpleado(ActionEvent event) throws IOException {
        controller.handleAltaEmp(event);
    }

    @FXML
    private void handleBajaEmpleado(ActionEvent event) throws IOException {
        controller.handleBajaEmp(event);
    }

    @FXML
    private void handleAltaProducto(ActionEvent event) throws IOException {
        controller.handleAltaProd(event);
    }

    @FXML
    private void handleListaCajeras(ActionEvent event) throws IOException {
        controller.handleSceneTablas(event);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    public void setController(FXMLMenuController controller) {
        this.controller = controller;
    }
}
