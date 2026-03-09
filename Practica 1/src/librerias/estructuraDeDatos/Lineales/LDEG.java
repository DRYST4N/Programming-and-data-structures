package librerias.estructuraDeDatos.Lineales;

import librerias.estructuraDeDatos.Modelo.ILEGS;

public class LDEG<E extends Comparable<E>> implements ILEGS<E> {

    private NodoLDEG<E> primero;
    private int talla;

    public LDEG() {
        this.primero=null;
        this.talla=0;
    }


    @Override
    public int talla() {
        return this.talla;
    }

    @Override
    public void insertarElemento(E e) { //Falta revisar
        NodoLDEG<E> nuevo = new NodoLDEG<E>(e);
        NodoLDEG<E> ant = null;
        NodoLDEG<E> aux = this.primero;

        while (aux != null && aux.getDato().compareTo(e) < 0) {
            ant = aux;
            aux = aux.getSiguiente();
        }

        if (ant != null) {
            ant.setSiguiente(nuevo);
        }
        nuevo.setAnterior(ant);
        nuevo.setSiguiente(aux);

        this.talla++;
    }

    @Override
    public void borrarElemento(E e) {
        NodoLDEG<E> ant = null;
        NodoLDEG<E> aux = this.primero;
        NodoLDEG<E> enc = null;

        /*while (aux!=null && !aux.getDato().equals(e)){
            if (aux.getDato().equals()) {}
            ant = aux;
            aux = aux.getSiguiente();
        }*/
    }

    @Override
    public void modificarElemento(E e) {

    }

    @Override
    public boolean existeElemento(E e) {
        NodoLDEG<E> aux = this.primero;

        while (aux!=null) {
            if (aux.getDato().equals(e)) {
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }
}
