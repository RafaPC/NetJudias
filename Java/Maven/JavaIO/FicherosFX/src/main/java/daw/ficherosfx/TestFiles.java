/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.ficherosfx;

import com.google.common.io.CharStreams;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

import java.nio.file.Path;
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
         
            //Files.asCharSink(f, Charset.forName("UTF-8")).write("hola");
            
            //FileReader fr = new FileReader("test.test");
            
            Files.asByteSink(f,FileWriteMode.APPEND).write("hola".getBytes("UTF-8"));
            
            //fr.close();
            System.out.println(CharStreams.toString(new FileReader("test.test")));
            System.out.println(Files.asCharSource(f, Charset.defaultCharset()).read());
            
            byte[] bytes = new byte[100];
            bytes = Files.asByteSource(f).read();
            System.out.println(new String(bytes));
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(TestFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
    
}
