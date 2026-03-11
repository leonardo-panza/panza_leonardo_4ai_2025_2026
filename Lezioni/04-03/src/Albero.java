import java.util.ArrayList;
import java.util.List;

public class Albero {

    private List<Nodo> nodi = new ArrayList<Nodo>();
    private Nodo root;

    public Albero(Nodo r){
        root = r;
        nodi.add(r);
    }

    public void aggiungiNumero(int n){
        boolean allocato = false;
        int i = 0;
        while(!allocato){
            Nodo nodo = nodi.get(i++);
            if(n<nodo.getValore()){
                if(nodo.getSx()==null){
                    nodo.setSx(new Nodo(n));
                }
            }else{

            }
        }
    }















    public String toString() {
        String s = "";
        for(int i = 0; i<nodi.size(); i++){
            if(i!=nodi.size()-1){
                s+=nodi.get(i).getValore() + ", ";
            }else{
                s+= nodi.get(i).getValore();
            }
        }
        return s;
    }
}
