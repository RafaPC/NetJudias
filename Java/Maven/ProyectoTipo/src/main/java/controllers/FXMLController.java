/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class FXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    List<Cliente> clientes;
    private int indice;
    
    
    @FXML
    private TextField fxUser;
    @FXML
    private Button fxBotonNormal;
    
    @FXML
    private void sumarFibonacci(ActionEvent event) throws IOException{
        
    }
    @FXML
    private void derecha(ActionEvent event) throws IOException{
        indice++;
    }
    @FXML
    private void izquierda(ActionEvent event) throws IOException{
        indice--;
    }
    @FXML
    private void otraFuncion(ActionEvent event) throws IOException{
        
        number = number + anterior;
        anterior = number - anterior;
        fxBotonHola.setText(number.toString());
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
