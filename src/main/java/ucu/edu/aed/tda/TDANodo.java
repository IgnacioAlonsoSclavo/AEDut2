package ucu.edu.aed.tda;

import java.util.function.Consumer;

public class TDANodo<T> implements TDAElemento<T>{
    private T dato;
    private TDAElemento<T> hijoIzq;
    private TDAElemento<T> hijoDer;

    public static int contador = 0;

    public TDANodo (T dato){
        this.hijoDer = null;
        this.hijoIzq = null;
        this.dato = dato;
    }

    @Override
    public void setHijoIzquierdo(TDAElemento<T> hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    @Override
    public void setHijoDerecho(TDAElemento<T> hijoDer) {
        this.hijoDer = hijoDer;
    }

    @Override
    public TDAElemento<T> getHijoIzquierdo() {
        return hijoIzq;
    }

    @Override
    public TDAElemento<T> getHijoDerecho() {
        return hijoDer;
    }

    @Override
    public void setDato(T dato) {
        this.dato = dato;
    }

    @Override
    public T getDato() {
        return dato;
    }

    @Override
    public TDAElemento<T> buscar(Comparable<T> criterioBusqueda) {

        int cmp = criterioBusqueda.compareTo(this.dato);

        if (cmp == 0) {
            return this;
        }
        else if(cmp<0){
            if (hijoIzq != null){
                return hijoIzq.buscar(criterioBusqueda);
            }
        } else {
            if (hijoDer != null){
                return hijoDer.buscar(criterioBusqueda);
            }
        }
        return null;
    }

    @Override
    public TDAElemento<T> eliminar(Comparable<T> criterioBusqueda) {
        return null;
    }

    @Override
    public boolean insertar(Comparable<T> nuevoDato) {
            if (nuevoDato.compareTo(this.dato) > 0) {
                if (hijoDer == null){
                    hijoDer = new TDANodo(nuevoDato); //bug del profe, lo va a arreglar.
                    return true;
                }else{
                    hijoDer.insertar(nuevoDato);

                }
            }else if (nuevoDato.compareTo(this.dato) <0){
                if(hijoIzq == null){
                    hijoIzq = new TDANodo(nuevoDato);
                    return true;
                }else{
                    hijoIzq.insertar(nuevoDato);
                }
            }
            return false;
    }

    @Override
    public void inOrder(Consumer<TDAElemento<T>> consumidor) {

    }

    @Override
    public void preOrder(Consumer<TDAElemento<T>> consumidor) {

    }

    @Override
    public void postOrder(Consumer<TDAElemento<T>> consumidor) {

    }

    @Override
    public boolean esHoja() {
        if (hijoDer == null && hijoIzq == null){
            return true;
        }
        else return false;
    }

    @Override
    public int cantidadHojas() {
        return 0;
    }

    @Override
    public int cantidadNodosInternos() {
        return 0;
    }

    @Override
    public int cantidadNodos() {
        return 0;
    }

    @Override
    public int altura() {
        return 0;
    }

    @Override
    public int obtenerNivel(Comparable<T> criterioBusqueda) {
        return 0;
    }
}
