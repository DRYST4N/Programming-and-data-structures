package librerias.estructuraDeDatos.Lineales;

import java.util.Scanner;
import librerias.excepcionesDeUsuario.Validaciones;

/**
 * Controlador central de la aplicación GEST_BUS.
 * Gestiona el menú principal, derivando el flujo de ejecución hacia
 * el submenú de Mantenimiento o el submenú de Listados según
 * la opción seleccionada por el usuario.
 */
public class MenuPrincipal {

    private Scanner teclado;
    private LDEGOrdenada<Autobus> autobuses;

    /**
     * Constructor del menú principal.
     * @param autobuses La estructura de datos principal que contiene
     * todos los autobuses y viajes cargados en el sistema.
     */
    public MenuPrincipal(LDEGOrdenada<Autobus> autobuses) {
        this.teclado = new Scanner(System.in);
        this.autobuses = autobuses;
    }

    /**
     * Inicia el bucle de ejecución del menú principal.
     */
    public void iniciar() {
        boolean salida = false;

        do {
            try {
                mostrarMenu();
                int opcion = Integer.parseInt(teclado.nextLine().trim());
                Validaciones.validarOpcionesMenu(opcion, 2);

                switch (opcion) {
                    case 1:
                        new MenuMantenimiento(teclado, autobuses).iniciar();
                        break;
                    case 2:
                        new MenuListados(teclado, autobuses).iniciar();
                        break;
                    case 0:
                        System.out.println("Gracias por utilizar la aplicacion GEST_BUS");
                        salida = true;
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe seleccionar un numero");
            } catch (IllegalArgumentException e) {
                System.out.println("Error validacion: " + e.getMessage());
            }
        } while (!salida);

        teclado.close();
    }

    private void mostrarMenu() {
        System.out.println("\nMENU PRINCIPAL");
        System.out.println("--------------");
        System.out.println("1.-Mantenimiento");
        System.out.println("2.-Listado");
        System.out.println("0.-Salir");
        System.out.print("\nSeleccione una opción: ");
    }
}