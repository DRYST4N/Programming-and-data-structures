package librerias.estructuraDeDatos.Lineales;

/**
 * Representa un viaje programado para un autobús.
 * Almacena la información: código identificador,
 * ciudad de origen, ciudad de destino y hora de salida.
 */
public class Viaje {
    private int codigo;
    private String origen;
    private String destino;
    private String hora;

    /**
     * Constructor de la clase Viaje.
     * @param codigo  Código identificador único del viaje.
     * @param origen  Ciudad de origen del viaje.
     * @param destino Ciudad de destino del viaje.
     * @param hora    Hora de salida del viaje.
     */
    public Viaje(int codigo, String origen, String destino, String hora) {
        this.codigo = codigo;
        this.origen = origen;
        this.destino = destino;
        this.hora = hora;
    }

    //Getters
    public int getCodigo() {
        return codigo;
    }
    public String getOrigen() {
        return origen;
    }
    public String getDestino() {
        return destino;
    }
    public String getHora() {
        return hora;
    }

    //Setters
    public void setOrigen(String origen) {
        this.origen = origen;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * Comprueba si un código numérico coincide con el código de este viaje.
     * @param codigo El código a comparar.
     * @return true si los códigos coinciden; false en caso contrario.
     */
    public boolean codigoViajeSimilar(int codigo){
        return codigo==this.codigo;
    }

    /**
     * Compara el viaje actual con otro objeto para verificar si son iguales.
     * La igualdad se determina basándose únicamente en el código del viaje.
     * @param obj El objeto con el que comparar.
     * @return true si son el mismo viaje o tienen el mismo código; false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        Viaje viaje = (Viaje) obj;

        return this.codigo == viaje.codigo;
    }

    /**
     * Devuelve una representación en formato de cadena de texto
     * con todos los detalles del viaje.
     * @return Una cadena de texto estructurada con el código, origen, destino y hora.
     */
    @Override
    public String toString() {
        return "[Codigo viaje]:"+this.codigo+"\n[Origen]:"+this.origen+"\n[Destino]:"+this.destino+"\n[Hora]:"+this.hora;
    }
}