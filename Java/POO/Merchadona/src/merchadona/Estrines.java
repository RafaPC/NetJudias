/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merchadona;

/**
 *
 * @author daw
 */
public class Estrines {

    public String menu0 = "1.-Login"
            + "\n8.-Salir del programa";
    public String menuadmin = "1.-Dar de alta empleado/a"
            + "\n2.-Dar de baja empleado/a"
            + "\n3.-Dar de alta producto"
            + "\n4.-Lista de cajeras con sus totales"
            + "\n5.-Logout";
    public String menucajero = "1.-Venta"
            + "\n2.-Logout";
    public String menureponedor = "1.-Reponer productos"
            + "\n2.-Ver lista de productos"
            + "\n3.-Logout";
    public String msgLogin = "Dame el nombre del empleado e ID";
    public String msgLog2 = "Has entrado como ";
    public String msgLogout = "Te has deslogueado correctamente";

    public String getMenu0() {
        return menu0;
    }

    public String getMsgLog() {
        return msgLogin;
    }

    public String getMsgLog2() {
        return msgLog2;
    }

    public Estrines() {
        String menu = "1.-OPCION1\n2.-OPCION2\n3.-OPCION3\n4.-OPCION4\n5.-OPCION5";

    }
}
