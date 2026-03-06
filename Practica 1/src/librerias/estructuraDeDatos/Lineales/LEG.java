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
    public void InsertItem(NodoLEG n) {

    }

    @Override
    public void DeleteItem(NodoLEG n) {

    }

    @Override
    public void UpdateItem(NodoLEG n) {

    }

}
