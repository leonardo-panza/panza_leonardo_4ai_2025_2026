import java.time.LocalDate;

public class Automobile {

    private String targa;
    private Colore colore;
    private float km;
    private LocalDate primaImm;
    private String modello;

    public Automobile(String targa, String modello, String colore, LocalDate primaImm, float km){
        setTarga(targa);
        setModello(modello);
        setColore(colore);
        setPrimaImm(primaImm);
        setKm(km);
    }

    public void setColore(String colore) {
        colore = colore.toLowerCase();
        switch (colore){
            case "rosso": this.colore = Colore.ROSSO; break;
            case "bianco": this.colore = Colore.BIANCO; break;
            case "nero": this.colore = Colore.NERO; break;
            case "giallo": this.colore = Colore.GIALLO; break;
            default: throw new IllegalArgumentException("Colore non accettabile");
        }
    }

    public void setKm(float km) {
        //Dieci milioni (record del mondo è 5.2mln)
        if(km<0 || km>10000000) throw new IllegalArgumentException("Chilometraggio inaccettabile");
        this.km = km;
    }

    public void setModello(String modello) {
        if(modello.length()<2 || modello.length()>30) throw new IllegalArgumentException("Modello inaccettabile");
        this.modello = modello;
    }

    public void setPrimaImm(LocalDate primaImm) {
        if(primaImm.isAfter(LocalDate.now()) || primaImm.isBefore(LocalDate.parse("1886-01-29"))) throw new IllegalArgumentException("Data inaccettabile");
        this.primaImm = primaImm;
    }

    public void setTarga(String targa) {
        targa = targa.toUpperCase();
        if(!targa.matches("[A-Z]{2}[0-9]{3}[A-Z]{2}")) throw new IllegalArgumentException("targa inaccettabile");
        this.targa = targa;
    }

    public String getTarga() {
        return targa;
    }

    public Colore getColore() {
        return colore;
    }

    public float getKm() {
        return km;
    }

    public LocalDate getPrimaImm() {
        return primaImm;
    }

    public String getModello() {
        return modello;
    }

}
