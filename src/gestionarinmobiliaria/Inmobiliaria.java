/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionarinmobiliaria;

/**
 * @version 1.0
 * @author Lucía Casado Caballero
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Inmobiliaria implements IOrdenaArray {

    private String nombre;
    private String cif;
    private String direccion;
    private String propietario;
    private Inmueble[] inmuebles;
    Cuenta cuenta;
    private int numeroInmueble;

    /**
     * Recibe parametros que dan valor a los atributos.
     *
     * @param nombre
     * @param cif
     * @param direccion
     * @param propietario
     * @param saldo
     */
    public Inmobiliaria(String nombre, String cif, String direccion, String propietario, double saldo) {
        this.nombre = nombre;
        this.cif = cif;
        this.direccion = direccion;
        this.propietario = propietario;
        this.inmuebles = new Inmueble[100];
        this.cuenta = new Cuenta(nombre, cif, saldo, 10);
        this.numeroInmueble = 0;
    }

    public Inmueble[] getInmuebles() {
        return inmuebles;
    }

    public void setInmuebles(Inmueble[] inmuebles) {
        this.inmuebles = inmuebles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public int getNumeroInmueble() {
        return numeroInmueble;
    }

    public void setNumeroInmueble(int numeroInmueble) {
        this.numeroInmueble = numeroInmueble;
    }

    /**
     * Recibe un objeto de la clase inmueble y lo inserta en el vector si puede.
     *
     * @param i
     * @return verdadero en el caso de que se pueda, falso en el caso de que no
     * se pueda
     */
    public boolean altaInmueble(Inmueble i) {
        if (numeroInmueble < inmuebles.length && i != null) {
            inmuebles[numeroInmueble] = i;
            numeroInmueble++;
            return true;
        }
        return false;
    }

    /**
     * Recibe posicion del vector.
     *
     * @param pos
     * @return null o un objeto tipo Inmueble
     */
    public Inmueble devolverInmueble(int pos) {
        Inmueble i = null;
        if (pos >= 0 && pos < numeroInmueble) {
            i = inmuebles[pos];
        }
        return i;
    }

    /**
     * Borra del vector el inmueble de la posicion dada.
     *
     * @param pos
     * @return
     */
    public boolean bajaInmueble(int pos) {
        if (pos >= 0) {
            for (int i = pos; i < numeroInmueble - 1; i++) {
                inmuebles[i] = inmuebles[i + 1];
            }
            inmuebles[numeroInmueble - 1] = null;
            return true;
        }
        return false;
    }

    /**
     * Ingresa el alquiler + comsion en la cuenta de dicho inmueble, muestra sus
     * datos y lo borra del vector.
     *
     * @param pos
     * @return verdadero o falso dependiendo si la operación se puede hacer o no
     */
    public boolean alquilar(int pos) {
        Inmueble i = devolverInmueble(pos);
        if (i != null) {
            double total;
            total = i.precioAlquiler() + i.comision();
            cuenta.ingreso(total);
            i.verDatos();
            bajaInmueble(pos);
            return true;
        }
        return false;
    }

    /**
     * Pide los datos dependiendo del tipo de inmueble que sea.
     *
     * @return
     */
    public Inmueble pedirDatos() {
        Inmueble i = null;
        char tipoInmueble;
        String direccion;
        double superficie, precio, terraza;
        int numHabitaciones, numBaños, plazasGaraje, planta;
        boolean ascensor;

        System.out.println("\nTipo del nuevo empleado (local/vivienda/atico):");
        try {
            tipoInmueble = Entrada.leerCaracter();
        } catch (Exception error) {
            tipoInmueble = 'x';
        }
        if (tipoInmueble == 'l' || tipoInmueble == 'v' || tipoInmueble == 'a') {
            direccion = Entrada.leerCadena("Direccion:");
            superficie = Entrada.leerDouble("Superficie:");
            precio = Entrada.leerDouble("Precio:");

            switch (tipoInmueble) {
                case 'l':
                    i = new Local(superficie, direccion, precio);
                    break;
                case 'v':
                    numHabitaciones = Entrada.leerEntero("Número de habitaciones:");
                    numBaños = Entrada.leerEntero("Número de Baños");
                    plazasGaraje = Entrada.leerEntero("Plazas de Garaje:");
                    planta = Entrada.leerEntero("Planta: ");
                    ascensor = Entrada.leerBoolean("\n Ascensor");
                    i = new Vivienda(numHabitaciones, numBaños, planta, plazasGaraje, ascensor, superficie, direccion, precio);
                    break;
                case 'a':
                    terraza = Entrada.leerDouble("Terraza:");
                    numHabitaciones = Entrada.leerEntero("Número de habitaciones:");
                    numBaños = Entrada.leerEntero("Número de Baños");
                    plazasGaraje = Entrada.leerEntero("Plazas de Garaje:");
                    planta = Entrada.leerEntero("Planta: ");
                    ascensor = Entrada.leerBoolean("\n Ascensor");
                    i = new Atico(terraza, numHabitaciones, numBaños, planta, plazasGaraje, ascensor, superficie, direccion, precio);
            }
        }
        return i;
    }

    /**
     * Muestra los datos del objeto pedido.
     */
    public void verDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Cif: " + cif);
        System.out.println("Direccion: " + direccion);
        System.out.println("Propietario:" + propietario);
        System.out.println("Número de inmuebles:" + numeroInmueble);
        System.out.println("Saldo de la cuenta:" + cuenta.getSaldo());
    }

    /**
     * Muestra los datos de todos los objetos de la clase inmueble.
     */
    public void verDatosInmueble() {
        System.out.println("Listado de inmuebles:\n");
        for (int i = 0; i < numeroInmueble; i++) {
            inmuebles[i].verDatos();
            System.out.println("");
        }
    }

    @Override
    public void ordenaPor(int opcion) {
        Inmueble aux;
        for (int i = 0; i < numeroInmueble; i++) {
            for (int j = numeroInmueble - 1; j > i; j--) {
                if (inmuebles[j].menorQue(inmuebles[j - 1], opcion)) {
                    aux = inmuebles[j];
                    inmuebles[j] = inmuebles[j - 1];
                    inmuebles[j - 1] = aux;
                }
            }
        }
    }

    public void datosFichero() {
        try {
            FileReader fichero = new FileReader("C:\\Users\\laawa\\OneDrive\\Escritorio\\IES\\PROGR\\Proyectos\\GestionarInmobiliaria\\src\\gestionarinmobiliaria\\local.txt");
            BufferedReader bf = new BufferedReader(fichero);
            String linea = bf.readLine();
            int contador = 0;
            double superficie = 0, precio = 0;
            String direccion = "";
            while (linea != null) {
                switch (contador) {
                    case 0:
                        superficie = Double.parseDouble(linea);
                        contador++;
                        break;
                    case 1:
                        direccion = linea;
                        contador++;
                        break;
                    case 2:
                        precio = Double.parseDouble(linea);
                        contador = 0;
                        Local local = new Local(superficie, direccion, precio);
                        altaInmueble(local);
                        break;
                }
                linea = bf.readLine();
            }
            bf.close();
        } catch (FileNotFoundException e) {//qué hacer si no se encuentra el fichero
            System.out.println("No se encuentra el fichero local.txt");
        } catch (IOException e) {//qué hacer si hay un error en la lectura del fichero
            System.out.println("No se puede leer el fichero local.txt");
        }
    }
}
