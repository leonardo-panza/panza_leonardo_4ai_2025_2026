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
        id = "ZZZ" + numID;
        numID++;
        setDscr("Descrizione di default");
        setData(LocalDate.now());
        setPrezzo(0);
        setType("decorativo");
    }

    private void setId(String id) { //Ho sistemato anche la modifica del main
        if(!checkID(id)) throw new IllegalArgumentException("ID non accettabile");
        this.id = id;
        arch_id.add(id);
    }

    public void setDscr(String descr){
        if(!checkDescr(descr)) throw new IllegalArgumentException("Descrizione inaccettabile!");
        dscr = descr;
    }

    public void setType(String tipo){
        if(!checkType(tipo)) throw new IllegalArgumentException("Tipo inaccettabile!");
        type = tipo;
    }

    public void setPrezzo(double prz){
        if(!checkPrezzo(prz)) throw new IllegalArgumentException("Prezzo inaccettabile");
        prezzo = prz;
    }

    public void setData(LocalDate dt){
        if(!checkData(dt)) throw new IllegalArgumentException("Data inaccettabile");
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

    public static boolean checkID(String id){
        id = id.toUpperCase().trim();
        if(!id.matches("^[A-Z]{3}[0-9]{3}$") || id.contains("ZZZ") || arch_id.contains(id)) return false;
        return true;
    }

    public static boolean checkDescr(String descr){
        descr = descr.trim();
        if(descr.length()<5 || descr.length()>45) return false;
        return true;
    }

    public static boolean checkType(String tipo){
        if(!tipo.equals("elettronico") && !tipo.equals("decorativo") && !tipo.equals("ecofriendly") & !tipo.equals("ironico")) return false;
        return true;
    }

    public static boolean checkPrezzo(double prz){
        if(prz<0) return false;
        return true;
    }

    public static boolean checkData(LocalDate dt){
        if(dt.isAfter(LocalDate.now()) || dt.isBefore(LocalDate.parse("2000-01-01"))) return false;
        return true;
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
