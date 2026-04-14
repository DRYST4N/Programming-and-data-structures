package librerias.estructurasDeDatos.lineales;

import librerias.estructurasDeDatos.modelos.I_Cola;

public class ArrayCola<E extends Comparable<E>> implements I_Cola<E> {

    private E elArray[];
    private int fin,primero;
    private static final int capacidadPorDefecto=200;

    public ArrayCola() {
        this.elArray = (E[]) new Object[capacidadPorDefecto];
        this.fin=-1;
        this.primero=0;
    }

    @Override
    public void encolar(E dato) {
        //ver lo de duplicar array
        this.fin = incementa(this.fin);
        this.elArray[this.fin] = dato;
    }

    @Override
    public E desencolar() {

        if (esVacia()){
            return null;
        }

        E dato=this.elArray[this.primero];

        this.primero = incementa(this.primero);

        return dato;
    }

    @Override
    public E primero() {
        return this.elArray[this.primero];
    }

    @Override
    public boolean esVacia() {
        for (E e : this.elArray) {
            if (e != null) {
                return false;
            }
        }
        return true;
    }

    private int incementa(int indice){
        if(++indice==this.elArray.length){
            indice=0;
        }
        return indice;
    }

    public int tamnioElementos(){
        int tamanio=0;
        for (int i = 0;i < this.elArray.length;i++) {
            if (this.elArray[i] != null) {
                tamanio++;
            }
            else {
                break;
            }
        }
        return tamanio;
    }
}
