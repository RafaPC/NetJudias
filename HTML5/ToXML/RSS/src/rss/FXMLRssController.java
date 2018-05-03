/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rss;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLRssController implements Initializable {

    public HostServices hostServices;

    @FXML
    private TextArea fxCosaArea;

    @FXML
    private ImageView fxImagenView;

    @FXML
    private FlowPane fxFlowPane;

    private int numNoticia = 0;
    
    private int tamañoNoticias;

    Configuration c = null;

    private void cargarRSS() {

        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(Rss.class);

            Unmarshaller um = jaxbContext.createUnmarshaller();

            Configuration c = new Configuration();
            for (String url : c.getUrls()) {

                //System.out.println(url);

                Rss p = (Rss) um.unmarshal(new URL(url));

                //Esto irá cambiando si tenemos varias url's
                tamañoNoticias = p.channel.getItem().size();
                
                //System.out.println(p.channel.getLink());

                
                String textoTotal = "";

                textoTotal = p.channel.getItem().get(numNoticia).getTitle() + "\n";
                textoTotal += p.channel.getItem().get(numNoticia).mediaTitle + "\n";
                textoTotal += "------------------\n";

                

                if (p.channel.getItem().get(numNoticia).thumbnail != null) {
                    //System.out.println(p.channel.getItem().get(numNoticia).thumbnail);
                    if (p.channel.getItem().get(numNoticia).thumbnail.url != null) {
                        fxImagenView.setImage(new Image(p.channel.getItem().get(numNoticia).thumbnail.url));
                    } else {
                        fxImagenView.setImage(null);
                    }
                }
                fxCosaArea.setText(textoTotal);

            }
        } catch (JAXBException ex) {
            Logger.getLogger(TestRss.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(TestRss.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void handleNoticiaAnterior(ActionEvent event) {
        if(numNoticia == 0){
            numNoticia = tamañoNoticias -1;
        }else{
          numNoticia--;  
        }
        cargarRSS();
    }

    @FXML
    public void handleNoticiaSiguiente(ActionEvent event) {
        numNoticia++;
        numNoticia %= tamañoNoticias;      
        cargarRSS();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        c = new Configuration();
        // TODO
        Button but = new Button("testing");
        but.setOnAction(click -> {
            this.hostServices.showDocument("http://www.marca.es");
        });
        cargarRSS();
    }

}
