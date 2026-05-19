import Jerárquicos.ABEnteros;

import java.util.Scanner;

import static java.lang.System.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main<E> {
    public static void main(String[] args) {

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
                        System.out.println("El AB1 es un ABB:"+abe1.EsABB());
                        System.out.println("El AB2 es un ABB:"+abe2.EsABB());
                        break;
                    case 7:
                        System.out.println("El AB1 tiene raiz igual a nodos internos:"+abe1.RaizIgualNodosInternos());
                        System.out.println("El AB2 tiene raiz igual a nodos internos:"+abe2.RaizIgualNodosInternos());
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
}










