package Codigo;

public class NodoLDEG<E> {

    E dato;
    NodoLDEG<E> anterior,siguiente;

    public NodoLDEG(E dato)
    {
        this(dato,null,null);
    }

    public NodoLDEG(E  dato,NodoLDEG<E> anterior,NodoLDEG<E> siguiente) {
        this.dato=dato;
        this.anterior=anterior;
        this.siguiente=siguiente;
    }
}
