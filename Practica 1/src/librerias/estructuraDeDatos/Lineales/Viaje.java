package librerias.estructuraDeDatos.Lineales;

public class Viaje {
    private int codigo;
    private String origen;
    private String destino;
    private String hora;

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

    public boolean viajeSimilar(Viaje viaje){
        return this.origen.equals(viaje.getOrigen()) && this.destino.equals(viaje.getDestino()) &&  this.hora.equals(viaje.getHora());
    }

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

    @Override
    public String toString() {
        return "[Codigo viaje]:"+this.codigo+"\n[Origen]:"+this.origen+"\n[Destino]:"+this.destino+"\n[Hora]:"+this.hora;
    }
}
