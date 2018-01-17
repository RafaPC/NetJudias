/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.objetos;

import java.util.Scanner;

/**
 *
 * @author daw
 */
public class CalculadoraObjetos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        NewClass cal = new NewClass();

        System.out.println("Elige el primer operando");
        cal.setOp1(sc.nextInt());
        System.out.println("Y ahora el segundo");
        cal.setOp2(sc.nextInt());

        
        
        System.out.println("Ahora elige la operación:");
        
        System.out.println("Suma (+)    Resta(-)");
        
        System.out.println("Multiplicar (*)    Dividir(/)");
        
        String operacion = sc.next();
        
        
        switch (operacion) {
            case "+":
                System.out.println("La suma es " + cal.suma());
                break;

            case "-":
                System.out.println("La resta es " + cal.resta());
                break;

            case "*":
                System.out.println("La multiplicación es " + cal.multiplicar());
                break;
            
            case "/":
                System.out.println("La dividir es " + cal.dividir());
                break;
            
            default:
                System.out.println("te has inventado el simbolo");
        }
    }

}
