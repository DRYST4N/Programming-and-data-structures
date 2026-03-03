package Codigo;

public class main {
   
    public static void main(String [] args){
        
    }

    public static void menuPrincipal(){
        System.out.println("MENU PRINCIPAL");
        System.out.println();
        System.out.println("1.-Mantenimiento");
        System.out.println("2.-Listado");
        System.out.println("0.-Salir");
    }

    public static void menuMantenimiento(){
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

    public static void menuListado(){
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

    public static boolean listadoDeElementos(int eleccion){ //Falta añadir la lista enlazada por parametro y los metodos que devuelvan true si se ha completado de forma correcta y false si no
        switch (eleccion) {
            case 1:
                System.out.println("Listado general de autobuses ordenado por numero de plazas".toUpperCase()+" (orden ascendente)");
                elementosLista();
            case 2:
                System.out.println("Listado general de autobuses ordenado por numero de plazas".toUpperCase()+" (orden descendente)");
                elementosLista();
            case 3:
                System.out.println("Listado general de viajes".toUpperCase());
                elementosLista();
            case 4:
                System.out.println("Listado de viajes que parten de una ciudad determinada".toUpperCase());
                elementosLista();
            case 5:
                System.out.println("Listado de viajes que llegan a una ciudad determinada".toUpperCase());
                elementosLista();
            case 6:
                System.out.println("Listado de autobuses que tienen una capacidad mayor o igual a la indicada por el usuario".toUpperCase());
                elementosLista();
            case 7:
                System.out.println("Listado de autobus o autobuses que realizan la mayor cantidad de viajes".toUpperCase());
                elementosLista();
            case 8:
                System.out.println("Cantidad total de viajes que realizan los autobuses de la empresa".toUpperCase());
                elementosLista();
            case 9:
                System.out.println("Cantidad total de pasajeros que viajan de una ciudad a otra".toUpperCase());
                elementosLista();
            default:
                System.out.println("Volver al menu principal");
                return true;
        }
    }

    public static boolean opcionesDeMantenimiento(int eleccion){ //Falta añadir la lista enlazada por parametro y los metodos que devuelvan true si se ha completado de forma correcta y false si no
        switch (eleccion) {
            case 1: //Alta autobus
                
            case 2: //Baja autobus
                
            case 3: //Modificacion autobus
                
            case 4: //Alta viaje
                
            case 5: //Baja viaje
                
            case 6: //Modificacion viaje
                
            default:
                System.out.println("Volver al menu principal");
                return true;
        }
    }


    public static void elementosLista(){
        System.out.println("\n\tMatricula\tAño Compra\tPlazas\n");
    }
}
