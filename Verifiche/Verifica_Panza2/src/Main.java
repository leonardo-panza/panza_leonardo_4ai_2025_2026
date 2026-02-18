
void main() {

    Frutto f = new Frutto("Mela", false);
    Ordinario o = new Ordinario("Mela", false, "Rossa", 5.3F);
    Ordinario p = new Ordinario("Pera", true, "Viola", 100F);
    Esotico e = new Esotico("Passione", false, "Brasile", 0.3F);
    Esotico b = new Esotico("Banana", true, "Brasile", 0.3F); //stesso prezzo, paese
    Esotico g = new Esotico("Granoturco", false, "Chile", 0.3F); //paese diverso


    IO.println(f.toString());
    IO.println(o.toString());
    IO.println(o.toString());
    IO.println(e.toString());
    IO.println(b.toString());
    IO.println(g.toString());

    IO.println("-----");

    IO.println(f.scontoMax()); //prevedo sconto 0 (classe Frutto)
    IO.println(o.scontoMax()); //prevedo 5.3*0.01+1.05 (ossia 1.103) perché prezzo<10 €/kg
    IO.println(p.scontoMax()); //prevedo 1.35 perché €/kg > 10
    IO.println(e.scontoMax());
    IO.println(b.scontoMax()); //dimostro che lo sconto cambia se c'è allergia (+0.11)
    IO.println(g.scontoMax()); //dimostro che lo sconto cambia se è di paese diverso

    //---- RANDOMIZZATORE ----

    boolean running = true;

    while(running) {

        IO.println("---- CREA IL TUO FRUTTO RANDOM ----\n\n\n\n\n");
        boolean err = true;
        String scelta = "";
        while (err) {
            err = false;

            IO.println("1- Crea un frutto ORDINARIO randomico");
            IO.println("2- Crea un frutto ESOTICO randomico");
            IO.println("X- Esci");
            scelta = IO.readln("Scelta: ");

            scelta = scelta.toUpperCase().strip();
            if (!scelta.equals("1") && !scelta.equals("2") && !scelta.equals("X")) err = true;
            IO.println("Metti un numero accettabile: 1 o 2");
        }

        if (!scelta.equals("X")) {
            String[] possibilita = new String[10];
            possibilita[0] = "Mela";
            possibilita[1] = "Banana";
            possibilita[2] = "Pera";
            possibilita[3] = "Kiwi";
            possibilita[4] = "Pesca";
            possibilita[5] = "Albicocca";
            possibilita[6] = "Arancia";
            possibilita[7] = "Passione";
            possibilita[8] = "Ciliegia";
            possibilita[9] = "Fragola";

            String[] varianti = new String[7];
            varianti[0] = "Blu";
            varianti[1] = "Gialla";
            varianti[2] = "Viola";
            varianti[3] = "Salata";
            varianti[4] = "Dolce";
            varianti[5] = "Pelosa";
            varianti[6] = "Grande";

            String[] provenienze = new String[6];
            provenienze[0] = "Brasile";
            provenienze[1] = "Chile";
            provenienze[2] = "Paraguay";
            provenienze[3] = "Colombia";
            provenienze[4] = "Argentina";
            provenienze[5] = "Altro";


            //Variabili per la random
            Random r = new Random();
            int num;

            //Inizializzo i parametri e la classe
            String nome;
            boolean allergia = false;
            String specialita;  //varietà o provenienza in base a ESOTICO o ORDINARIO
            float prezzo;
            Frutto nuovo;


            //Nome e allergia sono comuni quindi non devo necessariamente inserirle negli if

            num = r.nextInt(0, 10);
            nome = possibilita[num];

            num = r.nextInt(0, 2);
            if (num == 0) allergia = true;

            if (scelta.equals("1")) {  //creo un ORDINARIO

                num = r.nextInt(0, 7);
                specialita = varianti[num];

                prezzo = r.nextFloat(0, 50); //prezzo/kg
                prezzo += 0.01F; //Per evitare che estragga 0 e causare un eccezione

                nuovo = new Ordinario(nome, allergia, specialita, prezzo); //Qui creo l'oggetto

            } else {  //Creo un esotico

                num = r.nextInt(0, 6);
                specialita = provenienze[num];

                prezzo = r.nextFloat(0, 100); //prezzo/pz
                prezzo += 0.01F; //Per evitare che estragga 0 e causare un eccezione

                nuovo = new Esotico(nome, allergia, specialita, prezzo); //Qui creo l'oggetto

            }

            IO.println("----\n2Ecco il tuo frutto random: ");
            IO.println(nuovo);
            IO.println("Sconto massimo: " + nuovo.scontoMax());
        } else {
            running = false;
        }
    }
}
