package Excepciones;

public class Excepciones {

    public static void nivelesFueraDeRango(int nivel, int niveles) {

        if (nivel > niveles || nivel < 0){
            throw new IllegalArgumentException("ERROR: no existen "+nivel+" niveles en el árbol. El árbol tiene "+niveles+" niveles");
        }

    }
}
