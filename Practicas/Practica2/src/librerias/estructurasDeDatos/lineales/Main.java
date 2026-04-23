package librerias.estructurasDeDatos.lineales;

import librerias.excepcionesDeUsuario.Validaciones;

import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayCola arrayCola = new ArrayCola();
        arrayCola.rellenarDatosPrueba();

        boolean salida = false;

        do {
            try{
                menuPrincipal();
                int eleccion = Integer.parseInt(sc.nextLine());

                switch (eleccion) {
                    case 1:
                        enviarTrabajoImpresora(arrayCola);
                        break;
                    case 2:
                        imprimirTrabajos(arrayCola);
                        break;
                    case 3:
                        mostrarTrabajoMasPesado(arrayCola);
                        break;
                    case 4:
                        mostrarTIempoEspera(arrayCola);
                        break;
                    case 5:
                        arrayCola.informeTodasPrioridades();
                        break;
                    case 6:
                        mostrarInformeUnaPrioridad(arrayCola);
                        break;
                    case 7:
                        mostrarReducirEspera(arrayCola);
                        break;
                    case 8:
                        arrayCola.reiniciarSistema();
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

    private static void enviarTrabajoImpresora(ArrayCola arrayCola){

        System.out.println("Introduce un id de usuario");
        int idUsuario = Integer.parseInt(sc.nextLine());

        Validaciones.rangosIdUsuario(idUsuario);

        System.out.println("Introduce el titulo del trabajo");
        String titulo = sc.nextLine();

        System.out.println("Introduce el tamaño del del trabajo");
        int peso = Integer.parseInt(sc.nextLine());

        arrayCola.enviarTrabajoImpresora(idUsuario, titulo, peso);
    }

    private static void imprimirTrabajos(ArrayCola arrayCola){

        String respuesta = "";
        boolean mastrabajos;

        do {
            mastrabajos = arrayCola.imprimirTrabajos();

            if (mastrabajos) {
                System.out.println("¿Desea imprimir otro trabajo?(S/N)");
                respuesta = sc.nextLine().toUpperCase();
            }

        }while (respuesta.equals("S") && mastrabajos);
    }

    private static void mostrarTrabajoMasPesado(ArrayCola arrayCola){
        arrayCola.mostrarTrabajoMasPesado();
    }

    private static void mostrarTIempoEspera(ArrayCola arrayCola){
        int idBusqueda = Integer.parseInt(sc.nextLine());
        arrayCola.informarEspera(idBusqueda);
    }

    private static void mostrarInformeUnaPrioridad(ArrayCola arrayCola){
        int prioridadConsulta = Integer.parseInt(sc.nextLine());

        Validaciones.rangoPrioridad(prioridadConsulta);

        arrayCola.informeUnaPrioridad(prioridadConsulta);
    }

    private static void mostrarReducirEspera(ArrayCola arrayCola){
        int espera = Integer.parseInt(sc.nextLine());
        Validaciones.rangoPrioridad(espera);

        arrayCola.reducirEspera(espera);
    }

}