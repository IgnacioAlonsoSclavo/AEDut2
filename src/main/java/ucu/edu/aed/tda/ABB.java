package ucu.edu.aed.tda;
import java.util.function.Consumer;

public class ABB<T> implements TDAArbolBinario<T>{

    Nodo<T> raiz;

    public ABB(){
        this.raiz = null;
    }
    public ABB(Nodo<T> raiz){
        this.raiz = raiz;
    }

    @Override
    public T buscar(Comparable<T> predicate) {
        if (raiz == null) {
            return null;
        }
        else{
            TDAElemento<T> nodoEncontrado = raiz.buscar(predicate);
            if(nodoEncontrado != null){
                return nodoEncontrado.getDato();
            }
            else {
                return null;
            }
        }

    }

    @Override
    public TDAElemento<T> obtenerRaiz() {
        return raiz;
    }

    @Override
    public boolean eliminar(Comparable<T> criterioBusqueda) {
        if (raiz == null) return false;
        if (this.buscar(criterioBusqueda) == null) return false;
        this.raiz = (Nodo<T>) raiz.eliminar(criterioBusqueda);
        return true;
    }

    @Override
    public boolean insertar(Comparable<T> dato) {
        if (this.raiz == null){
            raiz = new Nodo<T>((T) dato);
            return true;
        }
        else{
            return raiz.insertar(dato);
        }
    }

    @Override
    public void inOrder(Consumer<T> consumidor) {
        if (raiz != null){
            this.raiz.inOrder(elemento -> consumidor.accept(elemento.getDato()));
        }

    }

    @Override
    public void preOrder(Consumer<T> consumidor) {
        if (raiz != null){
            this.raiz.preOrder(elemento -> consumidor.accept(elemento.getDato()));
        }

    }

    @Override
    public void postOrder(Consumer<T> consumidor) {
        if(raiz != null){
            this.raiz.postOrder(elemento -> consumidor.accept(elemento.getDato()));
        }

    }

    @Override
    public boolean esVacio() {
       if (raiz == null){
           return true;
       }
       else{
           return false;
       }
    }

    @Override
    public int cantidadNodos() {
        if(raiz == null){
            return 0;
        }
        return raiz.cantidadNodos();
    }

    @Override
    public int cantidadHojas() {
        if (raiz == null){
            return 0;
        }
        return raiz.cantidadHojas();
    }

    @Override
    public int cantidadNodosInternos() {
        if(raiz == null){
        return 0;}
        return raiz.cantidadNodosInternos();
    }
}
