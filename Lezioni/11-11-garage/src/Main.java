import java.time.LocalDate;

List<Scooter> archivio = new ArrayList<Scooter>();

void datiDiProva(){
    archivio.add(new Scooter("A09876", 0, "Malaguti F12", LocalDate.of(2006, 3, 3)));
    archivio.add(new Scooter("D12345", 0, "Malaguti F10", LocalDate.of(1997, 1, 1)));
    archivio.add(new Scooter("ABCDEF", 0, "Ovetto", LocalDate.of(2025, 11, 12)));
    archivio.add(new Scooter("FWAEH1", 0, "Piaggio Vespa", LocalDate.of(2017, 8, 1)));
}

//Visualizzo
void visualizzaTutti(){
    IO.println("Ci sono " + this.archivio.size() + " scooter nell'archivio");

    //ForEach quando devo trattare tutti gli elementi in una lista, l'elemento viene messo in s
    for(Scooter s : this.archivio){
        IO.println(s);
    }
}

void aggiungiScooter(){
    Scooter s = new Scooter();

    boolean err = true;
    while(err){
        err = false;
        String t = IO.readln("Targa scooter: ");
        try{
            s.setTarga(t);
        }catch(Exception e){
            IO.println(e.getMessage());
            err = true;
        }
    }

    err = true;
    while(err){
        err = false;
        String t = IO.readln("Modello scooter: ");
        try{
            s.setModello(t);
        }catch(Exception e){
            IO.println(e.getMessage());
            err = true;
        }
    }

    err = true;
    while(err){
        err = false;
        String t = IO.readln("Chilometraggio scooter: ");
        try{
            int km = 0;
            try {
                km = Integer.parseInt(t);
            }catch (Exception e){
                throw new IllegalArgumentException("Inserisci un numero");
            }
            s.setKm(km);
        }catch(Exception e){
            IO.println(e.getMessage());
            err = true;
        }
    }

    err = true;
    while(err){
        err = false;
        try{
            s.setDataAcq(LocalDate.parse(IO.readln("Inserisci la data d'acquisto: ")));
        }catch(Exception e){
            IO.println("Data inaccettabile");
            err = true;
        }
    }

    s.setDataAcq(LocalDate.parse(IO.readln("Inserisci la data d'acquisto: ")));
    archivio.add(s);
}

void eliminaScooter(){
    String t = IO.readln("Quale scooter vuoi eliminare? Inserisci la targa: ").toUpperCase();
    Scooter daEliminare = null;

    int conta = 0;
    while(daEliminare == null && conta < archivio.size()){

        if (archivio.get(conta).getTarga().equals(t)) {
            daEliminare = archivio.get(conta);
            IO.println("Trovato");
        }
        conta ++;

    }

    archivio.remove(daEliminare);

}


//Menu
int stampaMenu(){

    IO.println("1. Aggiungi scooter");
    IO.println("2. Elimina scooter");
    IO.println("3. Modifica scooter");
    IO.println("4. Visualizza scooter");
    IO.println("0. Esci");

    int scelta = 0;
    boolean err = true;

    while(err){
        err = false;
        String s = IO.readln("Scelgi: ");

        //Converto in intero e controllo
        try{
            scelta = Integer.parseInt(s);
            if(scelta<0 || scelta > 4) {
                IO.println("Inserisci un numero nei campi");
                err = true;
            }
        }catch(Exception e){
            IO.println("Inserisci un numero");
            err = true;
        }
    }

    return scelta;
}

void modificaScooter(){

    String targa = IO.readln("Inserisci la targa dello scooter da modificare: ");
    Scooter moto = null;
    for(Scooter s: archivio){
        if(s.getTarga() == targa){
            moto = s;
        }
    }

    if(moto!=null){

        String kilo_s = IO.readln("Vuoi modificare il chilometraggio? (si/no): ");
        if(kilo_s == "si"){
            String new_kilo = IO.readln("Inserisci il nuovo chilometraggio: ");
            int km = Integer.parseInt(new_kilo);
            if(km<moto.getKm()) throw new IllegalArgumentException("Il chilometraggio non può diminuire");
            moto.setKm(km);
        }

        String data_s = IO.readln("Vuoi modificare la data d'acquisto? (si/no): ");
        if(data_s == "si"){
            String new_data = IO.readln("Inserisci la nuova data: ");
            LocalDate data = LocalDate.parse(new_data);
            moto.setDataAcq(data);
        }

    }else{
        IO.println("Scooter non trovato");
    }

}


void main() {

    datiDiProva();

    int s = 0;
    boolean running = true;

    while(running) {

        s = stampaMenu();

        switch (s) {
            case 1:
                aggiungiScooter(); break;
            case 2:
                eliminaScooter(); break;
            case 3:
                modificaScooter(); break;
            case 4:
                visualizzaTutti(); break;
            case 0:
                running = false;
                IO.println("Arrivederci!");
        }
    }
}
