public class Docente extends Persona{

    public Docente(String n, String c, int e){
        super(n,c,e);
    }

    @Override
    public float calcolaStipendio() {
        return 0;
    }
}
