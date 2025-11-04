

public class Otello {

    private final int LATO = 8;
    public char[][] griglia = new char[LATO][LATO];
    private char gioc1;
    private char gioc2;
    private char turno;

    public Otello(){
        for(int i = 0; i<LATO; i++){
            for(int j = 0; j<LATO; j++){
                griglia[i][j] = ' ';
            }
        }

        gioc1 = 'X';
        gioc2 = 'O';

        if(turno == gioc1){
            turno = gioc2;
        }else{
            turno = gioc1;
        }

        griglia[3][3] = gioc1;
        griglia[4][4] = gioc1;
        griglia[3][4] = gioc2;
        griglia[4][3] = gioc2;

    }

    public Otello(char g1, char g2){

        if(g1 == g2) throw new IllegalArgumentException("Non puoi avere due pedine uguali!");
        for(int i = 0; i<LATO; i++){
            for(int j = 0; j<LATO; j++){
                griglia[i][j] = ' ';
            }
        }

        gioc1 = g1;
        gioc2 = g2;

        if(turno == gioc1){
            turno = gioc2;
        }else{
            turno = gioc1;
        }

        griglia[3][3] = gioc1;
        griglia[4][4] = gioc1;
        griglia[3][4] = gioc2;
        griglia[4][3] = gioc2;

    }

    public void stampaGriglia(){
        for(int i = 0; i<LATO; i++){
            for(int j = 0; j<LATO; j++){
                IO.print(griglia[j][i] + " | ");

            }
            IO.println();
            IO.println("--------------------------------");
        }
    }

    public void aggiungiPedina(int rig, int col){
        rig--;
        col--;
        IO.println(rig + " " + col);
        if(rig<0 || rig>LATO) throw new IllegalArgumentException("Riga inesistente");
        if(col<0 || col>LATO) throw new IllegalArgumentException("Colonna inesistente");
        IO.println(griglia[rig][col]);
        if(griglia[rig][col] != ' ') throw new IllegalArgumentException("Cella occupata!");

        controllaAdiacenze(col, rig);

    }

    private void controllaAdiacenze(int col, int rig){
        boolean pedina_col = false;
        int coord_ped_col = 0;
        int coord_ped_rig = 0;
        int maggiore = 0;
        int minore = 0;

        //Controllo che ci sia un'altra pedina sulla colonna
        for(int i = 0; i<LATO; i++){
            if(griglia[i][col] == turno && i!=rig){
                pedina_col = true;
                coord_ped_col = i;
            }
        }

        //Controllo che ci sia un'altra pedina sulla riga
        boolean pedina_rig = false;
        for(int i = 0; i<LATO; i++){
            if(griglia[rig][i] == turno && i!=col){
                pedina_rig = true;
                coord_ped_rig = i;
            }
        }

        //Se non ci sono adiacenze lancio un'eccezione
        if(pedina_col == false && pedina_rig == false) throw new IllegalArgumentException("Mossa invalida1");

        //Controllo se lo spazio fra i due è completamente riempito da bianchi
        if(pedina_col == true){
            if(coord_ped_col > col){
                maggiore = coord_ped_col;
                minore = col;
            }else{
                maggiore = col;
                minore = coord_ped_col;
            }

            IO.println(maggiore + " " + minore + " " + coord_ped_col);
            int distanza = maggiore-minore;
            int conta_altri = 0;
            for(int i = minore; i<maggiore; i++){
                if(griglia[i][col] != turno && griglia[i][col] !=' '){
                    conta_altri++;
                }
            }

            if(distanza != conta_altri){
                throw new IllegalArgumentException("Mossa invalida2");
            }

            for(int i = minore; i<maggiore; i++){
                griglia[i][col] = turno;
            }
        }

        if(pedina_rig == true){
            if(coord_ped_rig > rig){
                maggiore = coord_ped_rig;
                minore = rig;
            }else{
                maggiore = rig;
                minore = coord_ped_rig;
            }

            IO.println(maggiore + " " + minore + " " + rig);

            int distanza = maggiore-minore;
            int conta_altri = 0;
            for(int i = minore; i<maggiore; i++){
                if(griglia[rig][i] != turno && griglia[rig][i] !=' '){
                    conta_altri++;
                }
            }

            //Se la distanza (spazi in mezzo) è diversa dalla conta (vuol dire che gli spazi in mezzo hanno pedine non dell'altro colore)
            if(distanza != conta_altri){
                throw new IllegalArgumentException("Mossa invalida3");
            }

            //Trasformo le pedine di mezzo
            for(int i = minore; i<maggiore; i++){
                griglia[rig][i] = turno;
            }
        }
    }
}
