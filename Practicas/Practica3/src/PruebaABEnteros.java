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
                        System.out.println("AB1 en PreOrden: ");
                        abe1.PreOrden();
                        break;
                    case 2:
                        System.out.println("AB1 en InOrden: ");
                        abe1.InOrden();
                        break;
                    case 3:
                        System.out.println("AB1 en InOrden Converso: ");
                        abe1.InOrdenConverso();
                        break;
                    case 4:
                        System.out.println("AB1 en PostOrden: ");
                        abe1.PostOrden();
                        break;
                    case 5:
                        System.out.println("AB2 en InOrden: ");
                        abe2.InOrden();
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
                        System.out.println("Árbol AB2: El valor mínimo obtenido en el nivel N es "+minimoValorAbe2);
                        break;
                    case 0:
                        salida = true;
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Se debe seleccionar un numero valido");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: "+e.getMessage());
            }
        System.out.print("Pulse una tecla para continuar.....");
        sc.nextLine();
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

        ABEnteros nodo104 = new ABEnteros();
        nodo104.setRaiz(104);

        //Nodos de la parte izquierda

        ABEnteros nodo71 = new ABEnteros();
        nodo71.setRaiz(71);

        ABEnteros nodo17= new ABEnteros();
        nodo17.setRaiz(17);

        ABEnteros nodo19= new ABEnteros();
        nodo19.setRaiz(19);

        ABEnteros nodo3= new ABEnteros();
        nodo3.setRaiz(3);

        ABEnteros nodo18= new ABEnteros();
        nodo18.setRaiz(18);

        nodo104.setIzquierda(nodo71);

        nodo71.setIzquierda(nodo17);
        nodo71.setDerecha(nodo19);

        nodo17.setIzquierda(nodo3);
        nodo17.setIzquierda(nodo18);

        //Nodos de la parte derecha

        ABEnteros nodo240= new ABEnteros();
        nodo240.setRaiz(240);

        ABEnteros nodo108= new ABEnteros();
        nodo108.setRaiz(108);

        ABEnteros nodo245= new ABEnteros();
        nodo245.setRaiz(245);

        ABEnteros nodo110= new ABEnteros();
        nodo110.setRaiz(110);

        nodo104.setDerecha(nodo240);

        nodo240.setIzquierda(nodo108);
        nodo104.setDerecha(nodo245);

        nodo108.setDerecha(nodo110);

        return nodo104;
    }
    public static ABEnteros CrearAB2(){

        ABEnteros nodo2 = new ABEnteros();
        nodo2.setRaiz(2);

        //Nodos de la parte izquierda

        ABEnteros nodo1= new ABEnteros();
        nodo1.setRaiz(1);

        ABEnteros nodo0= new ABEnteros();
        nodo0.setRaiz(0);

        nodo2.setIzquierda(nodo1);

        nodo1.setIzquierda(nodo0);

        //Nodos de la parte derecha

        ABEnteros nodo5= new ABEnteros();
        nodo5.setRaiz(5);

        ABEnteros nodo3= new ABEnteros();
        nodo3.setRaiz(3);

        ABEnteros nodo7= new ABEnteros();
        nodo7.setRaiz(7);

        nodo2.setDerecha(nodo5);

        nodo5.setIzquierda(nodo3);
        nodo5.setDerecha(nodo7);

        return nodo2;
    }
}
