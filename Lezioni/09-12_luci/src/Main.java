

void main() {

    Lampadina a = new Lampadina();
    a.accendi();
    IO.readln();
    a.spegni();
    IO.println(a.getTempoFunzionamento());
}