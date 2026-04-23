package librerias.estructurasDeDatos.lineales;

/**
 * Representa un trabajo de impresión en el sistema.
 */
public class Trabajo {

    private int idUsuario;
    private int prioridad;
    private String titulo;
    private int peso;

    /**
     * Constructor principal, que inicializa un trabajo de impresión y calcula
     * su prioridad automáticamente basándose en el ID del usuario.
     * @param idUsuario Identificador único del usuario.
     * @param titulo    Título descriptivo del documento.
     * @param peso      Tamaño en Kb del documento.
     */
    public Trabajo(int idUsuario, String titulo, int peso) {
        this.idUsuario = idUsuario;
        this.prioridad = asignarPrioridad(idUsuario);
        this.titulo = titulo;
        this.peso = peso;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPeso() {
        return peso;
    }

    /**
     * Método de servicio privado que calcula la prioridad del usuario
     * @param idUsuario El identificador del usuario.
     * @return Un número entero del 1 al 9 representando la prioridad asignada.
     */
    private int asignarPrioridad(int idUsuario) {
        return idUsuario / 100;
    }
}
