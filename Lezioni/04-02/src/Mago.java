import java.util.Random;

public class Mago extends Personaggio{

    private Potere tipo;
    private int aura;

    public Mago(String nome) {
        super(nome, 100, 16, 100, Armi.MAGIA);
        setPotere();
        aura = 1;
    }

    public void setPotere() {
        scegliTipo();

    }

    public void attacca(Personaggio p){

    }

    public void scegliTipo(){
        Random n = new Random();
        int numero = n.nextInt(1, 3);

        switch(numero){
            case 1:
                tipo = Potere.ELETTRICO; break;
            case 2:
                tipo = Potere.FUOCO; break;
            case 3:
                tipo = Potere.GHIACCIO; break;
        }
    }

    public String toString(){
        return super.toString() + ": Mago[" + tipo + " - " + aura +"]";
    }

    public boolean subisci(int d) {
        vita-=d;
        if(vita<0) return true;
        return false;
    }
}
