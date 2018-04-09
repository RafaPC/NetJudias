/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import merchadona.modelo.Empleado;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLSceneController implements Initializable {

    private FXMLMenuController controller;

    @FXML
    private TextField fxUser;

    @FXML
    ImageView fxImage;

    @FXML
    private void handleLoginAction(ActionEvent event) throws IOException {

        Alert a = new Alert(Alert.AlertType.ERROR, "El numero no es valido", ButtonType.CLOSE);
        //final Stage stage = (Stage) fxUser.getScene().getWindow();
        //a.initOwner(stage);
        //a.showAndWait();
        try {
            // mirar varaib le de login
            if (fxUser.getText() == null || fxUser.getText().trim().isEmpty()) {
            Alert b = new Alert(Alert.AlertType.ERROR, "Tienes que introducir una ID", ButtonType.CLOSE);
            b.showAndWait();
        }
            
            int empleadoID = Integer.parseInt(fxUser.getText());

            //Empleado emp = this.controller.getMerchadona().login(empleadoID);
            switch (this.controller.getMerchadona().tipoEmpleado(empleadoID)) {
                case 1:
                    this.controller.habilitaMenuAdmin(empleadoID);
                    break;
                case 2:
                    this.controller.habilitaMenuReponedor(empleadoID);
                    break;
                case 3:
                    this.controller.habilitaMenuCajero(empleadoID);
                   break;
                case 0:
                    a.setContentText("Id de usuario no valido");
                    a.showAndWait();
                break;
            }

        } catch (Exception e) {
            a.setContentText("El id no es un número");
            a.showAndWait();
        }
//         FadeTransition ft = new FadeTransition(Duration.millis(5000), fxUser);
//    ft.setFromValue(1.0);
//    ft.setToValue(0.0);
//    ft.play();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        Image image
          = new Image(getClass().getResourceAsStream("/images/image.jpeg"));

        fxImage.setImage(image);
    }

    public void setController(FXMLMenuController controller) {
        this.controller = controller;
    }

}
