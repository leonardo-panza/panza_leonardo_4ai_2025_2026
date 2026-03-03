import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

void main(){
    List<Persona> persone = new ArrayList<>();

    // 3 bambini
    persone.add(new Bambino("Luca", 8, "Scuola Primaria A"));
    persone.add(new Bambino("Marta", 6, "Scuola Primaria B"));
    persone.add(new Bambino("Giulia", 10, "Scuola Media C"));

    // 2 adulti
    persone.add(new Adulto("Marco", 35, 1800.50F));
    persone.add(new Adulto("Sara", 42, 2200.00F));

    // 1 persona generica
    persone.add(new Persona("Nonno Piero", 70));

    // Serializzazione
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:/Users/LEONARDOPANZA/Desktop/docs/persone.txt"))) {
        oos.writeObject(persone);
        IO.println("Lista caricata e serializzata correttamente!");
    } catch (Exception e) {
        IO.println("UH-OH");
    }

    persone.clear();
    IO.println(persone);

    try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("C:/Users/LEONARDOPANZA/Desktop/docs/persone.txt"))) {
        Object letto = oos.readObject();
        if(letto instanceof List) {
            List l = (List) letto;
            if(l.getFirst() instanceof Persona){
                IO.println("Lista scaricata correttamente!");
                persone = l;
            }else{
                IO.println("Dati corrotti");
            }
        }
    } catch (Exception e) {
        IO.println("UH-OH");
    }

    for(Persona a : persone){
        IO.println(a);
    }

}
