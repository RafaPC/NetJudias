package fuerzasEspeciales.controlador;

import fuerzasEspeciales.modelo.Arma;
import fuerzasEspeciales.modelo.Equipo;
import fuerzasEspeciales.modelo.Humano;
import fuerzasEspeciales.modelo.Material;
import fuerzasEspeciales.modelo.Mision;
import fuerzasEspeciales.modelo.MisionCombate;
import fuerzasEspeciales.modelo.RecursoMilitar;
import fuerzasEspeciales.modelo.RecursoUso;
import fuerzasEspeciales.modelo.Vehiculo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "FuerEsp")
public class FuerEsp {

    //variables
    Scanner s = new Scanner(System.in);
    @XmlElementWrapper(name = "recursos")
    @XmlElements({
        @XmlElement(name = "humano", type = Humano.class)
        ,
        @XmlElement(name = "vehiculo", type = Vehiculo.class)
        ,
        @XmlElement(name = "arma", type = Arma.class)
        ,
        @XmlElement(name = "equipo", type = Equipo.class)
    })
    protected ArrayList<RecursoMilitar> recursos;
    @XmlElementWrapper(name = "misiones")
    @XmlElements({
        @XmlElement(name = "mision_reconocimiento", type = Mision.class)
        ,
        @XmlElement(name = "mision_combate", type = MisionCombate.class)
    })
    protected Map<String, Mision> misiones;

    public FuerEsp() {
        recursos = new ArrayList<>();
        misiones = new LinkedHashMap<>();

        //recursos
        //humanos
        //(int potenciaMuerte, String nombre,int nvlEstres,int muertesCuchillo,int nvlHabilidadManejo,int nvlExperiencia) 
        Humano a = new Humano(9, "juan", 2, 4, 5, 18);
        Humano b = new Humano(7, "pedro", 4, 5, 7, 20);
        Humano c = new Humano(8, "luis", 5, 4, 13, 12);
        Humano d = new Humano(4, "jaime", 21, 10, 15, 11);
        Humano e = new Humano(10, "victor", 9, 14, 9, 14);
        Humano f = new Humano(6, "roberto", 8, 15, 11, 17);
        recursos.add(a);
        recursos.add(b);
        recursos.add(c);
        recursos.add(d);
        recursos.add(e);
        recursos.add(f);
        //armas
        Material a1 = new Arma(9, "pistola", 9, 9);
        Material b1 = new Arma(11, "subfusil", 10, 19);
        Material c1 = new Arma(20, "francotirador", 19, 39);
        Material d1 = new Arma(25, "sentex", 14, 20);
        Material e1 = new Arma(28, "c4", 18, 20);
        Material f1 = new Arma(14, "fusil", 11, 22);
        recursos.add(a1);
        recursos.add(b1);
        recursos.add(c1);
        recursos.add(d1);
        recursos.add(e1);
        recursos.add(f1);
        //equipos 
        Material a2 = new Equipo(0, "vendas", 2, 0);
        Material b2 = new Equipo(0, "medicamentos", 6, 0);
        Material c2 = new Equipo(0, "uniformes", 2, 9);
        Material d2 = new Equipo(0, "cascos", 2, 0);
        Material e2 = new Equipo(0, "chalecos", 2, 0);
        Material f2 = new Equipo(0, "botas", 2, 0);
        recursos.add(a2);
        recursos.add(b2);
        recursos.add(c2);
        recursos.add(d2);
        recursos.add(e2);
        recursos.add(f2);
        //vehiculos
        Material a3 = new Vehiculo(40, "tanque", 16, 18, 6);
        Material b3 = new Vehiculo(19, "moto", 6, 11, 2);
        Material c3 = new Vehiculo(22, "coche", 5, 10, 4);
        Material d3 = new Vehiculo(38, "avion", 15, 23, 15);
        Material e3 = new Vehiculo(15, "remolque", 6, 13, 4);
        Material f3 = new Vehiculo(23, "barco", 14, 24, 17);
        recursos.add(a3);
        recursos.add(b3);
        recursos.add(c3);
        recursos.add(d3);
        recursos.add(e3);
        recursos.add(f3);

    }

    public void crearMision() {
        //variables
        int opc, exp, dia, mes;
        Mision temp;
        String nombre, localizacion;
        LocalDate fechaMision;
        //tipo de mision
        do {
            System.out.println("Indica que tipo de mision es.\n"
                    + "1. Reconocimiento.\n"
                    + "2. Combate");
            opc = s.nextInt();
            s.nextLine();
        } while (opc > 2 || opc < 1);
        //datos de mision
        System.out.println("Nombre de la mision.");
        nombre = s.nextLine().toLowerCase();
        System.out.println("Lugar de la mision.");
        localizacion = s.nextLine().toLowerCase();
        System.out.println("Expeciencia que se gana en la misión.");
        exp = s.nextInt();
        s.nextLine();
        System.out.println("Dia de la mision.");
        dia = s.nextInt();
        s.nextLine();
        System.out.println("Mes de la mision.");
        mes = s.nextInt();
        //fecha
        fechaMision = LocalDate.of(2018, mes, dia);

        switch (opc) {
            case 1:
                misionReconocimiento(nombre, localizacion, fechaMision, exp);
                break;
            case 2:
                misionCombate(nombre, localizacion, fechaMision, exp);
                break;
            default:
                System.out.println("Error.");
        }
        leerNombreMisiones();

    }

    public void resultadoMision() {
        String nombre;
        Mision tempResul;
        int exito, exp;
        //pedir mision
        System.out.println("Escribe el nombre de la mision.");
        nombre = s.nextLine().toLowerCase();
        //encontrar y asignar mision
        tempResul = misiones.get(nombre);
        System.out.println("Mision:" + tempResul.getNombre());

        //sacar exp
        exp = tempResul.getNivelExperienciaGanar();
        do {
            System.out.println("¿La mision fue un exito?\n"
                    + "1. Si.\n"
                    + "2. No.");
            exito = s.nextInt();
            s.nextLine();
        } while (exito > 2 || exito < 1);
        switch (exito) {
            case 1:
                misionExito(tempResul, exp);

                break;
            case 2:
                misionFracaso(tempResul, exp);

                break;
            default:
        }

        tempResul.addMision(tempResul);
    }

    //********************************************************************************************************
    public void misionReconocimiento(String nombre, String lugar, LocalDate fecha, int exp) {
        //variables
        Humano humanoTemp;
        Mision temp = new Mision(fecha, lugar, nombre, exp);
        int numVehiculos = 0;
        //pedir tipo recurso y añadir recursos
        tipoRecurso(temp);

        recursosNoRepetidos();
        //verificar que se cumplen las condiciones

        if (temp.nivelEstres() || !temp.vehiculoMinimo() || !temp.personasPorVehiculo()) {

            System.out.println("Los recursos no cumplen algunas de las condiciones. La mision"
                    + "no se puede realizar porque seria un fracaso..");
        } else {
            misiones.put(nombre, temp);
            System.out.println("Se añadio la mision:" + misiones.get(nombre).getNombre() + " de tipo reconocimiento");
        }
    }

    public void misionCombate(String nombre, String lugar, LocalDate fecha, int exp) {
        //pedir potencia de fuego.
        System.out.println("Indica el nivel minimo de potencia necesario");
        int nvlPotenciaMinimo = s.nextInt();
        s.nextLine();
        int numVehiculos = 0;
        Mision temp = new MisionCombate(fecha, lugar, nombre, exp, nvlPotenciaMinimo);

        //pedir tipo recurso y añadir recursos
        tipoRecurso(temp);
        recursosNoRepetidos();
        //verificar que se cumplen las condiciones
        if (temp.nivelEstres() || !temp.vehiculoMinimo() || !temp.personasPorVehiculo() || temp.fuerzaMinima(temp, nvlPotenciaMinimo)) {

            System.out.println("Los recursos no cumplen algunas de las condiciones. La mision"
                    + "no se puede realizar porque seria un fracaso..");
        } else {
            misiones.put(nombre, temp);
            System.out.println("Se añadio la mision:" + misiones.get(nombre).getNombre() + " de tipo reconocimiento");
        }
    }

    public void tipoRecurso(Mision temp) {
        int elegir;
        do {
            System.out.println("");
            System.out.println("Indique que tipo de recurso desea añadir:\n"
                    + "1. Recurso humano.\n"
                    + "2. Arma.\n"
                    + "3. Equipo.\n"
                    + "4. Vehiculo.\n"
                    + "0. No insertar mas recursos. ");
            elegir = s.nextInt();
            s.nextLine();
            switch (elegir) {
                case 1:
                    añadirRecurso(elegir, temp);
                    break;
                case 2:
                    añadirRecurso(elegir, temp);
                    break;
                case 3:
                    añadirRecurso(elegir, temp);
                    break;
                case 4:
                    añadirRecurso(elegir, temp);
                    break;
                case 0:

                    break;
                default:
                    System.out.println("error");

            }
        } while (elegir != 0);

    }

    public void añadirRecurso(int tipo, Mision temp) {
        int elegir, salir = -5;
        String uso;
        RecursoMilitar recursoTemp;

        do {
            do {
                leerTipoRecurso(tipo, temp);
                //elegir recurso
                System.out.println("Indique que recurso quiere añadir segun el indice.");
                elegir = s.nextInt() - 1;
                s.nextLine();
                recursoTemp = recursos.get(elegir);
                if (temp.recursoExisteMision(recursoTemp)) {
                    System.out.println("El recurso " + recursos.get(elegir).getNombre() + " ya existe, intentalo con otro");
                }
            } while (temp.recursoExisteMision(recursoTemp));
            /*//pedir uso
            System.out.println("Indica el uso que le daras al recurso.");
            uso=s.nextLine();
           RecursoUso usoRecurso=new RecursoUso(recursoTemp, uso);
           temp.addUso(elegir,usoRecurso);
            //add recurso a mision
            temp.addRecurso(recursoTemp);*/

            //si quiere añadir mas
            do {
                System.out.println("¿Quiere añadir mas recursos de este tipo?. 1:SI, 0:NO");
                salir = s.nextInt();
                s.nextLine();
            } while (salir > 1 || salir < 0);
        } while (salir != 0);

    }

    public void recursosNoRepetidos() {
        String nombre = null;
        for (String key : misiones.keySet()) {
            nombre = misiones.get(key).leerRecursosMision();

        }
        System.out.println(nombre);
    }

    /**
     * ***
     */
    public void misionExito(Mision temp, int exp) {
        temp.getNivelExperienciaGanar();
        temp.addExpHumano(exp);
        temp.addEstresHumano(exp);
    }

    public void misionFracaso(Mision temp, int exp) {
        exp = exp * 2;
        temp.addEstresHumano(exp);
    }

    public void descansoRecursos() {
        for (int i = 0; i < recursos.size(); i++) {
            if (recursos.get(i) instanceof Humano) {
                Humano temp = (Humano) recursos.get(i);
                temp.setNvlEstres(0);
            }
        }
    }

    ///////////////////////////
    public void leerNombreMisiones() {
        String nombre;
        for (String key : misiones.keySet()) {
            nombre = misiones.get(key).getNombre();

        }

    }

    public void leerTipoRecurso(int tipo, Mision temp) {
        switch (tipo) {
            case 1:
                System.out.println("----HUMANO----");
                for (int i = 0; i < recursos.size(); i++) {
                    if (recursos.get(i) instanceof Humano) {
                        System.out.println((i + 1) + " " + recursos.get(i));
                    }
                }
                System.out.println("---------------------------------------------------------------------");
                break;
            case 2:
                System.out.println("----ARMA----");
                for (int i = 0; i < recursos.size(); i++) {
                    if (recursos.get(i) instanceof Arma) {
                        System.out.println((i + 1) + " " + recursos.get(i));
                    }
                }
                System.out.println("---------------------------------------------------------------------");
                break;
            case 3:
                System.out.println("----EQUIPO----");
                for (int i = 0; i < recursos.size(); i++) {
                    if (recursos.get(i) instanceof Equipo) {
                        System.out.println((i + 1) + " " + recursos.get(i));
                    }
                }
                System.out.println("---------------------------------------------------------------------");
                break;
            case 4:
                System.out.println("----VEHICULO----");
                for (int i = 0; i < recursos.size(); i++) {
                    if (recursos.get(i) instanceof Vehiculo) {
                        System.out.println((i + 1) + " " + recursos.get(i));
                    }
                }
                System.out.println("---------------------------------------------------------------------");
                break;
            default:
        }

    }

}
