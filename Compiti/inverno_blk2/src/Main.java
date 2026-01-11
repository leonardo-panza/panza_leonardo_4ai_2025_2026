import java.util.*;

static List<Pizza> menu = new ArrayList<>();
static List<Tavolo> tavoli = new ArrayList<>();
static Queue<Tavolo> pizzePronte = new LinkedList<>();

static Pizzaiolo pizzaiolo = new Pizzaiolo();
static Cassa cassa = new Cassa();

static String Menu(){
    IO.println("\n----- PIZZERIA DON LUCIANO -----");
    IO.println("1. Nuovo tavolo");
    IO.println("2. Cameriere");
    IO.println("3. Pizzaiolo");
    IO.println("4. Cassa");
    IO.println("X. Chiudi");
    return IO.readln("Scegli: ");
}

static List<Pizza> prendiOrdine(){
    List<Pizza> ordine = new ArrayList<>();
    String s = "";

    while(!s.equals("X")){
        for(int i = 0; i < menu.size(); i++){
            IO.println(i + ". " + menu.get(i).getNome());
        }
        if(!ordine.isEmpty()){
            IO.println("X. Basta pizze");
        }

        s = IO.readln("Scegli la pizza: ").toUpperCase();

        if(!s.equals("X")){
            ordine.add(menu.get(Integer.parseInt(s)));
        }
    }
    return ordine;
}

void main() {

    IO.println("Inserisci 5 pizze nel menu.");
    for(int i = 0; i < 5; i++){
        String n = IO.readln("Nome pizza: ");
        double c = Double.parseDouble(IO.readln("Costo: "));
        menu.add(new Pizza(n, c));
    }

    while(true){
        String scelta = Menu();

        switch(scelta){

            case "1":{ // nuovo tavolo
                if(tavoli.size() >= 10){
                    IO.println("Locale pieno.");
                    break;
                }

                int n = Integer.parseInt(IO.readln("Numero persone (1-8): "));
                Tavolo t = new Tavolo(n);
                tavoli.add(t);
                IO.println("Tavolo " + t.getNumTavolo() + " assegnato.");
                break;
            }

            case "2":{ // cameriere
                IO.println("1. Prendi ordine");
                IO.println("2. Porta pizze");
                String sc = IO.readln("Scegli: ");

                if(sc.equals("1")){
                    boolean fatto = false;

                    for(Tavolo t : tavoli){
                        if(t.getStato() == StatoTavolo.NUOVO){
                            IO.println("Prendi ordine dal tavolo " + t.getNumTavolo());
                            t.aggiungiOrdine(prendiOrdine());
                            t.setStato(StatoTavolo.ORDINATO);
                            pizzaiolo.aggiungiOrdine(t);
                            fatto = true;
                            break;
                        }
                    }

                    if(!fatto){
                        IO.println("Nessun tavolo nuovo.");
                    }

                } else if(sc.equals("2")){
                    if(pizzePronte.isEmpty()){
                        IO.println("Nessuna pizza pronta.");
                        break;
                    }

                    Tavolo t = pizzePronte.remove();
                    IO.readln("Premi INVIO per servire il tavolo " + t.getNumTavolo());
                    t.setStato(StatoTavolo.SERVITO);
                }
                break;
            }

            case "3":{ // pizzaiolo
                try{
                    Tavolo t = pizzaiolo.preparaOrdine();
                    IO.println("Preparato ordine tavolo " + t.getNumTavolo());
                    pizzePronte.add(t);
                }catch(NoSuchElementException e){
                    IO.println("Nessun ordine da preparare.");
                }
                break;
            }

            case "4":{ // cassa
                boolean pagato = false;

                Iterator<Tavolo> it = tavoli.iterator();
                while(it.hasNext()){
                    Tavolo t = it.next();
                    if(t.getStato() == StatoTavolo.SERVITO){
                        cassa.stampaConto(t);
                        it.remove();
                        pagato = true;
                        break;
                    }
                }

                if(!pagato){
                    IO.println("Nessun tavolo da far pagare.");
                }
                break;
            }

            case "X":{
                IO.println("Sai qual è la cosa peggiore di un tradimento?");
                IO.println("Che non viene quasi mai da un nemico...");
                return;
            }

            default:
                IO.println("Scelta non valida.");
        }
    }
}
