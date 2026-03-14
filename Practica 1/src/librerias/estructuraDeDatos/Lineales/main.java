package librerias.estructuraDeDatos.Lineales;

import java.util.BitSet;
import java.util.Scanner;
import librerias.excepcionesDeUsuario.Validaciones;

public class main {
   
    public static void main(String [] args){
        try{
            menuPrincipal();
        }catch (Exception e){
            System.out.println("Error en el programa: "+e.getMessage());
        }
    }

    public static void opcionesMenuPrincipal(){
        System.out.println("MENU PRINCIPAL");
        System.out.println();
        System.out.println("1.-Mantenimiento");
        System.out.println("2.-Listado");
        System.out.println("0.-Salir");
    }

    public static void opcionesMenuMantenimiento(){
        System.out.println("MENU MANTENIMIENTO");
        System.out.println();
        System.out.println("1.-Alta de autobus");
        System.out.println("2.-Baja de autobus");
        System.out.println("3.-Modificacion de autobus");
        System.out.println();
        System.out.println("4.-Registrar viaje");
        System.out.println("5.-Borrar viaje");
        System.out.println("6.-Modificar viaje");
        System.out.println();
        System.out.println("0.-Volver al menu principal");
    }

    public static void opcionesMenuListado(){
        System.out.println("MENU LISTADO");
        System.out.println("1.-Listado general de autobuses ordenado por numero de plazas (orden ascendente)");
        System.out.println("2.-Listado general de autobuses ordenado por numero de plazas (orden descendente)");
        System.out.println("3.-Listado general de viajes");
        System.out.println("4.-Listado de viajes que parten de una ciudad determinada");
        System.out.println("5.-Listado de viajes que llegan a una ciudad determinada");
        System.out.println("6.-Listado de autobuses que tienen una capacidad mayor o igual a la indicada por el usuario");
        System.out.println("7.-Listado de autobus o autobuses que realizan la mayor cantidad de viajes");
        System.out.println("8.-Cantidad total de viajes que realizan los autobuses de la empresa");
        System.out.println("9.-Cantidad total de pasajeros que viajan de una ciudad a otra");
        System.out.println();
        System.out.println("0.-Volver al menu principal");
    }

    public static void menuPrincipal() {

        boolean salida = false;
        Scanner sc = new Scanner(System.in);

        LDEG<Autobus>autobuses = new LDEG<Autobus>();

        do {
            try {
                opcionesMenuPrincipal();
                zonaDeEleccion();

                int opcion = Integer.parseInt(sc.nextLine());
                Validaciones.numeroEntero(opcion, 3);

                switch (opcion) {
                    case 1:
                        menuMantenimiento(autobuses);
                        break;
                    case 2:
                        menuListado(autobuses);
                        break;
                    case 0:
                        System.out.println("Saliendo del programa");
                        salida = true;
                        break;
                }
            }catch (NumberFormatException e){
                System.out.println("Introduce un numero entero");
            }catch (IllegalArgumentException e){
                System.out.println("Introduce un numero valido");
            }
        }while (!salida);
    }


    public static void menuListado(LDEG<Autobus>autobuses){//Falta añadir la lista enlazada por parametro y los metodos que devuelvan true si se ha completado de forma correcta y false si no

        boolean salida = false;
        Scanner sc = new Scanner(System.in);

        do{
            try{
                opcionesMenuListado();
                zonaDeEleccion();

                int eleccion = Integer.parseInt(sc.nextLine());
                Validaciones.numeroEntero(eleccion,10);

                switch (eleccion) {
                    case 1:
                        System.out.println("Listado general de autobuses ordenado por numero de plazas".toUpperCase()+" (orden ascendente)");
                        elementosLista();
                        break;
                    case 2:
                        System.out.println("Listado general de autobuses ordenado por numero de plazas".toUpperCase()+" (orden descendente)");
                        elementosLista();
                        break;
                    case 3:
                        System.out.println("Listado general de viajes".toUpperCase());
                        elementosLista();
                        break;
                    case 4:
                        System.out.println("Listado de viajes que parten de una ciudad determinada".toUpperCase());
                        elementosLista();
                        break;
                    case 5:
                        System.out.println("Listado de viajes que llegan a una ciudad determinada".toUpperCase());
                        elementosLista();
                        break;
                    case 6:
                        System.out.println("Listado de autobuses que tienen una capacidad mayor o igual a la indicada por el usuario".toUpperCase());
                        elementosLista();
                        break;
                    case 7:
                        System.out.println("Listado de autobus o autobuses que realizan la mayor cantidad de viajes".toUpperCase());
                        elementosLista();
                        break;
                    case 8:
                        System.out.println("Cantidad total de viajes que realizan los autobuses de la empresa".toUpperCase());
                        elementosLista();
                        break;
                    case 9:
                        System.out.println("Cantidad total de pasajeros que viajan de una ciudad a otra".toUpperCase());
                        elementosLista();
                        break;
                    default:
                        System.out.println("Volver al menu principal");
                        salida = true;
                        break;
                }
            }catch (IllegalArgumentException e){
                System.out.println("Introduce un numero o un numero valido");
            }
        }while (!salida);
    }

    public static void menuMantenimiento(LDEG<Autobus>autobuses) {//Falta añadir la lista enlazada por parametro y los metodos que devuelvan true si se ha completado de forma correcta y false si no

        boolean salida = false;
        Scanner sc = new Scanner(System.in); //Para escanear los datos por teclado

        do {
            try{
                opcionesMenuMantenimiento(); //Llamamos a las opciones del menu
                zonaDeEleccion();

                int eleccion = Integer.parseInt(sc.nextLine());//Escaneamos y guardamos la eleccion para usarla
                Validaciones.numeroEntero(eleccion,7);

                Scanner sc2 = new Scanner(System.in);

                switch (eleccion) {
                    case 1: //Alta autobus

                        boolean salidaAltaAutobus = false;

                        do {
                            try{
                                System.out.println("Introduce una matricula");
                                String matricula = sc2.nextLine();

                                if (autobuses.existeElemento(new Autobus(matricula,"",0)) != null){
                                    System.out.println("Error: ya existe un autobus registrado con esa matricula");
                                }
                                else{
                                    System.out.println("Introduce el año de compra en este formato dd/mm/yyyy");
                                    String annoCompra = sc2.nextLine();

                                    System.out.println("Introduce numero de plazad");
                                    int plazas = Integer.parseInt(sc2.nextLine());

                                    autobuses.insertarElemento(new Autobus(matricula,annoCompra,plazas));

                                    System.out.println("Desea añadir un nuevo autobus? (S/N)");
                                    String respuesta = sc2.nextLine().toUpperCase();

                                    if (!respuesta.equals("S")){
                                        salidaAltaAutobus = true;
                                    }
                                }
                            }catch (IllegalArgumentException e){}
                        }while (salidaAltaAutobus);

                        break;
                    case 2: //Baja autobus

                        boolean salidaBajaAutobus = false;

                        do {
                            try{
                                System.out.println("Introduce una matricula");
                                String matricula = sc2.nextLine();

                                Autobus autobus = autobuses.existeElemento(new Autobus(matricula,"",0));

                                if (autobus != null){
                                    autobus.toString();

                                    System.out.println("Desea realmente dar de baja a este autobus? (S/N)");
                                    String respuesta = sc2.nextLine().toUpperCase();

                                    if (respuesta.equals("S")){
                                        autobuses.borrarElemento(autobus);
                                        System.out.println("Baja realizada");
                                        salidaBajaAutobus = true;
                                    }
                                    else {
                                        System.out.println("Proceso de baja abortado");
                                    }
                                }
                                else{
                                    System.out.println("Error: esta matricula no esta  registrada en la aplicacion");
                                }
                            }catch (IllegalArgumentException e){}
                        }while (salidaBajaAutobus);

                        break;
                    case 3: //Modificacion autobus

                        boolean salidaModificacionAutobus = false;

                        do {
                            try{
                                System.out.println("Introduce una matricula");
                                String matricula = sc2.nextLine();

                                Autobus autobus = autobuses.existeElemento(new Autobus(matricula,"",0));

                                if (autobus != null){

                                    System.out.println("Introduce un año de modificacion");
                                    String annoModificacion = sc2.nextLine();

                                    System.out.println("Introduce numero de plazas");
                                    int plazas = Integer.parseInt(sc2.nextLine());

                                    autobuses.modificarElemento(new Autobus(autobus.getMatricula(),annoModificacion,plazas,autobus.getViajes()));

                                    System.out.println("Desea modificar los datos de otro autobus? (S/N)");
                                    String respuesta = sc2.nextLine().toUpperCase();

                                    if (!respuesta.equals("S")){
                                        salidaModificacionAutobus = true;
                                    }
                                }
                                else{
                                    System.out.println("Error: esta matricula no esta  registrada en la aplicacion");
                                }
                            }catch (IllegalArgumentException e){}
                        }while (salidaModificacionAutobus);

                        break;
                    case 4: //Alta viaje

                        boolean salidaAltaViajes = false;

                        do {
                            try{
                                System.out.println("Introduce una matricula");
                                String matricula = sc2.nextLine();

                                Autobus autobus = autobuses.existeElemento(new Autobus(matricula,"",0));

                                if (autobus != null){

                                    System.out.println("Introduzca el codigo de viajes");
                                    int codigoViaje = Integer.parseInt(sc2.nextLine());

                                    System.out.println("Introduzca el codigo de viajes");
                                    String origen = sc2.nextLine();

                                    System.out.println("Introduzca el codigo de viajes");
                                    String destino = sc2.nextLine();

                                    System.out.println("Introduzca el codigo de viajes");
                                    String hora = sc2.nextLine();

                                    Viaje viaje = autobus.getViajes().existeElemento(new Viaje(codigoViaje,origen,destino,hora));


                                    if (viaje != null){
                                        autobuses.borrarElemento(autobus);
                                        System.out.println("Baja realizada");
                                        salidaBajaAutobus = true;
                                    }
                                    else {
                                        System.out.println("Proceso de baja abortado");
                                    }
                                }
                                else{
                                    System.out.println("Error: esta matricula no esta  registrada en la aplicacion");
                                }
                            }catch (IllegalArgumentException e){}
                        }while (salidaAltaViajes);

                        break;
                    case 5: //Baja viaje
                        break;
                    case 6: //Modificacion viaje
                        break;
                    default:
                        System.out.println("Volver al menu principal");
                        salida = true;
                        break;
                }
            }catch (IllegalArgumentException e){
                System.out.println("Introduce un numero o un numero valido");
            }
        } while (!salida);

    }

    public static void elementosLista(){
        System.out.println("\n\tMatricula\tAño Compra\tPlazas\n");
    }
    public static void zonaDeEleccion(){System.out.print("\nSelecione una opcion:");}
}
