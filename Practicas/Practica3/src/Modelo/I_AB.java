package Modelo;

import Jerarquicos.NodoAB;

/**
 * Interfaz que define el TAD Árbol Binario genérico.
 *
 * @param <E> El tipo de dato que almacenará el árbol.
 */
public interface I_AB<E> {
    /**
     * Indica si el árbol está vacío.
     *
     * @return true si la raíz es null o false en caso contrario.
     */
    boolean esVacio();
    /**
     * Devuelve el subárbol derecho como un nuevo AB.
     *
     * @return El subárbol derecho o un AB vacío si no existe.
     */
    I_AB<E> getDerecha();
    /**
     * Devuelve el subárbol izquierdo como un nuevo AB.
     *
     * @return El subárbol izquierdo o un AB vacío si no existe.
     */
    I_AB<E> getIzquierda();
    /**
     * Devuelve el dato almacenado en el nodo raíz.
     *
     * @return El dato de la raíz o null si el árbol está vacío.
     */
    E getDato();
    /**
     * Devuelve el nodo raíz del árbol.
     *
     * @return El NodoAB raíz o null si el árbol está vacío.
     */
    NodoAB<E> getRaiz();
    /**
     * Indica si el árbol es una hoja.
     *
     * @return true si el nodo raíz no tiene hijos o false en caso contrario
     *         o si el árbol está vacío.
     */
    boolean esHoja();
    /**
     * Elimina todos los nodos que se encuentran en niveles
     * inferiores al nivel dado.
     *
     * @param nivel Nivel a partir del cual se eliminan los nodos inferiores.
     */
    void EliminarNodosInferiores(int nivel);
    /**
     * Calcula el número total de niveles del árbol.
     *
     * @return El número de niveles del árbol.
     */
    int nivelesAB();
    /**
     * Muestra las claves del árbol en recorrido PreOrden.
     */
    void PreOrden();
    /**
     * Muestra las claves del árbol en recorrido InOrden
     */
    void InOrden();
    /**
     * Muestra las claves del árbol en recorrido InOrden Converso
     */
    void InOrdenConverso();
    /**
     * Muestra las claves del árbol en recorrido PostOrden
     */
    void PostOrden();
    /**
     * Establece el subárbol derecho del árbol actual.
     *
     * @param derecho El I_AB que se asignará como subárbol derecho.
     */
    void setDerecha(I_AB<E> derecho);
    /**
     * Establece el subárbol izquierdo del árbol actual.
     *
     * @param izquierdo El I_AB que se asignará como subárbol izquierdo.
     */
    void setIzquierda(I_AB<E> izquierdo);
    /**
     * Establece el dato del nodo raíz.
     *
     * @param dato El valor a asignar a la raíz.
     */
    void setDato(E dato);
}
