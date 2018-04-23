/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.ficherosfx;

import com.google.common.io.CharSink;
import com.google.common.io.CharStreams;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oscar
 */
public class TestFiles {
    
    public static void main(String[] args) {
        
        try {
            File f = new File("test.test");
        
            Files.touch(f);
            String s ="hola";
         
            //escribir en un fichero
            CharSink sink = Files.asCharSink(f, Charset.forName("UTF-8"));
            
            sink.write("hola");
            
            
            // escribir al final de un fichero
            Files.asByteSink(f,FileWriteMode.APPEND).write("hola".getBytes("UTF-8"));
            

            //leer un fichero
            System.out.println(CharStreams.toString(new FileReader("test.test")));
            System.out.println(Files.asCharSource(f, Charset.defaultCharset()).read());

            Files.copy(new File("test.test"),new File("test.test.copia"));
            
            File delete = new File("test.test");
            delete.delete();
            
            File rename = new File("test.test.copia");
            rename.renameTo(new File("test.test.copia2"));
            
            //leer gichero binario
            byte[] bytes = new byte[100];
            bytes = Files.asByteSource(f).read();
            System.out.println(new String(bytes));
            
            
        } catch (IOException ex) {
            Logger.getLogger(TestFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
    
}
