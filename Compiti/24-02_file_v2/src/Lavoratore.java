public class Lavoratore extends Persona{

    private float stipendioMensile;

    public Lavoratore(String n, String c, int e, float s){
        super(n, c, e);
        stipendioMensile = s;
    }

    public void setStipendioMensile(float stipendioMensile) {
        if(stipendioMensile<=0 || stipendioMensile>100000000) throw new IllegalArgumentException("Stipendio inaccettabile");
        this.stipendioMensile = stipendioMensile;
    }

    public float getStipendioMensile() {
        return stipendioMensile;
    }

    @Override
    public String toString() {

        return "Lavoratore: " + super.getNome() + " " + super.getCognome() + ": " + super.getEta() + "; Stipendio: €" + stipendioMensile;
    }
}
