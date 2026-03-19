package librerias.estructuraDeDatos.Lineales;

public class Listados<E> {

    public Listados(){}

    public static void listarAutobusesPorNumeroPlazaAscendente(LDEGOrdenada<Autobus> autobuses){

    }
    public static void listarAutobusesPorNumeroPlazaDescendente(LDEGOrdenada<Autobus> autobuses){

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
}
