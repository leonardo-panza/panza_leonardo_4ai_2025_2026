import java.time.LocalDate;

public class Scooter {

    private String targa;
    private int km;
    private String modello;
    private LocalDate dataAcquisto;

    public String getTarga(){
        return targa;
    }

    //Formato X11111 (lettera iniziale, resto è uguale
    //Altro esempio XXX2XX

    public void setTarga(String t){
        t = t.toUpperCase();
        if(!t.matches("[A-Z][A-Z0-9]{5}")) throw new IllegalArgumentException("Formato targa inaccettabile");
        IO.print("fatto");
        targa = t;
    }

    public int getKm(){
        return km;
    }

    public void setKm(int k){

    }

    public String getModello(){
        return modello;
    }

    public void setModello(String m){

    }

    public LocalDate getDataAcq(){
        return dataAcquisto;
    }

    public void setDataAcq(LocalDate d){

    }

    public Scooter(){
        targa = "XXXXXX";
        km = 0;
        modello = "Default";
        dataAcquisto = LocalDate.now();
    }


    public Scooter(String t, int k, String m, LocalDate d){
        targa = t;
        km = k;
        modello = m;
        dataAcquisto = d;
    }



}
