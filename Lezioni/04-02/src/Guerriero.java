import java.util.Random;

public class Guerriero extends Personaggio{

    private int resistenza;

    public Guerriero(String nome){
        super(nome, 150, 30, 100, Armi.COLTELLO);
        resistenza = 4;
    }

    public String toString(){
        return super.toString() + ": Guerriero[" + resistenza +"]";
    }

    public void attacca(Personaggio p){

    }

    public boolean subisci(int d) {
        if(resistenza != 4){ //Subisce danno ogni 4 colpi
            vita-=d;
            resistenza ++;
        }
        if(resistenza >= 4){
            resistenza = 0;
        }
        if(vita<0) return true;
        return false;
    }
}
