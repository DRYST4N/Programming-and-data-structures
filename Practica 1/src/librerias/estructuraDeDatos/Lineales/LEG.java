package librerias.estructuraDeDatos.Lineales;

import librerias.estructuraDeDatos.Modelo.ILEGS;

public class LEG<E> implements ILEGS<E> {

    private NodoLEG<E> primero;
    private int talla;

    public LEG(){
        this.primero= null;
        this.talla=0;
    }

    @Override
    public int talla(){
        return this.talla;
    }

    @Override
    public void insertarElemento(E e) {
        NodoLEG<E> nuevo = new NodoLEG<E>(e);
        NodoLEG<E> aux = this.primero;

        if (aux==null) {
            this.primero = nuevo;
        }
        else{
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
            nuevo.setSiguiente(aux.getSiguiente());
        }
        this.talla++;
    }

    @Override
    public void borrarElemento(E e) {
        NodoLEG<E> aux = this.primero;
        NodoLEG<E> ant = null;

        while (aux!=null) {
            if (aux.getDato().equals(e)) {
                if (ant==null) {
                    this.primero = aux.getSiguiente();
                }
                else {
                    ant.setSiguiente(aux);
                }

                this.talla--;
            }
            ant = aux;
            aux = aux.getSiguiente();
        }
    }

    @Override
    public void modificarElemento(E e) {
        NodoLEG<E> aux = this.primero;

        while (aux != null) {
            if(aux.getDato().equals(e)){
                aux.setDato(e);
                return;
            }
            aux = aux.getSiguiente();
        }
    }

    @Override
    public E existeElemento(E e) {
        NodoLEG<E> aux = this.primero;

        while (aux!=null) {
            if (aux.getDato().equals(e)) {
                return aux.getDato();
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    @Override
    public E getElemento(int i) {
        NodoLEG<E> aux = this.primero;
        int  contador = 0;

        while (aux!=null) {
            if (contador==i) {
                return aux.getDato();
            }
            aux = aux.getSiguiente();
            contador++;
        }
        return  null;
    }

}
