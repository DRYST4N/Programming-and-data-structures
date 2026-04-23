package librerias.estructurasDeDatos.lineales;

/**
 * Representa un nodo genérico individual para una estructura de datos lineal
 * enlazada simple.
 *
 * @param <E> Tipo genérico del dato que almacenará el nodo.
 */
public class NodoLEG<E> {

    private E dato;
    private NodoLEG<E> siguiente;

    /**
     * Constructor del nodo. Inicializa el nodo con un dato y establece
     * el puntero al siguiente nodo como nulo por defecto.
     *
     * @param dato El elemento de tipo genérico E que se guardará en el nodo.
     */
    public NodoLEG(E dato) {
        this(dato, null);
    }

    /**
     * Constructor del nodo. Inicializa el nodo con un dato y establece
     * el puntero al siguiente nodo.
     *
     * @param dato El elemento de tipo genérico E que se guardará en el nodo.
     * @param siguiente El nodo de tipo genérico E que apunta al siguiente nodo.
     */
    public NodoLEG(E dato, NodoLEG<E> siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    //Setter
    public void setDato(E dato) {
        this.dato = dato;
    }

    public void setSiguiente(NodoLEG<E> siguiente) {
        this.siguiente = siguiente;
    }

    //Getters
    public E getDato() {
        return dato;
    }

    public NodoLEG<E> getSiguiente() {
        return siguiente;
    }
}
