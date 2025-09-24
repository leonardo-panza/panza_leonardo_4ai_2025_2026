//Iscrizioni di ping pong
//Importo le librerie utili (per input e try-catch)

//Queste servono al BufferReader per gli input
import java.io.BufferedReader;
import java.io.InputStreamReader;

//Questa serve per per trovare le eccezioni nel try-catch
import java.io.IOException;

//a = array | s = size (conta)
public static void stampaTutto(String[] a, int s){
    IO.println("----- Archivio iscritti ----- " + s + " iscritti al torneo");
    if (s == 0){
        IO.println("Non c'è nessuno al momento!");
    }else{
        for(int i = 0; i<s; i++){
            IO.println((i+1) + " - " + a[i]);
        }
    }
}


public static int inserisci(String[] a, int s) throws IOException {
    IO.println("----- Iscriviti al torneo ----- ");
    if(s==10){
        IO.println("🤘 Impossibile iscriversi: archivio pieno!");
    }else{
        int err = 1;
        String nome = "";
        while(err == 1){
            err = 0;
            IO.print("Nome iscritto: ");
            nome = br.readLine();
            String nome_acc = "";
            for(int i = 0; i<nome.length(); i++){
                char c = nome.charAt(i);
                if(c != ' '){
                    nome_acc = nome_acc + c;
                }
            }
            if(nome_acc == ""){
                IO.println("Il nome non può essere vuoto");
                err = 1;
            }
        }
        String nome_finale = "";
        for(int i = 0; i<nome.length(); i++){
            char c = nome.charAt(i);
            if (c!=' '){
                nome_finale = nome_finale + c;
            }
        }

        a[s] = nome_finale;
        s++;

    }

    return s;

}

public static int elimina(String[] a, int s)throws IOException{
    IO.println("----- Annulla iscrizione ----- ");
    if(s!=0) {
        IO.print("Iscritto da cancellare: ");
        String iscrizione_elimina = br.readLine();
        int err = 1;
        int pos = 0;
        while(err == 1) {
            err = 0;
            try {
                pos = Integer.parseInt(iscrizione_elimina);
                if(pos>s ||pos==0){
                    IO.println("Fuori dal raggio! Gli iscritti eliminabili hanno numeri dall'1 al " + s);
                    err = 1;
                }
            }catch(Exception e){
                IO.println("Inserisci un numero intero tra 1 e  " + s + "!");
                err = 1;
            }
        }

        //diminuisco pk l'utente prende il numero dall'elenco, che è di 1 più grande rispetto al valore reale
        pos--;

        //la posizione scelta prende il valore dell'ultimo elemento, per non dover spostare tutti gli elementi (SOLO SE L'ELENCO NON DEVE ESSERE ORDINATO)
        a[pos] = a[s - 1];

        //tolgo l'ultima cella visto che ho trasferito il valore in quella eliminata
        a[s--] = null;

        //ritorno l'indice con 1 in meno perché ho eliminato un elemento
        return s--;
    }else{
        IO.println("Nessuno in lista!");
        return s;
    }
}



//Uso il BufferReader per poter prendere input dalla console
static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//throws IOException se devo usare un try-catch
void main() throws IOException {

    String[] iscritti = new String[10]; //Elenco iscritti
    int conta = 3;
    iscritti[0] = "Verstappen";
    iscritti[1] = "Leclerc";
    iscritti[2] = "Piastri";

    String scelta = "";
    do {
        IO.println("----------------------");
        IO.println("-------- Menù --------");
        IO.println("1. Inserisci un iscritto");
        IO.println("2. Visualizza tutti gli iscritti");
        IO.println("3. Cancella iscrizione");
        IO.println("Inserisci 'q' per uscire dal programma");
        IO.print("Cosa vuoi fare? ");
        scelta = br.readLine();
        switch (scelta) {
            case "1": conta = inserisci(iscritti, conta); break;
            case "2": stampaTutto(iscritti, conta); break;
            case "3": conta = elimina(iscritti, conta); break;
            case "q": IO.println("Bye bye"); break;
            default: IO.println("Scelta inesistente");
        }
    }while(scelta != "q");


}
