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

        if(aux==null){
            return;
        }

        while (aux != null) {
            if(aux.getDato().equals(e)){
                aux.getAnterior().setSiguiente(aux.getSiguiente());
                aux.getSiguiente().setAnterior(ant);

                this.talla--;
                return;
            }
            ant = aux;
            aux = aux.getSiguiente();
        }
    }

    @Override
    public void modificarElemento(E e) { //Este borra e inserta ya que al cambiar datos puede modificar las listas ordenadas
        NodoLDEG<E> aux = this.primero;

        while (aux != null) {
            if(aux.getDato().equals(e)){
               borrarElemento(e);
               insertarElemento(e);
            }
            aux = aux.getSiguiente();
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
}
