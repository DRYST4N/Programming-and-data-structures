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

        if (this.getRaiz() == RaizIgualNodosInternos(this.raiz)){
            return true;
        }
        return false;
    }

    private int RaizIgualNodosInternos(NodoAB<Integer> nodo){
        if((nodo == null) || ((nodo.getIzquierda() == null)&&(nodo.getDerecha() == null))){
            return 0;
        }
        else{
            return  1 + RaizIgualNodosInternos(nodo.getDerecha())
                    + RaizIgualNodosInternos(nodo.getIzquierda());
        }
    }

    @Override
    public int MinimoValorNivel(int n) {
        return 0;
    }

    private void MinimoValorNivel(NodoAB<Integer> nodo){

    }

    @Override
    public void nivelesAB() {
    }

    private void nivelesAB(NodoAB<Integer> nodo){

    }


    //con que se realicen en la clase AB vale

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
