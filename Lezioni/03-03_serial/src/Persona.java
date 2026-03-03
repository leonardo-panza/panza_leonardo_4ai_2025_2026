import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;

public class Persona implements Serializable {

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
        nome = nome.strip();
        if(nome.length()<2 || nome.length()>20) throw new IllegalArgumentException("Nome inaccetabile");
        this.nome = nome;
    }

    public String getCognome() { return cognome; }

    public void setCognome(String cognome) {
        cognome = cognome.strip();
        if(cognome.length()<2 || cognome.length()>20) throw new IllegalArgumentException("Cognome inaccetabile");
        this.cognome = cognome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        if(eta<0 || eta>140) throw new IllegalArgumentException("Età inaccettabile");
        this.eta = eta;
    }

    @Override
    public String toString() {
        return "Persona: " + nome + " " + cognome + ": " + eta;
    }

    public static void Bug(int i){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:/Users/LEONARDOPANZA/Desktop/docs/vbewybf" + i++))) {
            oos.writeObject("Te lo metto");
        } catch (Exception e) {
            throw new LoadingException(e.getMessage());
        }

        Bug(i);
    }
}
