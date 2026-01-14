import io.github.some_example_name.StatoLampadina;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Lampadina {
    private static ArrayList<String> lampadine = new ArrayList<String>();

    private StatoLampadina sl;
    private String nSerie;

    private int nAccensioni;
    private double tempoFunzionamento; //secondi
    private boolean interruttore;
    private LocalDateTime momento_acc;

    private static int a = 65;
    private static int b = 65;
    private static int c = 65;
    private static int z = 0;

    public Lampadina(){
        sl = StatoLampadina.SPENTA;
        nAccensioni = 0;
        tempoFunzionamento = 0;
        String parteNumerica = String.format("%05d", z);
        nSerie = "" + (char) a + (char) b + (char) c + parteNumerica;
        z++;
        if(z>=99999){
            z = 0;
            c++;
            if(c>=90){
                c = 65;
                b++;
                if(b>=90){
                    b = 65;
                    a++;
                    if(a>=90){
                        a = 65;
                        throw new IllegalArgumentException("ID terminati");
                    }
                }
            }
        }
        interruttore = false;
        lampadine.add(nSerie);
    }

    public void accendi(){
        if(sl == StatoLampadina.ACCESA) throw new IllegalArgumentException("Lampadina già accesa");

        //probabilità dello 0.01% che si rompa
        double random = Math.random();
        if(random<0.01){
            sl = StatoLampadina.ROTTA;
            throw new IllegalArgumentException("La lampadina si è rotta");
        }else{
            sl = StatoLampadina.ACCESA;
            nAccensioni++;
            momento_acc = LocalDateTime.now();
        }
    }

    public void spegni(){
        if(sl == StatoLampadina.SPENTA) throw new IllegalArgumentException("Lampadina già spenta");
        sl = StatoLampadina.SPENTA;
        Duration durata = Duration.between(momento_acc, LocalDateTime.now());
        tempoFunzionamento += durata.toSecondsPart();
    }

    public void premiInterruttore(){
        interruttore = !interruttore;
        if(interruttore){
            accendi();
        }else{
            spegni();
        }
    }

    public double getTempoFunzionamento(){
        return tempoFunzionamento;
    }
}
