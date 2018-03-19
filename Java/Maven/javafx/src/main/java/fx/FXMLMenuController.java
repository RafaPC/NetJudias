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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import merchadona.servicios.Merchadona;

/**
 * FXML Controller class
 *
 * @author oscar
 */
public class FXMLMenuController implements Initializable {

    
    private Merchadona merchadona;
    
    @FXML
    private MenuBar fxMenu;

    @FXML
    private Menu fxProbar;

    @FXML
    private BorderPane fxRoot;

    @FXML
    public void handleScene1(ActionEvent event) throws IOException {
        AnchorPane anchor;
        //load up OTHER FXML document
        FXMLLoader loader = new FXMLLoader(
          getClass().getResource("/fxml/FXMLScene.fxml"));
        anchor = loader.load();
        FXMLSceneController controller = loader.getController();
        controller.setController(this);
        fxRoot.setCenter(anchor);
    }

    @FXML
    public void handleScene2(ActionEvent event) throws IOException {
        AnchorPane anchor;
        //load up OTHER FXML document
        FXMLLoader loader = new FXMLLoader(
          getClass().getResource("/fxml/FXMLSceneNew.fxml"));
        anchor = loader.load();
        FXMLSceneNewController controller = loader.getController();
        controller.setController(this);

        fxRoot.setCenter(anchor);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        fxMenu.setVisible(false);
        merchadona = new Merchadona();

    }

    public MenuBar getFxMenu() {
        return fxMenu;
    }

    public Menu getFxProbar() {
        return fxProbar;
    }

    public Merchadona getMerchadona() {
        return merchadona;
    }

}
