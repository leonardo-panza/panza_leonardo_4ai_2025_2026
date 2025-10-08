

void main() {

    /*
    Mostro m1 = new Mostro();
    Mostro m2 = new Mostro();

    //Modifico
    m1.cambiaNome("Wario");

    IO.println("Il mostro è " + m1.mostraNome());
    IO.println(m1.mostraNome() + " ha " + m1.mostraVita() + " punti vita!");

    IO.println("Il mostro è " + m2.mostraNome());
    IO.println(m2.mostraNome() + " ha " + m2.mostraVita() + " punti vita!");
    */

    Player p1 = new Player("Leonardo");
    Player p2 = new Player("Coumba");

    IO.println("Il primo nickname è: " + p1.mostraNome());
    IO.println("Il secondo nickname è: " + p2.mostraNome());

    p1.setId("AAA1");
    p2.setId("AAA2");
    p1.cambiaNome("LeonardoPanza");
    p2.cambiaNome("CoumbaBa");

    IO.println("----- Apporto modifiche -----");
    IO.println("Il primo nickname è: " + p1.mostraNome());
    IO.println("Il secondo nickname è: " + p2.mostraNome());

    IO.println(p1.toString());
    IO.println(p2.toString());
}
