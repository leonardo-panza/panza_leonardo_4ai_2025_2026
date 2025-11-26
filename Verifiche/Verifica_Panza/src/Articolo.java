import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

public class Articolo {

    private static List<String> arch_id = new ArrayList<String>();
    private static int numID = 100;
    private String id;
    private String dscr;
    private String type;
    private LocalDate data;
    private double prezzo;

    public Articolo(String id, String descr, String tipo, double prz, LocalDate dt){
        setId(id);
        setData(dt);
        setDscr(descr);
        setPrezzo(prz);
        setType(tipo);

    }

    public Articolo(){
        setId("ZZZ" + numID);
        numID++;
        setDscr("Descrizione di default");
        setData(LocalDate.now());
        setPrezzo(0);
        setType("decorativo");
    }

    public void setId(String id) {
        id = id.toUpperCase().trim();
        if(!id.matches("^[A-Z]{3}[0-9]{3}$")) throw new IllegalArgumentException("ID non acettabile. Deve avere il formato XXX000");
        if(arch_id.contains(id)) throw new IllegalArgumentException("ID già utilizzato!");
        this.id = id;
        arch_id.add(id);
    }

    public void setDscr(String descr){
        descr = descr.trim();
        if(descr.length()<5 || descr.length()>45) throw new IllegalArgumentException("Descrizione troppo lunga/corta");
        dscr = descr;
    }

    public void setType(String tipo){
        if(!tipo.equals("elettronico") && !tipo.equals("decorativo") && !tipo.equals("ecofriendly") & !tipo.equals("ironico")) throw new IllegalArgumentException("Tipo non accettabile");
        type = tipo;
    }

    public void setPrezzo(double prz){
        if(prz<0) throw new IllegalArgumentException("Prezzo non può essere negativo");
        prezzo = prz;
    }

    public void setData(LocalDate dt){
        if(dt.isAfter(LocalDate.now()) || dt.isBefore(LocalDate.parse("2000-01-01"))) throw new IllegalArgumentException("Data inaccettabile");
        data = dt;
    }

    public String getId() {
        return id;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public String getDscr() {
        return dscr;
    }

    public String getType() {
        return type;
    }

    public LocalDate getData() {
        return data;
    }

    public List<String> getArchivio(){
        return arch_id;
    }

    public double scontoApplicabile(){
        double sconto = 0;
        int giorni = LocalDate.now().compareTo(data)*365; //Mi servono i giorni, quindi moltiplico per 365

        if(!type.equals("elettronico") && !type.equals("decorativo") && prezzo>=15){
            sconto = 0.8 + ((double) giorni /1000) * prezzo; //Formula
        }else{
            throw new IllegalArgumentException("Sconto non applicabile");
        }
        return sconto;
    }

    public String toString(){
        return "Articolo: {ID: " + id + "| Tipo: " + type + "| Prezzo: " + prezzo + "| Data: " + data + "}\nDescrizione: " + dscr;
    }

}
