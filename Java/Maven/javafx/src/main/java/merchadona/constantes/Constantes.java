/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merchadona.constantes;

/**
 *
 * @author daw
 */
public class Constantes {
    
    public static final int ADMIN_ID = 1;
    public static final int NUM_SEGUNDOS_CADUCA = 60;
    public static final int NUM_SEGUNDOS_BAJA_PRECIO = 10;
    public static final double FACTOR_BAJA_PRECIO = 0.10;

    public static int getADMIN_ID() {
        return ADMIN_ID;
    }

    public static int getNUM_SEGUNDOS_CADUCA() {
        return NUM_SEGUNDOS_CADUCA;
    }

    public static int getNUM_SEGUNDOS_BAJA_PRECIO() {
        return NUM_SEGUNDOS_BAJA_PRECIO;
    }

    public static double getFACTOR_BAJA_PRECIO() {
        return FACTOR_BAJA_PRECIO;
    }
    
    
}
