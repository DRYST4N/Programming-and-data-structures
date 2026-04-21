package librerias.estructurasDeDatos.lineales;

public class Trabajo {
    private int idUsuario;
    private int prioridad;
    private String titulo;
    private int peso;

    public Trabajo(int idUsuario, String titulo, int peso) {
        this.idUsuario = idUsuario;
        this.prioridad = asignarPrioridad(idUsuario); //hay que hacer validacion datos entre 100 y 999
        this.titulo = titulo;
        this.peso = peso;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    private int asignarPrioridad(int idUsuario) {
        return idUsuario / 100;
    }
}
