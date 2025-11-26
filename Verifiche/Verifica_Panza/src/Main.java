import com.sun.jdi.PathSearchingVirtualMachine;
import jdk.jshell.spi.ExecutionControlProvider;

import java.awt.image.ImagingOpException;

List<Articolo> archivio = new ArrayList<Articolo>();
List<Articolo> cercati = new ArrayList<Articolo>();

int Menu (){
    int scelta = 0;
    boolean err = true;
    while(err){
        err = false;
        IO.println("-----\n1. Aggiungi articolo");
        IO.println("2. Visualizza archivio");
        IO.println("3. Cancella articolo");
        IO.println("4. Modifica articolo");
        IO.println("5. Visualizza numeri");
        IO.println("6. Ricerca per descrizione");
        IO.println("0. Esci");
        String s = IO.readln("Scegli: ");
        try{
           scelta =  Integer.parseInt(s);
           if(scelta<0 || scelta > 6) {
               IO.println("Numero non nei campi");
               err = true;
           }
        }catch(Exception e){
            IO.println("Numero inaccettabie");
            err = true;
        }
    }
    return scelta;
}

void aggiungiArticolo(){
    Articolo nuovo = new Articolo();

    boolean err = true;
    while(err) {
        err = false;
        String id = IO.readln("Inserisci l'id: ");
        id = id.toUpperCase();
        try{
            nuovo.setId(id);
        }catch (Exception e){
            IO.println(e.getMessage());
            err = true;
        }
    }

    err = true;
    while(err) {
        err = false;
        String id = IO.readln("Inserisci la descrizione: ");
        try{
            nuovo.setDscr(id);
        }catch (Exception e){
            IO.println(e.getMessage());
            err = true;
        }
    }

    err = true;
    while(err) {
        err = false;
        String id = IO.readln("Inserisci il tipo: ");
        try{
            nuovo.setType(id);
        }catch (Exception e){
            IO.println(e.getMessage());
            err = true;
        }
    }

    err = true;
    while(err) {
        err = false;
        String id = IO.readln("Inserisci il prezzo: ");
        double prz = Double.parseDouble(id);
        try{
            nuovo.setPrezzo(prz);
        }catch (Exception e){
            IO.println(e.getMessage());
            err = true;
        }
    }

    err = true;
    while(err) {
        err = false;
        String id = IO.readln("Inserisci la data di aggiunta al catalogo: ");
        LocalDate data = LocalDate.parse(id);
        try{
            nuovo.setData(data);
        }catch (Exception e){
            IO.println(e.getMessage());
            err = true;
        }
    }

    archivio.add(nuovo);
}

void visualizzaArchivio(){
    if(archivio.isEmpty()){
        IO.println("Archivio vuoto!");
    }else {
        for (Articolo a : archivio) {
            IO.println("------");
            IO.println(a);
        }
    }
}

void eliminaArticolo(){

    String id = IO.readln("Inserisci l'id dell'articolo da eliminare: ");
    id = id.toUpperCase();

    if(archivio.getFirst().getArchivio().contains(id)){
        for(int i = 0; i<archivio.size(); i++){
            if(archivio.get(i).getId().equals(id)){
                archivio.get(i).getArchivio().remove(id);
                archivio.remove(i);
            }
        }
    }else{
        IO.println("ID non trovato");
    }
}

void modificaArticolo(){

    String id = IO.readln("Inserisci l'id dell'articolo da eliminare: ");
    id = id.toUpperCase();
    if(!archivio.get(0).getArchivio().contains(id)){
        IO.println("ID non trovato!");
    }else {
        Articolo modificare = new Articolo();
        for (Articolo a : archivio) {
            if (a.getId().equals(id)) {
                modificare = a;
            }
        }

        IO.println("Ecco il tuo articolo: " + modificare);
        IO.println("Cosa vuoi modificare? ");
        IO.println("1. Descrizione");
        IO.println("2. Tipo");
        IO.println("3. Prezzo");
        IO.println("4. Data di aggiunta al catalogo");
        String s = IO.readln("Scelta: ");
        try{
            int scelta = Integer.parseInt(s);
            if(scelta<1 || scelta>4) throw new IllegalArgumentException("Scelta non accettabile");
            switch(scelta){
                case 1:
                    boolean err = true;
                    while(err) {
                        err = false;
                        String newDescr = IO.readln("Inserisci la descrizione nuova: ");
                        try {
                            modificare.setDscr(newDescr);
                        } catch (Exception e) {
                            IO.println(e.getMessage());
                            err = true;
                        }
                    }; break;
                case 2:
                    err = true;
                    while(err) {
                        err = false;
                        String type = IO.readln("Inserisci il tipo: ");
                        try{
                            modificare.setType(type);
                        }catch (Exception e){
                            IO.println(e.getMessage());
                            err = true;
                        }
                    }; break;
                case 3:
                    err = true;
                    while(err) {
                        err = false;
                        String prezzo = IO.readln("Inserisci il prezzo: ");
                        double prz = Double.parseDouble(prezzo);
                        try{
                            modificare.setPrezzo(prz);
                        }catch (Exception e){
                            IO.println(e.getMessage());
                            err = true;
                        }
                    }; break;
                case 4:
                    err = true;
                    while(err) {
                        err = false;
                        String date = IO.readln("Inserisci la data di aggiunta al catalogo: ");
                        LocalDate data = LocalDate.parse(date);
                        try{
                            modificare.setData(data);
                        }catch (Exception e){
                            IO.println(e.getMessage());
                            err = true;
                        }
                    }; break;
            }
        }catch (Exception e){
            IO.println("Scelta inacettabile!");
        }



    }
}

void visualizzaNumeri(){

    double totale = 0;
    int scontabili = 0;
    double max = 0;
    for(Articolo a: archivio){
        totale += a.getPrezzo();
        try{
            a.scontoApplicabile();
            if(a.scontoApplicabile()>max) max = a.scontoApplicabile();
            scontabili++;
        }catch (Exception e){}
    }

    double media = totale/archivio.size();

    IO.println("Numero articoli: "+ archivio.size());
    IO.println("Numero articoli scontabili: " + scontabili);
    IO.println("Prezzo medio: "+ media);
    IO.println("Sconto massimo applicabile: "+ max);

}

void ricerca(){

    cercati.clear();

    String ric = IO.readln("Ricerca: ").trim().toLowerCase();

    for(Articolo a: archivio){
        if(a.getDscr().toLowerCase().contains(ric)){
            cercati.add(a);
        }
    }

    if(cercati.isEmpty()) {
        IO.println("Nessun articolo trovato");
    }else{
        for(Articolo a: cercati){
            IO.println(a);
        }
    }

}

void main() {

    Articolo a = new Articolo("AAA000", "Giocattolo elettrico", "ecofriendly", 32.3, LocalDate.parse("2008-12-12"));
    Articolo b = new Articolo("BCH234", "Orologio elettrico", "elettronico", 100, LocalDate.parse("2024-12-12"));

    archivio.add(a);
    archivio.add(b);

    boolean running = true;
    while(running){
        int scelta = Menu();
        switch (scelta){
            case 0: running = false; break;
            case 1: aggiungiArticolo(); break;
            case 2: visualizzaArchivio(); break;
            case 3: eliminaArticolo(); break;
            case 4: modificaArticolo(); break;
            case 5: visualizzaNumeri(); break;
            case 6: ricerca(); break;
        }
    }
}
