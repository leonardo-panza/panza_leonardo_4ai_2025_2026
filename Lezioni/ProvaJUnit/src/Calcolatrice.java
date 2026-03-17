public class Calcolatrice {

    public int somma(int a, int b) {
        return a + b;
    }
    public int differenza(int a, int b) { return a-b; }
    public int prodotto(int a, int b) { return a*b; }
    public double quoziente(int a, int b) { return (double) a /b; }
    public double potenza(int a, int b) { return Math.pow(a, b); }
    public double radice(int a, int b) { return Math.pow(a, ((double) 1 /b)); }
    public double logaritmo(int a) { return Math.log10(a);}
}