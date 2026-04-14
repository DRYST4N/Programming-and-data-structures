package librerias.estructurasDeDatos.lineales;

public class NodoLEG<E> {
    private E dato;
    private NodoLEG<E> siguiente;

    public NodoLEG(E dato) {
        this(dato, null);
    }

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
