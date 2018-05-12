/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.AsignaturaDAO;
import dao.ConexionSimpleBD;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Asignatura;
import servicios.AsignaturaService;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class AsignaturasFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private MenuFXMLController controller;

    private AsignaturaService conex;

    @FXML
    private AnchorPane fxRoot;

    @FXML
    private TextField fxNombre;

    @FXML
    private TextField fxCurso;

    @FXML
    private TextField fxCiclo;

    @FXML
    private ListView<Asignatura> fxListAsignaturas;

    @FXML
    public void handleMouseClick(MouseEvent event) {
        Asignatura seleccionado = fxListAsignaturas.getSelectionModel().getSelectedItem();

        fxNombre.setText(seleccionado.getNombre());
        fxCurso.setText(seleccionado.getCurso());
        fxCiclo.setText(seleccionado.getCiclo());

    }

    @FXML
    public void handleInsert(ActionEvent event) {

        boolean ok = true;

        if (fxNombre.getText() == null) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Tienes que rellenar el nombre", ButtonType.CLOSE);
            a.showAndWait();
            ok = false;
        } else if (fxCurso.getText() == null) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Tienes que rellenar el curso", ButtonType.CLOSE);
            a.showAndWait();
            ok = false;
        } else if (fxCiclo.getText() == null) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Tienes que rellenar el nombre", ButtonType.CLOSE);
            a.showAndWait();
            ok = false;
        }

        if (ok) {
            Asignatura a = new Asignatura(fxNombre.getText(), fxCurso.getText(), fxCiclo.getText());
            if (conex.insertAsignatura(a)) {
                fxListAsignaturas.getItems().add(a);
                Alert b = new Alert(Alert.AlertType.INFORMATION, "Asignatura creada correctamente", ButtonType.CLOSE);
                b.showAndWait();
                fxListAsignaturas.refresh();
            } else {
                Alert b = new Alert(Alert.AlertType.INFORMATION, "Ha ocurrido un problema al crear la asignatura", ButtonType.CLOSE);
                b.showAndWait();
            }
        }
        clearCampos();
    }

    @FXML
    public void handleUpdate(ActionEvent event) {
        boolean ok = true;
        if (fxListAsignaturas.getSelectionModel().getSelectedItem() == null) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Tienes que seleccionar una asignatura", ButtonType.CLOSE);
            a.showAndWait();
        } else {
            if (fxNombre.getText().trim().length() == 0) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Tienes que rellenar el nombre", ButtonType.CLOSE);
                a.showAndWait();
                ok = false;
            }
            if (fxCurso.getText().trim().length() == 0) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Tienes que rellenar el curso", ButtonType.CLOSE);
                a.showAndWait();
                ok = false;
            }
            if (fxCiclo.getText().trim().length() == 0) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Tienes que rellenar el ciclo", ButtonType.CLOSE);
                a.showAndWait();
                ok = false;
            }
            if (ok) {
                String nombre = fxNombre.getText();
                String curso = fxCurso.getText();
                String ciclo = fxCiclo.getText();

                Asignatura original = fxListAsignaturas.getSelectionModel().getSelectedItem();

                Asignatura a = new Asignatura(nombre, curso, ciclo);
                a.setId(fxListAsignaturas.getSelectionModel().getSelectedItem().getId());

                if (conex.updateAsignatura(a)) {

                    fxListAsignaturas.getItems().set(fxListAsignaturas.getItems().indexOf(original), a);
                    Alert b = new Alert(Alert.AlertType.INFORMATION, "Asignatura actualizada correctamente", ButtonType.CLOSE);
                    b.showAndWait();
                    fxListAsignaturas.refresh();
                } else {
                    Alert b = new Alert(Alert.AlertType.ERROR, "Ha ocurrido un problema al actualizar la asignatura", ButtonType.CLOSE);
                    b.showAndWait();
                }
            }
        }
        clearCampos();
    }

    @FXML
    public void handleDelete(ActionEvent event) {
        if (fxListAsignaturas.getSelectionModel().getSelectedItem() == null) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Tienes que seleccionar una asignatura", ButtonType.CLOSE);
            a.showAndWait();
        } else {
            Asignatura a = fxListAsignaturas.getSelectionModel().getSelectedItem();
            long id = a.getId();
            if (conex.deleteAsignatura(id)) {
                fxListAsignaturas.getItems().remove(a);
                Alert b = new Alert(Alert.AlertType.INFORMATION, "Asignatura borrada correctamente", ButtonType.CLOSE);
                b.showAndWait();
                fxListAsignaturas.refresh();
            } else {
                Alert b = new Alert(Alert.AlertType.ERROR, "Ha ocurrido un problema al borrar la asignatura", ButtonType.CLOSE);
                b.showAndWait();
            }
        }
        clearCampos();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ConexionSimpleBD c = new ConexionSimpleBD();
        conex = new AsignaturaService();
        cargarDatosLista();
    }

    public void cargarDatosLista() {

        fxListAsignaturas.getItems().clear();
        fxListAsignaturas.getItems().addAll(
                conex.getAllAsignaturas());
    }

    private void clearCampos() {
        fxNombre.setText("");
        fxCurso.setText("");
        fxCiclo.setText("");
    }

    public void setController(MenuFXMLController controller) {
        this.controller = controller;
    }

}
