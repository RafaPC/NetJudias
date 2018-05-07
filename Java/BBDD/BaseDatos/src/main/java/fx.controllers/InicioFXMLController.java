/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class InicioFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private AnchorPane fxRoot;
    
    @FXML
    private TextField fxNombre;
    
    @FXML
    private TextField fxEdad;
    
    @FXML
    private ListView fxListAlumnos;
    
    
    @FXML
    public void handleInsert(ActionEvent event){
        
    }
    
    @FXML
    public void handleUpdate(ActionEvent event){
        
    }
    
    @FXML
    public void handleDelete(ActionEvent event){
        
    }
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
