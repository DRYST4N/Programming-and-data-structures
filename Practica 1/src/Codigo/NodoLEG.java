package Codigo;

import Interfaces.INodo;

public class NodoLEG<E> implements INodo  {
    private E dato;
    private NodoLEG<E> siguiente;
    private NodoLEG<E> primero;

    public NodoLEG(E dato) {
        this.dato = dato;
    }
    public NodoLEG(E dato, NodoLEG<E> siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }
    public NodoLEG(E dato, NodoLEG<E> siguiente, NodoLEG<E> primero) {
        this.dato = dato;
        this.siguiente = siguiente;
        this.primero = primero;
    }

    //Setter
    public void setDato(E dato) {
        this.dato = dato;
    }
    public void setSiguiente(NodoLEG<E> siguiente) {
        this.siguiente = siguiente;
    }
    public void setPrimero(NodoLEG<E> primero) {
        this.primero = primero;
    }

    //Getters
    public E getDato() {
        return dato;
    }

    public NodoLEG<E> getPrimero() {
        return primero;
    }

    public NodoLEG<E> getSiguiente() {
        return siguiente;
    }

    //Agregar items
    public void AddItem(NodoLEG item2, NodoLEG item3) {
        item2.setSiguiente(item3);
    }

    //Para devolver items
    public NodoLEG SelectItem(NodoLEG item2) {
        return item2;
    }

    //Para borrar items
    public void DeleteItem(NodoLEG item2) {
        NodoLEG aux = item2.getSiguiente().getSiguiente();

        item2.setSiguiente(aux);
    }
}
