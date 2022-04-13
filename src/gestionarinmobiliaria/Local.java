/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionarinmobiliaria;

/**
 * @version 1.0
 * @author Lucía Casado Caballero
 */
public class Local extends Inmueble{
    
    //Constructor por parámetros.
    public Local(double superficie, String direccion, double precio) {
        super(superficie, direccion, precio);
    }
    
    /**
     * Recibe el precio del alquiler y lo multiplica por dos
     * @return comision
     */
    @Override
    public double comision() {
        return precioAlquiler()*2;
    }
    
    /**
     * Recibe la superficie y la multiplica por 20
     * @return precio del alquiler
     */
    @Override
    public double precioAlquiler() {
        return super.getSuperficie()*20;
    }
    
    /**
     * Sirve para ver los datos del Local.
     */
    public void verDatos(){
        System.out.println("Local");
        super.verDatos();
    }
}
