/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author daw
 */
public class Puesto {

    private int expMIn;
    private String puesto;
    private int salHora;
    private Freelance freelancer;

    public Puesto(int expMIn, String puesto, int salHora) {
        this.expMIn = expMIn;
        this.puesto = puesto;
        this.salHora = salHora;
    }

    public void addFreelance(Freelance falsoAutonomo) {
        this.freelancer = falsoAutonomo;
    }

    public Freelance getFreelancer() {
        return freelancer;
    }

    @Override
    public String toString() {
        return "\n---\nPuesto{" + "expMIn=" + expMIn + ", puesto=" + puesto + ", salHora=" + salHora + ", freelancer=" + freelancer + '}';
    }

    public int getSalHora() {
        return salHora;
    }

    public int getExpMIn() {
        return expMIn;
    }

}
