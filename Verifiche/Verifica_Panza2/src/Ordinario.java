public class Ordinario extends Frutto{

    private String varieta;
    private float prezzoKg;

    public Ordinario(String n, boolean r, String v, float p){
        super(n, r);
        setVarieta(v);
        setPrezzoKg(p);
    }

    public void setVarieta(String varieta) {
        varieta = varieta.toLowerCase().strip();
        if(!varieta.matches("^[a-z]{3,15}$")) throw new IllegalArgumentException("Varietà inaccettabile");
        this.varieta = varieta;
    }

    public void setPrezzoKg(float prezzoKg) {
        if(prezzoKg<0) throw new IllegalArgumentException("Prezzo inaccettabile");
        this.prezzoKg = prezzoKg;
    }

    @Override
    public float scontoMax() {
        if(prezzoKg<10) return (float) (prezzoKg * 0.01 + 1.05);
        return 1.35F;
    }

    @Override
    public String toString() {
        return super.toString() + "|varietà: " + varieta + ". €/kg: " + prezzoKg;
    }
}
