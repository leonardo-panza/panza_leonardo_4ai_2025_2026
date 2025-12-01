public class Smartphone {

    private String marca;
    private String modello;
    private double prezzoDiLancio;
    private double numPollici;
    private double ram;
    private boolean touchscreen;

    public Smartphone(){
        marca = "Java phone";
        modello = "JDK 25";
        prezzoDiLancio = 299.99;
        numPollici = 6.5;
        ram = 8;
        touchscreen = true;
    }

    public Smartphone(String m, String mo, double p, double np, double r, boolean t) {
        setMarca(m);
        setModello(mo);
        setPrezzoDiLancio(p);
        setNumPollici(np);
        setRam(r);
        setTouchscreen(t);
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String m) {
        if (m.length() < 2) {
            throw new IllegalArgumentException("Lunghezza marca troppo corta");
        }
        marca = m;
    }

    public String getModello() {
        return modello;
    }
    public void setModello(String m) {
        if (m.length() < 2) {
            throw new IllegalArgumentException("Lunghezza modello troppo corta");
        }
        modello = m;
    }

    public double getPrezzoDiLancio() {
        return prezzoDiLancio;
    }
    public void setPrezzoDiLancio(double p) {
        if (p < 0) {
            throw new IllegalArgumentException("Prezzo di lancio non può essere negativo");
        }
        prezzoDiLancio = p;
    }

    public double getNumPollici() {
        return numPollici;
    }
    public void setNumPollici(double p) {
        if (p < 0) {
            throw new IllegalArgumentException("Numero pollici non può essere negativo");
        }
        numPollici = p;
    }

    public double getRam() {
        return ram;
    }
    public void setRam(double r) {
        if (r < 0) {
            throw new IllegalArgumentException("RAM non può essere negativa");
        }
        ram = r;
    }

    public boolean getTouchscreen() {
        return touchscreen;
    }
    public void setTouchscreen(boolean t) {
        touchscreen = t;
    }

    public String ottieniFasciaDiPrezzo(){
        if(prezzoDiLancio>=500) return "fascia ALTA";
        if(prezzoDiLancio<500 && prezzoDiLancio>200) return "fascia MEDIA";
        if(prezzoDiLancio<=200) return "fascia BASSA";
        return null;
    }

    public String ottieniTipologiaSmartphone(){
        if(numPollici<=5) return "Mini";
        if(numPollici<7 || numPollici>5) return "Normal";
        if(numPollici>=7) return "Maxi";
        return null;
    }

    public String toString(){
        return "Smartphone {Marca: " + marca + "; Modello: " + modello + "; Pollici: " + numPollici + "; Prezzo: " + prezzoDiLancio + "; RAM: " + ram + "; Touchscreen: " + touchscreen;
    }

}
