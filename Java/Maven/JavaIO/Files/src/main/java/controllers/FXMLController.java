/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class FXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Integer number;
    private int anterior;
    
    @FXML
    private Button fxBotonHola;
    
    @FXML
    private void sumarFibonacci(ActionEvent event) throws IOException{
        number = number + anterior;
        anterior = number - anterior;
        fxBotonHola.setText(number.toString());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        number = 1;
        anterior = 0;
        //File f = "/";
        
    }    
    
}
