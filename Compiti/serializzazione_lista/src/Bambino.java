public class Bambino extends Persona {
    private String scuolaFrequentata;

    public Bambino(String nome, int eta, String scuolaFrequentata) {
        super(nome, eta);
        this.scuolaFrequentata = scuolaFrequentata;
    }

    public String getScuolaFrequentata() { return scuolaFrequentata; }

    @Override
    public String toString() {
        return "Bambino{nome='" + getNome() + "', eta=" + getEta() +
                ", scuolaFrequentata='" + scuolaFrequentata + "'}";
    }
}
