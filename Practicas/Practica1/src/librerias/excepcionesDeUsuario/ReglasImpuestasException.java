package librerias.excepcionesDeUsuario;

/**
 * Excepción personalizada para manejar las infracciones de las reglas
 * impuestas en la practica de la aplicación GEST_BUS
 */
public class ReglasImpuestasException extends IllegalArgumentException {
    public ReglasImpuestasException(String mensaje){
        super(mensaje);
    }
}