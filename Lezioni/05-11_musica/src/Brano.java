import java.time.LocalDate;
import java.util.Random;


/**
 * @author: Leonardo Panza
 * @version: 1.0
 */
public class Brano {

    private String titolo;
    private String artista;
    private int anno;
    private int copieVendute;
    private int num_nuovi_brani = 0;

    //Methods
    public String getTitolo(){
        return titolo;
    }

    public void setTitolo(String tit){
        if (tit.isEmpty()) throw new IllegalArgumentException("Titolo vuoto");

        titolo = tit;
    }

    public String getArtista(){
        return artista;
    }

    public void setArtista(String arti){
        if(arti.length() < 2) throw new IllegalArgumentException("Nome artista non accettabile: minimo 2 caratteri");

        artista = arti;
    }

    public int getAnno(){
        return anno;
    }

    public void setAnno(int a){
        if(a>LocalDate.now().getYear()) throw new IllegalArgumentException("Data non valida");

        anno = a;
    }

    public int getCopieVendute(){
        return copieVendute;
    }

    public void setCopieVendute(int c){
        if(c<0) throw new IllegalArgumentException("Numero non accettabile: numero negativo di copie vendute");

        copieVendute = c;
    }

    public Classifica getRiconoscimento(){
        Classifica c = Classifica.NESSUNA;
        if(copieVendute<=1000) c = Classifica.LEGNO;
        if(copieVendute>100000 && copieVendute<= 250000)  c = Classifica.ARGENTO;
        if(copieVendute>250000 && copieVendute<= 500000) c = Classifica.ORO;
        if(copieVendute>500000) c = Classifica.PLATINO;

        return c;
    }

    public int getEta(){
        return LocalDate.now().getYear() - anno;
    }

    public Brano(String t, String a, int an, int c){
        setTitolo(t);
        setArtista(a);
        setAnno(an);
        setCopieVendute(c);
    }

    public Brano creaBrano(){
        num_nuovi_brani++;

        Random r = new Random();
        String[] artisti = {"DjOne", "BlueDragon", "BasicSound"};

        Brano b = new Brano("Br" + num_nuovi_brani, artisti[r.nextInt(artisti.length)], LocalDate.now().getYear(), 0);

        return b;
    }

    public String toString(){
        return artista + " - " + titolo + " (" + anno + " _copie: " + copieVendute + ")";
    }


}
