/*
Attributi
    capienza: n max di unità contenibili
    occupazione_corrente: n di unità occupate all'istante (inizialmente 0)


Costante:
    SCATOLA_PICCOLA: intero costante 1
    SCATOLA_MEDIA: itero costante 2
    SCATOLA_GRANDE: intero costante 3


Metodi
    l'utilizzatore della classe potrà decidere la capienza iniziale del furgone, che (ovviamente?! - ma và) non potrà essere modificata successivamente
    l'utilizzatore della classe dovrà poter caricare sul camion uno scatolone piccolo (se c'è ancora spazio sul furgone)
    l'utilizzatore della classe dovrà poter caricare sul camion uno scatolone medio (se c'è ancora spazio sul furgone)
    l'utilizzatore della classe dovrà poter caricare sul camion uno scatolone grande (se c'è ancora spazio sul furgone)
    l'utilizzatore della classe dovrà poter scaricare l'intero camion (non è consentito scaricare singoli scatoloni)
    l'utilizzatore della classe dovrà poter conoscere quante unità di spazio rimangono sul furgone
    l'utilizzatore della classe dovrà poter calcolare il costo totale delle spedizione, così calcolata --> 1 unità occupata = 10 euro di spesa
*/


import java.security.PublicKey;

/**
 * Funzione bellissima secondo me
 * @author Leonardo Panza
 * @version 1.0
 */
public class Furgone {

    private int capienza;
    private int occupazione_corrente;

    //public così il programmatore vede quanto valgono, tanto non può modificarle
    public final int SCATOLA_PICCOLA = 1;
    public final int SCATOLA_MEDIA = 2;
    public final int SCATOLA_GRANDE = 3;
    public final Float PREZZO_PER_SCATOLA = 10F;

    public Furgone(){
        capienza = 10;
        occupazione_corrente = 0;
    }

    public Furgone(int capienza){
        if(capienza>50) throw new IllegalArgumentException("Capienza oltre il limite (massimo 50!)");
        this.capienza = capienza;
        occupazione_corrente = 0;
    }


    //Per evitare di fare 3 funzioni uguali singolarmente ne faccio una e la applico in tutte le altre

    private void aggiungiScatola(int grandezza){
        if(occupazione_corrente>capienza-grandezza) throw new IllegalArgumentException("Furgone pieno");
        occupazione_corrente += grandezza;
    }

    public void aggiungiPiccolo(){
        aggiungiScatola(SCATOLA_PICCOLA);
    }

    public void aggiungiMedio(){
        aggiungiScatola(SCATOLA_MEDIA);
    }

    public void aggiungiGrande(){
        aggiungiScatola(SCATOLA_GRANDE);
    }

    public void scarica(){
        if(occupazione_corrente<1) throw new IllegalArgumentException("Nulla da scaricare, il furgone è vuoto");
        occupazione_corrente = 0;
    }

    public int spazioRimanente(){
        return capienza - occupazione_corrente;
    }

    public float calcolaSpesa(){
        return occupazione_corrente * PREZZO_PER_SCATOLA;
    }

}
