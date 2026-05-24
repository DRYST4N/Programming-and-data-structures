package Modelo;

/**
 * Interfaz que define el TAD Árbol Binario de claves enteras (ABEnteros).
 */
public interface I_ABEnteros extends I_AB<Integer> {
    /**
     * Comprueba si el arbol binario de enteros es un arbol Binario de Búsqueda.
     *
     * @return true si el árbol es ABB o false
     *         en caso contrario.
     */
    boolean EsABB();
    /**
     * Comprueba si el valor de la clave de la raíz es igual al número de
     * nodos internos del árbol.
     *
     * @return true si raiz.getDato() == número de nodos internos o
     *         false en caso contrario o si el árbol está vacío.
     */
    boolean RaizIgualNodosInternos();
    /**
     * Calcula el valor mínimo existente en un nivel dado del árbol.
     *
     * @param n Nivel en el que se buscará el valor mínimo.
     * @return El valor mínimo encontrado en el nivel n.
     */
    int MinimoValorNivel(int n);
}
