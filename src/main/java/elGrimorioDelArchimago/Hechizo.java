package elGrimorioDelArchimago;

public class Hechizo implements Comparable<Hechizo>{
    private int id;
    private String nombre;

    Hechizo(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public int compareTo(Hechizo otroHechizo) {
        return Integer.compare(this.id, otroHechizo.id);
    }
}
