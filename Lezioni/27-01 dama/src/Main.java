

void main() {

    Scacchiera s = new Scacchiera();

    Pedina[][] pedine = s.getScacchiera();



    stampaScacchiera(pedine);

}

public static void stampaScacchiera(Pedina[][] board) {
    for (int i = 7; i >= 0; i--) {   // stampa dalla riga 7 alla 0
        for (int j = 0; j < 8; j++) {

            Pedina p = board[i][j];

            if (p == null) {
                System.out.print(". ");
            } else {
                Colore colore = p.getColore();
                Tipo tipo = p.getTipo();

                boolean bianco = colore.equals(Colore.BIANCO);
                boolean damone = tipo.equals(Tipo.DAMONE);

                if (damone) {
                    System.out.print(bianco ? "B " : "N ");
                } else { // DAMA
                    System.out.print(bianco ? "b " : "n ");
                }
            }
        }
        System.out.println();
    }
}

