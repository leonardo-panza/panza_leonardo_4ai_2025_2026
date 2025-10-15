import java.util.Random;

public class Mare {

    final int num_bombe = 5;
    final int righe = 5;
    final int colonne = 20;
    private char[][] mare = new char [righe][colonne];
    private char[][] mare_mostra = new char [righe][colonne];
    private boolean giocando;

    public Mare(){
        for(int i = 0; i<righe; i++){
            for(int j = 0; j<colonne; j++){
                mare[i][j] = ' ';
                mare_mostra[i][j] = ' ';
            }
        }
        giocando = false;
    }

    public void aggiungiCorsaro(char lettera, int pos_rig, int pos_col){

        if(giocando) throw new IllegalArgumentException("Non puoi aggiungere corsari mentre si gioca!");
        int num = trovaNumCorsari(mare);
        if(num>10) throw new IllegalArgumentException("Numero corsari massimo raggiunto");
        aggiungiAlMare(lettera, pos_rig, pos_col);

    }

    public void mostraMare(){
        for(int i = 0; i<righe; i++){
            if(i==0) IO.println("--------------------------------------------------------------------------------|");
            for(int j = 0; j<colonne; j++){if(j==0) IO.print("~ ");
                IO.print(mare_mostra[i][j] + " ~ ");
                if(j==colonne-1) IO.println();
            }
            IO.println("--------------------------------------------------------------------------------|");
        }
    }

    public void trovaCorsari(char[][] mare_input){
        for(int i = 0; i<righe; i++){
            for(int j = 0; j<colonne; j++){
                if(Character.isLetter(mare_input[i][j])) IO.println("Trovato corsaro " + mare[i][j] + " (" + i + ", " + j + ")");
            }
        }
    }

    private int trovaNumCorsari(char[][] mare_input){

        int n = 0;
        for(int i = 0; i<righe; i++){
            for(int j = 0; j<colonne; j++){
                if(Character.isLetter(mare_input[i][j])) n++;
            }
        }
        return n;

    }

    //Restituisce true quando trova un oggetto
    private boolean trovaOggetto(int rig, int col){
        if(mare[rig][col] == ' '){
            return false;
        }
        return true;
    }


    private void aggiungiAlMare(char a, int b, int c){
        mare[b][c] = a;
        mare_mostra[b][c] = a;
    }

    public void inizia(){
        giocando = true;
        spawnBombe();
    }

    private void spawnBombe(){
        Random rand = new Random();
        int rig = 0;
        int col = 0;
        for(int i = 0; i<num_bombe; i++){
            boolean err = true;
            while(err){
                err = false;
                rig = rand.nextInt(righe);
                col = rand.nextInt(colonne);
                if(trovaOggetto(rig, col)){
                    err = true;
                }
            }
            mare[rig][col] = 'X';
        }
    }


}
