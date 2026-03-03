package Codigo;

import java.sql.Time;

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

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public void setOrigen(String origen) {
        this.origen = origen;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
}
