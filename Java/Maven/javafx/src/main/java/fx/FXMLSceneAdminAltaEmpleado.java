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
public class FXMLSceneAdminAltaEmpleado implements Initializable {

    private FXMLMenuController controller;

    @FXML
    private ToggleGroup fxTipoEmpleado;

    @FXML
    private TextField fxUser;

    @FXML
    private TextField fxID;

    @FXML
    private void handleLoginAction(ActionEvent event) throws IOException {

        if (fxID.getText() == null || fxID.getText().trim().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Tienes que introducir un número", ButtonType.CLOSE);
            a.showAndWait();
        } else if (fxUser.getText() == null || fxUser.getText().trim().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Tienes que introducir un nombre", ButtonType.CLOSE);
            a.showAndWait();
        } else {

            String radio = ((RadioButton) fxTipoEmpleado.getSelectedToggle()).getText();
            int opcion = 0;
            if (radio.equalsIgnoreCase("reponed@r")) {
                opcion = 2;
            } else {
                opcion = 1;
            }

            Integer id = Integer.parseInt(fxID.getText());
            boolean altaOk = this.controller.getMerchadona().darAltaEmpleado(fxUser.getText(), Integer.parseInt(fxID.getText()), opcion);

            if (altaOk) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Alta OK", ButtonType.CLOSE);
                //final Stage stage = (Stage) fxUser.getScene().getWindow();
                //a.initOwner(stage);
                a.showAndWait();
                fxUser.setText("");
                fxID.setText("");
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "El id ya existe", ButtonType.CLOSE);
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
