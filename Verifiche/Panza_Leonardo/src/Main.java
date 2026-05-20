

void main() throws Exception {

    GestoreIscritti gestore = new GestoreIscritti();

    Utente u1 = new Utente("Leonardo", "Panza", LocalDate.parse("2026-03-04"));
    Utente u2 = new Utente("Paolo", "Ruggeri", LocalDate.parse("2025-03-04"));
    Utente u3 = new Utente("Viola", "Testori", LocalDate.parse("2026-05-04"));
    Utente u4 = new Utente("Goffredo", "De Rossi", LocalDate.parse("2025-11-04"));

    UtenteGold u5 = new UtenteGold("Michele", "Pelucchi", LocalDate.parse("2026-01-03"));
    UtenteGold u6 = new UtenteGold("Nicola", "Pasta", LocalDate.parse("2023-01-03"));
    UtenteGold u7 = new UtenteGold("Federico", "Agazzi", LocalDate.parse("2026-03-03"));

    gestore.iscrivi(u1);
    gestore.iscrivi(u2);
    gestore.iscrivi(u3);
    gestore.iscrivi(u4);
    gestore.iscrivi(u5);
    gestore.iscrivi(u6);
    gestore.iscrivi(u7);

    u1.iscrizioneCorso(Corsi.GINNASTICA);

    try {
        u1.iscrizioneCorso(Corsi.GINNASTICA);
    }catch(Exception e){
        IO.println(e.getMessage());
    }


    u2.iscrizioneCorso(Corsi.GINNASTICA);
    u3.iscrizioneCorso(Corsi.PILATES);
    u4.iscrizioneCorso(Corsi.KARATE);
    u5.iscrizioneCorso(Corsi.KARATE);
    u5.iscrizioneCorso(Corsi.JUDO);
    u7.iscrizioneCorso(Corsi.JUDO);
    u6.iscrizioneCorso(Corsi.KARATE);
    u6.iscrizioneCorso(Corsi.GINNASTICA);
    u7.iscrizioneCorso(Corsi.PILATES);

    IO.println("--- Test ricerca ------ ");
    IO.println(gestore.cercaIscritto(5));

    IO.println("--- ERRORI ---");
    try {
        IO.println(gestore.cercaIscritto(-2));
    } catch (RuntimeException e) {
        IO.println(e.getMessage());
    }
    try {
        IO.println(gestore.cercaIscritto(246732));
    } catch (RuntimeException e) {
        IO.println(e.getMessage());
    }

    IO.println("\n--- Test abbonamenti scaduti, ci aspettiamo Paolo e Nicola");
    IO.println(gestore.visualizzaUtentiScaduti());


    IO.println("\n--- Conteggio accessi a palestra e sauna (mi aspetto 70 palestra e 15 sauna)");
    IO.println(gestore.visualizzaAccessi()); //7utenti * 10 accessi simulati, 3gold * 5 accessi simulati


    IO.println("\n--- Test nPartecipanti ai corsi");
    IO.println(gestore.visualizzaNumeroPartecipanti());

}
