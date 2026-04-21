import java.util.ArrayList;
import java.util.List;

public class Rete {

    private List<Router> router;

    public Rete(){
        router = new ArrayList();
    }

    public void collega(Router r1, Router r2){
        r1.collega(r2);
        r2.collega(r1);
    }

    public void mandaMessaggio(String ipStart, String ipEnd, String m){
        Router start;
        Router end;

        for(Router r: router){
            if(r.getIpAddress().equals(ipStart)) start = r;
            if(r.getIpAddress().equals(ipEnd)) end = r;
        }

        //Djikstra(start, end, mess);
    }

}
