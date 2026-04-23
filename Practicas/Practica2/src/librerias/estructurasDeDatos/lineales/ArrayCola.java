package librerias.estructurasDeDatos.lineales;

import librerias.estructurasDeDatos.modelos.I_Cola;

import java.lang.annotation.Target;
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

    public void informarEspera(int idUsuario){
        int prioridadUsuario = idUsuario / 100;
        int indiceUsuario = prioridadUsuario - 1;
        int contadorTrabajos = 0;
        boolean encontrado = false;

        for(int i = 0; i< indiceUsuario; i++){
            contadorTrabajos += colas[indiceUsuario].contarElemCola();
        }

        I_Cola<Trabajo> suCola = colas[indiceUsuario];
        int n = suCola.contarElemCola();

        for (int i = 0; i < n; i++) {
            Trabajo t = suCola.desencolar();

            if (!encontrado && t.getPrioridad() ==idUsuario) {
                encontrado = true;
            }

            if (!encontrado){
                contadorTrabajos++;
            }
            suCola.encolar(t);
        }

        if(encontrado){
            System.out.println("** El usuario " +idUsuario +"tiene delante "+ contadorTrabajos + "trabajos");
        }else{
            System.out.println("** No existen trabajos pendientes del usuario "+idUsuario);
        }
    }

    public void informeTodasPrioridades(){
        int totalPendientes = 0;

        System.out.println("\nINFORME DE TRABAJOS POR PRIORIDADES");
        System.out.println("Nivel de Prioridad\tTrabajos en espera");
        System.out.println("--------------------------------------------");

        for(int i= 0; i<colas.length; i++){
            int trabajosEnCola = colas[i].contarElemCola();

            System.out.println((i+1)+"\t\t\t"+trabajosEnCola);
            totalPendientes += trabajosEnCola;
        }
        System.out.println("----------------------------------------------------");
        System.out.println("Numero total de trabajos pendientes: "+totalPendientes);
        System.out.println("----------------------------------------------------");
    }
    public void informeUnaPrioridad(int idUsuario){
        I_Cola<Trabajo> colaSeleccionada = colas[idUsuario - 1];
        int n = colaSeleccionada.contarElemCola();

        System.out.println("\nINFORME DE TRABAJOS por Prioridad" + idUsuario);
        System.out.println("ID usuario\t\tTitulo");
        System.out.println("--------------------------------------------------------");

        if (n == 0){
            System.out.println("No hay trabajos en espera para esta prioridad");
        }else{
            for(int i = 0; i < n; i++){
                Trabajo t = colaSeleccionada.desencolar();
                System.out.println(t.getIdUsuario()+"\t\t\t"+t.getTitulo());
                colaSeleccionada.encolar(t);
            }
        }
    }

    public void reducirEspera(int prioridad){
        I_Cola<Trabajo> cola = colas[prioridad - 1];
        int distancia = 2;

        while(cola.contarElemCola() >= distancia){
            int n = cola.contarElemCola();
            int contadorPosicion = 1;

            for (int i = 0; i < n; i++) {
                Trabajo t = cola.desencolar();

                if ((contadorPosicion - 1) % distancia == 0) {
                    System.out.println("Se ha eliminado el trabajo " + t.getIdUsuario() + " <" + t.getTitulo() + "> de la cola");
                }else{
                    cola.encolar(t);
                }
                contadorPosicion++;
            }
            distancia++;
        }
    }

    public void reiniciarSistema(){
        for(int i = 0; i<colas.length; i++){
            while(!colas[i].esVacia()){
                colas[i].desencolar();
            }
        }
        System.out.println("Sistema de impresion reiniciado (todas las colas vacias).");
    }

    public void rellenarDatosPrueba() {
        // Formato: idUsuario, titulo, peso
        // Prioridad 1 (IDs 100-199)
        enviarTrabajoImpresora(120, "Examen_Final_Mates.pdf", 450);
        enviarTrabajoImpresora(150, "Apuntes_Historia.docx", 120);
        enviarTrabajoImpresora(120, "Graficos_Mates_V2.png", 800); // Mismo usuario (120)

        // Prioridad 2 (IDs 200-299)
        enviarTrabajoImpresora(210, "Presupuesto_Proyecto.xlsx", 50);

        // Prioridad 5 (IDs 500-599) - Para probar el Punto 7 con muchos datos
        enviarTrabajoImpresora(501, "Doc_A.txt", 10);
        enviarTrabajoImpresora(502, "Doc_B.txt", 20);
        enviarTrabajoImpresora(503, "Doc_C.txt", 30);
        enviarTrabajoImpresora(504, "Doc_D.txt", 40);
        enviarTrabajoImpresora(505, "Doc_E.txt", 50);
        enviarTrabajoImpresora(506, "Doc_F.txt", 60);

        // Prioridad 9 (IDs 900-999)
        enviarTrabajoImpresora(999, "Ultima_Hora.pdf", 1500);

        System.out.println("\n[SISTEMA] Se han cargado datos de prueba automáticamente.");
    }
}
