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
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import merchadona.modelo.Empleado;
import merchadona.servicios.Merchadona;

/**
 * FXML Controller class
 *
 * @author oscar
 */
public class FXMLMenuController implements Initializable {

    private AnchorPane sceneMenuAdmin;
    private AnchorPane sceneAltaEmp;
    private AnchorPane sceneBajaEmp;
    private AnchorPane sceneAltaProd;
    private AnchorPane sceneAdmin;
    private AnchorPane tabla;
    private AnchorPane sceneVender;
    private AnchorPane sceneReponer;
    private FXMLTablasController controllerT;
    private FXMLReponer controllerR;
    private FXMLVender controllerV;

    private Merchadona merchadona;
    private Empleado empleadoActual;
    private int empleadoID;

    @FXML
    private MenuBar fxMenu;

    @FXML
    private Menu fxAtras;

    @FXML
    private BorderPane fxRoot;


    @FXML
    public void handleAltaEmp(ActionEvent event) throws IOException {

        fxRoot.setCenter(sceneAltaEmp);
        fxAtras.setVisible(true);
    }

    @FXML
    public void handleBajaEmp(ActionEvent event) throws IOException {

        fxRoot.setCenter(sceneBajaEmp);
        fxAtras.setVisible(true);
    }

    @FXML
    public void handleAltaProd(ActionEvent event) throws IOException {

        fxRoot.setCenter(sceneAltaProd);
        fxAtras.setVisible(true);
    }

    @FXML
    public void handleSceneTablas(ActionEvent event) throws IOException {
        controllerT.cargarDatosLista();
        fxRoot.setCenter(tabla);
        fxAtras.setVisible(true);
    }

    @FXML
    public void handleLogout(ActionEvent event) throws IOException {
        fxAtras.setVisible(false);
        fxMenu.setVisible(false);
        fxRoot.setCenter(sceneMenuAdmin);
    }

    @FXML
    public void handleAtras(ActionEvent event) throws IOException {
        fxAtras.setVisible(false);
        fxRoot.setCenter(sceneAdmin);

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO

            merchadona = new Merchadona();
            //Escena de Login
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(Constantes.PANTALLA_SCENE));
            sceneMenuAdmin = loader.load();
            FXMLSceneController controller = loader.getController();
            controller.setController(this);

            //Escena de alta empleados
            loader = new FXMLLoader(
                    getClass().getResource(Constantes.PANTALLA_ADMIN_ALTAEMP));
            sceneAltaEmp = loader.load();
            FXMLSceneAdminAltaEmpleado controllerAltaEmp = loader.getController();
            controllerAltaEmp.setController(this);

            //Escena de baja empleados
            loader = new FXMLLoader(
                    getClass().getResource(Constantes.PANTALLA_ADMIN_BAJAEMP));
            sceneBajaEmp = loader.load();
            FXMLSceneAdminBajaEmpleado controllerBajaEmp = loader.getController();
            controllerBajaEmp.setController(this);

            //Escena de alta de productos
            loader = new FXMLLoader(
                    getClass().getResource(Constantes.PANTALLA_ADMIN_ALTAPROD));
            sceneAltaProd = loader.load();
            FXMLSceneAdminAltaProducto controllerAltaProd = loader.getController();
            controllerAltaProd.setController(this);

            //Menu de admin
            loader = new FXMLLoader(
                    getClass().getResource(Constantes.PANTALLA_ADMIN));
            sceneAdmin = loader.load();
            FXMLSceneAdmin controllerAdmin = loader.getController();
            controllerAdmin.setController(this);

            //Escena de tablas
            loader = new FXMLLoader(
                    getClass().getResource(Constantes.PANTALLA_ADMIN_TABLAS));
            tabla = loader.load();
            controllerT = loader.getController();
            controllerT.setController(this);

            //Escena de reponer
            loader = new FXMLLoader(
                    getClass().getResource(Constantes.PANTALLA_REPONER));
            sceneReponer = loader.load();
            controllerR = loader.getController();
            controllerR.setController(this);

            //Escena de vender
            loader = new FXMLLoader(
                    getClass().getResource(Constantes.PANTALLA_VENDER));
            sceneVender = loader.load();
            controllerV = loader.getController();
            controllerV.setController(this);

        } catch (IOException ex) {
            Logger.getLogger(FXMLMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

        fxMenu.setVisible(false);
        fxRoot.setCenter(sceneMenuAdmin);

    }

    public MenuBar getFxMenu() {
        return fxMenu;
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

    public HostServices getHostServices() {
        return (HostServices) ((Stage) this.fxRoot.getScene().getWindow()).getProperties().get("hostServices");
    }

    public void habilitaMenuAdmin(int id) {
        empleadoID = id;
        fxMenu.setVisible(true);
        fxAtras.setVisible(false);
        fxRoot.setCenter(sceneAdmin);
    }

    public void habilitaMenuReponedor(int id) {
        empleadoID = id;
        fxMenu.setVisible(true);
        fxAtras.setVisible(false);
        fxRoot.setCenter(sceneReponer);
        controllerR.cargarLista();
    }

    public void habilitaMenuCajero(int id) {
        empleadoID = id;
        fxMenu.setVisible(true);
        fxAtras.setVisible(false);
        fxRoot.setCenter(sceneVender);
        controllerV.cargarLista();
    }
}
