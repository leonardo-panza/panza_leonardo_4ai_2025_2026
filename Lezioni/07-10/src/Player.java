import java.util.ArrayList;

public class Player {

    //ATTRIBUTI
    private String nome;
    private String nickname;
    private String id; //Fatto in base ai dati dell'utente?

    //Creo la lista solamente quando la classe è chiamata la primissima volta (static)
    //Così ho una lista per tutti i player
    private static ArrayList<String> lista = new ArrayList<String>();

    //AZIONI O METODI

    //COSTRUTTORI
    public Player(){
        nome = "Super Mario";
        nickname = "Player";
        id="AAA000";
    }

    public Player(String nome){
        this.nome = nome;
        this.nickname = "Player";
        id="AAA000";
    }

    //Se devo restituire che qualcosa è andato storto, restituisco un eccezione
    //MAI usare IO.println() e IO.readln() nelle classi. Se non ho un terminale/console?
    public void cambiaNome(String n){

        //Quando sollevo un eccezione la funzione smette di eseguirsi
        if(n.length() < 4) throw new IllegalArgumentException("The name must be at least 4 letters");
        if(!n.matches("[a-zA-Z]+")) throw new IllegalArgumentException("Invalid name, the name must contain only letters");



        //Non serve un else perché nel caso dell'eccezione il programma si blocca
        nome = n;

    }

    public void setId(String id){

        if(lista.contains(id)) throw new IllegalArgumentException("Id non disponibile");

        lista.add(id);
        this.id = id;
    }

    public String ritornaId(){
        return id;
    }

    public String mostraNome(){
        return nome;
    }

    public String toString(){
        return "Player(" + id + "):" + nickname + " [" + nome + "]";
    }


}
