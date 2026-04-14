package librerias.estructuraDeDatos.Lineales;

/**
 * Clase principal que contiene la entrada a la aplicación GEST_BUS.
 */
public class Main {

    /**
     * Método principal que arranca la ejecución del programa.
     */
    public static void main(String[] args) {
        LDEGOrdenada<Autobus> autobuses = new LDEGOrdenada<>();
        Utilidades.creacionAutomatica(autobuses);

        System.out.println("\nBienvenido a la aplicación GEST_BUS!");
        MenuPrincipal menuPrincipal = new MenuPrincipal(autobuses);
        menuPrincipal.iniciar();
    }
}