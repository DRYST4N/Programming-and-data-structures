package Modelo;

import Jerárquicos.NodoAB;

public interface I_AB<E> {
    boolean esVacio();
    I_AB<E> getDerecha();
    I_AB<E> getIzquierda();
    E getRaiz();
    boolean esHoja();

    void EliminarNodosInferiores(int nivel);
    int nivelesAB();

    void PreOrden();
    void InOrden();
    void InOrdenConverso();
    void PostOrden();

    void setDerecha(I_AB<E> derecho);
    void setIzquierda(I_AB<E> izquierdo);
    void setRaiz(E dato);
}
