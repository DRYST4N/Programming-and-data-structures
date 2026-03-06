package librerias.estructuraDeDatos.Lineales;

public class Autobus implements Comparable<Autobus> {
    private String matricula;
    private String annoCompra;
    private int numeroPlazas;
    private LEG<Viaje> viajes;

    public Autobus(String matricula, String annoCompra, int numeroPlazas) {
        this.matricula = matricula;
        this.annoCompra = annoCompra;
        this.numeroPlazas = numeroPlazas;
        this.viajes = new LEG<Viaje>();
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

    @Override
    public int compareTo(Autobus o) {
        return Integer.compare(this.numeroPlazas, o.numeroPlazas);
        //this.numeroPlazas == o.numeroPlazas ? 0 : (this.numeroPlazas > o.numeroPlazas ? 1 : -1);
    }
}
