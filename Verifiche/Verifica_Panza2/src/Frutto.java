public class Frutto {

    private static int num = 0;
    private final String id;
    private String nome;
    private final boolean rischioAllergia;

    public Frutto(String n, boolean r){
        setNome(n);
        rischioAllergia = r;
        id = "" + ++num;
    }

    public void setNome(String nome) {
        nome = nome.toLowerCase().strip();
        if(!nome.matches("^[a-z]{3,15}$")) throw new IllegalArgumentException("Nome inaccettabile");
        this.nome = nome;
    }

    public float scontoMax(){
        return 0F;
    }

    public String toString() {
        return "id: " + id + "| nome: " + nome + ", allergia: " + rischioAllergia;
    }

    public boolean getRischioAllergia(){
        return rischioAllergia;
    }
}
