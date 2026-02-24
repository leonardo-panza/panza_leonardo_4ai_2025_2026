import java.time.LocalDate;

public class Bambino extends Persona{

    private LocalDate dataNascita;

    public Bambino(String n, String c, int e, LocalDate d){
        super(n,c,e);
        dataNascita = d;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }
}
