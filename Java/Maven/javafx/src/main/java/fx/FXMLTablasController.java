/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import merchadona.modelo.Cajera;
import merchadona.modelo.Producto;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLTablasController implements Initializable {

    private FXMLMenuController controller;

    @FXML
    private TableView fxTabla;

    @FXML
    private ListView<Producto> fxList;

    @FXML
    private VBox fxVbox;
    
    @FXML
    private ListView<Cajera> fxListCajero;

    @FXML
    private void clickAddProducto(ActionEvent event) {
        this.controller.getMerchadona().darAltaProducto("hh", 89);

    }

    @FXML
    private void clickAddCesta(ActionEvent event) {

        Producto p = fxList.getSelectionModel().getSelectedItem();

        int error = this.controller.getMerchadona().venderProducto(
         1235,
          1, p);
        switch (error) {
            case 1:
                Alert a = new Alert(Alert.AlertType.INFORMATION, "STOCK INSUFICIENTE", ButtonType.CLOSE);

                a.showAndWait();
                break;
            case 2:
                 a = new Alert(Alert.AlertType.INFORMATION, "Producto caducado", ButtonType.CLOSE);

                a.showAndWait();
                break;
        }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    public void cargarDatosLista() {
        fxList.getItems().clear();
        fxList.getItems().addAll(
          this.controller.getMerchadona().getProductos());
        
        fxListCajero.getItems().clear();
        fxListCajero.getItems().addAll(
          this.controller.getMerchadona().listaCajeras());
    }

    public void setController(FXMLMenuController controller) {
        this.controller = controller;
    }
}
