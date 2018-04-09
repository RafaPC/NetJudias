/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merchadona.modelo;

/**
 *
 * @author daw
 */
public class Reponedor extends Empleado {

    private int num_reposiciones;

    public Reponedor(String nombre, int id_empleado) {
        super(nombre, id_empleado);
        this.num_reposiciones = num_reposiciones;
    }

    public int getNum_reposiciones() {
        return num_reposiciones;
    }

    public void setNum_reposiciones(int num_reposiciones) {
        this.num_reposiciones = num_reposiciones;
    }

    public void sumRepuestos(int cantidad) {
        this.num_reposiciones += cantidad;
    }
    
    @Override

    public String toString() {
        return "Reponedor{" + super.toString() + "num_reposiciones=" + num_reposiciones + '}';
    }

}
