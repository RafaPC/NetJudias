/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nautilus.main.controllers;

//import com.qoppa.pdfViewerFX.PDFViewer;
import com.qoppa.pdfViewerFX.PDFViewer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
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
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javax.activation.MimetypesFileTypeMap;
import javax.imageio.ImageIO;
import com.qoppa.pdf.PDFException;
import com.qoppa.pdfViewerFX.PDFViewer;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLNautilusController implements Initializable {

    private AnchorPane sceneLeerFichero;

    @FXML
    private ListView<Path> fxFiles;

    @FXML
    private Label fxRutaActual;

    @FXML
    private PDFViewer fxPdfViewer;

    @FXML
    private TextArea fxReader;

    @FXML
    private Button fxBotonSalirFichero;

    @FXML
    private ImageView fxImagen;


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
                if (seleccionado.isFile()) {

                    String nombre = seleccionado.getName();

                    int primerpunto = nombre.indexOf('.');
                    int ultmopunto = nombre.lastIndexOf('.');

                    String extension = nombre.substring(ultmopunto + 1);
                    if (extension.equalsIgnoreCase("pdf")) {
                        verPDF(seleccionado);
                    } else {
                        String mimetype = new MimetypesFileTypeMap().getContentType(seleccionado);
                        String type = mimetype.split("/")[0];
                        if (type.equals("image")) {
                            verImagen(seleccionado);
                        } else {
                            leerFichero(seleccionado);
                        }
                    }
                } else {
                    fxRutaActual.setText(seleccionado.getAbsolutePath());
                    cargarFiles();
                }
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
    public void handleCopiar(ActionEvent event) throws FileNotFoundException, IOException {
        rutaCopiado = fxFiles.getSelectionModel().getSelectedItem().toFile().getAbsolutePath();

        if (fxFiles.getSelectionModel().getSelectedItem().toFile().isFile()) {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Fichero copiado ", ButtonType.CLOSE);
            a.showAndWait();

        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "No puedes copiar directorios", ButtonType.CLOSE);
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
        File file = new File(fxRutaActual.getText() + "\\" + newNombre + ".txt");
        cargarFiles();
    }
    @FXML
    public void handleBorrarFichero(ActionEvent event){
        if(fxFiles.getSelectionModel().getSelectedItem().toFile().isFile()){
            boolean borrado = new File(fxFiles.getSelectionModel().getSelectedItem().toFile().getAbsolutePath()).delete();
            if (borrado) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Fichero borrado", ButtonType.CLOSE);
            a.showAndWait();
            }else{
               Alert a = new Alert(Alert.AlertType.ERROR, "Error al borrar", ButtonType.CLOSE);
            a.showAndWait(); 
            }
            cargarFiles();
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR, "No puedes borrar directorios", ButtonType.CLOSE);
            a.showAndWait(); 
        }
    }
    public void leerFichero(File fichero) {
        BufferedReader br = null;
        FileReader fr = null;
        String textoCompleto = "";
        try {

            //br = new BufferedReader(new FileReader(FILENAME));
            fr = new FileReader(fichero.getAbsolutePath());
            br = new BufferedReader(fr);

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                textoCompleto += sCurrentLine + "\n";
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null) {
                    br.close();
                }

                if (fr != null) {
                    fr.close();
                }

            } catch (IOException ex) {

                ex.printStackTrace();

            }
            fxFiles.setVisible(false);
            fxReader.setVisible(true);
            fxReader.setText(textoCompleto);
            fxBotonSalirFichero.setVisible(true);
        }
    }

    public void verImagen(File imagen) {
        Image image = new Image(imagen.toURI().toString());
        fxImagen.setImage(image);
        fxImagen.setVisible(true);
        fxFiles.setVisible(false);
        fxBotonSalirFichero.setVisible(true);
    }

    public void verPDF(File fichero) {
        try {

            fxPdfViewer.setVisible(true);
            fxPdfViewer.loadPDF(new FileInputStream(fichero.getAbsolutePath()));
            fxPdfViewer.getToolBar().getOpenDoc().setVisible(true);

        } catch (PDFException ex) {
            Logger.getLogger(FXMLViewPdfController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLViewPdfController.class.getName()).log(Level.SEVERE, null, ex);
        }

        fxFiles.setVisible(false);
        fxBotonSalirFichero.setVisible(true);
    }

    @FXML
    public void handleSalirFichero(ActionEvent event) {
        fxPdfViewer.setVisible(false);
        fxReader.setVisible(false);
        fxImagen.setVisible(false);
        fxBotonSalirFichero.setVisible(false);
        fxFiles.setVisible(true);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
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
                            case "jpg":
                                ImageView x = new ImageView(item.toUri().toString());
                                x.setFitWidth(24);
                                x.setFitHeight(24);
                                setGraphic(x);
                                break;
                            case "png":
                                ImageView j = new ImageView(item.toUri().toString());
                                j.setFitWidth(24);
                                j.setFitHeight(24);
                                setGraphic(j);
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
