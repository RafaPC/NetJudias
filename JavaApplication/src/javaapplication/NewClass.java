
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
        int programa;
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
            case 4:
                ejercicio4(sc);
                break;
            case 5:
                ejercicio5(sc);
                break;
            case 6:
                ejercicio6(sc);
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
    
    public static void ejercicio4(Scanner sc){
        System.out.print("Cuántos valores quieres introducir? ");
        int nvalores= sc.nextInt();
        int num;
        float acum=0;
        for (int x=1;x<=nvalores;x++){
            System.out.println("Dime el "+x+"º valor");
            num=sc.nextInt();
            acum=acum+num;
        }
        System.out.println("La media de los "+nvalores+ " números es "+acum/nvalores);
    } 
   
    public static void ejercicio5(Scanner sc){
        System.out.print("Dime las horas ");
        //Multiplica las horas por 60 para convertirlas a minutos
        int minutos=sc.nextInt()*60;
        System.out.print("Dime los minutos ");
        minutos+=sc.nextInt();
        System.out.print("Dime las segundos ");
        //Divide los segundos netre 60 para convertirlos a minutos
        minutos+=sc.nextInt()/60;
        System.out.println("Eso son "+minutos+" minutos");
    }
     
    public static void ejercicio6(Scanner sc){
        System.out.print("Cuántos segundos quieres que convierta a horas, minutos y segundos? ");
        int segundos= sc.nextInt();
        int horas=segundos/3600;
        int minutos=(segundos%3600/60);
        segundos=segundos-((horas*3600)+(minutos*60));
        System.out.println("Eso son "+horas+" horas, "+minutos+" minutos y "+segundos+" segundos");
        
    }
    public static void ejercicio7(Scanner sc){
        int menor;
        int mayor;
        for(int x=1;x<10;x++){
            int num=sc.nextInt();
            if(x==1){
               menor=num; 
               mayor=num;
            }
            
            if (num<menor){
                menor=num;
                else if(num>mayor){
                        mayor=num;
                        }
            }
            
            
            
            
        }
       
       
       
       
   } 
    
    
    
    
    }
    
    
