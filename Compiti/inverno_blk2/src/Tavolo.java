import java.nio.channels.FileLockInterruptionException;
import java.util.List;

public class Tavolo {

    private static int tavoli = 1;
    private final int max_posti;
    private int numTavolo;
    private List<Pizza> ordine;

    public Tavolo(int max_posti){
        if(max_posti<1 || max_posti>8) throw new IllegalArgumentException("Numero di posti a sedere inaccettabile");
        this.max_posti=max_posti;
        numTavolo = tavoli++;
    }

    public void aggiungiOrdine(Pizza p){
        ordine.add(p);
    }

}
