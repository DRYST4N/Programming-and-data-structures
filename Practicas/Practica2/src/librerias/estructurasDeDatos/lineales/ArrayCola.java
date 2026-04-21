package librerias.estructurasDeDatos.lineales;

import librerias.estructurasDeDatos.modelos.I_Cola;

import java.util.Scanner;

public class ArrayCola {

    private I_Cola<Trabajo>[] colas;

    public ArrayCola() {
        this.colas = new LECola[9];
       for(int i = 0; i < this.colas.length; i++){
           this.colas[i] = new LECola<Trabajo>();
       }
    }

    public void enviarTrabajoImpresora(int idUsuario, String titulo, int peso){
        Trabajo trabajo = new  Trabajo(idUsuario, titulo, peso);
        colas[trabajo.getPrioridad()-1].encolar(trabajo);
        System.out.println("Trabajo enviado a la impresora");
    }

    public void imprimirTrabajos(){

        int i = 0;

        if (i < this.colas.length){
            if (!this.colas[i].esVacia()){
                Trabajo trabajo = this.colas[i].desencolar();
                System.out.println("Se ha impreso el trabajo "+trabajo.getTitulo()
                        +" "+("Usuario "+trabajo.getIdUsuario()
                        +", Prioridad "+trabajo.getPrioridad()));
            }
            else{
                i++;
            }
        }
    }

    public void mostrarTrabajoMasPesado(){

        Trabajo trabajoMasPesado = null;

        for (I_Cola<Trabajo> cola : this.colas) {
            for (int j = 0; j < cola.contarElemCola(); j++) {
                Trabajo trabajoActual = cola.desencolar();

                if (trabajoMasPesado == null ||
                        trabajoActual.getPeso() > trabajoMasPesado.getPeso()) {
                    trabajoMasPesado = trabajoActual;
                }
                if (trabajoActual.getPeso() == trabajoMasPesado.getPeso()) {
                    if (trabajoActual.getPrioridad() > trabajoMasPesado.getPrioridad() ||
                            trabajoActual.getPrioridad() == trabajoMasPesado.getPrioridad()) {
                        trabajoMasPesado = trabajoActual;
                    }
                }
                cola.encolar(trabajoActual);
            }
        }

        if (trabajoMasPesado != null){
            System.out.println("ID_Usuario\tNivel de Prioridad\tTitulo\tTamaño(Kb)");
            System.out.println("----------------------------------------------------");
            System.out.println(trabajoMasPesado.getIdUsuario()+"\t"
                    +trabajoMasPesado.getPrioridad()+"\t"
                    +trabajoMasPesado.getTitulo()+"\t"
                    +trabajoMasPesado.getPeso()+"\t");
        }
        else {
            System.out.println("No hay trabajos");
        }
    }
}
