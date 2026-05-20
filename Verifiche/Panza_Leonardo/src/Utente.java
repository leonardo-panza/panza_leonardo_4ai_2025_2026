import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Utente {

    private static int numero = 0;

    private int numeroTessera;
    private String nome;
    private String cognome;
    private LocalDate dataIscrizione;
    protected List<Corsi> corsi = new ArrayList();

    public Utente(String n, String c, LocalDate d){

        numeroTessera = numero++;
        setNome(n);
        setCognome(c);
        setDataIscrizione(d);

    }

    public void setNome(String n) {
        n = n.strip().toLowerCase();
        if(!(n.matches("[a-z]+") && n.length()<20)) throw new IllegalArgumentException("Nome inaccettabile");
        this.nome = n;
    }

    public void setCognome(String c) {
        c = c.strip().toLowerCase();
        if(!(c.matches("[a-z ]+") && c.length()<20)) throw new IllegalArgumentException("Cognome inaccettabile");
        this.cognome = c;
    }

    public void setDataIscrizione(LocalDate d) {
        if(d.isBefore(LocalDate.parse("2000-01-01")) || d.isAfter(LocalDate.now())) throw new IllegalArgumentException("Data inaccettabile");
        this.dataIscrizione = d;
    }

    public void iscrizioneCorso(Corsi c) throws Exception {
        if(!corsi.isEmpty()) throw new Exception("Utente standard: hai diritto solo ad un corso");
        corsi.add(c);
    }

    public int getNumeroTessera() {
        return numeroTessera;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public List<Corsi> getCorsi() {
        return corsi;
    }

    public LocalDate getDataIscrizione() {
        return dataIscrizione;
    }

    public String toString(){

        String s = "Nome: " + nome + "\nCognome: " + cognome + "" +
                "\nIscrizione: " + dataIscrizione + "" +
                "\nCorsi: ";

        for (int i = 0; i < corsi.size(); i++) {
            if(i<(corsi.size()-1)){
                s += corsi.get(i) + ", ";
            }else{
                s+= corsi.get(i);
            }
        }

        return s;

    }

    public LocalDate getScadenza(){
        LocalDate scadenza = dataIscrizione.plusYears(1);
        return scadenza;
    }

    public boolean isScaduto(){
        if(this.getScadenza().isBefore(LocalDate.now())) return true;
        return false;
    }



}
