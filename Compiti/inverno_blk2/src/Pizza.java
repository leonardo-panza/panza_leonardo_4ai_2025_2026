import java.util.Locale;

public class Pizza {

    private String nome;
    private double costo;

    public Pizza(String n, double c){
        setNome(n);
        setCosto(c);
    }

    public void setNome(String nome) {
        nome = nome.toLowerCase();
        if(!nome.matches("[a-z ]{2,20}")) throw new IllegalArgumentException("Nome inaccettabile");
        this.nome = nome;
    }

    public void setCosto(double costo) {
        if(costo>30 || costo<0) throw new IllegalArgumentException("Costo inaccettabile");
        this.costo = costo;
    }

    public double getCosto() {
        return costo;
    }

    public String getNome() {
        return nome;
    }
}
