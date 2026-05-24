package Jerarquicos;

import Modelo.I_AB;

/**
 * Implementación del TAD Árbol Binario.
 * <p>
 * El árbol se define como una estructura jerárquica no lineal. Un árbol puede
 * estar vacío (raíz nula) o compuesto por una raíz y dos subárboles
 * (izquierdo y derecho) que también son árboles binarios.
 * </p>
 * * @param <E> El tipo de dato que contendrá el árbol.
 */
public class AB<E> implements I_AB<E> {

    private NodoAB<E> raiz;

    public AB(){
        this.raiz = null;
    }

    private AB(NodoAB<E> raiz){
        this.raiz = raiz;
    }

    @Override
    public boolean esVacio() {
        return this.raiz == null;
    }

    @Override
    public I_AB<E> getDerecha() {
        if (esVacio() || this.raiz.getDerecha() == null) {
            return new AB<E>();
        }
        return new AB<E>(this.raiz.getDerecha());
    }

    @Override
    public I_AB<E> getIzquierda() {
        if (esVacio() || this.raiz.getIzquierda() == null) {
            return new AB<E>();
        }
        return new AB<E>(this.raiz.getIzquierda());
    }

    @Override
    public E getDato() {
        if (esVacio()){
            return null;
        }
        return this.raiz.getDato();
    }

    @Override
    public NodoAB<E> getRaiz() {
        if (esVacio()){
            return null;
        }
        return this.raiz;
    }

    @Override
    public boolean esHoja() {
        if (esVacio()) {
            return false;
        }
        return this.raiz.getDerecha() == null && this.raiz.getIzquierda() == null;
    }

    @Override
    public void EliminarNodosInferiores(int nivel) {
        EliminarNodosInferiores(this.raiz,0,nivel);
    }

    @Override
    public int nivelesAB() {
        return nivelesAB(this.raiz);
    }

    private int nivelesAB(NodoAB<E> nodo){
        if ( nodo == null ){
            return 0;
        }
        return 1+Math.max(nivelesAB(nodo.getDerecha()),nivelesAB(nodo.getIzquierda()));
    }

    @Override
    public void PreOrden() {
        PreOrden(this.raiz);
        System.out.println();
    }

    private void PreOrden(NodoAB<E> nodo){
        if (nodo == null) return;
        System.out.print(nodo.getDato() + " ");
        PreOrden(nodo.getIzquierda());
        PreOrden(nodo.getDerecha());
    }

    @Override
    public void InOrden() {
        InOrden(this.raiz);
        System.out.println();
    }

    private void InOrden(NodoAB<E> nodo){
        if (nodo == null) return;
        InOrden(nodo.getIzquierda());
        System.out.print(nodo.getDato() + " ");
        InOrden(nodo.getDerecha());
    }

    @Override
    public void InOrdenConverso() {
        InOrdenConverso(this.raiz);
        System.out.println();
    }

    private void InOrdenConverso(NodoAB<E> nodo){
        if (nodo == null) return;
        InOrdenConverso(nodo.getDerecha());
        System.out.print(nodo.getDato() + " ");
        InOrdenConverso(nodo.getIzquierda());
    }

    @Override
    public void PostOrden() {
        PostOrden(this.raiz);
        System.out.println();
    }

    private void PostOrden(NodoAB<E> nodo){
        if (nodo == null) return;
        PostOrden(nodo.getIzquierda());
        PostOrden(nodo.getDerecha());
        System.out.print(nodo.getDato() + " ");
    }

    @Override
    public void setDerecha(I_AB<E> derecho) {
        if (esVacio()) {
            this.raiz =  new NodoAB<E>(null);
        }

        AB<E> arbolBinarioDerecho = (AB<E>) derecho;
        this.raiz.setDerecha(arbolBinarioDerecho.raiz);
    }

    @Override
    public void setIzquierda(I_AB<E> izquierdo) {
        if (esVacio()) {
            this.raiz = new NodoAB<E>(null);
        }

        AB<E> arbolBinarioIzquierda = (AB<E>) izquierdo;
        this.raiz.setIzquierda(arbolBinarioIzquierda.raiz);
    }

    @Override
    public void setRaiz(E dato) {
        if(esVacio()){
            this.raiz = new NodoAB<E>(dato);
        }
        else{
            this.raiz.setDato(dato);
        }
    }

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
