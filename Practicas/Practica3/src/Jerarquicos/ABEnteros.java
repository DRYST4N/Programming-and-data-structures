package Jerarquicos;

import Modelo.I_ABEnteros;

import static Excepciones.Excepciones.nivelesFueraDeRango;

public class ABEnteros extends AB<Integer> implements I_ABEnteros {

    public ABEnteros(){
        super();
    }

    @Override
    public boolean EsABB() {

        return EsABB(this, null, null);
    }

    private boolean EsABB(AB<Integer>nodo, Integer minimo, Integer maximo) {

        if (nodo.esVacio()){
            return true;
        }
        if ((minimo != null && nodo.getDato() <= minimo)
                || (maximo != null && nodo.getDato() >= maximo)){
            return false;
        }
        return EsABB((AB<Integer>) nodo.getIzquierda(),minimo,nodo.getDato())
                && EsABB((AB<Integer>) nodo.getDerecha(), nodo.getDato(), maximo);
    }

    @Override
    public boolean RaizIgualNodosInternos() {

        if (esVacio()){
            return false;
        }
        return this.getDato() == RaizIgualNodosInternos(this);
    }

    private int RaizIgualNodosInternos(AB<Integer> nodo){
        if(nodo.esVacio() || nodo.esHoja()){
            return 0;
        }
        else{
            return  1 + RaizIgualNodosInternos( (AB<Integer>) nodo.getIzquierda())
                    + RaizIgualNodosInternos( (AB<Integer>) nodo.getDerecha());
        }
    }

    @Override
    public int MinimoValorNivel(int n) {

        int numeroNiveles = nivelesAB();

        nivelesFueraDeRango(n,numeroNiveles);

        return MinimoValorNivel(this,0,n);
    }

    private int MinimoValorNivel(AB<Integer> nodo, int nivelActual, int nivel){

        if (nodo.esVacio()){
            return Integer.MAX_VALUE;
        }
        if(nivel == nivelActual){
            return nodo.getDato();
        }

        int minimoValorDerecha = MinimoValorNivel( (AB<Integer>) nodo.getDerecha(),nivelActual + 1,nivel);
        int minimoValorIzquierda = MinimoValorNivel( (AB<Integer>) nodo.getIzquierda(), nivelActual + 1,nivel);

        return Math.min(minimoValorDerecha,minimoValorIzquierda);
    }

}
