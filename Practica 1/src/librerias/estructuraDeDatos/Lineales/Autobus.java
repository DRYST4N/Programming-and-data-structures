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

    public Autobus(String matricula, String annoCompra, int numeroPlazas, LEG<Viaje> viajes) {
        this.matricula = matricula;
        this.annoCompra = annoCompra;
        this.numeroPlazas = numeroPlazas;
        this.viajes = viajes;
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
    public LEG<Viaje> getViajes() { return viajes; }
    //Setters

    public void setAnnoCompra(String annoCompra) {
        this.annoCompra = annoCompra;
    }
    public void setNumeroPlazas(int numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
    }
    public void setViajes(LEG<Viaje> viajes) { this.viajes = viajes; }

    public void registrarViaje(Viaje viaje) {

        if (this.viajes.existeElemento(viaje) != null) {
            throw new IllegalArgumentException("Ya existe un viaje registrado con este codigo.");
        }

        for (int i = 0; i < this.viajes.talla(); i++){
            Viaje viajes = this.viajes.getElemento(i);

            if (viajes.viajeSimilar(viaje)){
                throw new IllegalArgumentException("Ya existe un viaje similar");
            }
        }

        this.viajes.insertarElemento(viaje);
    }

    public void bajaViajes(Viaje viaje) {
        this.viajes.borrarElemento(viaje);
    }

    public void modificarViajes(Viaje viaje) {

        if (viaje.getOrigen().equals(viaje.getDestino())){
            throw new IllegalArgumentException("Las ciudade de origen y destino son iguales.");
        }

        for (int i = 0; i < this.viajes.talla(); i++){
            Viaje viajes = this.viajes.getElemento(i);

            if (viajes.getCodigo() !=  viaje.getCodigo() && viajes.viajeSimilar(viaje)){
                throw new IllegalArgumentException("El autobus ya realiza otro viaje similar");
            }
        }

        this.viajes.modificarElemento(viaje);
    }

    public void listarViajes() {
        for (int i = 0; i < this.viajes.talla(); i++){
            System.out.println(this.viajes.getElemento(i).toString());
        }
    }

    public boolean ciudadVailida(String ciudad) {
        return ciudad.equals("madrid") || ciudad.equals("segovia") || ciudad.equals("barcelona") || ciudad.equals("sevilla");
    }

    @Override
    public int compareTo(Autobus autobus) {
        return Integer.compare(this.numeroPlazas, autobus.numeroPlazas);
        //this.numeroPlazas == o.numeroPlazas ? 0 : (this.numeroPlazas > o.numeroPlazas ? 1 : -1);
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
        Autobus autobus = (Autobus) obj;

        return this.matricula.equals(autobus.matricula);
    }

    @Override
    public String toString() {
        return "[Matricula]:"+this.matricula+"\n[Año de compra]:"+this.annoCompra+"\n[Numero de plazas]:"+this.numeroPlazas;
    }
}
