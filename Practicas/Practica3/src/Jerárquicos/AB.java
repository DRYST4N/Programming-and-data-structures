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
        return false;
    }

    @Override
    public NodoAB<E> getDerecho() {
        return null;
    }

    @Override
    public NodoAB<E> getIzquierda() {
        return null;
    }

    @Override
    public void getRaiz() {

    }

    @Override
    public void EliminarNodosInferiores() {

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
    public void setDerecho(NodoAB<E> derecho) {

    }

    @Override
    public void setIzquierda(NodoAB<E> izquierdo) {

    }

    @Override
    public void setRaiz(E dato) {

    }
}
