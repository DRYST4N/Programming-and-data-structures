package Codigo;

import java.util.Scanner;

public class main {
   
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
        Scanner sc = new Scanner(System.in);

        do {
            opcionesMenuPrincipal();
            zonaDeEleccion();

            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    menuMantenimiento();
                    break;
                case 2:
                    menuListado();
                    break;
                default:
                    System.out.println("Saliendo del programa");
                    salida = true;
                    break;
            }
        }while (!salida);
    }


    public static void menuListado(){//Falta añadir la lista enlazada por parametro y los metodos que devuelvan true si se ha completado de forma correcta y false si no

        boolean salida = false;
        Scanner sc = new Scanner(System.in);

        do{
            opcionesMenuListado();
            zonaDeEleccion();
            int eleccion = sc.nextInt();

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
        }while (!salida);
    }

    public static void menuMantenimiento() {//Falta añadir la lista enlazada por parametro y los metodos que devuelvan true si se ha completado de forma correcta y false si no

        boolean salida = false;
        Scanner sc = new Scanner(System.in); //Para escanear los datos por teclado

        do {
            opcionesMenuMantenimiento(); //Llamamos a las opciones del menu
            zonaDeEleccion();

            int eleccion = sc.nextInt();//Escaneamos y guardamos la eleccion para usarla

            switch (eleccion) {
                case 1: //Alta autobus
                    break;
                case 2: //Baja autobus
                    break;
                case 3: //Modificacion autobus
                    break;
                case 4: //Alta viaje
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
        } while (!salida);

    }

    public static void elementosLista(){
        System.out.println("\n\tMatricula\tAño Compra\tPlazas\n");
    }
    public static void zonaDeEleccion(){System.out.print("\nSelecione una opcion:");}
}
