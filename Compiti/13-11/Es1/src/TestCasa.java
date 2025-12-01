

void main() {

    Casa casa1 = new Casa();

    casa1.setNome("Casetta in montagna");
    casa1.setfibraOttica(false);
    casa1.setNumStanze(3);
    casa1.setMetriQuadrati(62.12);

    String nome = casa1.getNome();
    int stanze = casa1.getNumStanze();
    boolean fibra = casa1.getFibraOttica();
    double metriq = casa1.getMetriQuadrati();

    IO.println("Nome della casa: " + nome +
            "\nNumero stanze: " + stanze +
            "\nFibra ottica: " + fibra +
            "\nEstensione (m^2): " + metriq);

    Casa casa2 = new Casa();
    boolean in_fibra = false;

    casa2.setNome(IO.readln("Nome della tua casa: "));

    String a = IO.readln("Ha la fibra ottica? (si o no): ");
    a = a.toLowerCase();
    if(a.equals("si") || a.equals("sì")) {
        in_fibra = true;
    }
    casa2.setfibraOttica(in_fibra);

    String b = IO.readln("Estensione (m^2) della tua casa: ");
    double in_estensione = Double.parseDouble(b);
    casa2.setMetriQuadrati(in_estensione);

    String c = IO.readln("Numero di stanze nella tua casa: ");
    int in_num = Integer.parseInt(c);
    casa2.setNumStanze(in_num);

    IO.println("Nome della casa: " + casa2.getNome() +
            "\nNumero stanze: " + in_num +
            "\nFibra ottica: " + in_fibra +
            "\nEstensione (m^2): " + in_estensione);
}
