/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nautilus.main.controllers;

import com.qoppa.pdfViewerFX.PDFViewer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLNautilusController implements Initializable {

    @FXML
    private ListView<Path> fxFiles;

    @FXML
    private Label fxRutaActual;

    @FXML
    private PDFViewer fxPdfViewer;

    private String rutaActual;

    private File fileCopiado;

    @FXML
    public void handleMouseClick(MouseEvent event) {
        if (event.getClickCount() > 1) {
            File seleccionado
                    = fxFiles.getSelectionModel().getSelectedItem().toFile();
            boolean b = Files.isReadable(Paths.get(seleccionado.getAbsolutePath()));
            if (b) {
                fxRutaActual.setText(seleccionado.getAbsolutePath());
                cargarFiles();
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "No puedes leer este directorio", ButtonType.CLOSE);
                a.showAndWait();
            }
        }

    }

    @FXML
    public void handleSubir(ActionEvent event) {

        File actual = new File(fxRutaActual.getText());

        fxRutaActual.setText(actual.getParent());
        cargarFiles();

    }

    @FXML
    public void handleEntrar(ActionEvent event) {

        File seleccionado
                = fxFiles.getSelectionModel().getSelectedItem().toFile();

        fxRutaActual.setText(seleccionado.getAbsolutePath());
        cargarFiles();

    }

    @FXML
    public void handleCopiar(ActionEvent event) throws FileNotFoundException, IOException {

        File seleccionado
                = fxFiles.getSelectionModel().getSelectedItem().toFile();

        if (seleccionado.isFile()) {

            InputStream inStream = null;
            OutputStream outStream = null;

            try {
                String rutaArchivo = seleccionado.getAbsolutePath();

                inStream = new FileInputStream(seleccionado);
                fileCopiado = new File(seleccionado.getName());
                outStream = new FileOutputStream(fileCopiado);

                byte[] buffer = new byte[1024];

                int length;
                //copy the file content in bytes 
                while ((length = inStream.read(buffer)) >0) {

                    outStream.write(buffer, 0, length);

                }

                inStream.close();
                outStream.close();

                System.out.println("File is copied successful!");

            } catch (IOException e) {
                e.printStackTrace();
                Alert a = new Alert(Alert.AlertType.ERROR, "Problemo", ButtonType.CLOSE);
                a.showAndWait();
            }
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR, "No puedes copiar un directorio", ButtonType.CLOSE);
                a.showAndWait();
        }
    }

    @FXML
    public void handlePegar(ActionEvent event) {
    
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rutaActual = "/";
        fxRutaActual.setText(rutaActual);
        fxFiles.setCellFactory(list -> new ListCell<Path>() {

            @Override
            protected void updateItem(Path item, boolean empty) {
                super.updateItem(item, empty);
                if (item != null) {
                    setText(item.getFileName().toString());
                    if (item.toFile().isDirectory()) {
                        setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/folder.png"))));
                        setStyle("-fx-text-fill:red;");

                    } else {
                        String nombre = item.getFileName().toString();

                        int primerpunto = nombre.indexOf('.');
                        int ultmopunto = nombre.lastIndexOf('.');

                        String extension = nombre.substring(ultmopunto + 1);
                        switch (extension) {
                            case "pdf":
                                setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/pdf.png"))));
                                break;
                            default:
                                setGraphic(null);

                        }

                        setStyle("-fx-text-fill:black;");
                    }
                } else {
                    setText("");
                    setGraphic(null);
                    setStyle("-fx-text-fill:black;-fx-background-color:white");
                }
            }
        });
        cargarFiles();

        // TODO
    }

    private void cargarFiles() {
        try {
            File f = new File(fxRutaActual.getText());
            fxFiles.getItems().clear();
            fxFiles.getItems().addAll(Files.list(Paths.get(fxRutaActual.getText())).collect(Collectors.toList()));
        } catch (IOException ex) {
            Logger.getLogger(FXMLNautilusController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
