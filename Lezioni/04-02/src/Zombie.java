import java.util.ArrayList;
import java.util.List;

public class Zombie extends Personaggio{

    List<Personaggio> schiavi = new ArrayList<>();


    public Zombie(String nome) {
        super(nome, 50, 200, 50, Armi.PUGNI);
    }


    public void cattura(Personaggio p){
        schiavi.add(p);
    }


    public List<Personaggio> getSchiavi() {
        return schiavi;
    }

    public String toString() {
        String s = "";

        for(Personaggio p: schiavi){
            s += p.getNome() + "-";
        }


        return super.toString() + ": Zombie[Schiavi: " +
                s
                + "]";
    }

    public void attacca(Personaggio p) {
        if(p.subisci(getDanni())) cattura(p);

    }

    public boolean subisci(int d) {
        vita-=d/2;
        if(vita<0) return true;
        return false;
    }
}
