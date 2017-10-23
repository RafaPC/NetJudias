
package javaapplication;import java.util.Scanner;


/**
 *
 * @author daw
 */
public class NewClass {
    public static void main(String[] args) {
    Scanner sc= new Scanner (System.in);
    System.out.println("Elige program: ");
    int programa=0;
    programa= sc.nextInt();
    switch (programa){
    
    programa==1:
    break;
    
    
    
            default:
        }
    }
}
    /*  PRIMER PROGRAMA
    System.out.println("Dime dos números y te diré todos los que haya entre medias ");
    System.out.print("Dime el primero ");
    int min;
    int max;
    min= sc.nextInt();
    System.out.print("Y ahora el segundo ");
    max= sc.nextInt();
      for (int x=min+1;x<max;x++)
          System.out.print(x+", ");*/
          
    /* SEGUNDO PROGRAMA
    for(int x=1;x<21;x++)
    System.out.print(5*x+", ");*/
    
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
    