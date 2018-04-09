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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import merchadona.modelo.Producto;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLReponer implements Initializable {

    private FXMLMenuController controller;

    @FXML
    private TextField fxCantidad;

    @FXML
    private ListView<Producto> fxListProductos;

    @FXML
    private void handleReponer(ActionEvent event) throws IOException {
        Alert a = new Alert(Alert.AlertType.ERROR, "El numero no es valido", ButtonType.CLOSE);
        //final Stage stage = (Stage) fxUser.getScene().getWindow();
        //a.initOwner(stage);
        //a.showAndWait();
        int cantidad = 0;
        try {
            // mirar varaib le de login
            cantidad = Integer.parseInt(fxCantidad.getText());

            //Empleado emp = this.controller.getMerchadona().login(empleadoID);;

        } catch (Exception e) {
            a.setContentText("La cantidad no es un número");
            a.showAndWait();
        }
        Producto p = fxListProductos.getSelectionModel().getSelectedItem();

        this.controller.getMerchadona().reponerProducto(this.controller.getEmpleadoID(), p, cantidad);
        cargarLista();
        fxCantidad.setText("");
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

    public void cargarLista() {
        fxListProductos.getItems().clear();
        fxListProductos.getItems().addAll(
                this.controller.getMerchadona().getProductos());
    }
}
