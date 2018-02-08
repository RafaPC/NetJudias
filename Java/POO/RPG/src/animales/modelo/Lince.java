/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animales.modelo;

/**
 *
 * @author user
 */
public class Lince extends Animal{

    public Lince() {
        super(20);
    }
    
    
    public void cazar(ICazable caza)
    {
        hp += (caza.satisfaccion()/2);
    }

    
}
