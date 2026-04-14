package librerias.estructuraDeDatos.Lineales;

import librerias.estructuraDeDatos.Modelo.ILEGS;

/**
 * Implementación de una Lista Enlazada Genérica.
 * @param <E> El tipo de dato genérico que almacenará la lista.
 */
public class LEG<E> implements ILEGS<E> {

    private NodoLEG<E> primero;
    private int talla;

    /**
     * Constructor que inicializa una lista enlazada vacía.
     * El puntero al primer elemento es null y la talla inicial es 0.
     */
    public LEG(){
        this.primero= null;
        this.talla=0;
    }

    /**
     * Devuelve el número de elementos actualmente almacenados en la lista.
     * @return La cantidad de elementos (talla) de la lista.
     */
    @Override
    public int talla(){
        return this.talla;
    }

    /**
     * Inserta un nuevo elemento al final de la lista enlazada simple.
     * Si la lista está vacía, el nuevo elemento se convierte en el primero.
     * @param e El elemento a insertar.
     */
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
        }
        this.talla++;
    }

    /**
     * Busca la primera ocurrencia de un elemento en la lista y lo elimina,
     * reajustando los punteros de los nodos adyacentes.
     * @param e El elemento que se desea borrar.
     */
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
                    ant.setSiguiente(aux.getSiguiente());
                }
                this.talla--;
                return;
            }
            ant = aux;
            aux = aux.getSiguiente();
        }
    }

    /**
     * Busca un elemento en la lista usando su método equals y, si lo encuentra,
     * actualiza los datos del nodo contenedor con los nuevos datos proporcionados.
     * @param e El elemento con los datos actualizados a sobreescribir.
     */
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

    /**
     * Busca un elemento dentro de la lista para comprobar su existencia.
     * @param e El elemento a buscar.
     * @return El elemento si se encuentra, o null si no existe.
     */
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

    /**
     * Recupera el elemento situado en una posición secuencial de la lista.
     * @param i El índice del elemento.
     * @return El elemento situado en la posición i, o null si no existe.
     */
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