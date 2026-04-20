package librerias.estructurasDeDatos.lineales;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayCola arrayCola = new ArrayCola();

        boolean salida = false;

        do {
            try{
                nenuPrincipal();
                int eleccion = Integer.parseInt(sc.nextLine());

                switch (eleccion) {
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
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 0:
                        salida = true;
                        break;

                }
            }catch (NumberFormatException e){

            }
        }while (!salida);
    }

    private static void nenuPrincipal(){

        System.out.println("\nMENU PRINCIPAL");
        System.out.println("--------------");
        System.out.println("1.-Enviar un trabaja a la impresora");
        System.out.println("2.-Imprimir trabajos");
        System.out.println("3.-Mostrar trabajo mas pesado");
        System.out.println("4.-Mostrar tiempo de espera del usuario");
        System.out.println("5.-Informe de trabajos por prioridad");
        System.out.println("6.-Informe de trabajos de una prioridad");
        System.out.println("7.-Reducir espera en una prioridad");
        System.out.println("8.-Reiniciar el Sistema de impresion");
        System.out.println("0.-Salir");
        System.out.print("\nSeleccione una opción: ");
    }
}