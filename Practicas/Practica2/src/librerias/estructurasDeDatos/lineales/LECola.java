package librerias.estructurasDeDatos.lineales;

import librerias.estructurasDeDatos.modelos.I_Cola;

/**
 * Implementación del TAD Cola mediante nodos enlazados.
 *
 * @param <E> Tipo genérico de los elementos almacenados.
 */
public class LECola<E> implements I_Cola<E> {

    private NodoLEG<E> primero;
    private NodoLEG<E> ultimo;

    /**
     * Constructor por defecto.
     */
    public LECola(){
        this.primero= null;
        this.ultimo= null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void encolar(E dato) {
        NodoLEG<E> nuevo = new NodoLEG<>(dato);
        if(esVacia()){
            this.primero = nuevo;
        }
        else {
            this.ultimo.setSiguiente(nuevo);
        }
        this.ultimo = nuevo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E desencolar() {
        if (esVacia()) {
            return null;
        }

        E dato = this.primero.getDato();

        this.primero = this.primero.getSiguiente();

        if (esVacia()) {
            ultimo = null;
        }

        return dato;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E primero() {
        if(esVacia()){
            return null;
        }
        return this.primero.getDato();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean esVacia() {
        return this.primero == null;
    }

    /**
     * {@inheritDoc}
     * Realiza la llamada al método auxiliar recursivo pasando el primer nodo.
     */
    @Override
    public int contarElemCola() {
        return contarElemCola(this.primero);
    }

    /**
     * Método auxiliar privado que calcula el número de nodos de forma recursiva.
     * @param actual El nodo actual que se está evaluando.
     * @return El recuento acumulado de los nodos restantes más el nodo actual.
     */
    private int contarElemCola(NodoLEG<E> actual){
        if (actual == null){
            return 0;
        }
        return 1 + contarElemCola(actual.getSiguiente());
    }
}
