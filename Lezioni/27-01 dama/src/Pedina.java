public class Pedina {

    private Colore colore;
    private Tipo tipo;
    private int riga;
    private int colonna;

    // Costruttore: tipo sempre DAMA all'inizio
    public Pedina(int riga, int colonna, Colore colore) {
        this.riga = riga;
        this.colonna = colonna;
        this.colore = colore;
        this.tipo = Tipo.DAMA;
    }

    // Metodo che restituisce una copia della pedina
    public Pedina PedinaCP() {
        Pedina copia = new Pedina(this.riga, this.colonna, this.colore);
        copia.tipo = this.tipo; // Copia anche il tipo attuale
        return copia;
    }

    public Colore getColore() {
        return colore;
    }

    // Promuovi da DAMA a DAMONE
    public void promuovi() {
        if (this.tipo == Tipo.DAMA) {
            this.tipo = Tipo.DAMONE;
        }
    }

    public Tipo getTipo() {
        return tipo;
    }

    // Cambia le coordinate
    public void muovi(int nuovaRiga, int nuovaColonna) throws DamaException {
        // Controllo limiti della scacchiera
        if (nuovaRiga < 1 || nuovaRiga > 8 || nuovaColonna < 1 || nuovaColonna > 8) {
            throw new DamaException("Posizione non valida: fuori dai limiti della scacchiera");
        }

        // Se la pedina è già stata posizionata
        if (riga != 0 && colonna != 0) {
            int diffRiga = nuovaRiga - riga;
            int diffColonna = nuovaColonna - colonna;

            if (tipo == Tipo.DAMONE) {
                // Il damone può muoversi di una casella in diagonale
                if (!(Math.abs(diffRiga) == 1 && Math.abs(diffColonna) == 1)) {
                    throw new DamaException("Movimento non valido per un damone");
                }
            } else {
                // DAMA: movimento in avanti di una casella diagonale
                if (colore == Colore.BIANCO) {
                    if (diffRiga != 1 || Math.abs(diffColonna) != 1) {
                        throw new DamaException("Movimento non valido per una dama bianca");
                    }
                } else if (colore == Colore.NERO) {
                    if (diffRiga != -1 || Math.abs(diffColonna) != 1) {
                        throw new DamaException("Movimento non valido per una dama nera");
                    }
                }
            }
        }

        // Aggiorna le coordinate
        riga = nuovaRiga;
        colonna = nuovaColonna;
    }


    // (Opzionale) Getter per riga e colonna
    public int getRiga() {
        return riga;
    }

    public int getColonna() {
        return colonna;
    }
}
