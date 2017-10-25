
package javaapplication;
import java.util.Scanner;


/**
 *
 * @author daw
 */
public class NewClass {
    public static void main(String[] args) {
        Scanner sc= new Scanner (System.in);
        System.out.println("Elige programa: ");
        int programa=0;
        programa= sc.nextInt();
        switch (programa){
    
            case 1:
                 ejercicio1(sc);
                break;
            case 2:
                 ejercicio2(sc);
                break;
                
            case 3:
                ejercicio3(sc);
                break;
    
    
            default:
        }
    }

    public static void ejercicio1(Scanner sc){
    System.out.println("Dime dos números y te diré todos los que haya entre medias ");
    System.out.print("Dime el primero ");
    int min;
    int max;
    min= sc.nextInt();
    System.out.print("Y ahora el segundo ");
    max= sc.nextInt();
      for (int x=min+1;x<max;x++)
          System.out.print(x+", ");
    }
          
    public static void ejercicio2(Scanner sc){
    for(int x=1;x<21;x++)
        System.out.print(5*x+", ");
    }
   
    public static void ejercicio3(Scanner sc){
    int num;
    int acum=0;
    for(int x=1;x<16;x++){
        System.out.print("Dime el "+x+" º número: ");
        num= sc.nextInt();
        acum+=num;
    }
    System.out.println(acum/15.0);
    }
    
    

    
    
    
    
    
    
    
    
}