package librerias.excepcionesDeUsuario;

import java.util.Scanner;

/**
 * Clase que contiene métodos estáticos para la validación
 * de entradas del usuario.
 */
public class Validaciones {

    public class Validaciones1{}

    /**
     * Valida que una opción seleccionada en un menú esté dentro de un rango numérico válido.
     * @param numero La opción introducida por el usuario.
     * @param total  El valor máximo permitido para la opción.
     * @throws IllegalArgumentException Si el número es menor que 0 o mayor que el total.
     */
    public static void validarOpcionesMenu(int numero,int total) throws IllegalArgumentException{
        if(numero < 0 || numero > total){
            throw new IllegalArgumentException("El numero debe estar dentro de rango");
        }
    }

    /**
     * Valida que un número proporcionado no sea negativo.
     * @param numero El número a validar.
     * @throws IllegalArgumentException Si el número es estrictamente menor que 0.
     */
    public static void validarNumeroNoNegativo(int numero) throws IllegalArgumentException{
        if(numero < 0){
            throw new IllegalArgumentException("El numero debe ser positivo");
        }
    }
}