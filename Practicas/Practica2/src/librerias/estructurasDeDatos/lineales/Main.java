package librerias.estructurasDeDatos.lineales;

import librerias.excepcionesDeUsuario.Validaciones;

import java.util.Scanner;

/**
 * Clase principal de la aplicación.
 */
public class Main {

    private static Scanner sc = new Scanner(System.in);

    /**
     * Método principal que arranca la ejecución del programa.
     */
    public static void main(String[] args) {

        GestorImpresora gestorImpresora = new GestorImpresora();
        gestorImpresora.rellenarDatosPrueba();

        boolean salida = false;

        do {
            try{
                menuPrincipal();
                int eleccion = Integer.parseInt(sc.nextLine());

                switch (eleccion) {
                    case 1:
                        enviarTrabajoImpresora(gestorImpresora);
                        break;
                    case 2:
                        imprimirTrabajos(gestorImpresora);
                        break;
                    case 3:
                        mostrarTrabajoMasPesado(gestorImpresora);
                        break;
                    case 4:
                        mostrarTIempoEspera(gestorImpresora);
                        break;
                    case 5:
                        informeTodasPrioridades(gestorImpresora);
                        break;
                    case 6:
                        mostrarInformeUnaPrioridad(gestorImpresora);
                        break;
                    case 7:
                        mostrarReducirEspera(gestorImpresora);
                        break;
                    case 8:
                        reiniciarSistema(gestorImpresora);
                        break;
                    case 0:
                        salida = true;
                        break;

                }
            }catch (NumberFormatException e){
                System.out.println("Introduce un numero valido");
            }catch (IllegalArgumentException e){
                System.out.println("Error: "+e.getMessage());
            }
        }while (!salida);
    }

    /**
     * Muestra por consola el Menú Principal con sus 9 opciones disponibles.
     */
    private static void menuPrincipal(){

        System.out.println("\nMENU PRINCIPAL");
        System.out.println("--------------");
        System.out.println("1.-Enviar un trabaja a la impresora");
        System.out.println("2.-Imprimir trabajos");
        System.out.println("3.-Mostrar trabajo mas pesado");
        System.out.println("4.-Mostrar tiempo de espera del usuario");
        System.out.println("5.-Informe de trabajos por prioridad");
        System.out.println("6.-Informe de trabajos de una prioridad");
        System.out.println("7.-Reducir espera en una prioridad");
        System.out.println("8.-Reiniciar el Sistema de impresion");
        System.out.println("0.-Salir");
        System.out.print("\nSeleccione una opción: ");
    }

    /**
     * Solicita al usuario para crear un nuevo trabajo de impresión y
     * Valida el ID del usuario.
     *
     * @param gestorImpresora Instancia del gestor del sistema de colas.
     */
    private static void enviarTrabajoImpresora(GestorImpresora gestorImpresora){

        System.out.println("Introduce un id de usuario");
        int idUsuario = Integer.parseInt(sc.nextLine());

        Validaciones.rangosIdUsuario(idUsuario);

        System.out.println("Introduce el titulo del trabajo");
        String titulo = sc.nextLine();

        System.out.println("Introduce el tamaño del del trabajo");
        int peso = Integer.parseInt(sc.nextLine());

        gestorImpresora.enviarTrabajoImpresora(idUsuario, titulo, peso);
    }

    /**
     * Imprime los trabajos en espera y se detenie
     * si el usuario lo indica o si el sistema se queda sin trabajos.
     *
     * @param gestorImpresora Instancia del gestor del sistema de colas.
     */
    private static void imprimirTrabajos(GestorImpresora gestorImpresora){

        String respuesta = "";
        boolean mastrabajos;

        do {
            mastrabajos = gestorImpresora.imprimirTrabajos();

            if (mastrabajos) {
                System.out.println("¿Desea imprimir otro trabajo?(S/N)");
                respuesta = sc.nextLine().toUpperCase();
            }

        }while (respuesta.equals("S") && mastrabajos);
    }

    /**
     * Invoca al gestor para buscar y mostrar el trabajo de impresión más pesado.
     *
     * @param gestorImpresora Instancia del gestor del sistema de colas.
     */
    private static void mostrarTrabajoMasPesado(GestorImpresora gestorImpresora){
        gestorImpresora.mostrarTrabajoMasPesado();
    }

    /**
     * Invoca al gestor para generar un informe general detallando la cantidad
     * de trabajos pendientes por nivel de prioridad.
     *
     * @param gestorImpresora Instancia del gestor del sistema de colas.
     */
    private static void informeTodasPrioridades(GestorImpresora gestorImpresora){
        gestorImpresora.informeTodasPrioridades();
    }

    /**
     * Solicita al usuario un ID y consulta cuántos trabajos de impresión tiene
     * por delante.
     *
     * @param gestorImpresora Instancia del gestor del sistema de colas.
     */
    private static void mostrarTIempoEspera(GestorImpresora gestorImpresora){
        System.out.println("Introduce un id de usuario");
        int idBusqueda = Integer.parseInt(sc.nextLine());
        gestorImpresora.informarEspera(idBusqueda);
    }

    /**
     * Solicita al usuario un nivel de prioridad y muestra un informe con todos
     * los trabajos que se encuentran esperando en dicha cola.
     *
     * @param gestorImpresora Instancia del gestor del sistema de colas.
     */
    private static void mostrarInformeUnaPrioridad(GestorImpresora gestorImpresora){

        System.out.println("Introduce la prioridad que se desea consultar (1 al 9)");
        int prioridadConsulta = Integer.parseInt(sc.nextLine());

        Validaciones.rangoPrioridad(prioridadConsulta);

        gestorImpresora.informeUnaPrioridad(prioridadConsulta);
    }

    /**
     * Solicita al usuario una prioridad para aplicar el algoritmo de reducción de
     * esperas mediante saltos. Valida la prioridad antes de la ejecución.
     *
     * @param gestorImpresora Instancia del gestor del sistema de colas.
     */
    private static void mostrarReducirEspera(GestorImpresora gestorImpresora){

        System.out.println("Introduce la prioridad para reducir la espera (1 al 9)");
        int espera = Integer.parseInt(sc.nextLine());
        Validaciones.rangoPrioridad(espera);

        gestorImpresora.reducirEspera(espera);
    }

    /**
     * Invoca al gestor para abortar todos los trabajos del sistema, vaciando
     * completamente las colas e imprimiendo el listado de elementos abortados.
     *
     * @param gestorImpresora Instancia del gestor del sistema de colas.
     */
    private static void reiniciarSistema(GestorImpresora gestorImpresora){
        gestorImpresora.reiniciarSistema();
    }

}