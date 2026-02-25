import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestorePersoneFile {

    public final static String NOME_FILE = "persone.txt";

    public static void salvaPersone(List<Persona> personeDaSalvare) throws IOException {

        //Creo i buffer writer
        BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(NOME_FILE));

        String personaTesto;

        for (Persona p : personeDaSalvare) {
            personaTesto = "";
            //Distinguo le tre persone
            if(p instanceof Lavoratore) personaTesto += "Lavoratore|" + p.getNome() + "|" + p.getCognome() + "|" + p.getEta() + "|" + ((Lavoratore) p).getStipendioMensile();
            if(p instanceof Bambino) personaTesto += "Bambino|" + p.getNome() + "|" + p.getCognome() + "|" + p.getEta() + "|" + ((Bambino) p).getDataNascita();
            if(personaTesto.isEmpty()) personaTesto += "Persona|" +  p.getNome() + "|" + p.getCognome() + "|" + p.getEta();

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

                //Distinguo le 3 classi

                switch(parole[0]){
                    case "Lavoratore": ritorno.add(new Lavoratore(parole[1], parole[2], Integer.parseInt(parole[3]), Float.parseFloat(parole[4]))); break;
                    case "Bambino": ritorno.add(new Bambino(parole[1], parole[2], Integer.parseInt(parole[3]), LocalDate.parse(parole[4]))); break;
                    default: ritorno.add(new Persona(parole[1], parole[2], Integer.parseInt(parole[3])));
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
