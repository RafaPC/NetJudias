/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.Cliente;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class FXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    ArrayList<Cliente> clientes;

    private int indice;

    @FXML
    private TextField fxUser;

    @FXML
    private TextField fxEdad;
    
    //@FXML
    //private Button fxNew;

    @FXML
    private Button fxbotonSiguiente;

    @FXML
    private Button fxbotonAnterior;

    private void mirarIndice(){
        if(indice == clientes.size()-1){
            fxbotonSiguiente.setDisable(true);
        }else if(indice == 0){
            fxbotonAnterior.setDisable(true);
        }else{
            fxbotonAnterior.setDisable(false);
            fxbotonSiguiente.setDisable(false);
        }
    }
    private void mostrarCliente() throws IOException {
        fxUser.setText(clientes.get(indice).getNombre());
        fxEdad.setText(clientes.get(indice).getEdad() + "");
        System.out.println("------------------------------\n" + indice + "\n---------------------------");
    }
    @FXML
    private void crearCliente() throws IOException{
        Integer edad = Integer.parseInt(fxEdad.getText());
        clientes.add(new Cliente(fxUser.getText(),edad));
    }
    @FXML
    private void derecha(ActionEvent event) throws IOException {
      
            indice++;
            mirarIndice();
        
        System.out.println("------------------------------\n" + indice + "\n---------------------------");
        mostrarCliente();
    }

    @FXML
    private void izquierda(ActionEvent event) throws IOException {
        indice--;
            mirarIndice();
        System.out.println("------------------------------\n" + indice + "\n---------------------------");
        mostrarCliente();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clientes = new ArrayList<>();
        indice = 0;
        clientes.add(new Cliente("Kiko", 18));
        clientes.add(new Cliente("Andrea", 20));
        clientes.add(new Cliente("Yáñez", 18));
        fxUser.setText(clientes.get(indice).getNombre());
        fxEdad.setText(clientes.get(indice).getEdad() + "");
        fxbotonAnterior.setDisable(true);
        System.out.println("------------------------------\n" + indice + "\n---------------------------");
    }

}
