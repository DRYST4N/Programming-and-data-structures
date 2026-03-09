package librerias.estructuraDeDatos.Lineales;

import librerias.estructuraDeDatos.Modelo.ILEGS;

public class LEG<E> implements ILEGS {

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
    public void insertarElemento(Object o) {

    }

    @Override
    public void borrarElemento(Object o) {

    }

    @Override
    public void modificarElemento(Object o) {

    }

    @Override
    public boolean existeElemento(Object o) {
        return false;
    }

}
