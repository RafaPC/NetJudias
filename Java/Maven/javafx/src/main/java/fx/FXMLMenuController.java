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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import merchadona.modelo.Empleado;
import merchadona.servicios.Merchadona;

/**
 * FXML Controller class
 *
 * @author oscar
 */
public class FXMLMenuController implements Initializable {

    private AnchorPane scene;
    private AnchorPane scene2;
    private AnchorPane tabla;
    private FXMLTablasController controllerT;
    
    private Merchadona merchadona;
    private Empleado empleadoActual;
    private int empleadoID;

    @FXML
    private MenuBar fxMenu;

    @FXML
    private Menu fxProbar;

    @FXML
    private AnchorPane fxAdmin;
    
    @FXML
    private Menu fxLogout;

    @FXML
    private Menu fxAtras;

    @FXML
    private BorderPane fxRoot;

    @FXML
    public void handleScene1(ActionEvent event) throws IOException {

        fxRoot.setCenter(scene);
    }

    @FXML
    public void handleScene2(ActionEvent event) throws IOException {

        fxRoot.setCenter(scene2);
    }

    @FXML
    public void handleSceneTablas(ActionEvent event) throws IOException {
        controllerT.cargarDatosLista();
        fxRoot.setCenter(tabla);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            fxMenu.setVisible(false);
            merchadona = new Merchadona();
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(Constantes.PANTALLA_SCENE));
            scene = loader.load();
            FXMLSceneController controller = loader.getController();
            controller.setController(this);

            loader = new FXMLLoader(
                    getClass().getResource(Constantes.PANTALLA_SCENE_NEW));
            scene2 = loader.load();
            FXMLSceneNewController controllerNew = loader.getController();
            controllerNew.setController(this);

            /*loader = new FXMLLoader(
                    getClass().getResource(Constantes.PANTALLA_TABLAS));
            tabla = loader.load();
            controllerT = loader.getController();
            controllerT.setController(this);*/

        } catch (IOException ex) {
            Logger.getLogger(FXMLMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

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

    public Empleado getEmpleadoActual() {
        return empleadoActual;
    }

    public void setEmpleadoActual(Empleado empleadoActual) {
        this.empleadoActual = empleadoActual;
    }

    public int getEmpleadoID() {
        return empleadoID;
    }

    public void setEmpleadoID(int empleadoID) {
        this.empleadoID = empleadoID;
    }

    @FXML
    public void habilitaPantallaAdmin() {
        fxMenu.setVisible(true);
        fxAdmin.setVisible(true);
        
    }

    @FXML
    public void habilitaPantallaReponedor() {
        fxRoot.setCenter(tabla);
    }

    @FXML
    public void habilitaPantallaCajero() {
        fxRoot.setCenter(tabla);
    }
}
