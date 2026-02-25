import java.time.LocalDate;

public class Bambino extends Persona{

    private LocalDate dataNascita;

    public Bambino(String n, String c, int e, LocalDate d){
        super(n,c,e);
        setDataNascita(d);
    }

    public void setDataNascita(LocalDate dataNascita) {
        if(dataNascita.isBefore(LocalDate.parse("1900-01-01")) || dataNascita.isAfter(LocalDate.now())) throw new IllegalArgumentException("Data inaccettabile");
        this.dataNascita = dataNascita;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    @Override
    public String toString() {
        return "Bambino: " + super.getNome() + " " + super.getCognome() + ": " + super.getEta() + "; Nascita: " + dataNascita;
    }
}
