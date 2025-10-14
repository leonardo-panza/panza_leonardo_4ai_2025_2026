


void main() {

    Furgone f1 = new Furgone(12);

    f1.aggiungiGrande();
    f1.aggiungiGrande();
    f1.aggiungiPiccolo();
    f1.aggiungiMedio();
    f1.aggiungiMedio();

    IO.println(f1.spazioRimanente());
    IO.println(f1.calcolaSpesa());
    f1.scarica();
    IO.println(f1.calcolaSpesa());

    f1.scarica();

}
