

void main() {

    final char g1 = 'V';
    final char g2 = 'B';
    Quattro a = new Quattro(g1, g2);
    boolean gaiming = true;
    char vinc = ' ';
    while(gaiming){
        IO.print("Giocatore 1: ");
        String scelta_rosso = IO.readln();
        int col_rosso = Integer.parseInt(scelta_rosso);
        a.aggiungiPlayer1(col_rosso);
        a.mostraGriglia();

        vinc = a.check();
        if(vinc == g1){
            IO.println("Giocatore 1 vince");
            gaiming = false;
        }

        if(gaiming) {
            IO.print("Giocatore 2: ");
            String scelta_giallo = IO.readln();
            int col_giallo = Integer.parseInt(scelta_giallo);
            a.aggiungiPlayer2(col_giallo);
            a.mostraGriglia();

            vinc = a.check();
            if (vinc == g2) {
                IO.println("Giocatore 2 vince");
                gaiming = false;
            }
        }
    }

}
