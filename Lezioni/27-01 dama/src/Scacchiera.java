public class Scacchiera {

    final int N_CASELLE = 8;
    private Pedina[][] scacchiera;

    public Scacchiera(){
        scacchiera = new Pedina[N_CASELLE][N_CASELLE];

        for(int r = 0; r<3; r++){
            for(int c = 0; c<N_CASELLE; c++){
                if((r+c)%2 == 0){
                    scacchiera[r][c] = new Pedina(r, c, Colore.BIANCO);
                }
            }
        }

        for(int r = 5; r<N_CASELLE; r++){
            for(int c = 0; c<N_CASELLE; c++){
                if((r+c)%2 == 0){
                    scacchiera[r][c] = new Pedina(r, c, Colore.NERO);
                }
            }
        }
    }

    public Pedina[][] getScacchiera() {
        return scacchiera;
    }
}
