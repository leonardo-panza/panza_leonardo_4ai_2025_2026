import java.util.ArrayList;
import java.util.List;

public class GestoreIscritti {

    private List<Utente> iscritti;

    public GestoreIscritti(){
        iscritti = new ArrayList<>();
    }

    public void iscrivi(Utente u){
        iscritti.add(u);
    }

    //1
    public String cercaIscritto(int nTessera){

        if(nTessera<1) throw new IllegalArgumentException("Numero tessera inaccettabile");

        for(Utente u: iscritti){
            if(nTessera == u.getNumeroTessera()) return u.toString();
        }

        throw new IllegalArgumentException("Utente non trovato");

    }

    //2
    public String visualizzaUtentiScaduti(){

        List<Utente> scaduti = new ArrayList<>();

        for(Utente u : iscritti){
            if(u.isScaduto()) scaduti.add(u);
        }

        String s = "";

        for(Utente u:scaduti){
            s += u.getNome() + " " + u.getCognome() + ";\n";
        }

        return s;

    }

    //3
//     public void promuovi(Utente u){
//
//        UtenteGold promosso = new UtenteGold(u.getNome(), u.getCognome(), u.getDataIscrizione());
//
//     }

    //5
    public String visualizzaNumeroPartecipanti(){

        String s = "";
        int i;

        for(Corsi c: Corsi.values()){
            s += c + ": ";
            i = 0;

            for(Utente u : iscritti){
                if(u.getCorsi().contains(c)) i++;
            }

            s+=i + "\n";
        }

        return s;
    }

    //5
    public String visualizzaAccessi(){

        //int nAccessiPalestra = Palestra.getNaccessi(); - metodo non esistente, simulo 10 accessi per utente
        //int nAccessiSauna = Sauna.getNaccessi(); - metodo non esistente, simulo 5 accessi per utente (solo gold)

        int nAccessiPalestra = iscritti.size()*10;

        int nGold = 0;
        for(Utente u : iscritti){
            if(u instanceof UtenteGold) nGold++;
        }

        int nAccessiSauna = nGold*5;

        String s = "Accessi in palestra: " + nAccessiPalestra + "\n" +
                "Accessi alla sauna: " + nAccessiSauna;

        return s;

    }

}
