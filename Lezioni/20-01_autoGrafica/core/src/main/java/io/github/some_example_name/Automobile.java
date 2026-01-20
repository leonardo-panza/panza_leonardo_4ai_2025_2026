package io.github.some_example_name;
import java.time.LocalDate;
import java.util.List;

public class Automobile {

    private static List<String> targhe;
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

    public Automobile(String targa, String modello, String colore, LocalDate primaImm){
        setTarga(targa);
        setModello(modello);
        setColore(colore);
        setPrimaImm(primaImm);
        setKm(0);
    }
    public Automobile(String targa, String modello, String colore){
        setTarga(targa);
        setModello(modello);
        setColore(colore);
        setPrimaImm(LocalDate.now());
        setKm(0);
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
        if(targhe.contains(targa)) throw new IllegalArgumentException("Targa già presente");
        this.targa = targa;
        targhe.add(targa);
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
