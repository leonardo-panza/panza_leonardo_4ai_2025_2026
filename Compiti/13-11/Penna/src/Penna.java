public class Penna {

    private String marca;
    private boolean cancellabile;
    private double quantitaInchiostro;
    private String colore;

    public Penna(){
        marca = "Nessuna marca";
        cancellabile = false;
        quantitaInchiostro = 0;
        colore = "Nero";
    }

    public void setMarca(String m){
        if(m.length()<2) throw new IllegalArgumentException("Marca inaccettabile");
        marca = m;
    }
    public String getMarca(){
        return marca;
    }

    public void setCancellabile(boolean m){
        cancellabile = m;
    }
    public boolean getCancellabile(){
        return cancellabile;
    }

    public void setColore(String m){
        if(m.length()<3) throw new IllegalArgumentException("Colore inaccettabile");
        colore = m;
    }
    public String getColore(){
        return colore;
    }

    public void setQuantitaInchiostro(double m){
        if(m<0 || m>100) throw new IllegalArgumentException("La quantità deve essere tra 0 e 100%");
        quantitaInchiostro = m;
    }
    public double getQuantitaInchiostro(){
        return quantitaInchiostro;
    }


}
