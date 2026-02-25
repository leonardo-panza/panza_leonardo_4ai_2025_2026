

void main() {

    List<Persona> persone = new ArrayList<>();
    String path = "persone.txt";

//    persone.add(new Persona("Elisa", "Mariani", 28));
//    persone.add(new Bambino("Emma", "Rinaldi", 6, LocalDate.of(2020, 4, 12)));
//    persone.add(new Lavoratore("Chiara", "Gentile", 19, 1300F));
//    persone.add(new Persona("Marco", "Bianchi", 34));
//    persone.add(new Bambino("Tommaso", "Villa", 3, LocalDate.of(2023, 9, 3)));
//    persone.add(new Persona("Pietro", "Locatelli", 53));
//    persone.add(new Lavoratore("Luca", "Galli", 47, 2900F));
//    persone.add(new Persona("Aurora", "Pagani", 23));
//    persone.add(new Bambino("Sofia", "Marchetti", 10, LocalDate.of(2016, 1, 27)));
//    persone.add(new Persona("Giulia", "Rossi", 29));
//
//    try {
//        GestorePersoneFile.salvaPersone(path, persone);
//        IO.println("Ho salvato le persone su file!");
//    }catch (Exception e){
//        IO.println("Errore di scrittura su file");
//    }
//
//    persone.clear();

    try{
        persone = GestorePersoneFile.caricaPersone(path, false);
        IO.println("Ecco le persone caricate:");

        for(int i = 0; i<persone.size(); i++){
            IO.print((i+1) + "- ");
            if(persone.get(i) != null){
                IO.println(persone.get(i));
            }else{
                IO.println("Errore nel caricamento della persona");
            }
        }

    }catch(Exception e){
        IO.println("Errore nel caricare le informazioni");
        IO.println(e.getMessage());
    }



}
