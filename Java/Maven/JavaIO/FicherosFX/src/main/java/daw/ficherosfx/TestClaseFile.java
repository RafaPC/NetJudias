/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.ficherosfx;

import java.io.File;

/**
 *
 * @author user
 */
public class TestClaseFile {

    public static void main(String[] args) {

        File f = new File("c:\\");

        File[] files = f.listFiles();
        for (File s : files) {

            System.out.println(s.getAbsolutePath());
            if (s.isDirectory()) {
                System.out.println("Esto es un directorio");
                String[] s1 = s.list();
                if (s1 != null) {
                    for (String s2 : s1) {
                        System.out.println("\t" + s2);
                    }
                }
                else
                {
                    System.out.println("\t Vacio");
                }
            }

        }
    }

}
