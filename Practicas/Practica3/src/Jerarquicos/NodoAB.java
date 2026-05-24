package Jerarquicos;

/**
 * Representa un nodo en un árbol binario.
 * Contiene un elemento de tipo genérico y referencias a sus hijos izquierdo y derecho.
 * @param <E> El tipo de dato almacenado en el nodo.
 */
public class NodoAB<E> {
    private E dato;
    private NodoAB<E> izquierda;
    private NodoAB<E> derecha;

    /**
     * Construye un nuevo nodo con un dato especificado.
     * Los punteros a los hijos se inicializan como null.
     * @param dato El valor a almacenar en el nodo.
     */
    public NodoAB(E dato) {
        this.dato = dato;
        this.izquierda = null;
        this.derecha = null;
    }

    public E getDato() {
        return dato;
    }

    public void setDato(E dato) {
        this.dato = dato;
    }

    public NodoAB<E> getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoAB<E> izquierda) {
        this.izquierda = izquierda;
    }

    public NodoAB<E> getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoAB<E> derecha) {
        this.derecha = derecha;
    }
}
