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
    
    Configuration c = null;
    
    private void cargarRSS() {
        
        try {
            
            JAXBContext jaxbContext = JAXBContext.newInstance(Rss.class);
            
            Unmarshaller um = jaxbContext.createUnmarshaller();
            
            Configuration c = new Configuration();
            for (String url : c.getUrls()) {
                
                System.out.println(url);
                
                Rss p = (Rss) um.unmarshal(new URL(url));
                
                System.out.println(p.channel.getLink());
                
                String textoAcumulado = "";

                /*for (Item i : p.channel.getItem()) {
                    textoAcumulado = i.getTitle() + "\n";
                    textoAcumulado += i.mediaTitle + "\n";
                    textoAcumulado += "------------------\n";

                    System.out.println(i.getTitle());
                    System.out.println(i.mediaTitle);

                    if (i.thumbnail != null) {
                        System.out.println(i.thumbnail.url);
                        if (i.thumbnail.url != null) {
                            fxImagenView.setImage(new Image(i.thumbnail.url));
                            System.out.println("pene");
                        }
                    }
                    System.out.println("----------------------");
                    fxCosaArea.setText(textoAcumulado);

                }*/
                //for (int i = 0; i<p.channel.getItem().size();i++){
                //Item temp = new Item(p.channel.getItem().get(i));
                textoAcumulado = p.channel.getItem().get(numNoticia).getTitle() + "\n";
                textoAcumulado += p.channel.getItem().get(numNoticia).mediaTitle + "\n";
                textoAcumulado += "------------------\n";
                
                System.out.println(p.channel.getItem().get(numNoticia).getTitle());
                System.out.println(p.channel.getItem().get(numNoticia).mediaTitle);
                
                if (p.channel.getItem().get(numNoticia).thumbnail != null) {
                    System.out.println(p.channel.getItem().get(numNoticia).thumbnail);
                    if (p.channel.getItem().get(numNoticia).thumbnail.url != null) {
                        fxImagenView.setImage(new Image(p.channel.getItem().get(numNoticia).thumbnail.url));
                        System.out.println("pene");
                    } else {
                        fxImagenView.setImage(null);
                    }
                }
                System.out.println("----------------------");
                fxCosaArea.setText(textoAcumulado);
                
            }
        } catch (JAXBException ex) {
            Logger.getLogger(TestRss.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(TestRss.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @FXML
    public void handleNoticiaAnterior(ActionEvent event) {
        numNoticia--;
        cargarRSS();
    }
    
    @FXML
    public void handleNoticiaSiguiente(ActionEvent event) {
        if(numNoticia == ){
            
        }
        numNoticia++;
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
        fxCosaArea.setEditable(false);
        cargarRSS();
    }
    
}
