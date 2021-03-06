/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dao.CrearModelo;
import dao.DBConnectionPool;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Los Prieto
 */
public class NewFXMain extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        CrearModelo x = new CrearModelo();
        x.crearModeloJDBC();
        
        FXMLLoader loaderMenu = new FXMLLoader(
                getClass().getResource("/fxml/MenuFXML.fxml"));
        BorderPane root = loaderMenu.load();

        Scene scene = new Scene(root);

        primaryStage.setTitle("Hello World!");
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
