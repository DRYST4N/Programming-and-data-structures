package Codigo;

import java.util.Date;

public class Autobus {
    private String matricula;
    private Date annoCompra;
    private int numeroPlazas;

    public Autobus(String matricula, Date annoCompra, int numeroPlazas) {
        this.matricula = matricula;
        this.annoCompra = annoCompra;
        this.numeroPlazas = numeroPlazas;
    }

    // Getters
    public String getMatricula() {
        return matricula;
    }

    public Date getAnnoCompra() {
        return annoCompra;
    }

    public int getNumeroPlazas() {
        return numeroPlazas;
    }

    //Setters

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public void setAnnoCompra(Date annoCompra) {
        this.annoCompra = annoCompra;
    }
    public void setNumeroPlazas(int numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
    }

}
