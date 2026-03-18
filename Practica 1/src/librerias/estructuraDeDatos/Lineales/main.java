package librerias.estructuraDeDatos.Lineales;

import java.util.Scanner;

import librerias.excepcionesDeUsuario.ReglasImpuestasException;
import librerias.excepcionesDeUsuario.Validaciones;

public class main {

    static Scanner sc = new Scanner(System.in); //Se ha dejado un scanner por si se ralla el prama

    public static void main(String [] args){
        menuPrincipal();
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

        LDEGOrdenada<Autobus> autobuses = new LDEGOrdenada<Autobus>();

        do {
            try {
                opcionesMenuPrincipal();
                zonaDeEleccion();

                int opcion = Integer.parseInt(sc.nextLine());
                Validaciones.validarOpcionesMenu(opcion, 3);

                creacionAutomatica(autobuses);

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
            }catch(NumberFormatException e) {
                System.out.println("Error: Debe seleccionar un numero");
            }catch(IllegalArgumentException e){
                System.out.println("Error validacion: " + e.getMessage());
            }
        }while (!salida);
    }


    public static void menuListado(LDEGOrdenada<Autobus> autobuses){//Falta añadir la lista enlazada por parametro y los metodos que devuelvan true si se ha completado de forma correcta y false si no

        boolean salida = false;

        do{
            try{
                opcionesMenuListado();
                zonaDeEleccion();

                int eleccion = Integer.parseInt(sc.nextLine());
                Validaciones.validarOpcionesMenu(eleccion,10);

                switch (eleccion) {
                    case 1:
                        System.out.println("Listado general de autobuses ordenado por numero de plazas".toUpperCase()+" (orden ascendente)");
                        break;
                    case 2:
                        System.out.println("Listado general de autobuses ordenado por numero de plazas".toUpperCase()+" (orden descendente)");
                        break;
                    case 3:
                        System.out.println("Listado general de viajes".toUpperCase());
                        Listados.listarGeneralViajes(autobuses);
                        break;
                    case 4:
                        System.out.println("Listado de viajes que parten de una ciudad determinada".toUpperCase());
                        break;
                    case 5:
                        System.out.println("Listado de viajes que llegan a una ciudad determinada".toUpperCase());
                        break;
                    case 6:
                        System.out.println("Listado de autobuses que tienen una capacidad mayor o igual a la indicada por el usuario".toUpperCase());
                        break;
                    case 7:
                        System.out.println("Listado de autobus o autobuses que realizan la mayor cantidad de viajes".toUpperCase());
                        break;
                    case 8:
                        System.out.println("Cantidad total de viajes que realizan los autobuses de la empresa".toUpperCase());
                        break;
                    case 9:
                        System.out.println("Cantidad total de pasajeros que viajan de una ciudad a otra".toUpperCase());
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

    public static void menuMantenimiento(LDEGOrdenada<Autobus> autobuses) {//Falta añadir la lista enlazada por parametro y los metodos que devuelvan true si se ha completado de forma correcta y false si no

        boolean salida = false;

        do {
            try{
                opcionesMenuMantenimiento(); //Llamamos a las opciones del menu
                zonaDeEleccion();

                int eleccion = Integer.parseInt(sc.nextLine());//Escaneamos y guardamos la eleccion para usarla
                Validaciones.validarOpcionesMenu(eleccion,7);

                switch (eleccion) {
                    case 1: //Alta autobus

                        boolean salidaAltaAutobus = false;

                        do {
                            try {
                                System.out.println("Introduce una matricula");
                                String matricula = sc.nextLine();

                                if (autobuses.existeElemento(new Autobus(matricula, "", 0)) != null) {
                                    System.out.println("Error: ya existe un autobus registrado con esa matricula");
                                } else {
                                    System.out.println("Introduce el año de compra");
                                    String annoCompra = sc.nextLine();

                                    System.out.println("Introduce numero de plazas");
                                    int plazas = Integer.parseInt(sc.nextLine());

                                    Validaciones.validarNumeroNoNegativo(plazas);

                                    autobuses.insertarElemento(new Autobus(matricula, annoCompra, plazas));

                                    System.out.println("Desea añadir un nuevo autobus? (S/N)");
                                    String respuesta = sc.nextLine().toUpperCase();

                                    if (!respuesta.equals("S")) {
                                        salidaAltaAutobus = true;
                                    }
                                }
                            }catch (NumberFormatException e) {
                                System.out.println("Error: Debe seleccionar un numero");
                            }catch (ReglasImpuestasException e) {
                                System.out.println("Error: Regla no cumplida: "+e.getMessage());
                            }catch(IllegalArgumentException e){
                                System.out.println("Error validacion: " + e.getMessage());
                            }
                        }while (!salidaAltaAutobus);

                        break;
                    case 2: //Baja autobus

                        boolean salidaBajaAutobus = false;

                        do {
                            try{
                                System.out.println("Introduce una matricula");
                                String matricula = sc.nextLine();

                                Autobus autobus = autobuses.existeElemento(new Autobus(matricula,"",0));

                                if (autobus != null){
                                    System.out.println(autobus.toString());

                                    System.out.println("Desea realmente dar de baja a este autobus? (S/N)");
                                    String respuesta = sc.nextLine().toUpperCase();

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
                            }catch (NumberFormatException e) { //Comprueba Integer.parseInt
                                System.out.println("Error: Debe seleccionar un numero");
                            }catch (ReglasImpuestasException e) { //Comprueba la excepcion creada
                                System.out.println("Error: Regla no cumplida: "+e.getMessage());
                            }catch(IllegalArgumentException e){ //Comprueba las validaciones
                                System.out.println("Error validacion: " + e.getMessage());
                            }
                        }while (!salidaBajaAutobus);

                        break;
                    case 3: //Modificacion autobus

                        boolean salidaModificacionAutobus = false;

                        do {
                            try{
                                System.out.println("Introduce una matricula");
                                String matricula = sc.nextLine();

                                Autobus autobus = autobuses.existeElemento(new Autobus(matricula,"",0));

                                if (autobus != null){

                                    System.out.println("Introduce un año de modificacion");
                                    String annoModificacion = sc.nextLine();

                                    System.out.println("Introduce numero de plazas");
                                    int plazas = Integer.parseInt(sc.nextLine());

                                    Validaciones.validarNumeroNoNegativo(plazas);

                                    autobuses.modificarElemento(new Autobus(autobus.getMatricula(),annoModificacion,plazas,autobus.getViajes()));

                                    System.out.println("Desea modificar los datos de otro autobus? (S/N)");
                                    String respuesta = sc.nextLine().toUpperCase();

                                    if (!respuesta.equals("S")){
                                        salidaModificacionAutobus = true;
                                    }
                                }
                                else{
                                    System.out.println("Error: esta matricula no esta  registrada en la aplicacion");
                                }
                            }catch (NumberFormatException e) {
                                System.out.println("Error: Debe seleccionar un numero");
                            }catch (ReglasImpuestasException e) {
                                System.out.println("Error: Regla no cumplida: "+e.getMessage());
                            }catch(IllegalArgumentException e){
                                System.out.println("Error validacion: " + e.getMessage());
                            }
                        }while (!salidaModificacionAutobus);

                        break;
                    case 4: //Alta viaje

                        boolean salidaAltaViajes = false;

                        do {
                            try{
                                System.out.println("Introduce una matricula");
                                String matricula = sc.nextLine();

                                Autobus autobus = autobuses.existeElemento(new Autobus(matricula,"",0));

                                if (autobus != null){

                                    System.out.println("Introduzca el codigo de viajes");
                                    int codigoViaje  = Integer.parseInt(sc.nextLine());

                                    Validaciones.validarNumeroNoNegativo(codigoViaje);

                                    if (existeCodigoViaje(codigoViaje,autobuses)){
                                        System.out.println("Ya existe un viaje con este codigo");
                                    }
                                    else {
                                        System.out.println("Introduzca el origen del viaje");
                                        String origen = sc.nextLine().toLowerCase();

                                        System.out.println("Introduzca el destino del viaje");
                                        String destino = sc.nextLine().toLowerCase();

                                        System.out.println("Introduzca la hora del viaje");
                                        String hora = sc.nextLine();

                                        if (!autobus.ciudadVailida(origen) ||  !autobus.ciudadVailida(destino)){
                                            throw new ReglasImpuestasException("Las ciudades permitidas son: Madrid, Segovia, Barcelona y Sevilla.");
                                        }

                                        Viaje viaje = new Viaje(codigoViaje,origen,destino,hora);
                                        autobus.registrarViaje(viaje);
                                        salidaAltaViajes = true;
                                    }
                                }
                                else{
                                    System.out.println("Error: esta matricula no esta  registrada en la aplicacion");
                                }
                            }catch (NumberFormatException e) {
                                System.out.println("Error: Debe seleccionar un numero");
                            }catch (ReglasImpuestasException e) {
                                System.out.println("Error: Regla no cumplida: "+e.getMessage());
                            }catch(IllegalArgumentException e){
                                System.out.println("Error validacion: " + e.getMessage());
                            }
                        }while (!salidaAltaViajes);

                        break;
                    case 5: //Baja viaje

                        boolean salidaBajaViajes = false;

                        do {
                            try{
                                System.out.println("Introduce una matricula");
                                String matricula = sc.nextLine();

                                Autobus autobus = autobuses.existeElemento(new Autobus(matricula,"",0));

                                if (autobus != null){

                                    System.out.println("Introduzca el codigo de viajes");
                                    int codigoViaje = Integer.parseInt(sc.nextLine());

                                    Viaje viaje = autobus.getViajes().existeElemento(new Viaje(codigoViaje,"","",""));

                                    if (viaje != null){

                                        System.out.println("Desea realmente dar de baja este viaje? (S/N)");
                                        String respuesta = sc.nextLine().toUpperCase();

                                        System.out.println(viaje.toString());

                                        if (respuesta.equals("S")){
                                            autobus.bajaViajes(viaje);
                                            System.out.println("Baja realizada");
                                            salidaBajaViajes = true;
                                        }
                                        else {
                                            System.out.println("Proceso de baja abortado");
                                            salidaBajaViajes = true;
                                        }
                                    }
                                    else{
                                        System.out.println("No existe un viaje con este codigo");
                                    }
                                }
                                else{
                                    System.out.println("Error: esta matricula no esta  registrada en la aplicacion");
                                }
                            }catch (NumberFormatException e) {
                                System.out.println("Error: Debe seleccionar un numero");
                            }catch (ReglasImpuestasException e) {
                                System.out.println("Error: Regla no cumplida: "+e.getMessage());
                            }catch(IllegalArgumentException e){
                                System.out.println("Error validacion: " + e.getMessage());
                            }
                        }while (!salidaBajaViajes);

                        break;
                    case 6: //Modificacion viaje

                        boolean salidaModificacionViajes = false;

                        do {
                            try{
                                System.out.println("Introduce una matricula");
                                String matricula = sc.nextLine();

                                Autobus autobus = autobuses.existeElemento(new Autobus(matricula,"",0));

                                if (autobus != null){

                                    autobus.listarViajes();

                                    System.out.println("Que viaje desea modificar? (introduce el codigo del viaje a modificar)");
                                    int codigoViaje = Integer.parseInt(sc.nextLine());

                                    Viaje viaje = autobus.getViajes().existeElemento(new Viaje(codigoViaje,"","",""));

                                    if (viaje != null){

                                        System.out.println(viaje.toString());

                                        System.out.println("Introduzca el origen del viaje");
                                        String origen = sc.nextLine().toLowerCase();

                                        System.out.println("Introduzca el destino del viaje");
                                        String destino = sc.nextLine().toLowerCase();

                                        System.out.println("Introduzca la hora del viaje");
                                        String hora = sc.nextLine();

                                        if (!autobus.ciudadVailida(origen) ||  !autobus.ciudadVailida(destino)){
                                            throw new ReglasImpuestasException("Las ciudades permitidas son: Madrid, Segovia, Barcelona y Sevilla.");
                                        }

                                        autobus.modificarViajes(new Viaje(codigoViaje,origen,destino,hora));

                                        System.out.println("Autobus "+autobus.getMatricula()+": Viaje "+viaje.getCodigo()+" modificado correctamente");
                                    }
                                    else{
                                        System.out.println("No existe un viaje con este codigo");
                                    }
                                }
                                else{
                                    System.out.println("Error: esta matricula no esta  registrada en la aplicacion");
                                }
                            }catch (NumberFormatException e) {
                                System.out.println("Error: Debe seleccionar un numero");
                            }catch (ReglasImpuestasException e) {
                                System.out.println("Error: Regla no cumplida: "+e.getMessage());
                            }catch(IllegalArgumentException e){
                                System.out.println("Error validacion: " + e.getMessage());
                            }
                        }while (!salidaModificacionViajes);

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


    public static void zonaDeEleccion(){System.out.print("\nSelecione una opcion:");}

    public static boolean existeCodigoViaje(int codigoViaje, LDEGOrdenada<Autobus>autobuses){
        for (int i = 0; i < autobuses.talla(); i++){
            Autobus autobus = autobuses.getElemento(i);

            if (autobus.getViajes().existeElemento(new Viaje(codigoViaje,"","","")) != null){
                return true;
            }
        }
        return false;
    }

    public static void creacionAutomatica(LDEGOrdenada<Autobus> autobuses){

        Autobus autobus1 = new Autobus("345HBG", "2030", 34);
        Autobus autobus2 = new Autobus("654KAJ", "2070", 24);
        Autobus autobus3 = new Autobus("826ÑPL", "2043", 14);

        autobuses.insertarElemento(autobus1);
        autobuses.insertarElemento(autobus2);
        autobuses.insertarElemento(autobus3);

        Viaje viaje1 = new Viaje(123456,"madrid","barcelona","20:00");
        Viaje viaje2 = new Viaje(654321,"barcelona","madrid","10:45");
        Viaje viaje3 = new Viaje(678905,"segovia","madrid","12:15");

        autobus1.registrarViaje(viaje1);
        autobus1.registrarViaje(viaje2);
        autobus2.registrarViaje(viaje3);
    }
}
