

void main() {

    List<Persona> persone = new ArrayList<>();

    persone.add(new Persona("Elisa", "Mariani", 28));
    persone.add(new Bambino("Emma", "Rinaldi", 6, LocalDate.of(2020, 4, 12)));
    persone.add(new Lavoratore("Chiara", "Gentile", 19, 1300F));
    persone.add(new Persona("Marco", "Bianchi", 34));
    persone.add(new Bambino("Tommaso", "Villa", 3, LocalDate.of(2023, 9, 3)));
    persone.add(new Persona("Pietro", "Locatelli", 53));
    persone.add(new Lavoratore("Luca", "Galli", 47, 2900F));
    persone.add(new Persona("Aurora", "Pagani", 23));
    persone.add(new Bambino("Sofia", "Marchetti", 10, LocalDate.of(2016, 1, 27)));
    persone.add(new Persona("Giulia", "Rossi", 29));
    persone.add(new Lavoratore("Davide", "Fontana", 26, 1650F));
    persone.add(new Persona("Gabriele", "Costa", 32));
    persone.add(new Bambino("Matteo", "Colombo", 1, LocalDate.of(2025, 6, 18)));
    persone.add(new Persona("Leonardo", "Panza", 17));
    persone.add(new Lavoratore("Elena", "Moretti", 31, 2450F));
    persone.add(new Persona("Carlo", "Bacuzzi", 18));
    persone.add(new Lavoratore("Sara", "Verdi", 22, 1850F));
    persone.add(new Persona("Ciccio", "Pasticcio", 55));
    persone.add(new Bambino("Alice", "Ferri", 8, LocalDate.of(2018, 11, 2)));
    persone.add(new Persona("Alessio", "Amato", 42));




    try {
        GestorePersoneFile.salvaPersone(persone);
        IO.println("Ho salvato le persone su file!");
    }catch (Exception e){
        IO.println("Errore di scrittura su file");
    }

    persone.clear();

    try{
        persone = GestorePersoneFile.caricaPersone();
    }catch(Exception e){
        IO.println("Errore nel caricare le informazioni");
    }

    IO.println("Ecco le persone caricate:");
    for(Persona p: persone){
        IO.println(p);
    }


}
