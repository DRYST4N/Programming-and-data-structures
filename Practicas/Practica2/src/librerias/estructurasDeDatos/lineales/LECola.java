package librerias.estructurasDeDatos.lineales;

import librerias.estructurasDeDatos.modelos.I_Cola;

public class LECola<E> implements I_Cola<E> {

    private NodoLEG<E> primero;
    private NodoLEG<E> ultimo;

    public LECola(){
        this.primero= null;
        this.ultimo= null;
    }

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

    @Override
    public E primero() {
        if(esVacia()){
            return null;
        }
        return this.primero.getDato();
    }

    @Override
    public boolean esVacia() {
        return this.primero == null;
    }

    @Override
    public int contarElemCola() {
        return contarElemCola(this.primero);
    }

    private int contarElemCola(NodoLEG<E> actual){
        if (actual == null){
            return 0;
        }
        return 1 + contarElemCola(actual.getSiguiente());
    }
}
