import Jerárquicos.AB;
import Jerárquicos.ABEnteros;
import Jerárquicos.NodoAB;

public class PruebaABEnteros {

    public void menuPruebas(){}

    public static ABEnteros CrearAB1(){

        NodoAB<Integer> nodo104 = new NodoAB<Integer>(104);

        //Nodos de la parte izquierda

        NodoAB<Integer> nodo71 = new NodoAB<Integer>(71);

        nodo104.setIzquierda(nodo71);

        NodoAB<Integer> nodo17 = new NodoAB<Integer>(17);
        NodoAB<Integer> nodo19 = new NodoAB<Integer>(19);

        nodo71.setDerecha(nodo19);
        nodo71.setIzquierda(nodo17);

        NodoAB<Integer> nodo3 = new NodoAB<Integer>(3);
        NodoAB<Integer> nodo18 = new NodoAB<Integer>(18);

        nodo17.setIzquierda(nodo3);
        nodo17.setDerecha(nodo18);

        //Nodos de la parte derecha

        NodoAB<Integer> nodo240 = new NodoAB<Integer>(240);

        nodo104.setDerecha(nodo240);

        NodoAB<Integer> nodo108 = new NodoAB<Integer>(108);
        NodoAB<Integer> nodo245 = new NodoAB<Integer>(245);

        nodo240.setIzquierda(nodo108);
        nodo108.setDerecha(nodo245);

        NodoAB<Integer> nodo110 = new NodoAB<Integer>(108);

        nodo108.setDerecha(nodo110);

        return new ABEnteros(nodo104);
    }
    public static ABEnteros CrearAB2(){

        NodoAB<Integer> nodo2 = new NodoAB<Integer>(2);

        //Nodos de la parte izquierda

        NodoAB<Integer> nodo1 = new NodoAB<Integer>(1);

        nodo2.setIzquierda(nodo1);

        NodoAB<Integer> nodo0 = new NodoAB<Integer>(0);

        nodo1.setIzquierda(nodo0);

        //Nodos de la parte derecha

        NodoAB<Integer> nodo5 = new NodoAB<Integer>(5);

        nodo2.setDerecha(nodo5);

        NodoAB<Integer> nodo3 = new NodoAB<Integer>(3);
        NodoAB<Integer> nodo7 = new NodoAB<Integer>(7);

        nodo5.setIzquierda(nodo3);
        nodo5.setDerecha(nodo7);

        return new ABEnteros(nodo2);
    }
}
