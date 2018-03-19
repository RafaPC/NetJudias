/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLSceneAdmin implements Initializable {

    private FXMLMenuController controller;

    @FXML
    private void clickAltaEmpleado(ActionEvent event) throws IOException {

        boolean altaOk = this.controller.getMerchadona().darAltaEmpleado("pepe", 23, 1);

        if (altaOk) {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Alta OK", ButtonType.CLOSE);
            //final Stage stage = (Stage) fxUser.getScene().getWindow();
            //a.initOwner(stage);
            a.showAndWait();
        }
        else
        {
            Alert a = new Alert(Alert.AlertType.ERROR, "El id ya existe", ButtonType.CLOSE);
            //final Stage stage = (Stage) fxUser.getScene().getWindow();
            //a.initOwner(stage);
            a.showAndWait();
        }
         

    }

    @FXML
    private void handleAction(ActionEvent event) throws IOException {

        Alert a = new Alert(Alert.AlertType.INFORMATION, "HOLA", ButtonType.CLOSE);
        //final Stage stage = (Stage) fxUser.getScene().getWindow();
        //a.initOwner(stage);
        a.showAndWait();

        this.controller.getFxMenu().setVisible(true);
        this.controller.getFxProbar().setVisible(true);

//         
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
