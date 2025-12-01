import java.util.ArrayList;
import java.util.List;


public class Rastrelliera {

    List<Torre> torri;
    private int numeroDischi;
    public Rastrelliera(int numeroTorri, int numeroDischi, List<Integer> dischi){

        //controlli
        if (numeroTorri < 3){
            throw new IllegalArgumentException("La rastrelliera deve contenere almeno tre torri");
        }

        setNumeroDischi(numeroDischi);

        //creo le torri
        torri = new ArrayList<Torre>();
        for (int i=0; i<numeroTorri; i++){
            Torre t = new Torre(numeroDischi);
            torri.add(t);
        }

        //riempio la prima torre
        for (int i = 0; i<dischi.size(); i++){
            torri.get(0).inserisciDisco(dischi.get(i));
        }
    }

    public void spostaDisco(int posizioneIniziale, int posizioneFinale){
        if (posizioneIniziale-1 < 0 || posizioneIniziale-1 > torri.size()){
            throw new IllegalArgumentException("La torre iniziale non è valida");
        }
        if (posizioneFinale-1 < 0 || posizioneFinale-1 > torri.size()){
            throw new IllegalArgumentException("La torre finale non è valida");
        }
        int disco = torri.get(posizioneIniziale-1).estraiDisco();
        torri.get(posizioneFinale-1).inserisciDisco(disco);
    }

    public int[][] getRastrelliera(){
        int[][] risultato = new int[numeroDischi][torri.size()];
        for (int c = 0 ; c < torri.size(); c++ ){
            int[] dischiTorre = torri.get(c).getDischi();
            for (int d = 0; d < dischiTorre.length; d++){
                risultato[d][c] = dischiTorre[d];
            }
        }
        return risultato;
    }

    public boolean vittoria(){
        //restituisce vero se la torre[torri.size()-1] contiene un numero di dischi pari a numeroDischi
        //Controllo anche se la torre non è la prima (di partenza)
        for(int i = 0; i<torri.size(); i++){
            if(torri.get(i).torrePiena() && i!=0) return true;
        }

        return false;
    }

    private void setNumeroDischi(int numeroDischi) {
        if (numeroDischi <= 0){
            throw new IllegalArgumentException("Le torri devono contenere almeno un disco");
        }
        this.numeroDischi = numeroDischi;
    }

    public String toString(){
        int conta = 1;
        String s = "";
        for(Torre t: torri){
            s += conta + ": " + t.toString() + "\n";
            conta++;
        }
        return s;
    }
}
