/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import merchadona.modelo.Cajera;
import merchadona.modelo.Perecedero;
import merchadona.modelo.Producto;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLTablasController implements Initializable {

    private FXMLMenuController controller;

    @FXML
    private ListView<Cajera> fxListCajero;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }



    public void cargarDatosLista() {

        fxListCajero.getItems().clear();
        fxListCajero.getItems().addAll(
                this.controller.getMerchadona().listaCajeras());

    }

    public void setController(FXMLMenuController controller) {
        this.controller = controller;
    }
}
