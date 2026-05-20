import java.time.LocalDate;

public class UtenteGold extends Utente{

    public UtenteGold(String n, String c, LocalDate d) {
        super(n, c, d);
    }

    @Override
    public void iscrizioneCorso(Corsi c) throws Exception {
        if(corsi.contains(c)) throw new IllegalArgumentException("Utente già iscritto al corso");
        corsi.add(c);
    }



}
