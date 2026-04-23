package librerias.estructurasDeDatos.modelos;

/**
 * Interfaz que define la lógica del la Cola.
 *
 * @param <E> Tipo genérico de los elementos que almacenará la cola.
 */
public interface I_Cola<E> {
    /**
     * Inserta un nuevo elemento en la parte final de la cola.
     * @param dato Elemento de tipo genérico E que se desea encolar.
     */
    void encolar(E dato);
    /**
     * Extrae y devuelve el elemento situado en el frente de la cola.
     * @return El elemento de tipo E extraído, o nulo si la cola está vacía.
     */
    E desencolar();
    /**
     * Devuelve el elemento situado en el frente de la cola sin extraerlo.
     * @return El elemento de tipo E del frente, o nulo si la cola está vacía.
     */
    E primero();
    /**
     * Comprueba si la cola no contiene ningún elemento.
     * @return true si la cola está vacía o false en caso contrario.
     */
    boolean esVacia();
    /**
     * Calcula el número total de elementos almacenados actualmente en la cola.
     * @return Un número entero con la cantidad de elementos de la cola.
     */
    int contarElemCola();
}
