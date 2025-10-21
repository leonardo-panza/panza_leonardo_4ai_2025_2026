

void main() {

    Quattro a = new Quattro();
    while(true){
        IO.print("Rosso: ");
        String b = IO.readln();
        int col = Integer.parseInt(b);
        a.aggiungiColore(col, 'R');
        a.mostraGriglia();

        IO.print("Giallo: ");
        String b1 = IO.readln();
        int col1 = Integer.parseInt(b);
        a.aggiungiColore(col1, 'G');
        a.mostraGriglia();

    }

}
