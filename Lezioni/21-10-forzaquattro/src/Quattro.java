
/**
 * Gioco di forza quattro
 * @author: Leonardo Panza
 * @version: 1.0
 */
public class Quattro {

    final int COLONNE = 7;
    final int RIGHE = 6;
    private char colore1 = 'R';
    private char colore2 = 'G';
    private int giocate = 0;
    private char[][] griglia = new char[RIGHE][COLONNE];


    /**
     * Costruttore della classe, puoi inserire i colori personalizzati,
     * di default viene inserito R per giocatore 1 e G per giocatore 2
     * @param giocatore1 Colore scelto dal giocatore 1
     * @param giocatore2 Colore scelto dal giocatore 2
     */
    public Quattro(char giocatore1, char giocatore2){
        for(int i = 0; i<RIGHE; i++){
            for(int j = 0; j<COLONNE; j++){
                griglia[i][j] = ' ';
            }
        }

        if(colore1 == colore2) throw new IllegalArgumentException("I colori non possono essere uguali");

        colore1 = giocatore1;
        colore2 = giocatore2;
    }

    /**
     * Costruttore della classe, puoi inserire i colori personalizzati,
     * di default viene inserito R per giocatore 1 e G per giocatore 2
     */
    public Quattro(){
        for(int i = 0; i<RIGHE; i++){
            for(int j = 0; j<COLONNE; j++){
                griglia[i][j] = ' ';
            }
        }

        colore1 = 'R';
        colore2 = 'G';

    }

    /**
     * Aggiunge il colore di giocatore 1 sulla colonna selezionata
     * @param insert Colonna selezionata dal giocatore 1
     */
    public void aggiungiPlayer1(int insert){


        if(insert<1 || insert>COLONNE) throw new IllegalArgumentException("Colonna non accettabile");

        insert--;

        int coordinate_riga = trovaRigaLibera(insert);

        giocate ++;
        griglia[coordinate_riga][insert] = colore1;

    }

    /**
     * Aggiunge il colore di giocatore 2 sulla colonna selezionata
     * @param insert Colonna selezionata dal giocatore 2
     */
    public void aggiungiPlayer2(int insert){

        if(insert<1 || insert>COLONNE) throw new IllegalArgumentException("Colonna non accettabile");

        insert--;

        int coordinate_riga = trovaRigaLibera(insert);

        giocate ++;
        griglia[coordinate_riga][insert] = colore2;

    }

    /**
     * Controlla la griglia per capire se qualcuno ha vinto
     * @return Ritorna il colore scelto dal giocatore vincente
     */
    public char check() {

        char vincitore = ' ';

        for (int i = 0; i < COLONNE; i++) {
            vincitore = checkColonna(i);
        }
        if(vincitore == ' ') {
            for (int i = 0; i < RIGHE; i++) {
                vincitore = checkRiga(i);
            }
        }

        if(vincitore == ' ') {
            vincitore = checkDiagonali();
        }

        return vincitore;

    }

    /**
     * Stampa graficamente la griglia del forza quattro
     */
    public void mostraGriglia () {
        for (int i = 0; i < RIGHE; i++) {
            for (int j = 0; j < COLONNE; j++) {
                IO.print(griglia[i][j] + " | ");
            }
            if (i < 7) {
                IO.println("\n--------------------------|");
            } else {
                IO.println();
            }
        }
    }


    private int trovaRigaLibera ( int coordinate_col){

        int riga_libera = -1;
        int conta = RIGHE-1;
        while (riga_libera == -1) {

            if (conta < 0) throw new IllegalArgumentException("Nessuno slot libero nella colonna specificata");

            if (griglia[conta][coordinate_col] == ' ') {
                riga_libera = conta;
            }
            conta--;
        }

        return riga_libera;

    }

    private char checkRiga ( int coordinate_col){

        char vincitore = ' ';
        char slot = ' ';

        for (int i = COLONNE-1; i >= RIGHE / 2; i--) {
            slot = griglia[coordinate_col][i];
            if (slot == griglia[coordinate_col][(i-1)] && slot == griglia[coordinate_col][(i - 2)] && slot == griglia[coordinate_col][(i - 3)]) {
                if(slot!=' '){
                    vincitore = slot;
                }
            }
        }

        return vincitore;

    }

    private char checkColonna ( int coordinate_rig){

        char vincitore = ' ';
        char slot = ' ';

        for (int i = (RIGHE-1); i >= COLONNE / 2; i--) {
            slot = griglia[i][coordinate_rig];
            if (slot == griglia[(i-1)][coordinate_rig] && slot == griglia[(i - 2)][coordinate_rig] && slot == griglia[(i - 3)][coordinate_rig]) {
                if(slot!=' '){
                    vincitore = slot;
                }
            }
        }

        return vincitore;

    }

    private char checkDiagonali () {

        char slot = ' ';
        char vincitore = ' ';

        for (int j = COLONNE-1; j >= RIGHE / 2; j--) {
            for (int i = RIGHE-1; i >= COLONNE / 2; i--) {
                slot = griglia[j][i];
                if (slot == griglia[(j-1)][(i-1)] || slot == griglia[(j - 2)][(i - 2)] || slot == griglia[(j - 3)][(i - 3)]) {
                    vincitore = slot;
                }

            }
        }

        return vincitore;

    }
}

