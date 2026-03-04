package Codigo;

public class LEG<E> {

    private NodoLEG<E> primero;
    private int talla;

    public LEG(){
        this.primero= null;
        this.talla=0;
    }
    public int talla(){
        return this.talla;
    }
    public void insetar(){} //Tras insertar aumentar talla
    public void eliminar(){}
    public void modificar(){}
}
