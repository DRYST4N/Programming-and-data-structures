package librerias.excepcionesDeUsuario;

/**
 * Clase que centraliza la lógica de validación de los datos
 */
public class Validaciones {

    /**
     * Verifica que el identificador numérico de un usuario se encuentre
     * dentro del rango permitido.
     *
     * @param id El número entero introducido por el usuario.
     * @throws IllegalArgumentException Si el ID es menor a 100 o mayor a 999.
     */
    public static void rangosIdUsuario(int id){
        if (id < 100 || id > 999){
            throw new IllegalArgumentException("El Id de Usuario debe de estar entre 100 y 999");
        }
    }

    /**
     * Verifica que el nivel de prioridad solicitado se corresponda con un nivel válido
     * de la estructura.
     *
     * @param prioridad El número de prioridad introducido por el usuario.
     * @throws IllegalArgumentException Si la prioridad es menor a 1 o mayor a 9.
     */
    public static void rangoPrioridad(int prioridad){
        if (prioridad < 1 || prioridad > 9){
            throw new IllegalArgumentException("El Prioridad debe ser entre 1 y 9");
        }
    }
}
