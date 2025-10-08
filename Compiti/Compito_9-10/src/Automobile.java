import java.time.LocalDate;

public class Automobile {

    private String marca;
    private String modello;
    private int anno;
    private float km;

    public Automobile () {
        marca = "Lancia";
        modello = "Stratos";
        km = 1207.4F;
        anno = 1974;
    }

    public void stampaDettagli(){
        IO.println("Marca: " + marca);
        IO.println("Modello: " + modello);
        IO.println("Anno: " + anno);
        IO.println("Chilomeraggio: " + km  +"km");
    }

    public void aggiornaChilometraggio(float chilo){
        if(chilo<km) throw new IllegalArgumentException("I chilometri non possono diminuire");
        km = chilo;
    }

    //Inseriendo l'età dal parametro...
    public int calcolaEta(int anno){
        LocalDate data = LocalDate.now();
        int anno_corrente = data.getYear();

        if(anno>anno_corrente) throw new IllegalArgumentException("L'anno deve essere minore di " + anno_corrente);

        int eta = anno_corrente - anno;
        return eta;
    }

    //Utilizzando l'età prestabilita
    public int calcolaEta(){
        LocalDate data = LocalDate.now();
        int eta;

        eta = data.getYear() - anno;
        return eta;
    }


}
