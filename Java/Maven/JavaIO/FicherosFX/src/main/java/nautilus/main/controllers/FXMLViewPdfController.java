/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nautilus.main.controllers;

//import com.qoppa.pdf.PDFException;
//import com.qoppa.pdf.source.PDFSource;
//import com.qoppa.pdfViewerFX.PDFViewer;
//import com.qoppa.pdf.PDFException;
//import com.qoppa.pdfViewerFX.PDFViewer;
import com.qoppa.pdf.PDFException;
import com.qoppa.pdfViewerFX.PDFViewer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import org.jpedal.examples.baseviewer.BaseViewerFX;
import org.jpedal.examples.viewer.Commands;
import org.jpedal.examples.viewer.OpenViewerFX;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLViewPdfController implements Initializable {

    @FXML
    AnchorPane fxRoot;

    @FXML
    private PDFViewer fxPdfViewer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {

            fxPdfViewer.loadPDF(new FileInputStream("Entrega2.3.pdf"));
          
            fxPdfViewer.getToolBar().getOpenDoc().setVisible(false);
        } catch (PDFException ex) {
            Logger.getLogger(FXMLViewPdfController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLViewPdfController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
