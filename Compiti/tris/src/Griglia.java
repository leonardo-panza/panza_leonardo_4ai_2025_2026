
import java.util.ArrayList;
import java.util.List;


/**
 * Creates a grid to play tris
 * @Author: Panza Leonardo
 * @Version: 1.0
 */
public class Griglia {

    private final int LATO_GRIGLIA = 3;
    private char[][] griglia = new char[LATO_GRIGLIA][LATO_GRIGLIA];


    /**
     * Initializes the grid
     */
    public Griglia() {

        //dichiaro tutti gli spazi vuoti
        for (int i = 0; i < LATO_GRIGLIA; i++) {
            for (int j = 0; j < LATO_GRIGLIA; j++) {
                griglia[i][j] = ' ';
            }
        }

    }


    /**
     * Adds the X symbol in the selected slot
     *
     * @param coordinate the number of the selected slot, it must be a integer and between 1 and 9
     */
    public void aggiungiX(int coordinate) {

        List<Integer> a = convertiCoord(coordinate);

        griglia[a.get(0)][a.get(1)] = 'X';

    }

    /**
     * Adds the O symbol in the selected slot
     *
     * @param coordinate the number of the selected slot, it must be a integer and between 1 and 9
     */
    public void aggiungiO(int coordinate) {

        List<Integer> a = convertiCoord(coordinate);

        griglia[a.get(0)][a.get(1)] = 'O';

    }


    /**
     * Graphically prints the current state of the grid in the terminal,
     * using characters to represent each cell.
     */

    public void mostraGriglia() {
        for (int i = 0; i < LATO_GRIGLIA; i++) {
            for (int j = 0; j < LATO_GRIGLIA; j++) {
                IO.print(griglia[i][j] + " | ");
            }
            if (i < 2) {
                IO.println("\n----------|");
            } else {
                IO.println();
            }
        }
    }


    /**
     * Checks the winner of the game.
     *
     * @return 'X' if the player with symbol X has won,
     * 'O' if the player with symbol O has won,
     * ' ' (space) if there is no winner yet.
     */

    public char check() {


        List<Character> a = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                a.add(griglia[i][j]);
            }
        }

        char vincitore = ' ';

        //Controllo se c'è un tris orizzontale
        for (int i = 0; i < 9; i = i + 3) {
            char primo = a.get(i);
            if (primo == a.get(i + 1) && primo == a.get(i + 2)) {
                if (primo == 'X') {
                    vincitore = 'X';
                } else if (primo == 'O') {
                    vincitore = 'O';
                }
            }
        }

        //Controllo se c'è un tris verticale
        if (vincitore == ' ') {
            for (int i = 0; i < 3; i++) {
                char primo = a.get(i);
                if (primo == a.get(i + 3) && primo == a.get(i + 6)) {
                    if (primo == 'X') {
                        vincitore = 'X';
                    } else if (primo == 'O') {
                        vincitore = 'O';
                    }
                }
            }
        }

        //Controllo la diagonale basso sx - alto dx
        if (vincitore == ' ') {
            if (a.get(0) == a.get(4) && a.get(0) == a.get(8)) {
                if (a.get(0) == 'X') {
                    vincitore = 'X';
                } else if (a.get(0) == 'O') {
                    vincitore = 'O';
                }
            }
        }

        //Controllo la diagonale basso dx - alto sx
        if (vincitore == ' ') {
            if (a.get(2) == a.get(4) && a.get(2) == a.get(6)) {
                if (a.get(2) == 'X') {
                    vincitore = 'X';
                } else if (a.get(2) == 'O') {
                    vincitore = 'O';
                }
            }
        }

        return vincitore;

    }

    private List convertiCoord(int num) {
        List<Integer> a = new ArrayList<Integer>();

        if (num == 7 || num == 8 || num == 9) a.add(0);
        if (num == 4 || num == 5 || num == 6) a.add(1);
        if (num == 1 || num == 2 || num == 3) a.add(2);
        if (num == 1 || num == 4 || num == 7) a.add(0);
        if (num == 2 || num == 5 || num == 8) a.add(1);
        if (num == 3 || num == 6 || num == 9) a.add(2);


        if (griglia[a.get(0)][a.get(1)] != ' ') throw new IllegalArgumentException("Cella già occupata");

        return a;
    }
}

