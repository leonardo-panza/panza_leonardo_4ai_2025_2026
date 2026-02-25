import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestorePersoneFile {

    public static void salvaPersone(String nome_file, List<Persona> personeDaSalvare) throws IOException {

        //Creo i buffer writer
        BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(nome_file));

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

    public static List<Persona> caricaPersone(String nome_file, boolean segnala_subito) throws IOException {

        List<Persona> ritorno = new ArrayList<>();
        int r = 0;

        //creo buffer reader
        BufferedReader bufferReader = new BufferedReader(new FileReader(nome_file));

        //per ogni riga eseguo una split su ogni pipe |
        //prendo le 3 informazioni e creo una persona
        //aggiungo la persona alla lista dei risultati

        boolean running = true;
        while(running){
            try {
                r++;
                String riga = bufferReader.readLine();

                if(riga != null) {
                    if(!riga.equals("")) {
                        String[] parole = riga.split("\\|");

                        //Distinguo le 3 classi

                        switch (parole[0]) {
                            case "Lavoratore":
                                ritorno.add(new Lavoratore(parole[1], parole[2], Integer.parseInt(parole[3]), Float.parseFloat(parole[4])));
                                break;
                            case "Bambino":
                                ritorno.add(new Bambino(parole[1], parole[2], Integer.parseInt(parole[3]), LocalDate.parse(parole[4])));
                                break;
                            default:
                                ritorno.add(new Persona(parole[1], parole[2], Integer.parseInt(parole[3])));
                        }
                    }
                }else{
                    running = false;
                }

            }catch(Exception e){

                if(segnala_subito) throw new LoadingException("Errore alla riga " + r);
                ritorno.add(null);

            }

        }

        //chiudere il buffer reader
        bufferReader.close();

        return ritorno;
    }

}
