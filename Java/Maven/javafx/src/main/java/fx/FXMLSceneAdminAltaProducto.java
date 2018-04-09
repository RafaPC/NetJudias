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
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLSceneAdminAltaProducto implements Initializable {

    private FXMLMenuController controller;

    @FXML
    private TextField fxNombre;

    @FXML
    private TextField fxPrecio;

    @FXML
    private TextField fxCantidad;

    @FXML
    private CheckBox fxCheckPerecedero;

    @FXML
    private void handleAltaProducto(ActionEvent event) throws IOException {

        if (fxNombre.getText() == null || fxNombre.getText().trim().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Tienes que introducir un nombre", ButtonType.CLOSE);
            a.showAndWait();
        } else if (fxCantidad.getText() == null || fxCantidad.getText().trim().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Tienes que introducir una cantidad", ButtonType.CLOSE);
            a.showAndWait();
        } else if (fxPrecio.getText() == null || fxPrecio.getText().trim().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Tienes que introducir un precio", ButtonType.CLOSE);
            a.showAndWait();
        } else {

            int opcion;
            if (fxCheckPerecedero.isSelected()) {
                opcion = 2;
            } else {
                opcion = 1;
            }

            boolean altaOk = this.controller.getMerchadona().darAltaProducto(fxNombre.getText(), Double.parseDouble(fxPrecio.getText()), Integer.parseInt(fxCantidad.getText()), opcion);

            if (altaOk) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Alta OK", ButtonType.CLOSE);
                //final Stage stage = (Stage) fxUser.getScene().getWindow();
                //a.initOwner(stage);
                a.showAndWait();
                fxNombre.setText("");
                fxPrecio.setText("");
                fxCantidad.setText("");
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Ese producto ya existe", ButtonType.CLOSE);
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
