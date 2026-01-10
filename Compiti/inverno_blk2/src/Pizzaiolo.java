import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pizzaiolo {

    private Queue<Tavolo> ordini;

    public Pizzaiolo(){
        ordini = new LinkedList<>();
    }

    public Tavolo preparaOrdine(){
        return ordini.remove();
    }

    public void aggiungiOrdine(Tavolo t){
        ordini.add(t);
    }

}
