/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.objetos;

/**
 *
 * @author daw
 */
public class NewClass {
    private int op1;
    private int op2;
    
    public int getOp1() {
        return op1;
    }

    public void setOp1(int op1) {
        this.op1 = op1;
    }

    public int getOp2() {
        return op2;
    }

    public void setOp2(int op2) {
        this.op2 = op2;
    }
    
    public int suma(){
        return this.op1+this.op1;
        
    }
    
    public int resta(){
        int resultado;
        
        if(this.op2<this.op1)resultado = this.op1-this.op2;
        else resultado = this.op2-this.op1;
        
        return resultado;
    }
    
    public int multiplicar(){
        return this.op1*this.op2;
    }
    
    public float dividir(){
        return this.op1/this.op2; 
    }
}
