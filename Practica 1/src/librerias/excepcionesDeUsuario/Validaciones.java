package librerias.excepcionesDeUsuario;

public class Validaciones {

    public class Validaciones1{}

    public static int numeroEntero(int numero) throws NumberFormatException{
        if(numero>=0 && numero<=9){
            return numero;
        }
        throw new NumberFormatException("Introduce un numero entero");
    }
}
