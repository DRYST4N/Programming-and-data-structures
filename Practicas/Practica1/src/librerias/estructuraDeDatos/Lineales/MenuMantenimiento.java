package librerias.estructuraDeDatos.Lineales;

import java.util.Scanner;
import librerias.excepcionesDeUsuario.ReglasImpuestasException;
import librerias.excepcionesDeUsuario.Validaciones;

/**
 * Controlador para la sección de mantenimiento de la aplicación GEST_BUS.
 * Permite gestionar las altas, bajas y modificaciones
 * tanto de los autobuses como de sus respectivos viajes.
 */
public class MenuMantenimiento {

    private Scanner teclado;
    private LDEGOrdenada<Autobus> autobuses;

    /**
     * Constructor del menú de mantenimiento.
     * @param teclado   Objeto Scanner para la lectura de datos por consola.
     * @param autobuses La estructura de datos central que gestiona los autobuses del sistema.
     */
    public MenuMantenimiento(Scanner teclado, LDEGOrdenada<Autobus> autobuses) {
        this.teclado = teclado;
        this.autobuses = autobuses;
    }

    /**
     * Inicia el bucle del submenú de mantenimiento.
     */
    public void iniciar() {
        boolean salida = false;

        do {
            try {
                mostrarMenu();
                int eleccion = Integer.parseInt(teclado.nextLine().trim());
                Validaciones.validarOpcionesMenu(eleccion, 7);

                switch (eleccion) {
                    case 1:
                        altaAutobus();
                        break;
                    case 2:
                        bajaAutobus();
                        break;
                    case 3:
                        modificarAutobus();
                        break;
                    case 4:
                        registrarViaje();
                        break;
                    case 5:
                        borrarViaje();
                        break;
                    case 6:
                        modificarViaje();
                        break;
                    default:
                        System.out.println("Volver al menu principal");
                        salida = true;
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Lo sentimos vuelva a intentarlo.");
                System.out.println("\nSeleccione una opción:");
            }
        } while (!salida);
    }

    /**
     * Imprime por pantalla las distintas opciones de gestión
     * del menú de mantenimiento.
     */
    private void mostrarMenu() {
        System.out.println("\n\nMENU MANTENIMIENTO");
        System.out.println("------------------");
        System.out.println("1.-Alta de autobus");
        System.out.println("2.-Baja de autobus");
        System.out.println("3.-Modificacion de autobus");
        System.out.println();
        System.out.println("4.-Registrar viaje");
        System.out.println("5.-Borrar viaje");
        System.out.println("6.-Modificar viaje");
        System.out.println();
        System.out.println("0.-Volver al menu principal");
        System.out.print("\nSeleccione una opcion: ");
    }

    /**
     * Solicita datos al usuario para registrar un nuevo autobús en el sistema.
     * Verifica que la matrícula no exista previamente y asegura que
     * el número de plazas sea un valor no negativo.
     */
    private void altaAutobus() {
        boolean salidaAltaAutobus = false;

        do {
            try {
                System.out.println("\nAlta de autobus");
                System.out.println("---------------");
                System.out.println("Introduce una matricula:");
                String matricula = teclado.nextLine().trim();

                if (autobuses.existeElemento(new Autobus(matricula, "", 0)) != null) {
                    System.out.println("Error: ya existe un autobus registrado con esa matricula");
                } else {
                    System.out.println("Introduce el año de compra");
                    String annoCompra = teclado.nextLine().trim();

                    System.out.println("Introduce numero de plazas");
                    int plazas = Integer.parseInt(teclado.nextLine().trim());

                    Validaciones.validarNumeroNoNegativo(plazas);

                    autobuses.insertarElemento(new Autobus(matricula, annoCompra, plazas));
                }

                System.out.println("Desea añadir un nuevo autobus? (S/N):");
                String respuesta = teclado.nextLine().trim().toUpperCase();

                if (!respuesta.equals("S")) {
                    salidaAltaAutobus = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Debe seleccionar un numero");
            } catch (ReglasImpuestasException e) {
                System.out.println("Error: Regla no cumplida: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error validacion: " + e.getMessage());
            }
        } while (!salidaAltaAutobus);
    }

    /**
     * Solicita la matrícula de un autobús para darlo de baja del sistema.
     * Pide confirmación explícita al usuario antes de proceder a la eliminación.
     */
    private void bajaAutobus() {
        boolean salidaBajaAutobus = false;

        do {
            try {
                System.out.println("\nBaja de autobus");
                System.out.println("---------------");
                System.out.println("Introduce una matricula");
                String matricula = teclado.nextLine().trim();

                Autobus autobus = autobuses.existeElemento(new Autobus(matricula, "", 0));

                if (autobus != null) {
                    System.out.println(autobus.toString());

                    System.out.println("Desea realmente dar de baja a este autobus? (S/N)");
                    String respuesta = teclado.nextLine().trim().toUpperCase();

                    if (respuesta.equals("S")) {
                        autobuses.borrarElemento(autobus);
                        System.out.println("Baja registrada");
                    } else {
                        System.out.println("Proceso de baja abortado");
                    }
                } else {
                    System.out.println("Error: esta matricula no esta registrada en la aplicacion");
                }

                System.out.println("Desea dar de baja otro autobus? (S/N)");
                String respuesta = teclado.nextLine().trim().toUpperCase();

                if (!respuesta.equals("S")) {
                    salidaBajaAutobus = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Debe seleccionar un numero");
            } catch (ReglasImpuestasException e) {
                System.out.println("Error: Regla no cumplida: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error validacion: " + e.getMessage());
            }
        } while (!salidaBajaAutobus);
    }

    /**
     * Solicita la matrícula de un autobús existente para modificar sus datos.
     * Mantiene intacta su lista de viajes.
     */
    private void modificarAutobus() {
        boolean salidaModificacionAutobus = false;

        do {
            try {
                System.out.println("\nModificación de autobus");
                System.out.println("-----------------------");
                System.out.println("Introduce una matricula");
                String matricula = teclado.nextLine().trim();

                Autobus autobus = autobuses.existeElemento(new Autobus(matricula, "", 0));

                if (autobus != null) {
                    System.out.println("Introduce un año de modificacion");
                    String annoModificacion = teclado.nextLine().trim();

                    System.out.println("Introduce numero de plazas");
                    int plazas = Integer.parseInt(teclado.nextLine().trim());

                    Validaciones.validarNumeroNoNegativo(plazas);

                    autobuses.modificarElemento(new Autobus(
                            autobus.getMatricula(),
                            annoModificacion,
                            plazas,
                            autobus.getViajes()
                    ));
                } else {
                    System.out.println("Error: esta matricula no esta registrada en la aplicacion");
                }

                System.out.println("Desea modificar los datos de otro autobus? (S/N)");
                String respuesta = teclado.nextLine().trim().toUpperCase();

                if (!respuesta.equals("S")) {
                    salidaModificacionAutobus = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Debe seleccionar un numero");
            } catch (ReglasImpuestasException e) {
                System.out.println("Error: Regla no cumplida: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error validacion: " + e.getMessage());
            }
        } while (!salidaModificacionAutobus);
    }

    /**
     * Solicita los datos necesarios para registrar un nuevo viaje y lo asocia
     * al autobús correspondiente según la matrícula proporcionada.
     * Verifica reglas de negocio
     */
    private void registrarViaje() {
        boolean salidaAltaViajes = false;

        do {
            try {
                System.out.println("\nRegistro de viajes");
                System.out.println("------------------");
                System.out.println("Introduce una matricula");
                String matricula = teclado.nextLine().trim();

                Autobus autobus = autobuses.existeElemento(new Autobus(matricula, "", 0));

                if (autobus != null) {
                    System.out.println("Introduzca el codigo de viajes");
                    int codigoViaje = Integer.parseInt(teclado.nextLine().trim());

                    Validaciones.validarNumeroNoNegativo(codigoViaje);

                    if (Utilidades.existeCodigoViaje(codigoViaje, autobuses)) {
                        System.out.println("Ya existe un viaje con este codigo");
                    } else {
                        System.out.println("Introduzca el origen del viaje");
                        String origen = teclado.nextLine();

                        System.out.println("Introduzca el destino del viaje");
                        String destino = teclado.nextLine();

                        System.out.println("Introduzca la hora del viaje");
                        String hora = teclado.nextLine().trim();

                        if (!autobus.ciudadValida(origen) || !autobus.ciudadValida(destino)) {
                            throw new ReglasImpuestasException("Las ciudades permitidas son: Madrid, Segovia, Barcelona y Sevilla.");
                        }

                        Viaje viaje = new Viaje(codigoViaje, origen, destino, hora);
                        autobus.registrarViaje(viaje);
                    }
                } else {
                    System.out.println("Error: esta matricula no esta registrada en la aplicacion");
                }

                System.out.println("Desea registrar otro viaje? (S/N)");
                String respuesta = teclado.nextLine().trim().toUpperCase();

                if (!respuesta.equals("S")) {
                    salidaAltaViajes = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Debe seleccionar un número");
            } catch (ReglasImpuestasException e) {
                System.out.println("Error: Regla no cumplida: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error validación: " + e.getMessage());
            }
        } while (!salidaAltaViajes);
    }

    /**
     * Solicita la matrícula de un autobús y el código de uno de sus viajes
     * para dar de baja dicho trayecto. Requiere confirmación del usuario.
     */
    private void borrarViaje() {
        boolean salidaBajaViajes = false;

        do {
            try {
                System.out.println("\nBorrado de viajes");
                System.out.println("-----------------");
                System.out.println("Introduce una matrícula");
                String matricula = teclado.nextLine().trim();

                Autobus autobus = autobuses.existeElemento(new Autobus(matricula, "", 0));

                if (autobus != null) {
                    System.out.println("Introduzca el código de viajes");
                    int codigoViaje = Integer.parseInt(teclado.nextLine().trim());

                    Viaje viaje = autobus.getViajes().existeElemento(new Viaje(codigoViaje, "", "", ""));

                    if (viaje != null) {
                        System.out.println(viaje.toString());

                        System.out.println("Desea realmente dar de baja este viaje? (S/N)");
                        String respuesta = teclado.nextLine().trim().toUpperCase();

                        if (respuesta.equals("S")) {
                            autobus.bajaViajes(viaje);
                            System.out.println("Baja realizada");
                        } else {
                            System.out.println("Proceso de baja abortado");
                        }
                    } else {
                        System.out.println("No existe un viaje con este código");
                    }
                } else {
                    System.out.println("Error: esta matrícula no esta registrada en la aplicación");
                }

                System.out.println("Desea dar de baja otro viaje? (S/N)");
                String respuesta = teclado.nextLine().trim().toUpperCase();

                if (!respuesta.equals("S")) {
                    salidaBajaViajes = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Debe seleccionar un número");
            } catch (ReglasImpuestasException e) {
                System.out.println("Error: Regla no cumplida: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error validacion: " + e.getMessage());
            }
        } while (!salidaBajaViajes);
    }

    /**
     * Permite modificar los datos de origen, destino y hora de un viaje
     * ya existente en un autobús específico, verificando nuevamente
     * que la información actualizada cumpla con las reglas de negocio impuestas.
     */
    private void modificarViaje() {
        boolean salidaModificacionViajes = false;

        do {
            try {
                System.out.println("\nModificación de viajes");
                System.out.println("----------------------");
                System.out.println("Introduce una matrícula");
                String matricula = teclado.nextLine().trim();

                Autobus autobus = autobuses.existeElemento(new Autobus(matricula, "", 0));

                if (autobus != null) {
                    autobus.listarViajes();

                    System.out.println("Que viaje desea modificar? (introduce el codigo del viaje a modificar)");
                    int codigoViaje = Integer.parseInt(teclado.nextLine().trim());

                    Viaje viaje = autobus.getViajes().existeElemento(new Viaje(codigoViaje, "", "", ""));

                    if (viaje != null) {
                        System.out.println(viaje.toString());

                        System.out.println("Introduzca el origen del viaje");
                        String origen = teclado.nextLine().trim().toLowerCase();

                        System.out.println("Introduzca el destino del viaje");
                        String destino = teclado.nextLine().trim().toLowerCase();

                        System.out.println("Introduzca la hora del viaje");
                        String hora = teclado.nextLine().trim();

                        if (!autobus.ciudadValida(origen) || !autobus.ciudadValida(destino)) {
                            throw new ReglasImpuestasException("Las ciudades permitidas son: Madrid, Segovia, Barcelona y Sevilla.");
                        }

                        autobus.modificarViajes(new Viaje(codigoViaje, origen, destino, hora));
                        System.out.println("Autobus " + autobus.getMatricula() + ": Viaje " + viaje.getCodigo() + " modificado correctamente");
                    } else {
                        System.out.println("No existe un viaje con este codigo");
                    }
                } else {
                    System.out.println("Error: esta matricula no esta registrada en la aplicacion");
                }

                System.out.println("Desea modificar otro viaje? (S/N)");
                String respuesta = teclado.nextLine().trim().toUpperCase();
                if (!respuesta.equals("S")) {
                    salidaModificacionViajes = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Debe seleccionar un numero");
            } catch (ReglasImpuestasException e) {
                System.out.println("Error: Regla no cumplida: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error validacion: " + e.getMessage());
            }
        } while (!salidaModificacionViajes);
    }
}