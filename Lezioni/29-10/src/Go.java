/**
 * @author Leonardo Panza
 * @version 1.0
 */

public class Go {

    private int lato;
    private char[][] griglia;
    private char turno;

    public Go(){
        setDimensioneGriglia(2);
        turno = 'X';
    }

    public Go(int dim){
        setDimensioneGriglia(dim);
        turno = 'X';
    }

    /**
     *
     * @param riga Dove posizionare la pedina (1 - dimensione griglia)
     * @param colonna
     */
    public void mossa(int riga, int colonna){

        if(riga<1 || riga>lato) throw new IllegalArgumentException("Riga non esistente");
        if(colonna<1 || colonna>lato) throw new IllegalArgumentException("Colonna non esistente");

        riga--;
        colonna--;
        if(griglia[riga][colonna]!='-') throw new IllegalArgumentException("Casella occupata");

        griglia[riga][colonna] = turno;
        if(turno=='X'){
            turno = 'O';
        }else{
            turno = 'X';
        }

        // TODO: Aggiorno la griglia di gioco

    }

    public char[][] getGriglia(){

        char[][] g = new char[lato][lato];
        for(int i = 0; i<lato; i++){
            for(int j = 0; j<lato; j++){
                g[i][j] = griglia[i][j];
            }
        }

        return g;

    }

    /**
     *
     * @param tipo indica il tipo di pietra da contare. Sono ammessi ⦿ e ▣
     * @return restituisce il numero di pietre presenti nella griglia 🤘🤘
     */
    public int getNumPietre(char tipo){

        int conta = 0;
        for(int r = 0; r<lato; r++){
            for(int c = 0; c<lato; c++){
                if(griglia[r][c] == tipo) conta++;
            }
        }

        return conta;
    }


    public int getLato(){
        return lato;
    }


    //------------- Metodi privati -------------
    /**
     * Importa la griglia di gioco
     * 1 - 9x9
     * 2 - 13x13
     * 3 - 19x19
     *
     * @param size
     * @return non restituisce nulla. Genera un'eccezione se il
     * parametro non è accettabile.
     */
    private void setDimensioneGriglia(int size){
        if(size<1 || size>3) throw new IllegalArgumentException("Dimensione griglia non valida!");

        switch(size){
            case 1: lato = 9; break;
            case 2: lato = 13; break;
            case 3: lato = 19; break;
        }

        griglia = new char[lato][lato];

        //inizializzo la griglia vuota
        for(int r = 0; r<lato; r++){
            for(int c = 0; c<lato; c++){
                griglia[r][c] = '-';
            }
        }

    }

}
