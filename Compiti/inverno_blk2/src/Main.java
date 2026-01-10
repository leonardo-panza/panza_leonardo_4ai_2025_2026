
List<Pizza> menu = new ArrayList<>();

String Menu(){

    IO.println("----- PIZZERIA DON LUCIANO -----");
    IO.println("1. Nuovo tavolo");
    IO.println("2. Cameriere");
    IO.println("3. Pizzaiolo");
    IO.println("4. Cassa");
    IO.println("X. Chiudi");

    String a = IO.readln("Scegli: ");
    return a;
}

List<Pizza> prendiOrdine(){
    List<Pizza> ordine = new ArrayList<>();
    String s = "";
    while(!s.equals("X")) {
        for (int i = 0; i < menu.size(); i++) {
            IO.println(i + ". " + menu.get(i).getNome());
        }
        if (ordine.size() > 0) {
            IO.println("X. Basta pizze");
        }
        s = IO.readln("Scelgi la pizza: ");
        if (!s.equals("X")) {
            int sceltaPizza = Integer.parseInt(s);
            ordine.add(menu.get(sceltaPizza));
        }
    }

    return ordine;
}

void main(){

    IO.println("Prima di tutto, inserisci 5 pizze nel menu del tuo risporante.");
    for(int i = 0; i<5; i++){
        String s = IO.readln("Nome pizza: ");
        String c = IO.readln("Costo: ");
        double costo = Double.parseDouble(c);
        menu.add(new Pizza(s, costo));
    }

    List<Tavolo> tavoli = new ArrayList<>();
    Queue<Tavolo> pizzePronte = new LinkedList<>();

    String scelta = Menu();
    switch(scelta){
        case "1":{
            String num = IO.readln("Numero di persone (1-8): ");
            int n = Integer.parseInt(num);
            tavoli.add(new Tavolo(n));
            IO.readln("Il cameriere è prondo a prendere l'ordine!");
        }
        case "2":{
            boolean servito = false;
            IO.println("1. Prendi ordini dai tavoli");
            IO.println("2. Porta le pizze");
            String sceltaCameriere = IO.readln("Scelgi: ");
            if(sceltaCameriere.equals("1")){
                for(Tavolo t: tavoli){
                    if(t.getStato() == StatoTavolo.NUOVO && !servito){
                        servito = true;
                        IO.println("Servirai il tavolo numero " + t.getNumTavolo());
                        t.aggiungiOrdine(prendiOrdine());

                        t.setStato(StatoTavolo.ORDINATO);
                    }
                }
                if(!servito){
                    IO.println("Nessun tavolo nuovo. Attendi nuovi clienti.");
                }
            }else if(sceltaCameriere.equals("2")){
                Tavolo portaPizze = pizzePronte.remove();
                IO.readln("Premi INVIO per portare le pizze al tavolo " + portaPizze.getNumTavolo());
                portaPizze.setStato(StatoTavolo.SERVITO);
            }
        }
        case "3":{
            if()
        }
        case "4":{

        }
        case "X":{
            IO.println("Sai qual è la cosa peggiore di un tradimento?");
            try {
                Thread.sleep(2000);
            }catch(Exception e){}
            IO.println("Che non viene quasi mai da un nemico... ");
            try {
                Thread.sleep(2000);
            }catch(Exception e){}
        }
    }

}