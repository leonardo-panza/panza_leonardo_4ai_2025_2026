import java.util.ArrayList;
import java.util.Stack;

//TODO - da commentare
public class Torre {

    private Stack<Integer> dischi;
    private int dimensioneMassima;

    public Torre(int dimensioneMassima){
        dischi = new Stack<Integer>();
        setDimensioneMassima(dimensioneMassima);
    }

    public void inserisciDisco(int dimensione){

        if (dischi.size()+1 > dimensioneMassima) {
            throw new IndexOutOfBoundsException("Non c'è più spazio nella torre");
        }
        if (dimensione <= 0 || (!dischi.isEmpty() && dimensione >= dischi.peek())) {
            throw new IllegalArgumentException("Dimensione disco non consentita");
        }
        dischi.push(dimensione);

    }

    public int estraiDisco(){

        if (dischi.isEmpty()){
            throw new IndexOutOfBoundsException("La torre è vuota");
        }

        return dischi.pop();

    }

    public int[] getDischi(){
        int[] copiaDischi = new int[dischi.size()];
        for (int i = 0 ; i < dischi.size(); i++){
            copiaDischi[i] = dischi.elementAt(i);
        }
        return copiaDischi;
    }

    private void setDimensioneMassima(int dimensioneMassima){
        if (dimensioneMassima <= 0){
            throw new IllegalArgumentException("La dimensione della torre deve essere pari almeno a 1");
        }
        this.dimensioneMassima = dimensioneMassima;
    }

    public String toString(){
        String s = "[";
        for(int d: dischi){
            s+= d;
            if(d!=dischi.getLast()) s+= ", ";
        }
        s+= "]";

        return s;
    }

    public boolean torrePiena(){
        if(dischi.size() == dimensioneMassima){
            return true;
        }
        return false;
    }
}
