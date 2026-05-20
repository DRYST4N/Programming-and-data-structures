package Jerárquicos;

import Modelo.I_AB;

public class AB<E> implements I_AB<E> {

    NodoAB<E> raiz;

    public AB(){
        this.raiz = null;
    }

    public AB(NodoAB<E> raiz){
        this.raiz = raiz;
    }


    @Override
    public boolean esVacio() {
        return this.raiz == null;
    }

    @Override
    public I_AB<E> getDerecha() {
        if (esVacio()) {
            return new AB<E>();
        }
        return new AB<E>(this.raiz.getDerecha());
    }

    @Override
    public I_AB<E> getIzquierda() {
        if (esVacio()) {
            return new AB<E>();
        }
        return new AB<E>(this.raiz.getIzquierda());
    }

    @Override
    public E getRaiz() {
        if (esVacio()){
            return null;
        }
        return this.raiz.getDato();
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

    }

    @Override
    public void InOrden() {

    }

    @Override
    public void InOrdenConverso() {

    }

    @Override
    public void PostOrden() {

    }

    @Override
    public void setDerecha(I_AB<E> derecho) {
        if (!esVacio()) {
            this.raiz.setDerecha(((AB<E>) derecho).raiz);
        }
    }

    @Override
    public void setIzquierda(I_AB<E> izquierdo) {
        if (!esVacio()) {
            this.raiz.setIzquierda(((AB<E>) izquierdo).raiz);
        }
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
