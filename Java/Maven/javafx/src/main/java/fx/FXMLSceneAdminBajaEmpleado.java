/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLSceneAdminBajaEmpleado implements Initializable {

    private FXMLMenuController controller;

    @FXML
    private TextField fxID;

    @FXML
    private void handleBajaEmp(ActionEvent event) throws IOException {

        if (fxID.getText() == null || fxID.getText().trim().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Tienes que introducir un número", ButtonType.CLOSE);
            a.showAndWait();
        } else {
            Integer id = Integer.parseInt(fxID.getText());
            boolean bajaOk = this.controller.getMerchadona().darBajaEmpleado(Integer.parseInt(fxID.getText()));

            if (bajaOk) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Baja OK", ButtonType.CLOSE);
                //final Stage stage = (Stage) fxUser.getScene().getWindow();
                //a.initOwner(stage);
                a.showAndWait();
                fxID.setText("");
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "No existía ese usuario", ButtonType.CLOSE);
                //final Stage stage = (Stage) fxUser.getScene().getWindow();
                //a.initOwner(stage);
                a.showAndWait();
            }

        }
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
