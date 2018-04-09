/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import merchadona.modelo.Perecedero;
import merchadona.modelo.Producto;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLVender implements Initializable {

    private FXMLMenuController controller;

    @FXML
    private TextField fxCantidad;

    @FXML
    private TableView<Producto> fxTabla;

    ArrayList<Producto> temp = new ArrayList<>();

    @FXML
    private void handleReponer(ActionEvent event) throws IOException {
        Alert a = new Alert(Alert.AlertType.ERROR, "El numero no es valido", ButtonType.CLOSE);
        //final Stage stage = (Stage) fxUser.getScene().getWindow();
        //a.initOwner(stage);
        //a.showAndWait();
        int cantidad = 0;
        try {
            // mirar varaib le de login
            cantidad = Integer.parseInt(fxCantidad.getText());

            //Empleado emp = this.controller.getMerchadona().login(empleadoID);;
        } catch (Exception e) {
            a.setContentText("La cantidad no es un número");
            a.showAndWait();
        }
        Producto p = fxTabla.getSelectionModel().getSelectedItem();

        this.controller.getMerchadona().reponerProducto(this.controller.getEmpleadoID(), p, cantidad);
        fxCantidad.setText("");
    }

    @FXML
    private void handleAñadir(ActionEvent event) throws IOException {
        if (fxTabla.getSelectionModel().getSelectedItem() == null) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Tienes que seleccionar un producto", ButtonType.CLOSE);
            a.showAndWait();
        } else if (fxCantidad.getText() == null || fxCantidad.getText().trim().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Tienes que introducir un número", ButtonType.CLOSE);
            a.showAndWait();
        } else if (fxTabla.getSelectionModel().getSelectedItem().getStock() < Integer.parseInt(fxCantidad.getText())) {
            Alert a = new Alert(Alert.AlertType.ERROR, "No hay tanta cantidad disponible", ButtonType.CLOSE);
            a.showAndWait();
        } else {
            temp.add(new Producto(fxTabla.getSelectionModel().getSelectedItem().getNombre(), fxTabla.getSelectionModel().getSelectedItem().getPrecio_base(), Integer.parseInt(fxCantidad.getText())));

        }
        fxCantidad.setText("");
    }

    @FXML
    private void handleConfirmar(ActionEvent event) throws IOException {

        for (Producto temp1 : temp) {
            for (int i = 0; i < this.controller.getMerchadona().getProductos().size(); i++) {
                this.controller.getMerchadona().venderProducto(this.controller.getEmpleadoID(), temp1.getStock(), temp1);
                if (this.controller.getMerchadona().getProductos().get(i).getNombre().equals(temp1.getNombre())) {
                    this.controller.getMerchadona().getProductos().get(i).resStock(temp1.getStock());
                    i = this.controller.getMerchadona().getProductos().size();
                }
            }
        }
        temp.clear();
        cargarLista();
    }

    @FXML
    private void handleVaciarCesta(ActionEvent event) throws IOException {
        temp.clear();
        fxCantidad.setText("");
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        configTabla();
    }

    public void setController(FXMLMenuController controller) {
        this.controller = controller;
    }

    public void cargarLista() {
        fxTabla.getItems().clear();
        fxTabla.getItems().addAll(this.controller.getMerchadona().getProductos());
    }

    private void configTabla() {
        fxTabla.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("nombre"));
        fxTabla.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("stock"));
        fxTabla.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("precio_base"));
        TableColumn<Producto, LocalDateTime> caduca = new TableColumn<Producto, LocalDateTime>("Caduca");
        caduca.setCellValueFactory(new PropertyValueFactory<>("fecha_reposicion"));
        caduca.setCellFactory(column -> {
            return new TableCell<Producto, LocalDateTime>() {
                @Override
                protected void updateItem(LocalDateTime item, boolean empty) {
                    super.updateItem(item, empty);
                    DateTimeFormatter myDateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                    if (item == null || empty) {
                        setText(null);
                        setStyle("");
                    } else {
                        // Format date.
                        setText(myDateFormatter.format(item));

                        //setGraphic(new DatePicker());
                        // Style all dates in March with a different color.
                        if (getTableRow() != null && getTableRow().getItem() instanceof Perecedero) {
                            setTextFill(Color.CHOCOLATE);
                            setStyle("-fx-background-color: yellow");
                        } else {
                            setTextFill(Color.BLACK);
                            setText("no caduca");
                            setStyle("-fx-background-color: red");
                        }
                    }
                }
            };
        });

        fxTabla.getColumns().add(caduca);

    }
}
