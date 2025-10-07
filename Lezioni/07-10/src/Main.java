

void main() {

    Mostro m1 = new Mostro();
    Mostro m2 = new Mostro();

    //Modifico
    m1.cambiaNome("Wario");

    IO.println("Il mostro è " + m1.mostraNome());
    IO.println(m1.mostraNome() + " ha " + m1.mostraVita() + " punti vita!");

    IO.println("Il mostro è " + m2.mostraNome());
    IO.println(m2.mostraNome() + " ha " + m2.mostraVita() + " punti vita!");
}
