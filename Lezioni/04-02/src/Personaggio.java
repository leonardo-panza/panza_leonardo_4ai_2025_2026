

public abstract class Personaggio {

    private String nome;
    protected int vita;
    private int stamina;
    private int danni;
    private int livello;
    private Armi arma;

    public Personaggio(String nome, int vita, int stamina, int danni, Armi arma) {
        setNome(nome);
        setVita(vita);
        setStamina(stamina);
        setDanni(danni);
        setArma(arma);
        setLivello(1); // livello fisso allo spawn
    }


    public void setNome(String nome) {
        nome = nome.strip();
        if(nome.length()<2 || nome.length()>30) throw new IllegalArgumentException("Nome inaccettabile");
        this.nome = nome;
    }

    public void setVita(int vita) {
        if(vita<0 || vita>1000000) throw new IllegalArgumentException("Vita inaccettabile");
        this.vita = vita;
    }

    public void setStamina(int stamina) {
        if(stamina<0 || stamina>1000) throw new IllegalArgumentException("Stamina inaccettabile");
        this.stamina = stamina;
    }

    public void setDanni(int danni) {
        if(danni<0 || danni>1000) throw new IllegalArgumentException("Danni inaccettabili!");
        this.danni = danni;
    }

    private void setLivello(int livello) {
        if(livello<1) throw new IllegalArgumentException("Livello iaccetabile");
        this.livello = livello;
    }

    public void setArma(Armi arma) {
        this.arma = arma;
    }

    public String getNome() {
        return nome;
    }

    public Armi getArma() {
        return arma;
    }

    public int getDanni() {
        return danni;
    }

    public int getLivello() {
        return livello;
    }

    public int getStamina() {
        return stamina;
    }

    public int getVita() {
        return vita;
    }

    public void drop(){
        arma = Armi.PUGNI;
    }

    public String toString() {
        return "Pers:{" + nome + ": " + arma + ", lvl" + livello + "[" + vita + ", " + stamina + ", " + danni + "]}";
    }

    public abstract void attacca(Personaggio p);

    public abstract boolean subisci(int d);
}
