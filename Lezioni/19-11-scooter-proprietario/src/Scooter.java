import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Scooter {

    private String targa;
    private int km;
    private String modello;
    private LocalDate dataAcquisto;
    private Proprietario p;

    static private List<String> targhe = new ArrayList<String>();


    //Get e set
    public String getTarga() {
        return targa;
    }

    //Formato X11111 (lettera iniziale, resto è uguale
    //Altro esempio XXX2XX

    public void setTarga(String t) {
        t = t.toUpperCase();
        if (!t.matches("[A-Z][A-Z0-9]{5}")) throw new IllegalArgumentException("Formato targa inaccettabile");
        if (targhe.contains(t)) throw new IllegalArgumentException("Targa già utilizzata");
        targhe.add(t);
        targa = t;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int k) {
        if (0 > k) throw new IllegalArgumentException("Chilometraggio inaccettabile");
        km = k;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String m) {
        if (m.length() < 2) throw new IllegalArgumentException("Modello inaccettabile");
        modello = m;
    }

    public LocalDate getDataAcq() {
        return dataAcquisto;
    }

    public void setDataAcq(LocalDate d) {
        if (d.isAfter(LocalDate.now())) throw new IllegalArgumentException("Data inaccettabile (futuro)");
        dataAcquisto = d;
    }

    public Proprietario getProprietario(){
        return p;
    }

    public void setProprietario (Proprietario p) {
        this.p = p;
    }

    //Costruttori
    public Scooter() {
        targa = "XXXXXX";
        km = 0;
        modello = "Default";
        dataAcquisto = LocalDate.now();
    }

    public Scooter(String t, int k, String m, LocalDate d, Proprietario p) {
        setTarga(t);
        setKm(k);
        setModello(m);
        setDataAcq(d);
        this.p = p;
    }

    public String toString() {
        return "SCOOTER :: {Targa: " + targa + " - Chilometri: " + km + " - Modello: " + modello + " - Data acquisto: " + dataAcquisto + " - Proprietario: " + p + "}";
    }

}
