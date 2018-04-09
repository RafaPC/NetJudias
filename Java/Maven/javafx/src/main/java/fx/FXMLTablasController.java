/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import merchadona.modelo.Cajera;
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
