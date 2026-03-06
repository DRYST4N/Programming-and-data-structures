package librerias.estructuraDeDatos.Modelo;

import librerias.estructuraDeDatos.Lineales.NodoLEG;

public interface INodo {

    public void AddItem(NodoLEG n, NodoLEG n2);
    public NodoLEG SelectItem(NodoLEG n);
    public void DeleteItem(NodoLEG n);

}
