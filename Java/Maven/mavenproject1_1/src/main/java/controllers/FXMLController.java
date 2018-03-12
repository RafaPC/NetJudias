/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
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
    List<Cliente> clientes;
    private int indice;

    @FXML
    private Label fxUser;

    @FXML
    private Label fxEdad;

    @FXML
    private void mostrarCliente() throws IOException {
        fxUser.setText(clientes.get(indice).getNombre());
        fxEdad.setText(clientes.get(indice).getEdad() + "");
    }

    @FXML
    private void derecha(ActionEvent event) throws IOException {
        if (indice == clientes.size()) {
            indice = 0;
        } else {
            indice++;
        }
        this.mostrarCliente();
    }

    @FXML
    private void izquierda(ActionEvent event) throws IOException {
        if (indice == 0) {
            indice = clientes.size();
        } else {
            indice--;
        }
        this.mostrarCliente();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clientes = new LinkedList<>();
        indice = 0;
        clientes.add(new Cliente("Kiko", 18));
        clientes.add(new Cliente("Andrea", 20));
        clientes.add(new Cliente("Yáñez", 18));
        fxUser.setText(clientes.get(indice).getNombre());
    }

}
