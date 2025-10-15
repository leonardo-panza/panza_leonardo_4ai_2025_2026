


void main() {

    boolean gayming = true;
    Griglia a = new Griglia();

    while(gayming) {
        a.mostraGriglia();
        IO.print("Input: ");
        String b = IO.readln();
        int num = Integer.parseInt(b);
        a.aggiungiX(num);
        a.mostraGriglia();
    }
}
