package librerias.estructuraDeDatos.Lineales;

import librerias.estructuraDeDatos.Modelo.ILEGS;

/**
 * Implementación de una Lista Doblemente Enlazada Genérica que mantiene
 * sus elementos ordenados automáticamente.
 * Exige que el tipo genérico implemente la interfaz Comparable para
 * poder determinar el criterio de ordenación natural de los elementos al insertarlos.
 *
 * @param <E> El tipo de datos comparable que almacenará la lista.
 */
public class LDEGOrdenada<E extends Comparable<E>> implements ILEGS<E> {

    private NodoLDEG<E> primero;
    private int talla;

    /**
     * Constructor por defecto.
     * Inicializa una lista doblemente enlazada vacía.
     */
    public LDEGOrdenada() {
        this.primero=null;
        this.talla=0;
    }

    /**
     * Devuelve el número total de elementos almacenados en la lista.
     * @return La cantidad de nodos actuales.
     */
    @Override
    public int talla() {
        return this.talla;
    }

    /**
     * Inserta un nuevo elemento en la posición exacta que le corresponde
     * para mantener el orden ascendente de la lista basado en el compareTo.
     * Ajusta tanto el puntero al nodo anterior como al siguiente.
     * @param e El elemento a insertar.
     */
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

    /**
     * Busca un elemento y lo elimina de la lista, reajustando de forma segura
     * los enlaces dobles de los nodos adyacentes.
     * @param e El elemento que se desea borrar.
     */
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

    /**
     * Modifica un elemento existente en la lista.
     * Reinserta el elemento segun las modificaciones dadas.
     * @param e El elemento modificado a actualizar en la lista.
     */
    @Override
    public void modificarElemento(E e) { //Este borra e inserta ya que al cambiar datos puede modificar las listas ordenadas

        if (existeElemento(e) != null) {
            borrarElemento(e);
            insertarElemento(e);
        }

    }

    /**
     * Busca un elemento dentro de la lista para comprobar su existencia.
     * @param e El elemento a buscar.
     * @return El elemento si se encuentra, o null si no existe.
     */
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

    /**
     * Recupera el elemento situado en la posición secuencial solicitada.
     * @param i El índice del elemento a recuperar.
     * @return El elemento situado en la posición i, o null si no existe.
     */
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
    public NodoLDEG<E> getPrimero() {
        return this.primero;
    }
}