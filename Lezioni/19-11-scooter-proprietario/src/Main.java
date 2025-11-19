import java.time.LocalDate;

List<Scooter> archivio = new ArrayList<>();
List<Proprietario> proprietari = new ArrayList<>();

void datiDiProva(){

    //Creo proprietari
    Proprietario p1 = new Proprietario("BNCLCU85A01H501Z", "Luca Bianchi", "Via Roma 12", LocalDate.parse("1997-12-01"));
    Proprietario p2 = new Proprietario("RSSGLI92C15F205K", "Giulia Rossi", "Via Garibaldi 8", LocalDate.parse("1978-12-21"));
    Proprietario p3 = new Proprietario("VRDMRC78D22L219Y", "Marco Verdi", "Via Manzoni 25", LocalDate.parse("2002-12-31"));
    Proprietario p4 = new Proprietario("CNTSRA90E10M082X", "Sara Conti", "Via Dante 5", LocalDate.parse("2007-01-25"));

    proprietari.add(p1);
    proprietari.add(p2);
    proprietari.add(p3);
    proprietari.add(p4);

    archivio.add(new Scooter("A09876", 0, "Malaguti F12", LocalDate.of(2006, 3, 3), p1));
    archivio.add(new Scooter("D12345", 100, "Malaguti F10", LocalDate.of(1997, 1, 1), p2));
    archivio.add(new Scooter("ABCDEF", 671, "Ovetto", LocalDate.of(2025, 11, 12), p3));
    archivio.add(new Scooter("FWAEH1", 9992, "Piaggio Vespa", LocalDate.of(2017, 8, 1), p4));
}

void visualizzaProprietari(){
    for(int i = 0; i<proprietari.size(); i++){
        IO.println((i+1) + ". " + proprietari.get(i));
    }
}

//Visualizzo
void visualizzaTutti(){
    IO.println("Ci sono " + this.archivio.size() + " scooter nell'archivio");

    //ForEach quando devo trattare tutti gli elementi in una lista, l'elemento viene messo in s
    for(Scooter s : this.archivio){
        IO.println(s);
    }
}

Proprietario aggiungiProprietario(){
    boolean err = true;
    String scelta = "";
    while(err){
        err = false;
        IO.println("Si: creerai un nuovo proprietario da 0\nNo: darai lo scooter ad un proprietario che possiede già una moto");
        scelta = IO.readln("Vuoi creare un nuovo proprietario? (si o no): ");
        if(!scelta.equals("si") && !scelta.equals("no") && !scelta.equals("sì")){
            err = true;
            IO.println("Si o no ho detto!");
        }
    }

    if(scelta.equals("si") || scelta.equals("sì")) {
        Proprietario newp = new Proprietario();
        err = true;
        while (err) {
            err = false;
            String nome = IO.readln("Inserisci nome e cognome: ");
            try {
                newp.setNome(nome);
            } catch (Exception e) {
                IO.println(e.getMessage());
                err = true;
            }
        }

        err = true;
        while (err) {
            err = false;
            String nome = IO.readln("Inserisci il codice fiscale: ");
            try {
                newp.setCF(nome);
            } catch (Exception e) {
                IO.println(e.getMessage());
                err = true;
            }
        }

        err = true;
        while (err) {
            err = false;
            String nome = IO.readln("Inserisci la data di nascita (formato aaaa-mm-gg): ");
            try {

                newp.setNascita(LocalDate.parse(nome));
            } catch (Exception e) {
                IO.println(e.getMessage());
                err = true;
            }
        }

        err = true;
        while (err) {
            err = false;
            String nome = IO.readln("Inserisci la residenza: ");
            try {
                newp.setResidenza(nome);
            } catch (Exception e) {
                IO.println(e.getMessage());
                err = true;
            }
        }
        proprietari.add(newp);
        return newp;
    }

    int prop = 0;
    err = true;
    while(err){
        err = false;
        visualizzaProprietari();
        String s = IO.readln("Numero del proprietario a cui affidare lo scooter: ");
        try{
            prop = Integer.parseInt(s);
            if(prop<1 || prop > proprietari.size()){
                throw new IllegalArgumentException("Fuori dai campi");
            }
        }catch (Exception e){
            IO.println("Il numero deve essere tra i limiti");
            err = true;
        }
    }

    prop--;
    return proprietari.get(prop);

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
            int km;
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

    s.setProprietario(aggiungiProprietario());

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

void ricercaTarga(){
    List<Scooter> trovati = new ArrayList<>();

    boolean err = true;
    String t = ";";
    while(err){
        err = false;
        t = IO.readln("Inserisci la targa: ");
        t = t.toUpperCase();
        if(t.isEmpty() || t.length()>6) {
            err = true;
            IO.println("Targa inaccattabile");
        }
    }

    for(Scooter c : archivio){
        if(c.getTarga().contains(t)){
            trovati.add(c);
        }
    }

    stampaTrovati(trovati);

}

void ricercaModello(){

    List<Scooter> trovati = new ArrayList<>();

    String mod = " f";
    boolean err = true;
    while(err){
        err = false;
        mod = IO.readln("Inserisci il modello da ricercare: ");

        if(mod.isEmpty() || mod.length()>30){
            IO.println("Modello inaccettabile");
            err = true;
        }
    }

    for(Scooter s : archivio){
        if(s.getModello().contains(mod)){
            trovati.add(s);
        }
    }

    stampaTrovati(trovati);

}

void ricercaChilometri(){

    List<Scooter> trovati = new ArrayList<>();

    int km_min = 0;
    int km_max = 0;

    boolean err = true;
    while(err){
        err = false;
        String kilo_min = IO.readln("Chilometraggio MINIMO: ");
        String kilo_max = IO.readln("Chilometraggio MASSIMO: ");
        try{
            km_min = Integer.parseInt(kilo_min);
            km_max = Integer.parseInt(kilo_max);
        }catch (Exception e){
            IO.println("Inserisci numeri interi.");
            err = true;
        }

        if(km_max<km_min){
            IO.println("Il chilometraggio minimo NON può essere più ALTO di quello massimo");
            err = true;
        }
    }

    for(Scooter s : archivio){
        if(s.getKm()<=km_max && s.getKm()>=km_min){
            trovati.add(s);
        }
    }

    stampaTrovati(trovati);

}


void ricercaData(){

    List<Scooter> trovati = new ArrayList<>();

    LocalDate data_inizio = null;
    LocalDate data_fine = null;

    boolean err = true;
    while(err){
        err = false;

        String data_v = IO.readln("Inserisci la data di inizio ricerca: ");
        String data_n = IO.readln("Inserisci la data di inizio ricerca: ");

        try{
            data_inizio = LocalDate.parse(data_v);
            data_fine = LocalDate.parse(data_n);
        }catch (Exception e){
            IO.println("Inserisci le date nel formato corretto (aaaa-mm-gg)");
            err = true;
        }
    }

    for(Scooter s : archivio){
        if(s.getDataAcq().isAfter(data_inizio) && s.getDataAcq().isBefore(data_fine)){
            trovati.add(s);
        }
    }

    stampaTrovati(trovati);

}

//Mi accorgo che tutte le funzioni di ricerca usano lo stesso algoritmo per mostrare gli Scooter trovati
//Quindi faccio una funzione per abbreviare il tutto
void stampaTrovati(List<Scooter> trovati){
    if(trovati.isEmpty()){
        IO.println("Nessuno scooter rientra nei campi");
    }else{
        for(Scooter s : trovati){
            IO.println(s);
        }
    }
}

//Menu
int stampaMenu(){

    IO.println("\n1. Aggiungi scooter");
    IO.println("2. Elimina scooter");
    IO.println("3. Modifica scooter");
    IO.println("4. Visualizza scooter");
    IO.println("5. Ricerca per targa");
    IO.println("6. Ricerca per modello");
    IO.println("7. Ricerca per chilometraggio");
    IO.println("8. Ricerca per data d'acquisto");

    IO.println("0. Esci");

    int scelta = 0;
    boolean err = true;

    while(err){
        err = false;
        String s = IO.readln("Scelgi: ");

        //Converto in intero e controllo
        try{
            scelta = Integer.parseInt(s);
            if(scelta<0 || scelta > 8) {
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
    targa = targa.toUpperCase();
    Scooter moto = null;
    for(Scooter s: archivio){
        if(targa.equals(s.getTarga())){
            moto = s;
        }
    }

    if(moto!=null){

        String kilo_s = IO.readln("Vuoi modificare il chilometraggio? (si/no): ");
        if(kilo_s.equals("si")){
            String new_kilo = IO.readln("Inserisci il nuovo chilometraggio: ");
            int km = Integer.parseInt(new_kilo);
            if(km<moto.getKm()) throw new IllegalArgumentException("Il chilometraggio non può diminuire");
            moto.setKm(km);
        }

        String data_s = IO.readln("Vuoi modificare la data d'acquisto? (si/no): ");
        if(data_s.equals("si")){
            String new_data = IO.readln("Inserisci la nuova data: ");
            LocalDate data = LocalDate.parse(new_data);
            moto.setDataAcq(data);
        }

    }else{
        IO.println("Scooter non trovato");
    }

}


void main() {

    //  Aggiunte 18-11:
    //  Ricerca per targa (intera o parziale)
    //  Ricerca per modello
    //  Ricerca per chilometraggio
    //  Ricerca per data d'acquisto

    datiDiProva();

    int s;
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
            case 5:
                ricercaTarga(); break;
            case 6:
                ricercaModello(); break;
            case 7:
                ricercaChilometri(); break;
            case 8:
                ricercaData(); break;
            case 0:
                running = false;
                IO.println("Arrivederci!");
        }
    }
}
