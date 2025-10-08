import java.util.ArrayList;

public class Studente {

    private static ArrayList<String> studenti = new ArrayList<>();
    private String nome;
    private String cognome;
    private String matricola;
    private int annoIscrizione;
    private ArrayList<Float> voti = new ArrayList<>();

    public Studente(){
        nome = "Ernesto";
        cognome = "Alberghieri";
        studenti.add(nome);
        annoIscrizione = 2021;
        matricola = "Stud" + studenti.size() + annoIscrizione;
        voti.add(6.5F);
        voti.add(7F);
        voti.add(3.5F);
        voti.add(3F);
        voti.add(5.5F);
    }

    public void aggiungiVoto(float voto){
        if(voto<2 || voto>10) throw new IllegalArgumentException("Voto non accettabile");
        voti.add(voto);
    }

    public float calcolaMedia(){
        if(voti.size()<1) throw new IllegalArgumentException("Lista dei voti vuota");
        float somma = 0;
        for(int i = 0; i<voti.size(); i++){
            somma += voti.get(i);
        }

        float media = somma/voti.size();
        return media;
    }

    public void stampaDettagli(){
        IO.println("Nome: " + nome);
        IO.println("Cognome: " + cognome);
        IO.println("Anno iscrizione: " + annoIscrizione);
        IO.println("Matricola: " + matricola);
        IO.println("Media: " + calcolaMedia());
    }



}
