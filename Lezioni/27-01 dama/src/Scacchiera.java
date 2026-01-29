public class Scacchiera {

    private final int N_CASELLE = 8;
    private Pedina[][] scacchiera;

    public Scacchiera() {
        scacchiera = new Pedina[N_CASELLE][N_CASELLE];

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < N_CASELLE; c++) {
                if ((r + c) % 2 == 0) {
                    scacchiera[r][c] = new Pedina(r, c, Colore.BIANCO);
                }
            }
        }

        for (int r = 5; r < N_CASELLE; r++) {
            for (int c = 0; c < N_CASELLE; c++) {
                if ((r + c) % 2 == 0) {
                    scacchiera[r][c] = new Pedina(r, c, Colore.NERO);
                }
            }
        }
    }

    // Copy constructor (copia profonda)
    // Devo fare anche una copia delle pedine!!!
    public Scacchiera(Scacchiera other) {
        this.scacchiera = new Pedina[N_CASELLE][N_CASELLE];
        for (int r = 0; r < N_CASELLE; r++) {
            for (int c = 0; c < N_CASELLE; c++) {
                Pedina p = other.scacchiera[r][c];
                if (p != null) {
                    this.scacchiera[r][c] = new Pedina(
                            p.getRiga(),      // o p.getR()
                            p.getColonna(),   // o p.getC()
                            p.getColore()
                    );
                } else {
                    this.scacchiera[r][c] = null;
                }
            }
        }
    }

    public Pedina[][] getScacchiera() {
        return new Scacchiera(this).scacchiera;
    }

    public void muovi(Pedina p, int nuovaRiga, int nuovaColonna){
        if(nuovaColonna<0 || nuovaColonna>8) throw new IllegalArgumentException("NONONO Colonna");
        if(nuovaRiga<0 || nuovaRiga>8) throw new IllegalArgumentException("NONONO Riga");
        if(p==null) throw new DamaException("Non hai selezionato alcuna pedina");
        //Siccome è stampata specchiata, l'utente mette coordinate specchiate
        if(scacchiera[N_CASELLE-nuovaRiga][N_CASELLE-nuovaColonna] != null) throw new IllegalArgumentException("Casella occupata");

        p.muovi(nuovaRiga, nuovaColonna); //https://www.google.com
    }
}
