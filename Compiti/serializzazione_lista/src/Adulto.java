public class Adulto extends Persona {
    private float salarioMensile;

    public Adulto(String nome, int eta, float salarioMensile) {
        super(nome, eta);
        this.salarioMensile = salarioMensile;
    }

    public float getSalarioMensile() { return salarioMensile; }

    @Override
    public String toString() {
        return "Adulto{nome='" + getNome() + "', eta=" + getEta() +
                ", salarioMensile=" + salarioMensile + "}";
    }
}
