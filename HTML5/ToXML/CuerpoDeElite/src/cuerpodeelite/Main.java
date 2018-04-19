/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuerpodeelite;

import java.io.File;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author daw
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        CuerpoDeElite body = cargar();
        int opcion;
        do {
            System.out.println("1.- Crear misión"
                    + "\n2.- Relajar soldados"
                    + "\n3.- Lista de misiones"
                    + "\n4.- Lista de recursos"
                    + "\n8.- Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    body.crearMision();
                    break;
                case 2:
                    body.bajarStress();
                    break;
                case 3:
                    body.listadoMisiones();
                    break;
                case 4:
                    body.listadoRecursos();
                    break;
            }
        } while (opcion != 8);
        guardar(body);
                
    }

    public static CuerpoDeElite cargar() {
        CuerpoDeElite body = null;
        try {

            JAXBContext jaxbContext
                    = JAXBContext.newInstance(CuerpoDeElite.class);

            Unmarshaller um = jaxbContext.createUnmarshaller();
            body = (CuerpoDeElite) um.unmarshal(new File("cuerpodeelite.xml"));

        } catch (JAXBException ex) {
            body = new CuerpoDeElite();
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return body;
    }

    public static void guardar(CuerpoDeElite body) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(CuerpoDeElite.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(body, new File("cuerpodeelite.xml"));
        } catch (JAXBException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
