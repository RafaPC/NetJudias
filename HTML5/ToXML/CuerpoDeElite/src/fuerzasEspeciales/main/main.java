package fuerzasEspeciales.main;

import fuerzasEspeciales.controlador.FuerEsp;
import java.io.File;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class main {

    public static void main(String[] args) {
        //variables
        int opc = -1;
        FuerEsp fp = cargar();
        Scanner s = new Scanner(System.in);

        while (opc != 0) {
            do {
                System.out.println("----------MENU----------");
                System.out.println("1. Crear mision.\n"
                        + "2. Resultado de mision..\n"
                        + "3. Poner Estres a 0.\n"
                        + "4. Leer misiones.\n"
                        + "0. Salir.");
                opc = s.nextInt();
                System.out.println();

                switch (opc) {
                    case 1:
                        fp.crearMision();
                        break;
                    case 2:
                        fp.resultadoMision();
                        break;
                    case 3:
                        fp.descansoRecursos();
                        break;
                    case 4:
                        fp.leerNombreMisiones();
                        break;
                    case 0:
                        System.out.println("Saliste con exito");
                        break;

                    default:
                        System.out.println("Opcion incorrecta");
                }
            } while (opc < 0 || opc > 3);
            guardar(fp);
        }

    }

    public static FuerEsp cargar() {
        FuerEsp z = null;
        try {

            JAXBContext jaxbContext
                    = JAXBContext.newInstance(FuerEsp.class);

            Unmarshaller um = jaxbContext.createUnmarshaller();
            z = (FuerEsp) um.unmarshal(new File("CuerpoElite.xml"));

        } catch (JAXBException ex) {
            z = new FuerEsp();
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return z;
    }

    public static void guardar(FuerEsp z) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(FuerEsp.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(z, new File("CuerpoElite.xml"));
        } catch (JAXBException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
