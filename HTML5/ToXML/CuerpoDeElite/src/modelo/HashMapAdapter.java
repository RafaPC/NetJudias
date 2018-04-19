/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.HashMap;
import java.util.LinkedList;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author oscar
 */
public class HashMapAdapter extends XmlAdapter<LinkedList<Mision>, HashMap<String,Mision>>  {

    @Override
    public HashMap unmarshal(LinkedList v) throws Exception {
        HashMap<String,Mision> misiones = new HashMap<>();
        for (Object o : v)
        {
            Mision p = (Mision)o;
            misiones.put(p.getNombre(), p);
        }
        return misiones;
    }

    @Override
    public LinkedList marshal(HashMap v) throws Exception {
        LinkedList<Mision> lista = new LinkedList(v.values());
        return lista;
    }

  
  

    
}
