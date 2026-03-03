import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorePersoneFile {

    public static void salvaPersone(String nome_file, List<Persona> personeDaSalvare){

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nome_file))) {
            oos.writeObject(personeDaSalvare);
            IO.println("Lista caricata e serializzata correttamente!");
        } catch (Exception e) {
            throw new LoadingException("Errore nel caricamento dei dati.");
        }

    }

    public static List<Persona> caricaPersone(String nome_file){

        List<Persona> ritorno = new ArrayList<>();

        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream(nome_file))) {
            Object lettura = oos.readObject();
            ritorno = (List<Persona>) lettura;
        } catch (Exception e) {
            throw new DownloadingException("Errore nel download dei dati.");
        }

        return ritorno;
    }

}
