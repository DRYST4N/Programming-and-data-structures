package librerias.estructuraDeDatos.Modelo;

/**
 * Interfaz genérica que define las operaciones lógicas
 * para cualquier Estructura de Datos Lineal en el sistema.
 * Actúa como un contrato que garantiza que todas las listas implementen
 * las operaciones básicas
 *
 * @param <E> El tipo de elementos que almacenará la estructura.
 */
public interface ILEGS<E> {

    /**
     * Obtiene el número de elementos actualmente almacenados en la estructura.
     * * @return La talla de la lista.
     */
    int talla();
    /**
     * Inserta un nuevo elemento en la estructura de datos.
     * @param e El elemento genérico a insertar.
     */
    void insertarElemento(E e);
    /**
     * Busca y elimina un elemento específico de la estructura de datos.
     * @param e El elemento que se desea eliminar.
     */
    void borrarElemento(E e);
    /**
     * Reemplaza o actualiza un elemento existente en la estructura de datos.
     * @param e El elemento modificado que reemplazará al existente.
     */
    void modificarElemento(E e);
    /**
     * Comprueba si un elemento específico existe dentro de la estructura.
     * @param e El elemento a buscar
     * @return El propio elemento almacenado si se encuentra, o null si no existe.
     */
    E existeElemento(E e);
    /**
     * Recupera el elemento situado en una posición concreta de la estructura.
     * @param i La posición del elemento a recuperar.
     * @return El elemento ubicado en el índice i, o null si el índice no es válido.
     */
    E getElemento(int i);
}