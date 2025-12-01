

void main() {

    Giocatore totti = new Giocatore();
    totti.setNome("Totti");
    totti.setGoal(200);
    totti.setGoalNazionale(10);
    totti.setCapitano(true);

    Giocatore il_capitano = new Giocatore("Zanetti", 50, 3, true);

    Giocatore delPiero = new Giocatore();

    delPiero.setNome(IO.readln("Inserisci il nome: "));

    delPiero.setGoal(Integer.parseInt(IO.readln("Numero di goal: ")));

    delPiero.setGoalNazionale(Integer.parseInt(IO.readln("Numero di goal in nazionale: ")));

    boolean capt = false;
    String a = IO.readln("E' un capitano? (si o no): ");
    if(a.equals("si") || a.equals("sì")) capt = true;
    delPiero.setCapitano(capt);

    IO.println("---GIOCATORI---\n"+
            totti + "\n" +
            il_capitano + "\n" +
            delPiero);

}
