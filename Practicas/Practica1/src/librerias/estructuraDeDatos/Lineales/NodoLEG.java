package librerias.estructuraDeDatos.Lineales;

/**
 * Representa un nodo individual para una Lista Enlazada Genérica.
 * Actúa como un contenedor que guarda un dato y una referencia al siguiente nodo en la secuencia.
 * @param <E> El tipo genérico de dato que almacenará el nodo.
 */
public class NodoLEG<E> {
    private E dato;
    private NodoLEG<E> siguiente;

    /**
     * Constructor para crear un nodo aislado.
     * El puntero al siguiente nodo se inicializa por defecto a null.
     * @param dato El elemento que se va a almacenar en este nodo.
     */
    public NodoLEG(E dato) {
        this(dato, null);
    }

    /**
     * Constructor para crear un nodo estableciendo su enlace
     * al nodo que le sucederá en la lista.
     * @param dato      El elemento que se va a almacenar en este nodo.
     * @param siguiente La referencia al nodo que ocupará la siguiente posición en la estructura.
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