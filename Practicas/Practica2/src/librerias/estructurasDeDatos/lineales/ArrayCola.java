package librerias.estructurasDeDatos.lineales;

import librerias.estructurasDeDatos.modelos.I_Cola;

public class ArrayCola {

    private I_Cola<Trabajo>[] colas;

    public ArrayCola() {
        this.colas = new LECola[9];
       for(int i = 0; i < this.colas.length; i++){
           this.colas[i] = new LECola<Trabajo>();
       }
    }

    public void enviarTrabajoImpresora(int idUsuario, String titulo, int peso){

    }
}
