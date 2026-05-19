package Modelo;

import Jerárquicos.NodoAB;

public interface I_AB<E> {
    boolean esVacio();
    NodoAB<E> getDerecha();
    NodoAB<E> getIzquierda();
    E getRaiz();

    void EliminarNodosInferiores(int nivel);
    int nivelesAB();

    void PreOrden();
    void InOrden();
    void InOrdenConverso();
    void PostOrden();

    void setDerecha(NodoAB<E> derecho);
    void setIzquierda(NodoAB<E> izquierdo);
    void setRaiz(E dato);
}
