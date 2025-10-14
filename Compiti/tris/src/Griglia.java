
import java.util.ArrayList;
import java.util.List;

public class Griglia {

    private final int LATO_GRIGLIA = 3;
    private char[][] griglia = new char[LATO_GRIGLIA][LATO_GRIGLIA];

    public Griglia(){

        //dichiaro tutti gli spazi vuoti
        for(int i = 0; i<LATO_GRIGLIA; i++){
            for(int j = 0; i<LATO_GRIGLIA; i++){
                griglia[i][j] = ' ';
            }
        }

    }

    private List convertiCoord(int num){
        List a = new ArrayList<Integer>();

        if(num == 1 || num == 4 || num == 7) a.add(0);
        if(num == 2 || num == 5 || num == 8) a.add(1);
        if(num == 3 || num == 6 || num == 9) a.add(2);
        if(num == 7 || num == 8 || num == 9) a.add(0);
        if(num == 4 || num == 5 || num == 6) a.add(1);
        if(num == 1 || num == 2 || num == 3) a.add(2);

        if(griglia[(int) a.get(0)][(int) a.get(1)] != ' ') throw new IllegalArgumentException("Cella già occupata");
        IO.println(a);
        return a;
    }

    public void aggiungiX(int coordinate){

        List a = convertiCoord(coordinate);

        griglia[(int) a.get(1)][(int) a.get(0)] = 'X';

    }

    public void aggiungiO(int coordinate){

        List a = convertiCoord(coordinate);

        griglia[(int) a.get(0)][(int) a.get(1)] = 'O';

    }

    public void mostraGriglia(){
        for(int i = 0; i<LATO_GRIGLIA; i++){
            for(int j = 0; i<LATO_GRIGLIA; i++){
                IO.println(" " +  griglia[i][j] + " | " + griglia[i][j] + " | " + griglia[i][j] + " |");
                if (i<LATO_GRIGLIA-1){
                    IO.println("-----------|");
                }
            }
        }
    }


}
