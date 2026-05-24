package Jerarquicos;

import Modelo.I_AB;

/**
 * Implementación del TAD Arbol Binario genérico.
 *
 * @param <E> El tipo de dato que almacenará el árbol.
 */
public class AB<E> implements I_AB<E> {

    private NodoAB<E> raiz;

    /**
     * Construye un árbol binario vacío.
     */
    public AB(){
        this.raiz = null;
    }

    /**
     * Construye un árbol binario segun un nodo especifico.
     */
    private AB(NodoAB<E> raiz){
        this.raiz = raiz;
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public boolean esVacio() {
        return this.raiz == null;
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public I_AB<E> getDerecha() {
        if (esVacio() || this.raiz.getDerecha() == null) {
            return new AB<E>();
        }
        return new AB<E>(this.raiz.getDerecha());
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public I_AB<E> getIzquierda() {
        if (esVacio() || this.raiz.getIzquierda() == null) {
            return new AB<E>();
        }
        return new AB<E>(this.raiz.getIzquierda());
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public E getDato() {
        if (esVacio()){
            return null;
        }
        return this.raiz.getDato();
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public NodoAB<E> getRaiz() {
        if (esVacio()){
            return null;
        }
        return this.raiz;
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public boolean esHoja() {
        if (esVacio()) {
            return false;
        }
        return this.raiz.getDerecha() == null && this.raiz.getIzquierda() == null;
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public void EliminarNodosInferiores(int nivel) {
        EliminarNodosInferiores(this.raiz,0,nivel);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public int nivelesAB() {
        return nivelesAB(this.raiz);
    }

    /**
     * Metodo recursivo para calcular los niveles del AB
     *
     * @param nodo Nodo raíz del subárbol a evaluar.
     * @return Número de niveles del subárbol o 0 si el nodo es null.
     */
    private int nivelesAB(NodoAB<E> nodo){
        if ( nodo == null ){
            return 0;
        }
        return 1+Math.max(nivelesAB(nodo.getDerecha()),nivelesAB(nodo.getIzquierda()));
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public void PreOrden() {
        PreOrden(this.raiz);
        System.out.println();
    }

    /**
     * Metodo recursivo para recorrer el árbol en PreOrden
     *
     * @param nodo Nodo actual del recorrido.
     */
    private void PreOrden(NodoAB<E> nodo){
        if (nodo == null) return;
        System.out.print(nodo.getDato() + " ");
        PreOrden(nodo.getIzquierda());
        PreOrden(nodo.getDerecha());
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public void InOrden() {
        InOrden(this.raiz);
        System.out.println();
    }

    /**
     * Metodo recursivo para recorrer el árbol en InOrden
     *
     * @param nodo Nodo actual del recorrido.
     */
    private void InOrden(NodoAB<E> nodo){
        if (nodo == null) return;
        InOrden(nodo.getIzquierda());
        System.out.print(nodo.getDato() + " ");
        InOrden(nodo.getDerecha());
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public void InOrdenConverso() {
        InOrdenConverso(this.raiz);
        System.out.println();
    }

    /**
     * Metodo recursivo para recorrer el árbol en InOrden Converso
     *
     * @param nodo Nodo actual del recorrido.
     */
    private void InOrdenConverso(NodoAB<E> nodo){
        if (nodo == null) return;
        InOrdenConverso(nodo.getDerecha());
        System.out.print(nodo.getDato() + " ");
        InOrdenConverso(nodo.getIzquierda());
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public void PostOrden() {
        PostOrden(this.raiz);
        System.out.println();
    }

    /**
     * Metodo recursivo para recorrer el árbol en PostOrden
     *
     * @param nodo Nodo actual del recorrido.
     */
    private void PostOrden(NodoAB<E> nodo){
        if (nodo == null) return;
        PostOrden(nodo.getIzquierda());
        PostOrden(nodo.getDerecha());
        System.out.print(nodo.getDato() + " ");
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public void setDerecha(I_AB<E> derecho) {
        if (esVacio()) {
            this.raiz =  new NodoAB<E>(null);
        }

        AB<E> arbolBinarioDerecho = (AB<E>) derecho;
        this.raiz.setDerecha(arbolBinarioDerecho.raiz);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public void setIzquierda(I_AB<E> izquierdo) {
        if (esVacio()) {
            this.raiz = new NodoAB<E>(null);
        }

        AB<E> arbolBinarioIzquierda = (AB<E>) izquierdo;
        this.raiz.setIzquierda(arbolBinarioIzquierda.raiz);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public void setDato(E dato) {
        if(esVacio()){
            this.raiz = new NodoAB<E>(dato);
        }
        else{
            this.raiz.setDato(dato);
        }
    }

    /**
     * Metodo recursivo que elimina todos los nodos que se encuentran en niveles
     * inferiores al nivel dado.
     *
     *
     * @param nodo        Nodo actual del recorrido.
     * @param nivelActual Nivel en el que se encuentra el nodo.
     * @param nivel       Nivel objetivo.
     */
    private void EliminarNodosInferiores(NodoAB<E> nodo,int nivelActual, int nivel){
        if(nodo == null){
            return;
        }
        else{
            if(nivelActual == nivel){
                nodo.setDerecha(null);
                nodo.setIzquierda(null);
            }
            if (nivelActual < nivel){
                EliminarNodosInferiores(nodo.getDerecha(), nivelActual+1, nivel);
                EliminarNodosInferiores(nodo.getIzquierda(), nivelActual+1, nivel);
            }
        }
    }
}
