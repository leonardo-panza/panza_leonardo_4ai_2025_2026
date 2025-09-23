import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    //static rende una cosa globale
    //rendo l'array globale così lo uso dappertutto
    static public String [] iscritti = new String[10];

    public static void stampaIscritti(String[] a, int conta){

        System.out.println("--- Archivio iscritti al campionato --- " + conta);

        if(conta == 0){

            System.out.println("Al momento non ci sono iscritti!");

        }else{

            for (int i = 0; i < conta; i++) {
                System.out.println((i + 1) + " - " + a[i]);
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int quanti = 0;

        iscritti[quanti] = "Leonardo Viganò";
        quanti++;

        iscritti[quanti] = "Coumba Ba";
        quanti++;

        iscritti[quanti] = "Leonardo Panza";
        quanti++;

        stampaIscritti(iscritti, quanti);
        String nome = "";
        int err = 1;
        while(err==1){
            err = 0;
            System.out.print("Iscerisci il nome e cognome: ");
            nome = br.readLine();
            System.out.println("'" + nome + "'");

            //problema
            if(nome==""){
                err=1;
                System.out.println("Nome non accettabile");
            }else{
                System.out.println("Benvenuto!\n");
            }
        }

        iscritti[quanti] = nome;
        quanti++;

        stampaIscritti(iscritti, quanti);
    }
}