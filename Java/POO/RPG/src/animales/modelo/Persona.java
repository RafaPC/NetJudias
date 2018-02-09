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
public class Persona implements ICazable{

    @Override
    public int satisfaccion() {
        
        return 100;
    }
    
    public void comer(Animal animal)
    {
        System.out.println("Que bueno!!!! humhum!!!");
    }
    
}
