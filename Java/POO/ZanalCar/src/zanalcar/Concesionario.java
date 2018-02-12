/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zanalcar;

import Vehiculos.Bicicleta;
import Vehiculos.Coche;
import Vehiculos.Moto;
import Vehiculos.Quad;
import Vehiculos.Vehiculo;
import Vehiculos.VehiculoaMotor;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author daw
 */
public class Concesionario {

    private ArrayList<Vehiculo> stock = new ArrayList<>();

    public Scanner sc = new Scanner(System.in);

    public Concesionario() {
        /*String x = "hola";
        Quad temp = new Quad(x, 35, 1000, x, x);
        System.out.println(temp.precioventa);
        Coche temp1 = new Coche(x, 35, 5350, x, x);
        System.out.println(temp1.precioventa);
        Moto temp2 = new Moto(x, 35, 2672.5f, x, x);
        System.out.println(temp2.precioventa);
        Bicicleta temp3 = new Bicicleta(80.8f, x, x);
        System.out.println(temp3.precioventa);*/

        stock.add(new Coche("SDRG54", 5000, 10000, "Rojo", "Mustang"));
        stock.add(new Moto("ZDGFRDFHG23", 1003, 2087, "Negro", "Vespa"));
        stock.add(new Quad("BVLJHY87", 767, 300, "Rojo", "Marca de Quad"));
        stock.add(new Bicicleta(10, 13, "UnoMuyBueno", 300, "Verde", "ElBicho"));
    }

    public void comprarVehiculo() {

        System.out.println("1.-Vehículo a motor"
                + "\n2.-Otro (de momento solo compramos bicicletas)");
        int opcion = sc.nextInt();
        sc.nextLine();

        if (opcion == 1) {
            String marca, color, matricula;
            float preciocompra;
            int kilometros;

            System.out.print("Marca del coche:");
            marca = sc.next();
            System.out.print("Color:");
            color = sc.next();
            System.out.print("Precio:");
            preciocompra = sc.nextInt();
            System.out.print("Kilómetros:");
            kilometros = sc.nextInt();
            sc.nextLine();
            System.out.print("Matrícula:");
            matricula = sc.next();

            System.out.println("¿Que tipo de vehículo es?"
                    + "\n1.-Coche"
                    + "\n2.-Moto"
                    + "\n3.-Quad");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    stock.add(new Coche(matricula, kilometros, preciocompra, color, marca));
                    break;
                case 2:
                    stock.add(new Moto(matricula, kilometros, preciocompra, color, marca));
                    break;
                case 3:
                    stock.add(new Quad(matricula, kilometros, preciocompra, color, marca));
                    break;
            }
        } else {
            String marca, color, tipodecambio;
            int tamañoderueda, numdemarchas;
            float preciocompra;
            System.out.print("Marca: ");
            marca = sc.next();
            System.out.print("Color: ");
            color = sc.next();
            System.out.print("Precio de compra: ");
            preciocompra = sc.nextInt();
            sc.nextLine();
            System.out.print("Tamaño de rueda (pulgadas): ");
            tamañoderueda = sc.nextInt();
            sc.nextLine();
            System.out.print("Número de marchas: ");
            numdemarchas = sc.nextInt();
            sc.nextLine();
            System.out.print("Tipo de cambio: ");
            tipodecambio = sc.next();
            stock.add(new Bicicleta(tamañoderueda, numdemarchas, tipodecambio, preciocompra, color, marca));

        }

    }

    public void venderVehiculo() {
        System.out.println("¿Con qué quieres buscar el vehículo?");
        System.out.println("1.- Marca"
                + "2.- Tipo de vehículo"
                + "3.- Matrículo"
                + "4.- Precio menor a una cantidad");
        int opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1:
                System.out.println("Dime la marca");
                String marca = sc.next();
                for (int i = 0; i < stock.size(); i++) {
                    if (stock.get(i).marca.equalsIgnoreCase(marca)) {
                        printearVehiculo(i);
                    }
                }
                break;
            case 2:
                System.out.println("Dime el tipo de vehículo");
                String tipo = sc.next();
                printearTipo(tipo);
                break;
            case 3:
                System.out.println("Díme la matrícula");
                String matricula = sc.next();
                for (int i = 0; i < stock.size(); i++) {
                    if (stock.get(i) instanceof Bicicleta) {
                    } else {
                        VehiculoaMotor vm = ((VehiculoaMotor) stock.get(i));
                        if (vm.matricula.equals(matricula)) {
                        }
                    }
                }
                break;
            case 4:
                System.out.println("Dime el precio");
                int precio = sc.nextInt();
                sc.nextLine();
                for (int i = 0; i < stock.size(); i++) {
                    if (stock.get(i).precioventa < precio) {
                        printearVehiculo(i);
                    }
                }
        }
        System.out.println("Elige Nº de coche");
        opcion = sc.nextInt();
        sc.nextLine();
        System.out.println("Y por qué precio quieres venderlo");
        int precio = sc.nextInt();
        sc.nextLine();
        System.out.println(stock.get(opcion).precioventa);
        if (precio < stock.get(opcion).precioventa) {
            System.out.println("No puedes venerlo a ese precio, tiene que ser igual o mayor a " + stock.get(opcion).precioventa);
        }
    }

    public void cochesEnStock() {
        for (int i = 0; i < stock.size(); i++) {
            if (stock.get(i) instanceof Coche) {
                System.out.println(i + 1 + ".-Coche" + "\n" + stock.get(i));
            }
            if (stock.get(i) instanceof Moto) {
                System.out.println(i + 1 + ".-Moto" + "\n" + stock.get(i));
            }
            if (stock.get(i) instanceof Quad) {
                System.out.println(i + 1 + ".-Quad" + "\n" + stock.get(i));
            }
            if (stock.get(i) instanceof Bicicleta) {
                System.out.println(i + 1 + ".-Bicicleta" + "\n" + stock.get(i));
            }
            System.out.println("\n");
        }
    }

    public void printearVehiculo(int i) {
        if (stock.get(i) instanceof Coche) {
            System.out.println(i + 1 + ".-Coche" + "\n" + stock.get(i));
        } else if (stock.get(i) instanceof Moto) {
            System.out.println(i + 1 + ".-Moto" + "\n" + stock.get(i));
        } else if (stock.get(i) instanceof Quad) {
            System.out.println(i + 1 + ".-Quad" + "\n" + stock.get(i));
        } else if (stock.get(i) instanceof Bicicleta) {
            System.out.println(i + 1 + ".-Bicicleta" + "\n" + stock.get(i));
        }
        System.out.println("\n");
    }

    public void printearTipo(String tipo) {
        for (int i = 0; i < stock.size(); i++) {
            if (tipo.equalsIgnoreCase("Coche")) {
                if (stock.get(i) instanceof Coche) {
                    System.out.println(i + ".-" + "Coche" + "\n" + stock.get(i));
                }

            } else if (tipo.equalsIgnoreCase("Moto")) {
                if (stock.get(i) instanceof Moto) {
                    System.out.println(i + ".-" + "Moto" + "\n" + stock.get(i));
                }
            } else if (tipo.equalsIgnoreCase("Quad")) {
                if (stock.get(i) instanceof Quad) {
                    System.out.println(i + ".-" + "Quad" + "\n" + stock.get(i));
                }
            } else if (tipo.equalsIgnoreCase("Bicicleta")) {
                if (stock.get(i) instanceof Bicicleta) {
                    System.out.println(i + ".-" + "Bicicleta" + "\n" + stock.get(i));
                }
            }
        }
    }
}
