
public static void aggiungi(List<String> elenco){

    if(elenco.size()<10) {
        boolean err = true;
        String scelta = "";
        while (err) {
            err = false;
            IO.print("Inserisci l'oggetto da aggiungere: ");
            scelta = IO.readln();

            if (scelta.length() < 3) {
                IO.println("Inserisci qualcosa di accettabile!");
                err = true;
            }
        }

        IO.println("Oggetto aggiunto!");
        elenco.add(scelta);
    }else{
        IO.println("Non puoi portare più di 10 oggetti!");
    }
}

public static void modifica(List<String> elenco){
    if(elenco.size()>0) {
        visualizza(elenco);

        String scelta = "";
        boolean err = true;
        int s = 0;

        //Fase selezione
        while (err) {
            err = false;
            IO.print("Scegli l'oggeto da rimuovere: ");
            scelta = IO.readln();

            try {
                s = Integer.parseInt(scelta);
                if (s < 1 || s > elenco.size()) {
                    IO.println("Iscerisci un valore nei campi!");
                    err = true;
                } else {
                    s--;
                }
            } catch (Exception e) {
                IO.println("Inserisci un numero!");
                err = true;
            }
        }

        String cambio = "";

        //Fase aggiunta
        err = true;
        while (err) {
            err = false;
            IO.print("Inserisci l'oggetto da cambiare: ");
            cambio = IO.readln();

            if (cambio.length() < 3) {
                IO.println("Inserisci qualcosa di accettabile!");
                err = true;
            }
        }
        elenco.set(s, cambio);

        IO.println("Oggetto modificato!");
    }else{
        IO.println("Nulla da modificare qui! Lo zaino è vuoto!");
    }
}

public static void elimina(List<String> elenco){

    if(elenco.size() > 0) {
        visualizza(elenco);

        String scelta = "";
        boolean err = true;
        int s = 0;

        while (err) {
            err = false;
            IO.print("Scegli l'oggeto da rimuovere: ");
            scelta = IO.readln();

            try {
                s = Integer.parseInt(scelta);
                if (s < 1 || s > elenco.size()) {
                    IO.println("Iscerisci un valore nei campi!");
                    err = true;
                } else {
                    s--;
                }
            } catch (Exception e) {
                IO.println("Inserisci un numero!");
                err = true;
            }
        }

        elenco.remove(s);
        IO.println("Oggetto rimosso!");
    }else{
        IO.println("Nulla da eliminare qui! Lo zaino è vuoto!");
    }
}

public static void visualizza(List<String> elenco){

    String elemento = "";
    for(int i = 0; i<elenco.size(); i++){
        elemento = elenco.get(i);
        IO.println((i + 1) + ". " + elemento);
    }

}

public static char menu(){

    IO.println("\n\n\n\n\n\n----- MENU -----");
    IO.println("1. Aggiungi");
    IO.println("2. Modifica");
    IO.println("3. Elimina");
    IO.println("4. Visualizza");
    IO.println("X. Esci");

    String scelta = "";

    boolean err = true;
    while(err ==  true){
        err = false;
        IO.print("Inserisci la tua scelta: ");
        scelta = IO.readln();
        if(!scelta.equals("X")){
            try{
                int s = Integer.parseInt(scelta);
                if(s<1 || s>4){
                    IO.println("Inserisci un numero che rientri nei campi!");
                    err = true;
                }
            }catch(Exception e) {
                IO.println("Inserisci un numero!!");
                err = true;
            }
        }else{
            return 'X';
        }
    }

    char risposta = scelta.charAt(0);
    return risposta;
}


void main() {

    List<String> elenco = new ArrayList<String>();

    elenco.add("Matita");
    elenco.add("Penna");
    elenco.add("Gomma");

    boolean running = true;
    while(running){
        char scelta = menu();
        switch(scelta){
            case 'X': running = false; break;
            case '1': aggiungi(elenco); break;
            case '2': modifica(elenco); break;
            case '3': elimina(elenco); break;
            case '4': visualizza(elenco); break;
        }
    }

    IO.println("Ciao ciao! 🫂🫡");

}
