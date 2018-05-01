/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nautilus.main.controllers;

//import com.qoppa.pdfViewerFX.PDFViewer;
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
import java.util.Optional;
import javafx.scene.control.TextInputDialog;

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
    //private PDFViewer fxPdfViewer;

    private String rutaActual;

    private File fileCopiado;

    private String rutaCopiado;

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
        File seleccionado = new File(rutaCopiado);
        if (seleccionado.isFile()) {
            rutaCopiado = fxFiles.getSelectionModel().getSelectedItem().toFile().getAbsolutePath();

            Alert a = new Alert(Alert.AlertType.INFORMATION, "Fichero copiado ", ButtonType.CLOSE);
            a.showAndWait();

        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Error al copiar", ButtonType.CLOSE);
            a.showAndWait();
        }
    }

    @FXML
    public void handlePegar(ActionEvent event) {

        InputStream inStream = null;
        OutputStream outStream = null;

        try {
            File seleccionado = new File(rutaCopiado);
            String nombreFichero = seleccionado.getName();

            inStream = new FileInputStream(seleccionado);
            outStream = new FileOutputStream(new File(fxRutaActual.getText() + "\\" + nombreFichero));
            byte[] buffer = new byte[1024];

            int length;
            //copy the file content in bytes 
            while ((length = inStream.read(buffer)) > 0) {

                outStream.write(buffer, 0, length);

            }

            inStream.close();
            outStream.close();

            Alert a = new Alert(Alert.AlertType.INFORMATION, "Fichero pegado ", ButtonType.CLOSE);
            a.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR, "Problemo", ButtonType.CLOSE);
            a.showAndWait();
        }
        cargarFiles();
    }

    @FXML
    public void handleCambiarNombre(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Renombrar");
        dialog.setContentText("");
        dialog.setHeaderText("Nombre nuevo");
        Optional<String> result = dialog.showAndWait();
        String newNombre = "";
        //String extension = fxFiles.getSelectionModel().getSelectedItem().getFileName().get        
        if (result.isPresent()) {
            newNombre = result.get();
        }
        File x = new File(fxRutaActual.getText() + "\\" + newNombre);
        fxFiles.getSelectionModel().getSelectedItem().toFile().renameTo(x);
        cargarFiles();
    }
    
    @FXML
    public void handleCrearFichero(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Crear fichero");
        dialog.setContentText("");
        dialog.setHeaderText("Nombre");
        Optional<String> result = dialog.showAndWait();
        String newNombre = "";
        //String extension = fxFiles.getSelectionModel().getSelectedItem().getFileName().get        
        if (result.isPresent()) {
            newNombre = result.get();
        }
        File xm = new File(fxRutaActual.getText() + "\\" + newNombre);
        cargarFiles();
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
