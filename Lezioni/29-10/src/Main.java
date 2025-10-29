
void stampaGioco(char[][] gri, int dim){

    for(int r = 0; r<dim; r++){
        for(int c = 0; c<dim; c++){
            IO.print(gri[r][c] + " ");
        }
        IO.println();
    }
}


void main() {
    boolean finito = false;

    Go a = new Go(1);

    while(!finito){
        int p = a.getNumPietre('X');
        IO.println("Numero X: " + p);
        IO.println("Numero O: " + a.getNumPietre('O'));
        char[][] griglia = a.getGriglia();
        griglia[1][1] = 'H';
        stampaGioco(a.getGriglia(), a.getLato());

        try {
            IO.println("Dove vuoi mettere la prossima pietra? ");
            String r = IO.readln("Riga: ");
            int riga = Integer.parseInt(r);
            String c = IO.readln("Colonna: ");
            int colonna = Integer.parseInt(c);

            a.mossa(riga, colonna);
        }catch(Exception e){
            //Stampo il messaggio dell'errore invece che un messaggio con IO.print("...");
            IO.println(e.getMessage());
        }
    }
}
