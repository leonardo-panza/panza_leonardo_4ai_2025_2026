import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Biglietto {
    private static Queue<String> normali = new LinkedList<String>();
    private static Queue<String> prioritari = new LinkedList<String>();
    private static int nNorm = 0;
    private static int nPrio = 0;
    private String codice;
    private Priorita priorita;

    public Biglietto(Priorita priorita) {
        this.priorita = priorita;
        setCodice();
    }

    private void setCodice() {
        if (priorita == Priorita.NORMALE) {
            codice = "N" + nNorm++;
            normali.add(codice);
        } else {
            codice = "P" + nPrio++;
            prioritari.add(codice);
        }
    }

    public static String prossimoCliente(int chiamateNormali) {
        if ((chiamateNormali % 2 == 0 && !prioritari.isEmpty()) || normali.isEmpty()) {
            return (prioritari.isEmpty()) ? normali.poll() : prioritari.poll();
        } else {
            return normali.isEmpty() ? prioritari.poll() : normali.poll();
        }
    }

    public static ArrayList<String> clientiInAttesa() {
        ArrayList<String> lista = new ArrayList<>();
        lista.addAll(normali);
        lista.addAll(prioritari);
        return lista;
    }
}