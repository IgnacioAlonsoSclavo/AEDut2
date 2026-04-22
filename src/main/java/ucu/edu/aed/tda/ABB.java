package ucu.edu.aed.tda;
import java.util.function.Consumer;

public class ABB<T> implements TDAArbolBinario<T>{

    TDANodo<T> raiz;

    public ABB(){
        this.raiz = null;
    }
    public ABB(TDANodo<T> raiz){
        this.raiz = raiz;
    }

    @Override
    public T buscar(Comparable<T> predicate) {
        if (raiz == null) {
            return null;
        }
        else{
            return raiz.buscar(predicate).getDato();
        }
    }

    @Override
    public TDAElemento<T> obtenerRaiz() {
        return raiz;
    }

    @Override
    public boolean eliminar(Comparable<T> criterioBusqueda) {
        return false;
    }

    @Override
    public boolean insertar(Comparable<T> dato) {
        if (this.raiz == null){
            raiz = new TDANodo<T>((T) dato);
            return true;
        }
        else{
            raiz.insertar(dato);
            return true;
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
        return 0;
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
        return 0;
    }
}
