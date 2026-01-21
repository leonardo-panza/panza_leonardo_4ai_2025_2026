import java.awt.image.ImagingOpException;

List<Automobile> garage = new ArrayList<>();
List<String> targhe = new ArrayList<>();

String menu() {

    IO.println("---- MENU ----");
    IO.println("1. Aggiungi automobile");
    IO.println("2. Modifica automobile");
    IO.println("3. Elimina automobile");
    IO.println("4. Visualizza automobili");
    IO.println("5. Cerca automobili");
    IO.println("X. Esci");
    return IO.readln("Inserisci la scelta: ");

}

void aggiungiAuto(){

    Automobile a = new Automobile(
            IO.readln("Targa: "),
            IO.readln("Modello: "),
            IO.readln("Colore: "),
            LocalDate.parse(IO.readln("Data prima immatricolazione (aaaa-mm-gg): ")),
            Float.parseFloat(IO.readln("Chilometraggio: "))
    );

    if(targhe.contains(a.getTarga())) throw new IllegalArgumentException("Targa già usata");

    targhe.add(a.getTarga());
    garage.add(a);
}

void modificaAuto(){

    String targa = IO.readln("Inserisci la targa dell'auto che vuoi modificare: ").toUpperCase();
    Automobile autoDaModificare = null;

    IO.println(targhe + " - " + targa + " - " + targhe.contains(targa));
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

    String targa = IO.readln("Inserisci la targa dell'auto che vuoi eliminare dal garage: ").toUpperCase();

    if(targhe.contains(targa)){
        targhe.remove(targa);
        for(Automobile a: garage){
            if(a.getTarga().equals(targa)){
                garage.remove(a);
            }
        }
    }else{
        IO.println("Targa non trovata, riprova!");
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
            case "4":
                visualizzaAuto(); break;
            case "5":
                cercaAuto(); break;
            case "X":
                running = false;
            default: IO.println("Errore! Rifai!");
        }
    }

}
