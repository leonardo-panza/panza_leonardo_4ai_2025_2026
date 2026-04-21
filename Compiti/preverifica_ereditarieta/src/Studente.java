public class Studente extends Persona{

    private static int num_studenti=0;
    private final int matricola;
    private float sommaVoti;
    private int numeroEsami;

    public Studente(String n, String c, int e){
        super(n,c,e);
        num_studenti++;
        matricola = num_studenti;
    }


    @Override
    public String toString() {
        return super.toString() + ", studente n°" + matricola;
    }

    @Override
    public float calcolaStipendio() {
        return 0;
    }

    public boolean promosso(){
        if(numeroEsami<1) throw new IllegalArgumentException("Nessun esame svolto");
        if(sommaVoti/numeroEsami >= 6){
            return true;
        }
        return false;
    }

    public void nuovoEsame(float voto){
        if(voto<0 || voto>10) throw new IllegalArgumentException("Voto inaccettabile");

        numeroEsami++;
        sommaVoti += voto;
    }

    public float getMedia(){
        if(numeroEsami<1) throw new IllegalArgumentException("Nessun esame svolto");
        return (sommaVoti/numeroEsami);
    }
}
