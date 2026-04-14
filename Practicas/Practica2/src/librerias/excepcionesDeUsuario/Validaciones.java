package librerias.excepcionesDeUsuario;

public class Validaciones {

    public static void rangosIdUsuario(int id){
        if (id < 100 || id > 999){
            throw new IllegalArgumentException("El Id de Usuario debe de estar entre 100 y 999");
        }
    }
}
