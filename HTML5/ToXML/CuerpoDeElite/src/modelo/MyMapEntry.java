/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
/**
 *
 * @author oscar
 */
public class MyMapEntry {
   @XmlElement
   public String nombre; 
 
   @XmlElements({
            @XmlElement(name = "MisionReconomiento", type = Mision.class),
            @XmlElement(name = "MisionCombate", type = MisionDeCombate.class)
            
    })
   public Mision mision;
}