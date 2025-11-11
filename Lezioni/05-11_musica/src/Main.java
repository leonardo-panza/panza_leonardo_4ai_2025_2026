

void main() {

    //Implementa funzionalita minime (CRUD) per gestire una collezione di brani)

    List playlist = new ArrayList<>();

    boolean err = true;
    boolean running = true;
    int s = 0;
    String scelta = " ";

    while(running){

        IO.println("1. Aggiungi un brano alla playlist");
        IO.println("2. Modifica un brano della playlist");
        IO.println("3. Elimina un brano dalla playlist");
        IO.println("4. Visualizza la playlist");
        IO.println("X. Esci");

        err = true;
        while(err) {
            err = false;
            scelta = IO.readln("Inserisci la scelta: ");

            try{
                s = Integer.parseInt(scelta);
                if(s<1 || s>4){
                    IO.println("Non puoi inserire un numero fuori dai campi!");
                    err = true;
                }
            }catch (Exception e){
                if(scelta!="X"){
                    err = true;
                    IO.println("Inserisci un carattere valido!");
                }
            }
        }

        switch(scelta){
            case "1": aggiungiBrano(playlist); break;
            case "2": break;
            case "3": break;
            case "4": visualizzaPlaylist(playlist); break;
            case "X": running = false;
        }

        IO.println(playlist);

    }

}

public void aggiungiBrano(List lista){
    boolean err = true;
    Brano nuovo =  new Brano("Title", "Author", 2025, 0);
    while(err) {
        err = false;

        String tit = IO.readln("Titolo: ");
        String aut = IO.readln("Autore: ");
        String data = IO.readln("Data composizione: ");
        String copie = IO.readln("Copie vendute: ");

        try {
            int d = Integer.parseInt(data);
            int c = Integer.parseInt(copie);

            try {
                nuovo = new Brano(tit, aut, d, c);
            } catch (Exception e) {
                IO.println(e.getMessage());
                err = true;
            }

        } catch (Exception e) {
            IO.println("Data e numero di copie vendute devono essere numeri interi!");
            err = true;
        }
    }

    lista.add(nuovo);

}

public void visualizzaPlaylist(List lista){

    for(int i = 0; i<lista.size(); i++){
        IO.println((i+1) + ". " + lista.get(i).toString());
    }

}

public void modificaBrano(List lista){
    String s = "kdk";
    visualizzaPlaylist(lista);
    try{
        s = IO.readln("Quale brano vuoi modificare? ");
        int scelta = Integer.parseInt(s);
        if(scelta<1 || scelta > lista.size()) throw new IllegalArgumentException("Fuori dagli indici");



    }catch(Exception e){
        IO.println(e.getMessage());
    }



}