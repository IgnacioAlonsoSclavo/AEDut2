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
                    hijoDer = new TDANodo(nuevoDato);
                    return true;
                }else{
                    return hijoDer.insertar(nuevoDato);

                }
            }else if (nuevoDato.compareTo(this.dato) <0){
                if(hijoIzq == null){
                    hijoIzq = new TDANodo(nuevoDato);
                    return true;
                }else{
                    return hijoIzq.insertar(nuevoDato);
                }
            }
            return false;
    }

    @Override
    public void preOrder(Consumer<TDAElemento<T>> consumidor) {
        consumidor.accept(this);
        if(this.hijoIzq !=null) this.hijoIzq.preOrder(consumidor);
        if(this.hijoDer != null) this.hijoDer.preOrder(consumidor);
    }

    @Override
    public void inOrder(Consumer<TDAElemento<T>> consumidor) {
        if(this.hijoIzq != null) this.hijoIzq.inOrder(consumidor);
        consumidor.accept(this);
        if (this.hijoDer != null) this.hijoDer.inOrder(consumidor);
    }

    @Override
    public void postOrder(Consumer<TDAElemento<T>> consumidor) {
        if(this.hijoIzq != null) this.hijoIzq.postOrder(consumidor);
        if(this.hijoDer != null) this.hijoDer.postOrder(consumidor);
        consumidor.accept(this);
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
        //devuelve 1 si el primero es hoja
        if(this.esHoja() == true){
            return 1;
        }

        //si el primero no es hoja, todavia no tenemos hojas.
        int hojasSubArbol = 0;

        if (hijoIzq != null){
            hojasSubArbol += hijoIzq.cantidadHojas();
        }
        if(hijoDer != null){
            hojasSubArbol += hijoDer.cantidadHojas();
        }
        return hojasSubArbol;
    }

    @Override
    public int cantidadNodosInternos() {
        //devuevle 0 si es hoja, ya que si es hoja no tenemos ningun nodo interno
        if(this.esHoja()){
            return 0;
        }

        //Si el primero no es hoja, ya tenemos un nodo interno.
        int nodosSubArbol = 1;

        if(hijoDer != null){
            nodosSubArbol += hijoDer.cantidadNodosInternos();
        }
        if(hijoIzq != null){
            nodosSubArbol += hijoIzq.cantidadNodosInternos();
        }
        return nodosSubArbol;
    }

    @Override
    public int cantidadNodos() {
        //devuelve 1 si es hoja, ya que si es hoja tenemos solo un nodo
        if(this.esHoja()){
            return 1;
        }

        //si no es hoja, tenemos un nodo tambíen.
        int nodosTotales = 1;

        if(hijoDer != null){
            nodosTotales += hijoDer.cantidadNodos();
        }

        if(hijoIzq != null){
            nodosTotales += hijoIzq.cantidadNodos();
        }
        return nodosTotales;
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
