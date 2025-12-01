import java.util.NavigableMap;

public class Giocatore {

    private String nome;
    private boolean capitano;
    private int goal;
    private int goalNazionale;

    public Giocatore(){
        nome = "Giocatore";
        capitano = false;
        goal = 0;
        goalNazionale = 0;
    }

    public Giocatore(String n, int g, int gn, boolean c){
        setNome(n);
        setCapitano(c);
        setGoalNazionale(gn);
        setGoal(g);
    }

    public void setNome(String n){
        if(n.length()<2 || !n.matches("[A-Za-z ]+")) throw new IllegalArgumentException("Nome inaccettabile");
        nome = n;
    }
    public String getNome(){
        return nome;
    }

    public void setCapitano(boolean n){
        capitano = n;
    }
    public boolean getCapitano(){
        return capitano;
    }

    public void setGoal(int n){
        if(n<0 || n>3000) throw new IllegalArgumentException("Numero inaccettabile");
        goal = n;
    }
    public int getGoal(){
        return goal;
    }

    public void setGoalNazionale(int n){
        if(n<0 || n>3000) throw new IllegalArgumentException("Numero inaccettabile");
        goalNazionale = n;
    }
    public int getGoalNazionale(){
        return goalNazionale;
    }

    public int calcolaGoalTotali(){
        return goal + goalNazionale;
    }

    public String toString(){
        return "Giocatore {Nome: " + nome + "; Goal: " + goal + "; Goal in nazionale: " + goalNazionale + "; Capitano: " + capitano + "}";
    }

}
