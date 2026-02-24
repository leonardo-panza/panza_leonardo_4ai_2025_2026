import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorePersoneFile {

    public final static String NOME_FILE = "persone.txt";

    public static void salvaPersone(List<Persona> personeDaSalvare) throws IOException {

        //Creo i buffer writer
        BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(NOME_FILE));

        String personaTesto;

        for (Persona p : personeDaSalvare) {
            personaTesto = p.getNome() + "|"+ p.getCognome() + "|"+ p.getEta();
            if(p instanceof Lavoratore) personaTesto += "|"+ ((Lavoratore) p).getStipendioMensile();
            bufferWriter.write(personaTesto);  //la scrivo
            bufferWriter.newLine(); //a capo
        }

        bufferWriter.close();
    }

    public static List<Persona> caricaPersone() throws IOException {

        List<Persona> ritorno = new ArrayList<>();

        //creo buffer reader
        BufferedReader bufferReader = new BufferedReader(new FileReader(NOME_FILE));

        //per ogni riga eseguo una split su ogni pipe |
        //prendo le 3 informazioni e creo una persona
        //aggiungo la persona alla lista dei risultati

        boolean running = true;
        while(running){
            try {
                String riga = bufferReader.readLine();
                String[] parole = riga.split("\\|");

                //Se ha 3 dati è Persona, altrimenti lavoratore
                if(parole.length == 3) {

                    ritorno.add(new Persona(parole[0],
                            parole[1],
                            Integer.parseInt(parole[2])
                    ));

                }else{

                    ritorno.add(new Lavoratore(parole[0],
                            parole[1],
                            Integer.parseInt(parole[2]),
                            Float.parseFloat(parole[3])
                    ));

                }

            }catch(Exception e){
                running = false;
            }
        }

        //chiudere il buffer reader
        bufferReader.close();

        return ritorno;
    }

}
