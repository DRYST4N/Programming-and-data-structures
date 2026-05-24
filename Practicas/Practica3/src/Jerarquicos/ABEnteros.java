package Jerarquicos;

import Modelo.I_ABEnteros;

import static Excepciones.Excepciones.nivelesFueraDeRango;


/**
 * Implementación del TAD Arbol Binario de enteros.
 * Hereda de la clase AB de tipo entero e implemeta la
 * interfaz I_ABEnteros que hereda de la interfaz I_AB de tipo entero
 */
public class ABEnteros extends AB<Integer> implements I_ABEnteros {

    /**
     * Construye un ABEnteros vacío delegando en el constructor de AB.
     */
    public ABEnteros(){
        super();
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public boolean EsABB() {

        return EsABB(this, null, null);
    }

    /**
     * Metodo recursivo que comprueba si el árbol binario de enteros es un Arbol Binario de Búsqueda.
     *
     * @param nodo    Subárbol a evaluar.
     * @param minimo  Cota inferior permitida para el dato.
     * @param maximo  Cota superior permitida para el dato.
     * @return true si el subárbol cumple las propiedades de un ABB o
     *         false en caso contrario.
     */
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

    /**
     *{@inheritDoc}
     */
    @Override
    public boolean RaizIgualNodosInternos() {

        if (esVacio()){
            return false;
        }
        return this.getDato() == RaizIgualNodosInternos(this);
    }

    /**
     * Metodo recursivo que comprueba si el valor de la clave de la raíz es igual al número de
     * nodos internos del árbol.
     *
     *  @param nodo Subárbol sobre el que se cuentan los nodos internos.
     *  @return Número de nodos internos del subárbol.
     */
    private int RaizIgualNodosInternos(AB<Integer> nodo){
        if(nodo.esVacio() || nodo.esHoja()){
            return 0;
        }
        else{
            return  1 + RaizIgualNodosInternos( (AB<Integer>) nodo.getIzquierda())
                    + RaizIgualNodosInternos( (AB<Integer>) nodo.getDerecha());
        }
    }

    /**
     * {@inheritDoc}
     * @throws IllegalArgumentException Si n es negativo o supera
     *         el número de niveles del árbol.
     */

    @Override
    public int MinimoValorNivel(int n) {

        int numeroNiveles = nivelesAB();

        nivelesFueraDeRango(n,numeroNiveles);

        return MinimoValorNivel(this,0,n);
    }

    /**
     * Metodo recursivo que calcula el valor mínimo existente en un nivel dado del árbol.
     *
     * @param nodo         Subárbol actual del recorrido.
     * @param nivelActual  Nivel en el que se encuentra arbol.
     * @param nivel        Nivel objetivo en el que se busca el mínimo.
     * @return El valor mínimo encontrado en el nivel o
     *         Integer#MAX_VALUE si la rama no alcanza dicho nivel.
     */
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
