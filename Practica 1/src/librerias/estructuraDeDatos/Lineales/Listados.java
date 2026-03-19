package librerias.estructuraDeDatos.Lineales;


import java.util.Scanner;

public class Listados<E> {

    public Listados(){}

    public static void listarAutobusesPorNumeroPlazaAscendente(LDEGOrdenada<Autobus> autobuses){
        NodoLDEG<Autobus> aux = autobuses.getPrimero();

        System.out.println("LISTADO GENERAL DE AUTOBUSES POR NUMERO DE PLAZAS (Orden Ascendente):");
        System.out.println("\n");
        System.out.println("\tMatricula\tAño Compra \tPlazas");
        System.out.println("====================================================================");

        while (aux != null){
            String matricula = aux.getDato().getMatricula();
            String annoCompra = aux.getDato().getAnnoCompra();
            int numeroPlazas = aux.getDato().getNumeroPlazas();

            System.out.println("\t"+matricula+"\t\t"+annoCompra+"\t\t"+numeroPlazas);

            aux = aux.getSiguiente();
        }
        pause();
    }
    public static void listarAutobusesPorNumeroPlazaDescendente(LDEGOrdenada<Autobus> autobuses){
        NodoLDEG<Autobus> aux = autobuses.getPrimero();
        while (aux.getSiguiente() != null){
            aux = aux.getSiguiente();
        }
        System.out.println("LISTADO GENERAL DE AUTOBUSES POR NUMERO DE PLAZAS (Orden Descendente):");
        System.out.println("\n");
        System.out.println("\tMatricula\tAño Compra \tPlazas");
        System.out.println("====================================================================");
        while (aux != null){
            String matricula = aux.getDato().getMatricula();
            String annoCompra = aux.getDato().getAnnoCompra();
            int numeroPlazas = aux.getDato().getNumeroPlazas();

            System.out.println("\t"+matricula+"\t\t"+annoCompra+"\t\t"+numeroPlazas);

            aux = aux.getAnterior();
        }
        pause();
    }
    public static void listarGeneralViajes(LDEGOrdenada<Autobus> autobuses){
        mostrarElementosLista(elementosListaSimple()+"\tViajes");
        for (int i = 0; i < autobuses.talla();i++){
            if (autobuses.getElemento(i).getViajes().talla() == 0){
                System.out.println("\t"+autobuses.getElemento(i).getMatricula()+
                        "\t\t"+autobuses.getElemento(i).getAnnoCompra()+
                        "\t\t"+autobuses.getElemento(i).getNumeroPlazas());
            }
            else {
                for (int j = 0; j < autobuses.getElemento(i).getViajes().talla();j++){
                    System.out.println("\t"+autobuses.getElemento(i).getMatricula()+
                            "\t\t"+autobuses.getElemento(i).getAnnoCompra()+
                            "\t\t"+autobuses.getElemento(i).getNumeroPlazas()+
                            "\t\t"+autobuses.getElemento(i).getViajes().getElemento(j).getCodigo());
                }
            }
        }
    }
    public static void listarViajesPartenDeCiudadDeterminada(String ciudad,LDEGOrdenada<Autobus> autobuses){

    }
    public static void listarViajesLLeganDeCiudadDeterminada(LDEGOrdenada<Autobus> autobuses){

    }
    public static void listarAutobusesPorCantidadIgualOMayorAIndicada(LDEGOrdenada<Autobus> autobuses){

    }
    public static void listarAutobusesConMayorCantidadViajes(LDEGOrdenada<Autobus> autobuses){

    }
    public static void listarCantidadTotalViajesRealizaEmpresa(LDEGOrdenada<Autobus> autobuses){

    }
    public static void listarCantidadTotalPasajerosDeUnaCiudadAOtra(LDEGOrdenada<Autobus> autobuses){

    }

    public static String elementosListaSimple(){
        return "\n\tMatricula\tAño Compra\tPlazas";
    }

    public static void mostrarElementosLista(String cadena){
        System.out.println(cadena);
    }

    public static void pause(){
        Scanner sc = new Scanner(System.in);

        System.out.println("\nPulsa <Intro> para volver al menú...");
        sc.nextLine();
    }
}
