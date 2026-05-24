package Excepciones;

/**
 * Clase para la validación y lanzamiento
 * de excepciones relacionadas con los TADs.
 * Todos sus métodos son estáticos.
 */
public class Excepciones {

    /**
     * Comprueba que el nivel solicitado existe en el árbol.
     * Lanza una excepcion IllegalArgumentException si el nivel pedido
     * es negativo o mayor o igual que el número de niveles del árbol.
     * Se considera que el nivel de la raíz es el nivel 0.
     *
     * @param nivel   Nivel solicitado por el usuario.
     * @param niveles Número total de niveles que tiene el árbol,
     * @throws IllegalArgumentException Si nivel es negativo
     *         o no existe en el árbol.
     */
    public static void nivelesFueraDeRango(int nivel, int niveles) {

        if (nivel >= niveles || nivel < 0){
            throw new IllegalArgumentException("ERROR: no existen "+nivel+" niveles en el árbol. El árbol tiene "+niveles+" niveles");
        }

    }
}
