package librerias.estructuraDeDatos.Lineales;

import librerias.estructuraDeDatos.Modelo.ILEGS;

public class LDEGOrdenada<E extends Comparable<E>> implements ILEGS<E> {

    private NodoLDEG<E> primero;
    private int talla;

    public LDEGOrdenada() {
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

        if (ant == null) {
            this.primero = nuevo;
        }
        else {
            ant.setSiguiente(nuevo);
        }

        nuevo.setAnterior(ant);
        nuevo.setSiguiente(aux);

        if (aux != null) {
            aux.setAnterior(nuevo);
        }

        this.talla++;
    }

    @Override
    public void borrarElemento(E e) {
        NodoLDEG<E> aux = this.primero;

        while (aux != null) {
            if(aux.getDato().equals(e)){

                if(aux.getAnterior()==null){
                    this.primero=aux.getSiguiente();
                }
                else {
                    aux.getAnterior().setSiguiente(aux.getSiguiente());
                }

                if(aux.getSiguiente()!=null){
                    aux.getSiguiente().setAnterior(aux.getAnterior());
                }

                this.talla--;
                return;
            }
            aux = aux.getSiguiente();
        }
    }

    @Override
    public void modificarElemento(E e) { //Este borra e inserta ya que al cambiar datos puede modificar las listas ordenadas

        if (existeElemento(e) != null) {
            borrarElemento(e);
            insertarElemento(e);
        }

    }

    @Override
    public E existeElemento(E e) {
        NodoLDEG<E> aux = this.primero;

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
        NodoLDEG<E> aux = this.primero;
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
