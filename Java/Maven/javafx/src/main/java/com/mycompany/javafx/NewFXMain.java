/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javafx;

import fx.FXMLMenuController;
import fx.FXMLSceneController;
import fx.constantes.Constantes;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage stage) throws IOException {
        //BorderPane root = FXMLLoader.load(getClass().getResource("/fxml/FXMLMenu.fxml"));
        FXMLLoader loaderMenu = new FXMLLoader(
          getClass().getResource(Constantes.PANTALLA_MENU));
        BorderPane root = loaderMenu.load();
        FXMLMenuController menuController = loaderMenu.getController();   
               
        
        AnchorPane anchor;
                    //load up OTHER FXML document
        FXMLLoader loader = new FXMLLoader(
          getClass().getResource(Constantes.PANTALLA_SCENE));
        anchor = loader.load();
        FXMLSceneController controller = loader.getController();
        controller.setController(menuController);
        
        root.setCenter(anchor);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/fxmlscene.css");
        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
