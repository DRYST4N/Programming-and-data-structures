package librerias.estructuraDeDatos.Lineales;

public class NodoLDEG<E> {

    private E dato;
    private NodoLDEG<E> anterior,siguiente;

    public NodoLDEG(E dato)
    {
        this(dato,null,null);
    }

    public NodoLDEG(E  dato,NodoLDEG<E> anterior,NodoLDEG<E> siguiente) {
        this.dato=dato;
        this.anterior=anterior;
        this.siguiente=siguiente;
    }

    public E getDato() {
        return dato;
    }

    public void setDato(E dato) {
        this.dato = dato;
    }

    public NodoLDEG<E> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoLDEG<E> anterior) {
        this.anterior = anterior;
    }

    public NodoLDEG<E> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLDEG<E> siguiente) {
        this.siguiente = siguiente;
    }
}
