/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polideportivo;

/**
 *
 * @author daw
 */
public class Polideportivo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //creo array de actividades
        Actividades[] actividades = new Actividades [11];
        
        //creo array de afiliados
        Afiliados[] afiliados = new Afiliados [35];
        

        //creo actividad con un horario y la meto en un array 
        actividades [0] = new Actividades ("Aerobic", 35, 47.60f, new Horario (10, 11, "L, X, V"));
        
        actividades [1] = new Actividades ("Aerobic", 35, 47.60f, new Horario (11, 12, "L, X, V"));

        actividades [2] = new Actividades ("Aerobic", 35, 47.60f, new Horario (19, 20, "L, X, V"));
        
        actividades [3] = new Actividades ("Aerobic", 35, 35.70f, new Horario (9, 10, "M, J"));
        
        actividades [4] = new Actividades ("Aerobic", 35, 35.70f, new Horario (10, 11, "M, J"));
        
        actividades [5] = new Actividades ("Aerobic", 35, 35.70f, new Horario (18, 19, "M, J"));
        
        actividades [6] = new Actividades ("Artes marciales", 15, 45f, new Horario (19, 20, "L, X, V"));
        
        actividades [7] = new Actividades ("Artes marciales", 15, 34f, new Horario (18, 19, "M, J"));
        
        actividades [8] = new Actividades ("Artes marciales", 15, 34f, new Horario (19, 20, "M, J"));
        
        actividades [9] = new Actividades ("Natación", 35, 47.60f, new Horario (18, 19, "L, X, V"));
        
        actividades [10] = new Actividades ("Natación", 35, 35.70f, new Horario (17, 18, "M, J"));
        
        System.out.println("Precio es "+actividades[0].getPrecio()+"Y hay "+actividades[0].getPlazas()+" plazas");
    }

}
