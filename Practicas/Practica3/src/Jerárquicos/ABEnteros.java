package Jerárquicos;

import Modelo.I_ABEnteros;

import static Excepciones.Excepciones.nivelesFueraDeRango;

public class ABEnteros extends AB<Integer> implements I_ABEnteros {

    public ABEnteros(){
        super();
    }

    public ABEnteros(NodoAB<Integer> raiz){
        super(raiz);
    }

    @Override
    public boolean EsABB() {

        return EsABB(this.raiz, null, null);
    }

    private boolean EsABB(NodoAB<Integer>nodo, Integer minimo, Integer maximo) {

        if (nodo == null){
            return true;
        }
        if ((minimo != null && nodo.getDato() <= minimo)
                || (maximo != null && nodo.getDato() >= maximo)){
            return false;
        }
        return EsABB(nodo.getIzquierda(),minimo,nodo.getDato())
                && EsABB(nodo.getDerecha(), nodo.getDato(), maximo);
    }

    @Override
    public boolean RaizIgualNodosInternos() {

        if (esVacio()){
            return false;
        }
        return this.getRaiz() == RaizIgualNodosInternos(this.raiz);
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

        int numeroNiveles = nivelesAB();

        nivelesFueraDeRango(n,numeroNiveles);

        return MinimoValorNivel(this.raiz,0,n);
    }

    private int MinimoValorNivel(NodoAB<Integer> nodo, int nivelActual, int nivel){

        if (nodo == null){
            return Integer.MAX_VALUE;
        }
        if(nivel == nivelActual){
            return nodo.getDato();
        }

        int minimoValorDerecha = MinimoValorNivel(nodo.getDerecha(),nivelActual + 1,nivel);
        int minimoValorIzquierda = MinimoValorNivel(nodo.getIzquierda(), nivelActual + 1,nivel);

        return Math.min(minimoValorDerecha,minimoValorIzquierda);
    }
}
