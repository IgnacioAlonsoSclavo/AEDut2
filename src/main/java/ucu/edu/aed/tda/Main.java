package ucu.edu.aed.tda;
import ucu.edu.aed.utils.FileUtils;
import java.io.File;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;


public class Main  {

    String archivo = "archivos/clavesPrueba.txt";
    public void insertarClaves(){
        FileUtils.leerLineas(archivo, linea -> {

            FileUtils.escribirLineas("archivos/Archivo_Escrito_clavesPrueba", linea);
        });
    }

    public void main(String[] str) {
        insertarClaves();

        //cargar claves
    TDAArbolBinario<Integer> arbol = new ABB<Integer>();
    FileUtils.leerLineas("archivos/clavesPrueba.txt", linea -> {
        int clave = Integer.parseInt(linea);
        arbol.insertar(clave);
    });

    List<String> resultados = new ArrayList<>();



    }

}


