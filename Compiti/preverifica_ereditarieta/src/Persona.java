public abstract class Persona {

    private String nome;
    private String cognome;
    private int eta;

    public Persona(String n, String c, int e){
        setNome(n);
        setCognome(c);
        setEta(e);
    }

    public void setNome(String nome) {
        nome = nome.strip();
        if(!nome.matches("^[A-Z][a-z]{2,30}$")) throw new IllegalArgumentException("Nome inaccettaile");
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        cognome = cognome.strip();
        if(!cognome.matches("^[A-Z][a-z]{2,30}$")) throw new IllegalArgumentException("Cognome inaccettaile");
        this.cognome = cognome;
    }

    public void setEta(int eta) {
        if(eta<0 || eta>150) throw new IllegalArgumentException("Eta inaccettabile");
        this.eta = eta;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getEta() {
        return eta;
    }

    @Override
    public String toString() {
        return nome + " " + cognome + ": " + eta + " anni";
    }

    public abstract float calcolaStipendio();
}
