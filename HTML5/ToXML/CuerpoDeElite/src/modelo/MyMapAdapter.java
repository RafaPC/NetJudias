/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.HashMap;
import java.util.Map.Entry;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author daw
 */
public class MyMapAdapter extends
  
   XmlAdapter<MyMapType,HashMap<String,Mision>> {

    @Override
    public HashMap<String, Mision> unmarshal(MyMapType v) throws Exception {
         HashMap<String, Mision> hashMap = new HashMap<>();
      for(MyMapEntry myEntryType : v.entry) {
         hashMap.put(myEntryType.nombre, myEntryType.mision);
      }
      return hashMap;
        
        
    }

    @Override
    public MyMapType marshal(HashMap<String, Mision> v) throws Exception {
      MyMapType myMapType = new MyMapType();
      for(Entry<String, Mision> entry : v.entrySet()) {
         MyMapEntry myMapEntryType = 
            new MyMapEntry();
         myMapEntryType.nombre = entry.getKey();
         myMapEntryType.mision = entry.getValue();
         myMapType.entry.add(myMapEntryType);
      }
      return myMapType;      }
}
