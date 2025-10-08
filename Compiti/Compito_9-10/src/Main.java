

void main() {

    Automobile a1 = new Automobile();

    IO.println("Valori prima");
    a1.stampaDettagli();

    IO.println("-----");
    a1.aggiornaChilometraggio(1342.23F);
    IO.println("Età dal 2000: " + a1.calcolaEta(2000));
    IO.println("Età (no parametri): " + a1.calcolaEta());
    IO.println("-----");

    IO.println("Valori dopo");
    a1.stampaDettagli();

    IO.println("\nCLASSE STUDENTE\n");

    Studente s1  =new Studente();

    IO.println("Valori prima");
    s1.stampaDettagli();
    IO.println("-----");

    s1.aggiungiVoto(10F);
    s1.aggiungiVoto(6.5F);
    s1.aggiungiVoto(8F);

    IO.println("Valori dopo");
    s1.stampaDettagli();
    IO.println("-----");

    Studente s2 = new Studente();
    IO.println("Valori 2° studente");
    s2.stampaDettagli();

}
