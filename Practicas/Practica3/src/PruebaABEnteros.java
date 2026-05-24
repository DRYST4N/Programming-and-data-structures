import Jerarquicos.ABEnteros;

import java.util.Scanner;

/**
 * Clase de prueba para el TAD ABEnteros.
 */
public class PruebaABEnteros {

    /**
     * Menu para realizar las pruebas
     */
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
                        System.out.println("LISTADO DE CLAVES DEL AB1 EN PREORDEN");
                        System.out.println("=====================================");
                        abe1.PreOrden();
                        break;
                    case 2:
                        System.out.println("LISTADO DE CLAVES DEL AB1 EN INORDEN");
                        System.out.println("====================================");
                        abe1.InOrden();
                        break;
                    case 3:
                        System.out.println("LISTADO DE CLAVES DEL AB1 EN INORDENCONVERSO");
                        System.out.println("============================================");
                        abe1.InOrdenConverso();
                        break;
                    case 4:
                        System.out.println("LISTADO DE CLAVES DEL AB1 EN POSTORDEN");
                        System.out.println("======================================");
                        abe1.PostOrden();
                        break;
                    case 5:
                        System.out.println("LISTADO DE CLAVES DEL AB2 EN INORDEN");
                        System.out.println("====================================");
                        abe2.InOrden();
                        break;
                    case 6:
                        System.out.println("COMPROBAR SI LOS ARBOLES AB1 y AB2 son ABB");
                        System.out.println("==========================================");
                        System.out.println("El AB1 es un ABB:"+(abe1.EsABB()?"SI":"NO"));
                        System.out.println("El AB2 es un ABB:"+(abe2.EsABB()?"SI":"NO"));
                        break;
                    case 7:
                        System.out.println("COMPROBAR RAIZ IGUAL A NODOS INTERNOS");
                        System.out.println("=====================================");
                        System.out.println("El AB1 tiene raiz igual a nodos internos:"+(abe1.RaizIgualNodosInternos()?"SI":"NO"));
                        System.out.println("El AB2 tiene raiz igual a nodos internos:"+(abe2.RaizIgualNodosInternos()?"SI":"NO"));
                        break;
                    case 8:
                        System.out.println("ELIMINAR EN AB1 NODOS POR DEBAJO DEL NIVEL 2");
                        System.out.println("============================================");
                        abe1.EliminarNodosInferiores(2);
                        abe1.InOrden();
                        break;
                    case 9:
                        System.out.println("ELIMINAR EN AB2 NODOS POR DEBAJO DEL NIVEL 3");
                        System.out.println("============================================");
                        abe2.EliminarNodosInferiores(3);
                        abe2.InOrden();
                        break;
                    case 10:
                        System.out.println("COMPROBAR MINIMO VALOR DE UN NIVEL");
                        System.out.println("==================================");
                        System.out.println("Introduce el nivel");
                        int nivel = Integer.parseInt(sc.nextLine());

                        int minimoValorAbe1 = abe1.MinimoValorNivel(nivel);
                        int minimoValorAbe2 = abe2.MinimoValorNivel(nivel);

                        System.out.println("Arbol AB1: El valor mínimo obtenido en el nivel "+nivel+" es "+minimoValorAbe1);
                        System.out.println("Arbol AB2: El valor mínimo obtenido en el nivel "+nivel+" es "+minimoValorAbe2);
                        break;
                    case 0:
                        System.out.println("Gracias por utilizar nuestra aplicacion...");
                        salida = true;
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Se debe seleccionar un numero valido");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        System.out.print("Pulse una tecla para continuar.....");
        sc.nextLine();
        }while (!salida);
    }

    /**
     * Muestra el menú principal.
     */
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

    /**
     * Crea y devuelve el árbol binario de enteros AB1.
     */
    public static ABEnteros CrearAB1(){

        ABEnteros nodo104 = new ABEnteros();
        nodo104.setDato(104);

        //Nodos de la parte izquierda

        ABEnteros nodo71 = new ABEnteros();
        nodo71.setDato(71);

        ABEnteros nodo17= new ABEnteros();
        nodo17.setDato(17);

        ABEnteros nodo19= new ABEnteros();
        nodo19.setDato(19);

        ABEnteros nodo3= new ABEnteros();
        nodo3.setDato(3);

        ABEnteros nodo18= new ABEnteros();
        nodo18.setDato(18);

        nodo104.setIzquierda(nodo71);

        nodo71.setIzquierda(nodo17);
        nodo71.setDerecha(nodo19);

        nodo17.setIzquierda(nodo3);
        nodo17.setDerecha(nodo18);

        //Nodos de la parte derecha

        ABEnteros nodo240= new ABEnteros();
        nodo240.setDato(240);

        ABEnteros nodo108= new ABEnteros();
        nodo108.setDato(108);

        ABEnteros nodo245= new ABEnteros();
        nodo245.setDato(245);

        ABEnteros nodo110= new ABEnteros();
        nodo110.setDato(110);

        nodo104.setDerecha(nodo240);

        nodo240.setIzquierda(nodo108);
        nodo240.setDerecha(nodo245);

        nodo108.setDerecha(nodo110);

        return nodo104;
    }

    /**
     * Crea y devuelve el árbol binario de enteros AB2.
     */
    public static ABEnteros CrearAB2(){

        ABEnteros nodo2 = new ABEnteros();
        nodo2.setDato(2);

        //Nodos de la parte izquierda

        ABEnteros nodo1= new ABEnteros();
        nodo1.setDato(1);

        ABEnteros nodo0= new ABEnteros();
        nodo0.setDato(0);

        nodo2.setIzquierda(nodo1);

        nodo1.setIzquierda(nodo0);

        //Nodos de la parte derecha

        ABEnteros nodo5= new ABEnteros();
        nodo5.setDato(5);

        ABEnteros nodo3= new ABEnteros();
        nodo3.setDato(3);

        ABEnteros nodo7= new ABEnteros();
        nodo7.setDato(7);

        nodo2.setDerecha(nodo5);

        nodo5.setIzquierda(nodo3);
        nodo5.setDerecha(nodo7);

        return nodo2;
    }
}
