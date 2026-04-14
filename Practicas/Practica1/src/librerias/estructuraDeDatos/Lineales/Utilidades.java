package librerias.estructuraDeDatos.Lineales;

/**
 * Clase de utilidades que proporciona métodos auxiliares estáticos
 * para facilitar el funcionamiento y testeo de la aplicación GEST_BUS.
 */
public class Utilidades {

    /**
     * Verifica de forma global si un código de viaje ya se encuentra registrado
     * en alguno de los autobuses del sistema.
     * @param codigoViaje El código del viaje que se desea buscar.
     * @param autobuses   La lista general que contiene todos los autobuses registrados.
     * @return true si el código de viaje ya existe asignado a algún autobús; false si está disponible.
     */
    public static boolean existeCodigoViaje(int codigoViaje, LDEGOrdenada<Autobus> autobuses) {
        for (int i = 0; i < autobuses.talla(); i++) {
            Autobus autobus = autobuses.getElemento(i);

            if (autobus.getViajes().existeElemento(new Viaje(codigoViaje, "", "", "")) != null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Carga un conjunto de datos iniciales por defecto en el sistema.
     * @param autobuses La lista general de autobuses donde se insertarán los datos autogenerados.
     */
    public static void creacionAutomatica(LDEGOrdenada<Autobus> autobuses) {
        Autobus autobus1 = new Autobus("3457HBG", "2005", 34);
        Autobus autobus2 = new Autobus("6544KAJ", "2008", 24);
        Autobus autobus3 = new Autobus("8262ÑPL", "2003", 14);

        autobuses.insertarElemento(autobus1);
        autobuses.insertarElemento(autobus2);
        autobuses.insertarElemento(autobus3);

        Viaje viaje1 = new Viaje(123456, "Madrid", "Barcelona", "20:00");
        Viaje viaje2 = new Viaje(654321, "Barcelona", "Madrid", "10:45");
        Viaje viaje3 = new Viaje(678905, "Segovia", "Madrid", "12:15");
        Viaje viaje4 = new Viaje(628812, "Sevilla", "Segovia", "19:30");

        autobus1.registrarViaje(viaje1);
        autobus1.registrarViaje(viaje2);
        autobus2.registrarViaje(viaje3);
        autobus3.registrarViaje(viaje4);
    }
}