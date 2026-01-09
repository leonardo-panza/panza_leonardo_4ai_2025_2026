void main() {
    Scanner sc = new Scanner(System.in);
    List<Cassa> casse = new ArrayList<>();
    IO.print("Quante casse ci sono? ");
    int numCasse = sc.nextInt();
    for (int i = 0; i < numCasse; i++) casse.add(new Cassa());

    int scelta;
    do {
        IO.println("\n1. Cliente (prendi il numero)");
        IO.println("2. Cassa (chiama il prossimo cliente)");
        IO.println("3. Vedi clienti in attesa");
        IO.println("4. Vedi chiamate effettuate");
        IO.println("0. Esci");
        IO.print("Scegli: ");
        scelta = sc.nextInt();
        sc.nextLine();

        switch (scelta) {
            case 1:
                IO.print("Tipo biglietto (N/P): ");
                char t = sc.nextLine().toUpperCase().charAt(0);
                Priorita p = (t == 'P') ? Priorita.PRIORITARIO : Priorita.NORMALE;
                Biglietto b = new Biglietto(p);
                IO.println("Biglietto assegnato!");
                break;
            case 2:
                IO.print("Codice cassa (1-" + casse.size() + "): ");
                int id = sc.nextInt() - 1;
                if (id < 0 || id >= casse.size()) {
                    IO.println("Cassa inesistente");
                } else {
                    IO.println("Chiamato: " + casse.get(id).chiamaProssimo());
                }
                break;
            case 3:
                IO.println("Clienti in attesa: " + Biglietto.clientiInAttesa());
                break;
            case 4:
                IO.println("Chiamate effettuate: ");
                Chiamata.getCronologia().forEach(IO::println);
                break;
        }
    } while (scelta != 0);

    IO.println("Programma terminato");
}