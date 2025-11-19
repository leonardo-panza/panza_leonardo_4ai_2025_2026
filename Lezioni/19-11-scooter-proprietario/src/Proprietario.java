import java.time.LocalDate;

public class Proprietario {

    private String CF;
    private String nome;
    private String residenza;
    private LocalDate nascita;

    public Proprietario(String cod, String n, String v, LocalDate d){
        setCF(cod);
        setNome(n);
        setResidenza(v);
        setNascita(d);
    }

    public Proprietario(){
        setCF("XXXXXX00X00X000X");
        setNome("Default");
        setResidenza("Default");
        setNascita(LocalDate.parse("1900-01-01"));
    }

    // --- GET ---
    public String getCF() {
        return CF;
    }

    public String getNome() {
        return nome;
    }

    public String getResidenza() {
        return residenza;
    }

    public LocalDate getNascita() {
        return nascita;
    }

    public void setCF(String cod) {
        cod = cod.toUpperCase();
        if(!cod.matches("[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]")) throw new IllegalArgumentException("Codice fiscale inaccettabile");
        CF = cod;
    }

    public void setNome(String n) {
        n = n.trim();
        if(n.length()<2 || n.length()>40) throw new IllegalArgumentException("Lunghezza nome inaccettabile");
        nome = n;
    }

    public void setResidenza(String v) {
        v = v.trim();
        if(v.length()<5 || v.length()>50) throw new IllegalArgumentException("Residenza inaccettabile");
        residenza = v;
    }

    public void setNascita(LocalDate d) {
        LocalDate dataMaggiore = LocalDate.now().plusYears(-18);

        if(d.isAfter(dataMaggiore)) throw new IllegalArgumentException("Devi essere maggiorenne per possedere una moto!");
        if(d.isBefore(LocalDate.parse("1900-01-01"))) throw new IllegalArgumentException("Data inaccettabile");

        nascita = d;
    }

    public String toString(){
        return nome + " nato il " + nascita + ". Codice fiscale: " + CF;
    }

}
