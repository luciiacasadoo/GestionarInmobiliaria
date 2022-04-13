/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionarinmobiliaria;

/**
 *
 * @author Lucía Casado Caballero
 */ 
public class Vivienda extends Inmueble {
    private int numHabitaciones;
    private int numBaños;
    private int planta;
    private int plazasGaraje;
    private boolean ascensor;
    
    //constructor por parámetros.
    public Vivienda(int numHabitaciones, int numBaños, int planta, int plazasGaraje, boolean ascensor, double superficie, String direccion, double precio) {
        super(superficie, direccion, precio);
        this.numHabitaciones = numHabitaciones;
        this.numBaños = numBaños;
        this.planta = planta;
        this.ascensor = ascensor;
        this.plazasGaraje = plazasGaraje;
    }

    public int getNumHabitaciones() {
        return numHabitaciones;
    }

    public void setNumHabitaciones(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public int getNumBaños() {
        return numBaños;
    }

    public void setNumBaños(int numBaños) {
        this.numBaños = numBaños;
    }

    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }

    public boolean isAscensor() {
        return ascensor;
    }

    public void setAscensor(boolean ascensor) {
        this.ascensor = ascensor;
    }
    
    public int getPlazasGaraje() {
        return plazasGaraje;
    }

    public void setPlazasGaraje(int plazasGaraje) {
        this.plazasGaraje = plazasGaraje;
    }
    /**
     * Hace el calculo del precio del alquiler
     * @return precio del alquiler
     */
    @Override
    public double precioAlquiler() {
        double total;
        numHabitaciones *= 50;
        numBaños *= 10;
        if(ascensor){
            total = numHabitaciones + numBaños + super.getSuperficie()*10 + 50;
        } else {
            total = numHabitaciones + numBaños + super.getSuperficie()*10 - (planta * 10);
        }
        return total;
    }
    
    /**
     * Calacula la comision a pagar
     * @return comision
     */
    @Override
    public double comision() {
        return precioAlquiler()*3 + (super.getPrecio()*1.5)/100;
    }
    
    /**
     * Muestra los datos de la vivienda
     */
    public void verDatos(){
        System.out.println("Vivienda");
        super.verDatos();
    }

    
}
