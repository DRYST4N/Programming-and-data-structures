package librerias.estructuraDeDatos.Lineales;

import java.util.Scanner;
import librerias.excepcionesDeUsuario.Validaciones;

/**
 * Controlador encargado de gestionar la sección de Listados de la aplicación GEST_BUS.
 * Permite al usuario generar y visualizar  los datos  de diferentes maneras de
 * los autobuses y viajes registrados en el sistema.
 */
public class MenuListados {

    private Scanner teclado;
    private LDEGOrdenada<Autobus> autobuses;

    /**
     * Constructor del menú de listados.
     * @param teclado   Objeto Scanner para la lectura de datos por consola.
     * @param autobuses La estructura de datos central que contiene la información a listar.
     */
    public MenuListados(Scanner teclado, LDEGOrdenada<Autobus> autobuses) {
        this.teclado = teclado;
        this.autobuses = autobuses;
    }

    /**
     * Inicia el bucle interactivo del submenú de listados.
     */
    public void iniciar() {
        boolean salida = false;

        do {
            try {
                mostrarMenu();
                int eleccion = Integer.parseInt(teclado.nextLine().trim());
                Validaciones.validarOpcionesMenu(eleccion, 9);

                switch (eleccion) {
                    case 1:
                        listarAutobusesPorNumeroPlazaAscendente();
                        break;
                    case 2:
                        listarAutobusesPorNumeroPlazaDescendente();
                        break;
                    case 3:
                        listarGeneralViajes();
                        break;
                    case 4:
                        listarViajesPorOrigen();
                        break;
                    case 5:
                        listarViajesPorDestino();
                        break;
                    case 6:
                        listarAutobusesPorCapacidadMinima();
                        break;
                    case 7:
                        listarAutobusesConMasViajes();
                        break;
                    case 8:
                        mostrarCantidadTotalViajes();
                        break;
                    case 9:
                        mostrarCantidadTotalPasajerosEntreCiudades();
                        break;
                    case 0:
                        System.out.println("Volver al menu principal");
                        salida = true;
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe seleccionar un numero");
            } catch (IllegalArgumentException e) {
                System.out.println("Introduce un numero o un numero valido");
            }
        } while (!salida);
    }

    /**
     * Muestra por pantalla las opciones disponibles en el submenú de listados.
     */
    private void mostrarMenu() {
        System.out.println("\n\nMENU LISTADO");
        System.out.println(("-----------"));
        System.out.println("1.-Listado general de autobuses ordenado por número de plazas (orden ascendente)");
        System.out.println("2.-Listado general de autobuses ordenado por número de plazas (orden descendente)");
        System.out.println("3.-Listado general de viajes");
        System.out.println("4.-Listado de viajes que parten de una ciudad determinada");
        System.out.println("5.-Listado de viajes que llegan a una ciudad determinada");
        System.out.println("6.-Listado de autobuses que tienen una capacidad mayor o igual a la indicada por el usuario");
        System.out.println("7.-Listado de autobus o autobuses que realizan la mayor cantidad de viajes");
        System.out.println("8.-Cantidad total de viajes que realizan los autobuses de la empresa");
        System.out.println("9.-Cantidad total de pasajeros que viajan de una ciudad a otra");
        System.out.println();
        System.out.println("0.-Volver al menú principal");
        System.out.print("\nSeleccione una opción: ");
    }

    /**
     * Lista todos los autobuses registrados ordenados de menor a mayor
     * según su número de plazas.
     * Recorre la lista doblemente enlazada desde el primer nodo hasta el último.
     */
    private void listarAutobusesPorNumeroPlazaAscendente() {
        NodoLDEG<Autobus> aux = autobuses.getPrimero();

        System.out.println("\nLISTADO GENERAL DE AUTOBUSES POR NÚMERO DE PLAZAS (Orden Ascendente):");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("\tMatrícula\tAño Compra\tPlazas");
        System.out.println("\t===========================================================");

        while (aux != null) {
            String matricula = aux.getDato().getMatricula();
            String annoCompra = aux.getDato().getAnnoCompra();
            int numeroPlazas = aux.getDato().getNumeroPlazas();

            System.out.println("\t" + matricula + "\t\t" + annoCompra + "\t\t" + numeroPlazas);
            aux = aux.getSiguiente();
        }

        pause();
    }

    /**
     * Lista todos los autobuses registrados ordenados de mayor a menor
     * según su número de plazas.
     * Se desplaza al final de la lista doblemente enlazada y la recorre hacia atrás.
     */
    private void listarAutobusesPorNumeroPlazaDescendente() {
        NodoLDEG<Autobus> aux = autobuses.getPrimero();

        if (aux == null) {
            System.out.println("No hay autobuses registrados.");
            pause();
            return;
        }

        while (aux.getSiguiente() != null) {
            aux = aux.getSiguiente();
        }

        System.out.println("\nLISTADO GENERAL DE AUTOBUSES POR NÚMERO DE PLAZAS (Orden Descendente):");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("\tMatrícula\tAño Compra\tPlazas");
        System.out.println("\t============================================================");

        while (aux != null) {
            String matricula = aux.getDato().getMatricula();
            String annoCompra = aux.getDato().getAnnoCompra();
            int numeroPlazas = aux.getDato().getNumeroPlazas();

            System.out.println("\t" + matricula + "\t\t" + annoCompra + "\t\t" + numeroPlazas);
            aux = aux.getAnterior();
        }

        pause();
    }

    /**
     * Muestra un listado general de todos los autobuses junto con todos los viajes
     * que tienen asignados.
     */
    private void listarGeneralViajes() {
        System.out.println("\nLISTADO GENERAL DE VIAJES");
        System.out.println("--------------------------");
        System.out.println("\tMatricula\tAño Compra\tPlazas\tCodigo\tOrigen\t\tDestino\t\tHora");
        System.out.println("\t==============================================================================");

        for (int i = 0; i < autobuses.talla(); i++) {
            Autobus autobus = autobuses.getElemento(i);

            if (autobus.getViajes().talla() == 0) {
                System.out.println("\t" + autobus.getMatricula()
                        + "\t\t" + autobus.getAnnoCompra()
                        + "\t\t" + autobus.getNumeroPlazas()
                        + "\t\t" + "-"
                        + "\t" + "-"
                        + "\t\t" + "-"
                        + "\t\t" + "-");
            } else {
                for (int j = 0; j < autobus.getViajes().talla(); j++) {
                    Viaje viaje = autobus.getViajes().getElemento(j);

                    System.out.println("\t" + autobus.getMatricula()
                            + "\t\t" + autobus.getAnnoCompra()
                            + "\t\t" + autobus.getNumeroPlazas()
                            + "\t\t" + viaje.getCodigo()
                            + "\t" + viaje.getOrigen()
                            + "\t\t" + viaje.getDestino()
                            + "\t\t" + viaje.getHora());
                }
            }
        }

        pause();
    }

    /**
     * Solicita una ciudad de origen al usuario y muestra todos los viajes
     * de todos los autobuses que partan desde esa ciudad específica.
     */
    private void listarViajesPorOrigen() {
        System.out.println("\nIntroduce la ciudad de origen:");
        String ciudad = teclado.nextLine();

        Autobus autobusAux = new Autobus("", "", 0);

        if (!autobusAux.ciudadValida(ciudad)) {
            System.out.println("Error: ciudad no válida");
            pause();
            return;
        }

        ciudad = ciudad.trim().toLowerCase();

        System.out.println("\nLISTADO DE VIAJES QUE PARTEN DE " + ciudad.toUpperCase());
        System.out.println("--------------------------------------------------");
        System.out.println("\tMatricula\tCodigo\tDestino\tHora");
        System.out.println("\t=========================================");

        boolean encontrado = false;

        for (int i = 0; i < autobuses.talla(); i++) {
            Autobus autobus = autobuses.getElemento(i);

            for (int j = 0; j < autobus.getViajes().talla(); j++) {
                Viaje viaje = autobus.getViajes().getElemento(j);

                if (viaje.getOrigen().equalsIgnoreCase(ciudad)) {
                    System.out.println("\t" + autobus.getMatricula() + "\t\t"
                            + viaje.getCodigo() + "\t"
                            + viaje.getDestino() + "\t"
                            + viaje.getHora());
                    encontrado = true;
                }
            }
        }

        if (!encontrado) {
            System.out.println("No hay viajes con esa ciudad de origen");
        }

        pause();
    }

    /**
     * Solicita una ciudad de destino al usuario y muestra todos los viajes
     * de todos los autobuses que lleguen a esa ciudad específica.
     */
    private void listarViajesPorDestino() {
        System.out.println("\nIntroduce la ciudad de destino:");
        String ciudad = teclado.nextLine();

        Autobus autobusAux = new Autobus("", "", 0);

        if (!autobusAux.ciudadValida(ciudad)) {
            System.out.println("Error: ciudad no valida");
            pause();
            return;
        }

        ciudad = ciudad.trim().toLowerCase();

        System.out.println("\nLISTADO DE VIAJES QUE LLEGAN A " + ciudad.toUpperCase());
        System.out.println("--------------------------------------------");
        System.out.println("\tMatricula\tCodigo\tOrigen\tHora");
        System.out.println("\t==============================================");

        boolean encontrado = false;

        for (int i = 0; i < autobuses.talla(); i++) {
            Autobus autobus = autobuses.getElemento(i);

            for (int j = 0; j < autobus.getViajes().talla(); j++) {
                Viaje viaje = autobus.getViajes().getElemento(j);

                if (viaje.getDestino().equalsIgnoreCase(ciudad)){
                    System.out.println("\t" + autobus.getMatricula() + "\t\t"
                            + viaje.getCodigo() + "\t"
                            + viaje.getOrigen() + "\t"
                            + viaje.getHora());
                    encontrado = true;
                }
            }
        }

        if (!encontrado) {
            System.out.println("No hay viajes con esa ciudad de destino");
        }

        pause();
    }

    /**
     * Pide al usuario un número de plazas y lista únicamente aquellos autobuses
     * cuya capacidad sea mayor o igual al valor introducido.
     */
    private void listarAutobusesPorCapacidadMinima() {
        System.out.println("\nIntroduce la capacidad minima:");
        int capacidad = Integer.parseInt(teclado.nextLine().trim());

        Validaciones.validarNumeroNoNegativo(capacidad);

        System.out.println("\nLISTADO DE AUTOBUSES CON CAPACIDAD MAYOR O IGUAL A " + capacidad);
        System.out.println("---------------------------------------------------------");
        System.out.println("\tMatricula\tAño Compra\tPlazas");
        System.out.println("\t===================================================");

        boolean encontrado = false;

        for (int i = 0; i < autobuses.talla(); i++) {
            Autobus autobus = autobuses.getElemento(i);

            if (autobus.getNumeroPlazas() >= capacidad) {
                System.out.println("\t" + autobus.getMatricula() + "\t\t"
                        + autobus.getAnnoCompra() + "\t\t"
                        + autobus.getNumeroPlazas());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No hay autobuses con esa capacidad minima");
        }

        pause();
    }

    /**
     * Analiza todos los autobuses para determinar cuáles tienen
     * la mayor cantidad de viajes asignados y los muestra por pantalla.
     */
    private void listarAutobusesConMasViajes() {
        int maximo = 0;

        for (int i = 0; i < autobuses.talla(); i++) {
            int cantidadViajes = autobuses.getElemento(i).getViajes().talla();
            if (cantidadViajes > maximo) {
                maximo = cantidadViajes;
            }
        }

        System.out.println("\nAUTOBUS O AUTOBUSES CON MAYOR CANTIDAD DE VIAJES");
        System.out.println("\tMatricula\tNumero de viajes");
        System.out.println("=========================================");

        for (int i = 0; i < autobuses.talla(); i++) {
            Autobus autobus = autobuses.getElemento(i);

            if (autobus.getViajes().talla() == maximo) {
                System.out.println("\t" + autobus.getMatricula() + "\t\t" + maximo);
            }
        }

        pause();
    }

    /**
     * Calcula y muestra por pantalla la suma total de todos los viajes
     * que realizan todos los autobuses de la empresa en conjunto.
     */
    private void mostrarCantidadTotalViajes() {
        int total = 0;

        for (int i = 0; i < autobuses.talla(); i++) {
            total += autobuses.getElemento(i).getViajes().talla();
        }

        System.out.println("\nCANTIDAD TOTAL DE VIAJES DE LA EMPRESA");
        System.out.println("--------------------------------------");
        System.out.println("Total de viajes: " + total);

        pause();
    }

    /**
     * Pide al usuario una ciudad de origen y una de destino, y calcula el total de
     * pasajeros que viajan entre ambas ciudades. Asume que los autobuses viajan llenos.
     */
    private void mostrarCantidadTotalPasajerosEntreCiudades() {
        System.out.println("\nIntroduce la ciudad de origen:");
        String origen = teclado.nextLine();

        System.out.println("Introduce la ciudad de destino:");
        String destino = teclado.nextLine();

        Autobus autobusAux = new Autobus("", "", 0);

        if (!autobusAux.ciudadValida(origen) || !autobusAux.ciudadValida(destino)) {
            System.out.println("Error: ciudad no valida");
            pause();
            return;
        }

        origen = origen.trim().toLowerCase();
        destino = destino.trim().toLowerCase();

        int totalPasajeros = 0;

        for (int i = 0; i < autobuses.talla(); i++) {
            Autobus autobus = autobuses.getElemento(i);

            for (int j = 0; j < autobus.getViajes().talla(); j++) {
                Viaje viaje = autobus.getViajes().getElemento(j);

                if (viaje.getOrigen().equalsIgnoreCase(origen) && viaje.getDestino().equalsIgnoreCase(destino)) {
                    totalPasajeros += autobus.getNumeroPlazas();
                }
            }
        }

        System.out.println("\nCANTIDAD TOTAL DE PASAJEROS DE "
                + origen.toUpperCase() + " A " + destino.toUpperCase());
        System.out.println("----------------------------------------------");
        System.out.println("Total de pasajeros: " + totalPasajeros);

        pause();
    }

    private void pause() {
        System.out.println("\nPulsa <Intro> para volver al menú...");
        teclado.nextLine();
    }
}