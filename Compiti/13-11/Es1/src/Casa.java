public class Casa {

    private String nome;
    private boolean fibraOttica;
    private int numStanze;
    private double metriQuadrati;

    public Casa(){
        nome = "Nuova casa";
        fibraOttica = false;
        numStanze = 1;
        metriQuadrati = 40;
    }

    public void setNome(String n){
        if(n.length()<3) throw new IllegalArgumentException("Nome troppo corto");
        nome = n;
    }
    public String getNome(){
        return nome;
    }

    public void setfibraOttica(boolean n){
        fibraOttica = n;
    }
    public boolean getFibraOttica(){
        return fibraOttica;
    }

    public void setNumStanze(int n){
        if(n<1) throw new IllegalArgumentException("La casa deve avere almeno una stanza");
        numStanze = n;
    }
    public int getNumStanze(){
        return numStanze;
    }

    public void setMetriQuadrati(double n){
        if(n<10) throw new IllegalArgumentException("Casa troppo piccola");
        metriQuadrati = n;
    }
    public double getMetriQuadrati(){
        return metriQuadrati;
    }
}
