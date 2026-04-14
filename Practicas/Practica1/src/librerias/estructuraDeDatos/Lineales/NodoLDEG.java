package librerias.estructuraDeDatos.Lineales;

/**
 * Representa un nodo para una Lista Doblemente Enlazada Generica.
 * Este nodo almacena referencias tanto al nodo
 * siguente como al nodo anterior en la secuencia
 * @param <E> El tipo genérico de dato que almacenará el nodo.
 */
public class NodoLDEG<E> {

    private E dato;
    private NodoLDEG<E> anterior,siguiente;

    /**
     * Constructor para crear un nodo aislado.
     * Los punteros al nodo anterior y siguiente se inicializan por defecto a nulo.
     * @param dato El elemento que se va a almacenar en este nodo.
     */
    public NodoLDEG(E dato)
    {
        this(dato,null,null);
    }

    /**
     * Constructor para crear un nodo estableciendo sus enlaces
     * tanto al nodo anterior como al siguiente en la lista.
     * @param dato      El elemento que se va a almacenar en este nodo.
     * @param anterior  La referencia al nodo predecesor en la estructura.
     * @param siguiente La referencia al nodo sucesor en la estructura.
     */
    public NodoLDEG(E  dato,NodoLDEG<E> anterior,NodoLDEG<E> siguiente) {
        this.dato=dato;
        this.anterior=anterior;
        this.siguiente=siguiente;
    }

    //Getters
    public E getDato() {
        return dato;
    }
    public NodoLDEG<E> getAnterior() {
        return anterior;
    }
    public NodoLDEG<E> getSiguiente() {
        return siguiente;
    }

    //Setters
    public void setDato(E dato) {
        this.dato = dato;
    }
    public void setAnterior(NodoLDEG<E> anterior) {
        this.anterior = anterior;
    }
    public void setSiguiente(NodoLDEG<E> siguiente) {
        this.siguiente = siguiente;
    }
}