package librerias.excepcionesDeUsuario;

public class Validaciones {

    public static void rangosIdUsuario(int id){
        if (id < 100 || id > 999){
            throw new IllegalArgumentException("El Id de Usuario debe de estar entre 100 y 999");
        }
    }

    public static void rangoPrioridad(int prioridad){
        if (prioridad < 1 || prioridad > 9){
            throw new IllegalArgumentException("El Prioridad debe ser entre 1 y 9");
        }
    }
}
