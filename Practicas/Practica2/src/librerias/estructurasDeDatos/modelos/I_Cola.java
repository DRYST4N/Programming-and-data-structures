package librerias.estructurasDeDatos.modelos;

public interface I_Cola<E> {
    void encolar(E dato);
    E desencolar();
    E primero();
    boolean esVacia();
    int contarElemCola();
}
