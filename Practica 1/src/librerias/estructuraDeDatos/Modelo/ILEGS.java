package librerias.estructuraDeDatos.Modelo;

import librerias.estructuraDeDatos.Lineales.NodoLEG;

public interface ILEGS<E> {

    int talla();
    void insertarElemento(E e);
    void borrarElemento(E e);
    void modificarElemento(E e);
    E existeElemento(E e);
    E getElemento(int i);
}
