package elGrimorioDelArchimago;

import ucu.edu.aed.tda.ABB;
import ucu.edu.aed.tda.TDAArbolBinario;

public class Grimorio {
    private ABB<Hechizo> insertar;
    private ABB<Hechizo> hechizosProhibidos;

    public Grimorio(){
        this.insertar = new ABB<Hechizo>();
        this.hechizosProhibidos = new ABB<Hechizo>();
    }

    public ABB<Hechizo> getGrimorio() {
        return insertar;
    }

    public ABB<Hechizo> getHechizosProhibidos() {
        return hechizosProhibidos;
    }

    boolean insertarHechizo(Hechizo hechizo){
        if(hechizo != null){
            if (hechizo.getId() % 2 != 0){
                hechizosProhibidos.insertar(hechizo);
            } else if (hechizo.getId() % 2 == 0) {
                insertar.insertar(hechizo);
            }
            return true;
        }
        return false;
    }





    public static void main(String[] args) {
        Grimorio miGrimorio = new Grimorio();
        miGrimorio.insertarHechizo(new Hechizo(42, "Fireball"));
        miGrimorio.insertarHechizo(new Hechizo(17, "Ice Lance"));
        miGrimorio.insertarHechizo(new Hechizo(58, "Thunder"));
        miGrimorio.insertarHechizo(new Hechizo(9, "Invisibility"));
        miGrimorio.insertarHechizo(new Hechizo(31, "Levitate"));
        miGrimorio.insertarHechizo(new Hechizo(73, "Summon"));
        miGrimorio.insertarHechizo(new Hechizo(25, "Heal"));
        miGrimorio.insertarHechizo(new Hechizo(50, "Teleport"));
        miGrimorio.insertarHechizo(new Hechizo(65, "Shield"));
        miGrimorio.insertarHechizo(new Hechizo(88, "Curse"));

        miGrimorio.getHechizosProhibidos().inOrder(t->System.out.println(t.getNombre()));
        miGrimorio.getGrimorio().inOrder(t->System.out.println(t.getNombre()));

    }



}
