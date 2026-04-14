package librerias.excepcionesDeUsuario;

import java.util.Scanner;

public class Validaciones {

    public class Validaciones1{}

    public static void validarOpcionesMenu(int numero,int total) throws IllegalArgumentException{

        if(numero < 0 || numero > total){
            throw new IllegalArgumentException("El numero debe estar dentro de rango");
        }
    }

    public static void validarNumeroNoNegativo(int numero) throws IllegalArgumentException{
        if(numero < 0){
            throw new IllegalArgumentException("El numero debe ser positivo");
        }
    }
}
