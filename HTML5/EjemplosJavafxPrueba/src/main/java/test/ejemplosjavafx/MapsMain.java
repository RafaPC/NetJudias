/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.ejemplosjavafx;

import controllers.FXMLMapsController;
import java.io.IOException;
import javafx.application.Application;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class MapsMain extends Application {

    private FXMLMapsController controller;

    @Override
    public void start(Stage primaryStage) throws IOException {
        //BorderPane root = FXMLLoader.load(getClass().getResource("/fxml/FXMLMenu.fxml"));
        FXMLLoader loaderMenu = new FXMLLoader(
                getClass().getResource("/fxml/FXMLMaps.fxml"));
        Parent root = loaderMenu.load();
        controller = loaderMenu.getController();
        controller.setStage(primaryStage);
        controller.setWindowListener();

        Scene scene = new Scene(root);

        primaryStage.setTitle("BUS");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
