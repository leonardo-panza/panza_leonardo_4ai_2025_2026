public class Quattro {

    final int COLONNE = 7;
    final int RIGHE = 6;
    private char[][] griglia = new char[COLONNE][RIGHE];

    public Quattro(){
        for(int i = 0; i<COLONNE; i++){
            for(int j = 0; j<RIGHE; j++){
                griglia[i][j] = ' ';
            }
        }
    }

    public void aggiungiColore(int coordinate_col, char symbol){

        if(coordinate_col<1 || coordinate_col>RIGHE) throw new IllegalArgumentException("Colonna non accettabile");

        coordinate_col--;

        int coordinate_riga = trovaRigaLibera(coordinate_col);

        griglia[coordinate_riga][coordinate_col] = symbol;

    }


    public boolean check(){




















        return true;
    }


    public void mostraGriglia(){
        for (int i = 0; i < COLONNE; i++) {
            for (int j = 0; j < RIGHE; j++) {
                IO.print(griglia[i][j] + " | ");
            }
            if (i < 7) {
                IO.println("\n----------------------|");
            } else {
                IO.println();
            }
        }
    }


    private int trovaRigaLibera(int coordinate_col){

        int riga_libera = -1;
        int conta = 6;
        while(riga_libera == -1) {

            if(conta<0) throw new IllegalArgumentException("Nessuno slot libero nella colonna specificata");

            if(griglia[conta][coordinate_col] == ' '){
                riga_libera = conta;
            }
            conta--;
        }

        return riga_libera;

    }

    private char checkColonna(int coordinate_col){

        char vincitore = ' ';
        char slot = ' ';

        for(int i = 0; i<RIGHE/2; i++){
            slot = griglia[coordinate_col][i];
            if(slot == griglia[coordinate_col][++i] && slot == griglia[coordinate_col][(i+2)] && slot == griglia[coordinate_col][(i+3)]) {
                vincitore = slot;
            }
        }

        return vincitore;

    }

    private char checkRiga(int coordinate_rig){

        char vincitore = ' ';
        char slot = ' ';

        for(int i = 0; i<COLONNE/2; i++){
            slot = griglia[i][coordinate_rig];
            if(slot == griglia[++i][coordinate_rig] && slot == griglia[(i+2)][coordinate_rig] && slot == griglia[(i+3)][coordinate_rig]) {
                vincitore = slot;
            }
        }

        return vincitore;

    }

}
