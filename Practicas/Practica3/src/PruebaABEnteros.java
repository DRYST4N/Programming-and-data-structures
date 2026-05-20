import Jerárquicos.AB;
import Jerárquicos.ABEnteros;
import Jerárquicos.NodoAB;

import java.util.Scanner;

public class PruebaABEnteros {

    public void menuPruebas(){
        boolean salida = false;
        Scanner sc = new Scanner(System.in);

        ABEnteros abe1 = PruebaABEnteros.CrearAB1();
        ABEnteros abe2 = PruebaABEnteros.CrearAB2();

        do {

            try{

                menuPrincipal();

                System.out.println("Introduce una opcion:");
                int opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        System.out.println("El AB1 es un ABB:"+(abe1.EsABB()?"SI":"NO"));
                        System.out.println("El AB2 es un ABB:"+(abe2.EsABB()?"SI":"NO"));
                        break;
                    case 7:
                        System.out.println("El AB1 tiene raiz igual a nodos internos:"+(abe1.RaizIgualNodosInternos()?"SI":"NO"));
                        System.out.println("El AB2 tiene raiz igual a nodos internos:"+(abe2.RaizIgualNodosInternos()?"SI":"NO"));
                        break;
                    case 8:
                        abe1.EliminarNodosInferiores(2);
                        break;
                    case 9:
                        abe2.EliminarNodosInferiores(3);
                        break;
                    case 10:
                        System.out.println("Introduce el nivel");
                        int nivel = Integer.parseInt(sc.nextLine());

                        int minimoValorAbe1 = abe1.MinimoValorNivel(nivel);
                        int minimoValorAbe2 = abe2.MinimoValorNivel(nivel);

                        System.out.println("Árbol AB1: El valor mínimo obtenido en el nivel N es "+minimoValorAbe1);
                        System.out.println("Árbol AB1: El valor mínimo obtenido en el nivel N es "+minimoValorAbe2);
                        break;
                    case 0:
                        salida = true;
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Se debe seleccionar un numero valido");
            }
        }while (!salida);
    }

    public static void menuPrincipal(){
        System.out.println("\n\tMENU PRINCIPAL");
        System.out.println("\t===============");
        System.out.println("1. Listado de las claves del AB1 en PreOrden");
        System.out.println("2. Listado de las claves del AB1 en InOrden");
        System.out.println("3. Listado de las claves del AB1 en InOrden Converso");
        System.out.println("4. Listado de las claves del AB1 en PostOrden");
        System.out.println("5. Listado de las claves del AB2 en InOrden\n");
        System.out.println("------------------------------------------------------------\n");
        System.out.println("6. Comprobar si los árboles AB1 y AB2 son ABB");
        System.out.println("7. Comprobar Raiz Igual a Nodos Internos");
        System.out.println("8. Eliminar en AB1 nodos por debajo del nivel 2");
        System.out.println("9. Eliminar en AB2 nodos por debajo del nivel 3");
        System.out.println("10. Comprobar mínimo valor de un nivel");
        System.out.println("0. Salir");
    }

    public static ABEnteros CrearAB1(){

        NodoAB<Integer> nodo104 = new NodoAB<Integer>(104);

        //Nodos de la parte izquierda

        NodoAB<Integer> nodo71 = new NodoAB<Integer>(71);

        nodo104.setIzquierda(nodo71);

        NodoAB<Integer> nodo17 = new NodoAB<Integer>(17);
        NodoAB<Integer> nodo19 = new NodoAB<Integer>(19);

        nodo71.setDerecha(nodo19);
        nodo71.setIzquierda(nodo17);

        NodoAB<Integer> nodo3 = new NodoAB<Integer>(3);
        NodoAB<Integer> nodo18 = new NodoAB<Integer>(18);

        nodo17.setIzquierda(nodo3);
        nodo17.setDerecha(nodo18);

        //Nodos de la parte derecha

        NodoAB<Integer> nodo240 = new NodoAB<Integer>(240);

        nodo104.setDerecha(nodo240);

        NodoAB<Integer> nodo108 = new NodoAB<Integer>(108);
        NodoAB<Integer> nodo245 = new NodoAB<Integer>(245);

        nodo240.setIzquierda(nodo108);
        nodo108.setDerecha(nodo245);

        NodoAB<Integer> nodo110 = new NodoAB<Integer>(110);

        nodo108.setDerecha(nodo110);

        return new ABEnteros(nodo104);
    }
    public static ABEnteros CrearAB2(){

        NodoAB<Integer> nodo2 = new NodoAB<Integer>(2);

        //Nodos de la parte izquierda

        NodoAB<Integer> nodo1 = new NodoAB<Integer>(1);

        nodo2.setIzquierda(nodo1);

        NodoAB<Integer> nodo0 = new NodoAB<Integer>(0);

        nodo1.setIzquierda(nodo0);

        //Nodos de la parte derecha

        NodoAB<Integer> nodo5 = new NodoAB<Integer>(5);

        nodo2.setDerecha(nodo5);

        NodoAB<Integer> nodo3 = new NodoAB<Integer>(3);
        NodoAB<Integer> nodo7 = new NodoAB<Integer>(7);

        nodo5.setIzquierda(nodo3);
        nodo5.setDerecha(nodo7);

        return new ABEnteros(nodo2);
    }
}
