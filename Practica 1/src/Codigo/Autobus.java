package Codigo;

import java.util.Date;

public class Autobus {
    private String matricula;
    private String annoCompra;
    private int numeroPlazas;
    //El autobus deberia tener un atributo LEG<Viajes>

    public Autobus(String matricula, String annoCompra, int numeroPlazas) {
        this.matricula = matricula;
        this.annoCompra = annoCompra;
        this.numeroPlazas = numeroPlazas;
    }

    // Getters
    public String getMatricula() {
        return matricula;
    }

    public String getAnnoCompra() {
        return annoCompra;
    }

    public int getNumeroPlazas() {
        return numeroPlazas;
    }

    //Setters

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public void setAnnoCompra(String annoCompra) {
        this.annoCompra = annoCompra;
    }
    public void setNumeroPlazas(int numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
    }

}
