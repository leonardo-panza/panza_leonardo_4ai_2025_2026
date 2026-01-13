/**
 * Sium baby, stiamo volando
 */
public class FiguraGeometrica {

    private int numerolati;
    private float lunghezzalato;

    public FiguraGeometrica(int n, float l){
        numerolati = n;
        lunghezzalato = l;
    }

    /**
     * Calcola il perimetro della figura geometrica con una
     * formula avanzata
     * @return il prerimetro
     */
    public float perimetro(){
        return numerolati*lunghezzalato;
    }

}