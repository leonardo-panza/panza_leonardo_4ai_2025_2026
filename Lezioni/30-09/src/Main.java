//Esercizi con liste
//Rimuovi duplicati
//Gestisco in automatico l'accesso alla scuola
//Apro e chiudo il cancello in automatico con targhe autorizzati
//Inserisco, cancello le targhe
//Controllo le targhe
//No moto, bici
//targa.matches("^[A-Z]{2} [0-9]{3} [A-Z]{2}$")

public static String inserisciTarga(){
    String targa = "";
    boolean err = true;
    while(err) {
        err = false;
        IO.print("Inserisci la targa in formato XX111XX: ");
        String targa_input = IO.readln();

        //Rimuovo gli spazi
        for (int i = 0; i < targa_input.length(); i++) {
            char c = targa_input.charAt(i);

            if (c != ' ') {
                targa = targa + c;
            }
        }

        if (targa.matches("[A-Z]{2}[0-9]{3}[A-Z]{2}")) {
            IO.print("Targa accettata");
        } else {
            IO.print("Targa in formato non valido");
            err = true;
        }

    }

    return targa;
}


public static void aggiungiTarga(List<String> elenco){
    if (elenco.size()>=100) {
        String targa = "";
        boolean err = true;
        while(err){
            err = false;
            targa = inserisciTarga();
            boolean trovata = false;
            for (int i = 0; i<elenco.size(); i++){
                if (targa == elenco.get(i)) {
                    trovata=true;
                }
            }
            if (trovata){
                IO.println("Targa già inserita");
                err = true;
            }
        }
        elenco.add(targa);
        IO.println("Ho aggiunto la tua targa");
    }else{
        IO.print("Abbiamo raggiunto il numero massimo di targhe autorizzate");
    }
}

public static void eliminaTarga(List<String> elenco){

    if (elenco.size()>0) {
        String targa = inserisciTarga();
        boolean trovata = false;
        for (int i = 0; i < elenco.size(); i++){
            if (targa == elenco.get(i)) {
                trovata = true;
            }
        }
        if (trovata) {
            elenco.remove(targa);
            IO.println("Ho eliminato la tua targa");
        } else {
            IO.println("Non ho trovato la tua targa");
        }
    }else{
        IO.println("L'elenco è vuoto! Nessuna targa da eliminare!");
    }
}

public static void controllaTarga(List<String> elenco){

    String targa = inserisciTarga();

    for (int i = 0; i<elenco.size(); i++){
        if(targa == elenco.get(i)){
            IO.println("Puoi entrare, la tua targa è registrata");
        }else{
            IO.println("Accesso negato, targa non registrata");
        }
    }

}

public static String menu(){
    IO.println("1. Aggiungi targa autorizzata");
    IO.println("2. Rimuovi targa autorizzata");
    IO.println("3. Accedi alla zona riservata");
    IO.println("X. Esci");
    String scelta = "";

    boolean err = true;
    while(err){
        err = false;
        scelta = IO.readln();
        switch(scelta){
            case "X", "1", "2", "3": break;
            default: err = true; IO.println("Scelta non accettabile");
        }
    }

    return scelta;
}

void main(){

    List<String> targhe_autorizzate = new ArrayList<String>();
    boolean running = true;
    while(running){
        String scelta = menu();
        switch(scelta){
            case "X": running = false; break;
            case "1": aggiungiTarga(targhe_autorizzate); break;
            case "2": eliminaTarga(targhe_autorizzate); break;
            case "3": controllaTarga(targhe_autorizzate); break;
        }
    }
}
