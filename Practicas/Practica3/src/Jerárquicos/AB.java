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
    public NodoAB<E> getDerecha() {
        return this.raiz.getDerecha();
    }

    @Override
    public NodoAB<E> getIzquierda() {
        return this.raiz.getIzquierda();
    }

    @Override
    public E getRaiz() {
        return this.raiz.getDato();
    }

    @Override
    public void EliminarNodosInferiores(int nivel) {
        EliminarNodosInferiores(this.raiz,0,nivel);
    }

    @Override
    public void nivelesAB() {

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
    public void setDerecha(NodoAB<E> derecho) {
        this.raiz.getDerecha().setDerecha(derecho);
    }

    @Override
    public void setIzquierda(NodoAB<E> izquierdo) {
        this.raiz.getIzquierda().setIzquierda(izquierdo);
    }

    @Override
    public void setRaiz(E dato) {
        this.raiz.setDato(dato);
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
