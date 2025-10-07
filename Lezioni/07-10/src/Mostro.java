public class Mostro {

    //Attributi e caratteristiche
    private int punti_vita;
    private String nome;
    private String colore;

    public Mostro(){
        punti_vita = 1000;
        nome = "Bowser";
        colore = "giallo";
    }

    public void cambiaNome(String nome){
        this.nome = nome;
    }

    public String mostraNome(){
        return nome;
    }

    public int mostraVita(){
        return punti_vita;
    }

}
