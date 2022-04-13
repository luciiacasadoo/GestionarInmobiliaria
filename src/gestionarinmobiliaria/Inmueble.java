/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionarinmobiliaria;

/**
 *
 * @author Lucía Casado Caballero
 */
public abstract class Inmueble implements IComparable {

    private double superficie;
    private String direccion;
    private double precio;

    @Override
    public boolean menorQue(IComparable otroObjeto, int opcion) {
        Inmueble aux;
        aux = (Inmueble) otroObjeto;
        switch (opcion) {
            case 1:
                if (this.superficie < aux.getSuperficie()) {
                    return true;
                }
            case 2:
                if (this.precio < aux.getPrecio()) {
                    return true;
                }
            case 3:
                if (precioAlquiler() < aux.precioAlquiler()) {
                    return true;
                }
            default:
                return false;
        }
    }

    @Override
    public boolean mayorQue(IComparable otroObjeto, int opcion) {
        Inmueble aux;
        aux = (Inmueble) otroObjeto;
        switch (opcion) {
            case 1:
                if (this.superficie > aux.getSuperficie()) {
                    return true;
                }
            case 2:
                if (this.precio >  aux.getPrecio()) {
                    return true;
                }
            case 3:
                if (precioAlquiler() > aux.precioAlquiler()) {
                    return true;
                }
            default:
                return false;
        }
    }

    @Override
    public boolean igualQue(IComparable otroObjeto, int opcion) {
        Inmueble aux;
        aux = (Inmueble) otroObjeto;
        switch (opcion) {
            case 1:
                if (this.superficie == aux.getSuperficie()) {
                    return true;
                }
            case 2:
                if (this.precio == aux.getPrecio()) {
                    return true;
                }
            case 3:
                if (precioAlquiler() == aux.precioAlquiler()) {
                    return true;
                }
            default:
                return false;
        }
    }

    public Inmueble(double superficie, String direccion, double precio) {
        this.superficie = superficie;
        this.direccion = direccion;
        this.precio = precio;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void verDatos() {
        System.out.println("superficie " + superficie + " mts2");
        System.out.println("direccion " + direccion);
        System.out.println("precio " + precio + " euros");
        System.out.println("alquiler: " + precioAlquiler());
        System.out.println("comisión: " + comision());
    }

    public abstract double precioAlquiler();

    public abstract double comision();

}
