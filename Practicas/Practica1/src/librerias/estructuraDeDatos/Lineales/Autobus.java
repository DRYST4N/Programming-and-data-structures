package librerias.estructuraDeDatos.Lineales;

import  librerias.excepcionesDeUsuario.ReglasImpuestasException;

/**
 * Representa un autobús,almacena los datos básicos del vehículo y gestiona de forma interna
 * la lista de viajes que tiene asignados para realizar.
 * Implementa la interfaz Comparable para establecer un orden
 * basado en el número de plazas del autobús.
 */
public class Autobus implements Comparable<Autobus> {
    private String matricula;
    private String annoCompra;
    private int numeroPlazas;
    private LEG<Viaje> viajes;

    /**
     * Constructor para inicializar un nuevo autobús sin viajes asignados.
     * @param matricula    La matrícula única que identifica al autobús.
     * @param annoCompra   El año en el que se adquirió el autobús.
     * @param numeroPlazas La capacidad máxima de pasajeros del autobús.
     */
    public Autobus(String matricula, String annoCompra, int numeroPlazas) {
        this.matricula = matricula;
        this.annoCompra = annoCompra;
        this.numeroPlazas = numeroPlazas;
        this.viajes = new LEG<Viaje>();
    }

    /**
     * Constructor para inicializar un autobús recibiendo una lista de viajes ya existente.
     * @param matricula    La matrícula única del autobús.
     * @param annoCompra   El año de compra del autobús.
     * @param numeroPlazas La capacidad máxima de pasajeros.
     * @param viajes       La estructura LEG que contiene los viajes asignados.
     */
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

    /**
     * Registra un nuevo viaje en la lista de este autobús verificando estrictamente
     * las reglas impuestas.
     * @param viaje El objeto viaje que se desea añadir.
     * @throws ReglasImpuestasException Si se incumple alguna de las reglas de impuestas.
     */
    public void registrarViaje(Viaje viaje) {

        if (viaje.getOrigen().equals(viaje.getDestino())){
            throw new ReglasImpuestasException("Las ciudades de origen y destino son iguales.");
        }
        if (this.viajes.existeElemento(viaje) != null) {
            throw new ReglasImpuestasException("Ya existe un viaje registrado con este codigo.");
        }

        for (int i = 0; i < this.viajes.talla(); i++){
            Viaje viajes = this.viajes.getElemento(i);

            if (viajes.getHora().equals(viaje.getHora())){
                throw new ReglasImpuestasException("El autobus ya tiene un viaje asignado a esta hora");
            }
        }

        this.viajes.insertarElemento(viaje);
    }

    /**
     * Elimina un viaje específico de la lista de viajes del autobús.
     * @param viaje El viaje que se desea dar de baja.
     */
    public void bajaViajes(Viaje viaje) {
        this.viajes.borrarElemento(viaje);
    }

    /**
     * Modifica los datos de un viaje ya existente.
     * Verifica que el nuevo origen y destino sean distintos, y que la nueva hora
     * no entre en conflicto con otro viaje diferente ya asignado al autobús.
     * @param viaje El viaje con la información actualizada que sobreescribirá al anterior.
     * @throws ReglasImpuestasException Si origen y destino son iguales, o si hay un choque de horarios.
     */
    public void modificarViajes(Viaje viaje) {

        if (viaje.getOrigen().equals(viaje.getDestino())){
            throw new ReglasImpuestasException("Las ciudade de origen y destino son iguales.");
        }

        for (int i = 0; i < this.viajes.talla(); i++){
            Viaje viajes = this.viajes.getElemento(i);

            if (viajes.getCodigo() !=  viaje.getCodigo() && viajes.getHora().equals(viaje.getHora())){
                throw new ReglasImpuestasException("El autobus ya realiza otro viaje a esta hora");
            }
        }

        this.viajes.modificarElemento(viaje);
    }

    /**
     * Muestra por consola la información detallada
     * de todos los viajes asignados a este autobús.
     */
    public void listarViajes() {
        for (int i = 0; i < this.viajes.talla(); i++){
            System.out.println(this.viajes.getElemento(i).toString());
        }
    }

    /**
     * Verifica si una ciudad proporcionada es válida según las restricciones.
     * Las únicas ciudades permitidas son Madrid, Segovia, Barcelona y Sevilla.
     * @param ciudad El nombre de la ciudad a comprobar.
     * @return true si la ciudad es una de las permitidas; false en caso contrario.
     */
    public boolean ciudadValida(String ciudad) {
        if (ciudad == null) return false;

        ciudad = ciudad.toLowerCase().trim();

        return ciudad.equals("madrid") ||
                ciudad.equals("segovia") ||
                ciudad.equals("barcelona") ||
                ciudad.equals("sevilla");
    }

    /**
     * Compara este autobús con otro para establecer una ordenación.
     * El criterio de ordenación se basa de manera exclusiva en el número de plazas.
     * @param autobus El autobús con el que se va a comparar.
     * @return Un número negativo, cero o un número positivo si este autobús tiene
     * respectivamente menos, igual o más plazas que el autobús pasado como parámetro.
     */
    @Override
    public int compareTo(Autobus autobus) {
        return Integer.compare(this.numeroPlazas, autobus.numeroPlazas);
        //this.numeroPlazas == o.numeroPlazas ? 0 : (this.numeroPlazas > o.numeroPlazas ? 1 : -1);
    }

    /**
     * Determina la igualdad entre dos autobuses.
     * Dos autobuses se consideran el mismo, si tienen la misma matrícula.
     * @param obj El objeto a comparar con este autobús.
     * @return true si el objeto es un Autobús con la misma matrícula; false en cualquier otro caso.
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
        Autobus autobus = (Autobus) obj;

        return this.matricula.equals(autobus.matricula);
    }

    /**
     * Devuelve una representación en formato de cadena de texto
     * con los datos principales del autobús.
     * @return Una cadena de texto estructurada con la matrícula, el año de compra y el número de plazas.
     */
    @Override
    public String toString() {
        return "[Matricula]:"+this.matricula+"\n[Año de compra]:"+this.annoCompra+"\n[Numero de plazas]:"+this.numeroPlazas;
    }
}