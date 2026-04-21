package librerias.estructurasDeDatos.lineales;

import librerias.estructurasDeDatos.modelos.I_Cola;

import java.util.Scanner;

public class ArrayCola {

    private I_Cola<Trabajo>[] colas;

    public ArrayCola() {
        this.colas = new LECola[9];
       for(int i = 0; i < 9; i++){
           this.colas[i] = new LECola<Trabajo>();
       }
    }

    public void enviarTrabajoImpresora(int idUsuario, String titulo, int peso){
        Trabajo trabajo = new  Trabajo(idUsuario, titulo, peso);
        colas[trabajo.getPrioridad()-1].encolar(trabajo);
        System.out.println("Trabajo enviado a la impresora");
    }

    public boolean imprimirTrabajos(){

        for (int i = 0; i < 9;i++){
            if (!this.colas[i].esVacia()){
                Trabajo trabajo = this.colas[i].desencolar();
                System.out.println("Se ha impreso el trabajo "+trabajo.getTitulo()
                        +" "+("Usuario "+trabajo.getIdUsuario()
                        +", Prioridad "+trabajo.getPrioridad()));

                return true;
            }
        }
        System.out.println("No hay mas trabajos para imprimir");
        return false;
    }

    public void mostrarTrabajoMasPesado(){

        Trabajo trabajoMasPesado = null;

        for (I_Cola<Trabajo> cola : this.colas) {
            int elementos = cola.contarElemCola();
            for (int j = 0; j < elementos; j++) {
                Trabajo trabajoActual = cola.desencolar();

                if (trabajoMasPesado == null ||
                        trabajoActual.getPeso() > trabajoMasPesado.getPeso()) {
                    trabajoMasPesado = trabajoActual;
                }
                else if (trabajoActual.getPeso() == trabajoMasPesado.getPeso()) {
                    if (trabajoActual.getPrioridad() < trabajoMasPesado.getPrioridad() ||
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
