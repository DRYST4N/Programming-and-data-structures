package librerias.estructurasDeDatos.lineales.Menus;

import java.util.Scanner;

public class MenuPrincipal {

    private Scanner sc;
    //private

    public MenuPrincipal() {
        sc=new Scanner(System.in);
    }

    public void iniciar(){

        boolean salidaMenuInicio = false;

        do {
            try {
                mostrarMenu();
                int decision = Integer.parseInt(this.sc.nextLine());

                switch (decision) {
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
                        salidaMenuInicio = true;
                        break;
                }
            }catch(NumberFormatException e){
                System.out.println("Se debe seleccionar un numero valido de menu");
            }
        }while(!salidaMenuInicio);

    }

    private void mostrarMenu() {
        System.out.println("\nMENU PRINCIPAL");
        System.out.println("-----------------");
        System.out.println("1.-Enviar un trabaja a la impresora");
        System.out.println("2.-Imprimir trabajos");
        System.out.println("3.-Mostrar trabajo más pesado");
        System.out.println("4.-Mostrar tiempo de espera de un usuario");
        System.out.println("5.-Informe de trabajos por prioridad");
        System.out.println("6.-Informe de trabajos de una prioridad");
        System.out.println("7.-Reducir espera de una prioridad");
        System.out.println("8.-Reiniciar el Sistema de impresión");
        System.out.println("0.-Salir");
        System.out.print("\nSeleccione una opción: ");
    }
}
