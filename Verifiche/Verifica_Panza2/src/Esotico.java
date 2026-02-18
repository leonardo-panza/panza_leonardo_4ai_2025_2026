public class Esotico extends Frutto{

    private String provenienza;
    private float prezzoAlPezzo;

    public Esotico(String n, boolean r, String p, float prz){
        super(n,r);
        setPrezzoAlPezzo(prz);
        setProvenienza(p);
    }

    public void setProvenienza(String provenienza) {
        provenienza = provenienza.toLowerCase().strip();
        if(!provenienza.matches("^[a-z ']+")) throw new IllegalArgumentException("Provenienza inaccettabile");
        this.provenienza = provenienza;
    }

    public void setPrezzoAlPezzo(float prezzoAlPezzo) {
        if(prezzoAlPezzo<0) throw new IllegalArgumentException("Prezzo inaccettabile");
        this.prezzoAlPezzo = prezzoAlPezzo;
    }

    @Override
    public float scontoMax() {
        float sconto = 0;
        switch (provenienza){
            case "brasile": sconto += 0.90F; break;
            case "argentina": sconto+= 0.34F;break;
            case "paraguay": sconto+= 0.18F;break;
            case "chile": sconto+= 0.25F;break;
            case "colombia": sconto+= 0.16F;break;
            default: sconto+= 0.08F;
        }

        if(getRischioAllergia()) return (float) (sconto+0.11);
        return sconto;
    }

    @Override
    public String toString() {
        return super.toString() + "|provenienza: " + provenienza + ". €/pz: " + prezzoAlPezzo;
    }
}
