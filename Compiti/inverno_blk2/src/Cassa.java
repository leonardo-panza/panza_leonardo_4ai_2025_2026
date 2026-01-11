public class Cassa {

    public void stampaConto(Tavolo t){
        double totale = 0;

        for(Pizza p : t.getOrdine()){
            totale += p.getCosto();
        }

        IO.println("----- CONTO TAVOLO " + t.getNumTavolo() + " -----");
        IO.println("Totale da pagare: " + totale + " €");
        IO.println("Grazie e arrivederci 💔🥀");
    }
}
