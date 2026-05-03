package Jerárquicos;

public class NodoAB<E> {
    private E dato;
    private NodoAB<E> izquierda;
    private NodoAB<E> derecha;

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
