

void main() {

    final int righe = 5;
    final int colonne = 20;
    char [][] mare = new char[righe][colonne];

    //Inizializzo il mare
    for(int i = 0; i<righe; i++){
        for(int j = 0; j<colonne; j++){
            mare[i][j] = ' ';
        }
    }

    //Piazzo corsari ecc.
    mare[0][0] = 'R';
    mare[1][19] = 'A';
    mare[3][12] = 'N';
    mare[3][5] = '+';
    mare[1][1] = '0';
    mare[3][7] = '@';

    //Creo un muro verticale
    int r1, c1, l;
    r1 = 0;
    c1 = 15;
    l = 3;

    for(int u = 0; u<l; u++){
        mare[r1+u][c1] = '|';
    }

    //Stampo/visualizzo il mare con i suoi elementi
    for(int i = 0; i<righe; i++){
        if(i==0) IO.println("--------------------------------------------------------------------------------|");
        for(int j = 0; j<colonne; j++){if(j==0) IO.print("~ ");
            IO.print(mare[i][j] + " ~ ");
            if(j==colonne-1) IO.println();
        }
        IO.println("--------------------------------------------------------------------------------|");
    }

    //Individuo nel mare i corsari
    ricercaCorsari(righe, colonne, mare);

}

public void ricercaCorsari(int righe, int colonne, char[][] mare){
    for(int i = 0; i<righe; i++){
        for(int j = 0; j<colonne; j++){

            if(Character.isLetter(mare[i][j]) == true) IO.println("Trovato corsaro " + mare[i][j] + " (" + i + ", " + j + ")");

        }
    }
}