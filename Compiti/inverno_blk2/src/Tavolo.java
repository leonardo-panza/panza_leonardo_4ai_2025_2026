import java.nio.channels.FileLockInterruptionException;
import java.util.ArrayList;
import java.util.List;

public class Tavolo {

    private static int tavoli = 1;
    private final int posti;
    private int numTavolo;
    private List<Pizza> ordine;
    private StatoTavolo stato;

    public Tavolo(int max_posti){
        if(max_posti<1 || max_posti>8) throw new IllegalArgumentException("Numero di posti a sedere inaccettabile");
        posti=max_posti;
        numTavolo = tavoli++;
        stato = StatoTavolo.NUOVO;
    }

    public void aggiungiOrdine(List<Pizza> p){
        ordine = p;
    }

    public List<Pizza> getOrdine(){
        List<Pizza> o = new ArrayList<>();
        for(Pizza p: ordine){
            o.add(p);
        }
        return ordine;
    }

    public void setStato(StatoTavolo s){
        stato = s;
    }

    public StatoTavolo getStato() {
        return stato;
    }

    public int getNumTavolo() {
        return numTavolo;
    }
}
