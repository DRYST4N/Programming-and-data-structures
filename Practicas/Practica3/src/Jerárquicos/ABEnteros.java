package Jerárquicos;

import Modelo.I_ABEnteros;

public class ABEnteros extends AB<Integer> implements I_ABEnteros {

    public ABEnteros(){
        super();
    }

    public ABEnteros(NodoAB<Integer> raiz){
        super(raiz);
    }

    @Override
    public boolean EsABB() {
        return false;
    }

    @Override
    public boolean RaizIgualNodosInternos() {
        return false;
    }

    @Override
    public int MinimoValorNivel(int n) {
        return 0;
    }

    @Override
    public boolean esVacio() {
        return false;
    }

    @Override
    public NodoAB<Integer> devolverDerecho() {
        return null;
    }

    @Override
    public NodoAB<Integer> devolverIzquierda() {
        return null;
    }

    @Override
    public void devolverRaiz() {

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
}
