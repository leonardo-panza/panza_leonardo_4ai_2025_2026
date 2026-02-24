public class Persona {

    private String nome;
    private String cognome;
    private int eta;

    // Costruttore
    public Persona(String nome, String cognome, int eta) {
        setNome(nome);
        setCognome(cognome);
        setEta(eta);
    }

    // Getter e Setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    @Override
    public String toString() {
        return "P: " + nome + " " + cognome + ": " + eta;
    }
}
