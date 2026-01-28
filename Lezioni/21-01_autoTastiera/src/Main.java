import javax.swing.*;
import java.awt.image.ImagingOpException;

List<Automobile> garage = new ArrayList<>();
List<String> targhe = new ArrayList<>();
List<Automobile> possibilita = new ArrayList<>();

String menu() {

    IO.println("---- MENU ----");
    IO.println("1. Aggiungi automobile");
    IO.println("2. Modifica automobile");
    IO.println("3. Elimina automobile");
    IO.println("4. Svuota garage");
    IO.println("5. Visualizza automobili");
    IO.println("6. Cerca automobili");
    IO.println("7. Non ricordo la mia targa");
    IO.println("X. Esci");
    return IO.readln("Inserisci la scelta: ");

}

void aggiungiAuto(){

    Automobile a = new Automobile();
    boolean err = true;

    while(err){
        err = false;
        try {
            a.setTarga(IO.readln("Targa della tua auto: "));
            if(targhe.contains(a.getTarga())) {
                IO.println("Targa già esistente");
                err = true;
            }
        }catch(Exception e){
            IO.println(e.getMessage());
            err = true;
        }
    }

    err = true;

    while(err){
        err = false;
        try {
            a.setModello(IO.readln("Modello dell'automobile: "));
        }catch(Exception e){
            IO.println(e.getMessage());
            err = true;
        }
    }

    err = true;

    while(err){
        err = false;
        try {
            a.setColore(IO.readln("Colore dell'auto (rosso, nero, bianco, giallo): "));
        }catch(Exception e){
            IO.println(e.getMessage());
            err = true;
        }
    }

    err = true;

    while(err){
        err = false;
        try {
            a.setKm(Float.parseFloat(IO.readln("Chilometraggio dell'auto: ")));
        }catch(Exception e){
            IO.println(e.getMessage());
            err = true;
        }
    }

    err = true;

    while(err){
        err = false;
        try {
            a.setPrimaImm(IO.readln("Inserisci la data (gg/mm/aaaa): "));
        }catch(Exception e){
            IO.println(e.getMessage());
            err = true;
        }
    }

    targhe.add(a.getTarga());
    garage.add(a);
}

void modificaAuto(){

    String targa = IO.readln("Inserisci la targa dell'auto che vuoi modificare: ").toUpperCase();
    Automobile autoDaModificare = null;

    if(!targhe.contains(targa)){
        IO.println("Targa non trovata!");
    }else {
        for (Automobile a : garage) {
            if (a.getTarga().equals(targa)) {
                autoDaModificare = a;
            }
        }

        IO.println("1. Modifica colore");
        IO.println("2. Aggiungi chilometri");
        String scelta = IO.readln("Inserisci la scelta: ");

        switch (scelta) {

            case "1":
                IO.println("Colori disponibili: giallo, nero, rosso, bianco");
                String nuovoColore = IO.readln("Inserisci il nuovo colore: ");
                autoDaModificare.setColore(nuovoColore);
                IO.println("Colore aggiornato!");
                break;
            case "2":
                float km = Float.parseFloat(IO.readln("Chilometri da aggiungere: "));
                autoDaModificare.aggiungiKm(km);
                IO.println("Chilometraggio aggiornato!");
                break;
            default:
                IO.println("Scelta non valida!");
        }
    }
}


void eliminaAuto(){

    if(!garage.isEmpty()) {
        String targa = IO.readln("Inserisci la targa dell'auto che vuoi eliminare dal garage: ").toUpperCase();

        if (targhe.contains(targa)) {
            targhe.remove(targa);
            for (int i = 0; i < garage.size(); i++) {
                if (garage.get(i).getTarga().equals(targa)) {
                    garage.remove(i);
                }
            }
        } else {
            IO.println("Targa non trovata, riprova!");
        }
    }else{
        IO.println("Garage vuoto! Nessuna auto da eliminare");
    }
}

void cercaAuto(){

    IO.println("Ricerca auto immatricolate dopo la data che inserisci.");
    LocalDate data = LocalDate.parse(IO.readln("Inserisci una data (aaaa-mm-gg): "));

    boolean trovate = false;

    for(Automobile a : garage){
        if(a.getPrimaImm().isAfter(data)){
            IO.println(a);
            trovate = true;
        }
    }

    if(!trovate){
        IO.println("Nessuna automobile trovata!");
    }
}


void visualizzaAuto(){
    if(garage.isEmpty()) {
        IO.println("Garage vuoto!");
    }else{
        for (int i = 0; i < garage.size(); i++) {
            IO.println((i + 1) + ": " + garage.get(i));
        }
    }
}

void svuotaGarage(){
    if(!garage.isEmpty()){
        String targa = IO.readln("Inserisci una targa di una qualsiasi auto del garage per sicurezza: ").toUpperCase();
        if(!targhe.contains(targa)){
            IO.println("Permesso non consentito!");
        }else{
            for(int i = 0; i<garage.size(); i++){
                garage.remove(i);
                targhe.remove(i);
            }
            IO.println("Tutte le auto eliminate, garage vuoto!");
        }
    }
}

void trovaTarga(){

    for(Automobile a: garage){
        possibilita.add(a);
    }

    String modello = IO.readln("Scrivi il modello (o parte di esso) dell'auto: ").toLowerCase();

    for(int i = 0; i<possibilita.size(); i++){
        if(!possibilita.get(i).getModello().toLowerCase().contains(modello)){
            possibilita.remove(i);
            i--;
        }
    }

    if(possibilita.size() == 1){
        IO.println("Targa trovata! \nLa tua targa è: " + possibilita.getFirst().getTarga());
    }else{
        String colore = "";
        boolean err = true;
        while(err){
            err = false;
            colore = IO.readln("Scrivi il colore dell'auto: ").toLowerCase();
            if(!(colore.equals("rosso") || colore.equals("bianco") || colore.equals("giallo") || colore.equals("nero"))){
                IO.println("Colore inesistente");
                err = true;
            }
        }

        for(int i = 0; i<possibilita.size(); i++){
            if(!possibilita.get(i).getStringColore().equals(colore)){
                possibilita.remove(i);
                i--;
            }
        }

        if(possibilita.size() == 1) {
            IO.println("Targa trovata! \nLa tua targa è: " + possibilita.getFirst().getTarga());
        }else{
            LocalDate data = LocalDate.now();
            err = true;
            while(err){
                err = false;
                try{
                    data = LocalDate.parse(IO.readln("Data di immatricolazione dell'auto: "));
                }catch(Exception e){
                    IO.println("Data inacettaile, riprova");
                    err = true;
                }
            }

            for(int i = 0; i<possibilita.size(); i++){
                if (!possibilita.get(i).getPrimaImm().equals(data)){
                    possibilita.remove(i);
                    i--;
                }
            }
            if(possibilita.size() == 1){
                IO.println("La targa della tua auto è: " + possibilita.getFirst().getTarga());
            }
        }
    }

    if(!(possibilita.size()==1)){
        IO.println("Ho trovato " + possibilita.size() + " auto con caratteristiche simili: ");
        for(int i = 0; i<possibilita.size(); i++){
            IO.println((i+1) + ": " + possibilita.get(i).toString());
        }
    }

}

void main() {

    garage.add(new Automobile("FN365FG", "FIAT Panda", "Bianco", LocalDate.parse("2008-12-12"), 12045.35F));
    garage.add(new Automobile("AB123CD", "FIAT 500", "Rosso", LocalDate.parse("2015-06-21"), 8450.00F));
    garage.add(new Automobile("GH456IJ", "Volkswagen Golf", "Nero", LocalDate.parse("2012-03-14"), 10230.75F));
    garage.add(new Automobile("KL789MN", "Renault Clio", "Rosso", LocalDate.parse("2018-09-05"), 12990.50F));
    garage.add(new Automobile("OP147QR", "Toyota Yaris", "Giallo", LocalDate.parse("2010-11-30"), 6780.20F));
    garage.add(new Automobile("ST258UV", "Ford Fiesta", "Bianco", LocalDate.parse("2016-04-18"), 9100.00F));

    targhe.add("FN365FG");
    targhe.add("AB123CD");
    targhe.add("GH456IJ");
    targhe.add("KL789MN");
    targhe.add("OP147QR");
    targhe.add("ST258UV");


    boolean running = true;
    while(running) {

        String scelta = menu();

        switch (scelta) {
            case "1":
                aggiungiAuto(); break;
            case "2":
                modificaAuto(); break;
            case "3":
                eliminaAuto(); break;
            case "5":
                visualizzaAuto(); break;
            case "6":
                cercaAuto(); break;
            case "4":
                svuotaGarage(); break;
            case "7":
                trovaTarga(); break;
            case "X":
                running = false;
            default: IO.println("Errore! Valore inaccettabile!");
        }
    }

}
