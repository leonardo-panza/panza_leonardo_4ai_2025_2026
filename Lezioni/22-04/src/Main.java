

void main() {

    Classe a = Classe.getInstance("Ciao");

    IO.println(a);

    a.setDati("Dati aggiornati");

    Classe b = Classe.getInstance("Dati nuovi");

    IO.println(a);
    IO.println(b);

    Classe c = new Classe("English data");

    IO.println(a.equals(b) ? "A e B Sono uguali" : "A e B Non sono uguali");
    IO.println(a.equals(c) ? "A e C Sono uguali" : "A e C Non sono uguali");

}
