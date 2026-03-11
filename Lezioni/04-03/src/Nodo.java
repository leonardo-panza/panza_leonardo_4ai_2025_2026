public class Nodo {

    private int valore;
    private Nodo sx;
    private Nodo dx;

    public Nodo(int v){
        setValore(v);
    }

    public void setValore(int v){
        valore = v;
    }

    public int getValore() {
        return valore;
    }

    public int getSxVal() {
        if(sx==null) throw new SearchException("Nessun nodo sinistro");
        return sx.getValore();
    }

    public int getDxVal(){
        if(dx==null) throw new SearchException("Nessun nodo destro");
        return dx.getValore();
    }

    public Nodo getSx() {
        if(sx==null) throw new SearchException("Nessun nodo sinistro");
        return sx;
    }

    public Nodo getDx() {
        if(dx==null) throw new SearchException("Nessun nodo destro");
        return dx;
    }

    public boolean isLeaf(){
        return(sx == null && dx == null);
    }

    public void setSx(Nodo sx) {
        this.sx = sx;
    }

    public void setDx(Nodo dx) {
        this.dx = dx;
    }
}
