package Modelo;

import Jerárquicos.NodoAB;

public interface I_AB<E> {
    boolean esVacio();
    NodoAB<E> getDerecho();
    NodoAB<E> getIzquierda();
    void getRaiz();

    void EliminarNodosInferiores();
    void nivelesAB();

    void PreOrden();
    void InOrden();
    void InOrdenConverso();
    void PostOrden();

    void setDerecho(NodoAB<E> derecho);
    void setIzquierda(NodoAB<E> izquierdo);
    void setRaiz(E dato);
}
