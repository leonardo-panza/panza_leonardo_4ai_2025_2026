public class Lavoratore extends Persona{

    private float stipendioMensile;

    public Lavoratore(String n, String c, int e, float s){
        super(n, c, e);
        stipendioMensile = s;
    }

    public float getStipendioMensile() {
        return stipendioMensile;
    }

    @Override
    public String toString() {
        return super.toString() + "; Stipendio: €" + stipendioMensile;
    }
}
