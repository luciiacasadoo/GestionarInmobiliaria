/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionarinmobiliaria;

/**
 * @version 1.0
 * @author Lucía Casado Caballero
 */
public class Atico extends Vivienda {
    
    private double terraza;
    /**
     * Recibe parametros que dan valor a los atributos.
     * @param terraza
     * @param numHabitaciones
     * @param numBaños
     * @param planta
     * @param plazasGaraje
     * @param ascensor
     * @param superficie
     * @param direccion
     * @param precio 
     */
    public Atico(double terraza, int numHabitaciones, int numBaños, int planta, int plazasGaraje, boolean ascensor, double superficie, String direccion, double precio) {
        super(numHabitaciones, numBaños, planta, plazasGaraje, ascensor, superficie, direccion, precio);
        this.terraza = terraza;
    }
    
    /**
     * Suma al precio del alquiler de la vivienda los metros cuadrados de la terraza multiplicado por 20
     * @return el precio final del alquiler
     */
    public double precioAlquiler(){
        return super.precioAlquiler()+ (terraza*20);
    }
    
    /**
     * Suma al precio del alquiler de la vivienda los metros cuadrados de la terraza multiplicado por 10
     * @return la comision final
     */
    public double comision(){
        return super.comision() + (terraza*10);
    }
    
    /**
     * Muestra los datos del ático.
     */
    public void verDatos(){
        System.out.println("Terraza: " + this.terraza + " metros cuadrados");
        super.verDatos();
    }
}
