public class Classe {

    private static Classe istanza = null;
    private String dati;

    public Classe(String dati){

        this.dati = dati;

    }

    public static Classe getInstance(String dati){

        if(istanza == null){
            istanza = new Classe(dati);
        }

        return istanza;

    }

    public String toString() {
        return "Data: " + dati;
    }

    public void setDati(String dati) {
        this.dati = dati;
    }
}
