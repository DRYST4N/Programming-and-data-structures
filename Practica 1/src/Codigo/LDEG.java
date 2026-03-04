package Codigo;

public class LDEG<E extends Comparable<E>> extends LEG<E> {

    private NodoLDEG<E> siguiente;
    private int talla;

    public LDEG() {
        this.siguiente=null;
        this.talla=0;
    }

    public int talla(){
        return this.talla;
    }
    public void insetar(){}
    public void eliminar(){}
    public void modificar(){}

}
