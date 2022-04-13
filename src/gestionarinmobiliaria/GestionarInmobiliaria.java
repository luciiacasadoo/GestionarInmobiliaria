/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionarinmobiliaria;

/**
 * @version 1.0
 * @author Lucía Casado Caballero
 */
public class GestionarInmobiliaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String nombre = "Lucía Casado Caballero"; // Pon tu nombre aquí
        int opcion;
        char modificar;
        Inmueble miInmueble;
        int pos = 0, option;
        Inmobiliaria miInmobiliaria = new Inmobiliaria("Velázquez", "41-123456", "Feria 100", nombre, 1000.0);
        miInmobiliaria.datosFichero();
        do {
            opcion = menu();
            switch (opcion) {
                case 1:
                    System.out.println("\nDatos de la inmobiliaria:");
                    miInmobiliaria.verDatos();
                    System.out.println("¿Quiere modificar los datos (s/n)?:");
                    try {
                        modificar = Entrada.leerCaracter();
                    } catch (Exception e) {
                        modificar = 'n';
                    }
                    if (modificar == 's') {
                        System.out.println("Nuevo nombre:");
                        miInmobiliaria.setNombre(Entrada.leerCadena());
                        System.out.println("Nuevo CIF:");
                        miInmobiliaria.setCif(Entrada.leerCadena());
                        System.out.println("Nueva direccion:");
                        miInmobiliaria.setDireccion(Entrada.leerCadena());
                        System.out.println("Nuevo propietario:");
                        miInmobiliaria.setPropietario(Entrada.leerCadena());
                        System.out.println("Nuevo saldo:");
                        miInmobiliaria.cuenta.setSaldo(Entrada.leerDouble());
                    }
                    break;
                case 2:
                    miInmueble = miInmobiliaria.pedirDatos();
                    if (miInmobiliaria.altaInmueble(miInmueble)) {
                        System.out.println("Dado de alta");
                    } else {
                        System.out.println("Error");
                    }
                    break;
                case 3:
                    System.out.println("Número del inmueble:");
                    try {
                        pos = Entrada.leerEntero();
                    } catch (NumberFormatException e) {
                        pos = -1;
                    }
                    miInmueble = miInmobiliaria.devolverInmueble(pos);
                    if (miInmueble != null) {
                        if (miInmobiliaria.bajaInmueble(pos)) {
                            System.out.println("Se ha dado de baja");
                        } else {
                            System.out.println("No se ha podido dar de baja");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Número del inmueble:");
                    try {
                        pos = Entrada.leerEntero();
                    } catch (NumberFormatException e) {
                        pos = -1;
                    }
                    if (miInmobiliaria.alquilar(pos)) {
                        System.out.println("Alquilada");
                    } else {
                        System.out.println("No se ha podido alquilar");
                    }
                    break;
                case 5:
                    /*pos = Entrada.leerEntero("Número del inmueble:");
                    miInmueble = miInmobiliaria.devolverInmueble(pos);*/
                    miInmueble = miInmobiliaria.devolverInmueble(Entrada.leerEntero("Número del inmueble:")); //función inline
                    miInmobiliaria.verDatos();
                    break;
                case 6:
                    miInmobiliaria.verDatosInmueble();
                    break;
                case 7:
                    option = Entrada.leerEntero("¿Cómo quiere ordenar? \n 1.- Superficie del inmueble. \n 2.- Precio del inmueble. \n 3.- Precio del alquiler \n (1/2/3)");
                    miInmobiliaria.ordenaPor(option);
                    miInmobiliaria.verDatosInmueble();
                    break;
                default:
            }
            Entrada.leerCadena("Pulse intro para continuar...");
        } while (opcion != 0);
    }

    public static int menu() {
        int op;
        System.out.println("Menu");
        System.out.println("");
        System.out.println("1.- Ver/modificar los datos de la inmobiliaria.");
        System.out.println("2.- Dar de alta un inmueble.");
        System.out.println("3.- Dar de baja un inmueble.");
        System.out.println("4.- Alquilar un inmueble.");
        System.out.println("5.- Ver los datos de un inmueble.");
        System.out.println("6.- Ver los datos de todos los inmuebles.");
        System.out.println("7.- Ordenar los inmuebles.");
        System.out.println("0.- Salir.");
        op = Entrada.leerEntero("\nElija opción:");

        return op;
    }

}
