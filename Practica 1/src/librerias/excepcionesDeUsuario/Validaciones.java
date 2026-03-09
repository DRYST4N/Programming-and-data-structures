package librerias.excepcionesDeUsuario;

public class Validaciones {

    public class Validaciones1{}

    public static int numeroEntero(int numero,int total) throws IllegalArgumentException{
        for (int i = 0; i < total;i++){
            if(numero == i){
                return numero;
            }
        }
        throw new IllegalArgumentException("Introduce un numero entero");
    }
}
