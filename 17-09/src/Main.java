//studying
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Comincamo!");

        /*
        //Nome
        System.out.print("Inserisci il nome: ");
        String nome = br.readLine();

        benvenuto(nome);
        System.out.println("Benvenuto " + nome);
        */

        //Numero

        System.out.print("\nInserisci un numero: ");
        String numero = br.readLine();

        verificanum1(numero);

    }

    public static void benvenuto(String nomignolo){
        switch(nomignolo){
            case "Mario": System.out.println("Sei " + nomignolo + "??? Hmmmm non penso"); break;
            case "Luigi": System.out.println("Sei " + nomignolo + "??? Hmmmm non penso");break;
            case "Adam": System.out.println("Che brutto nome, 9 mesi per essere chiamto" + nomignolo + " 💀🙏");break;
            case "Nicola": System.out.println("Che brutto nome, 9 mesi per essere chiamto "+ nomignolo +" 💀🙏");break;
            case "Balotelli": System.out.println("Bro is NOT him 😭🙏");break;
            default: System.out.println("Ciao "+ nomignolo +"! Sei bellissimo 😎😎😎");
        }
    }

    public static void verificanum1(String numero){
        try {
            int n = Integer.parseInt(numero);

            //for(inizializzazione; condizione di terminazione; incremento){
            //  istruzioni
            //}

            for (int i = -50; i >= n; i = i - 2){
                System.out.println(i + "X");
            }

            if (n==0){
                System.out.println("We furbetto pensi di fregarmi? Il quadrato di 0 è 0 😭🙏");
                System.out.println("Brochacho tought he could fool me");
                System.out.println("'some attention please' ahh input 😭😭😭");
            }else{
                if (n<0){
                    System.out.println("niente numeri negativi");
                }else {
                    System.out.println("Il quadrato di " + n + " è: " + (n * n));
                }
            }
            System.out.println("\nHai inserito questo btw: " + n);
        } catch (Exception e){
            System.out.print("NOOOOOOO ANGELOOOO");
        }
    }




}



        /*
        System.out.println("COSTRUTTI!");
        //ricerco come fare degli input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Scrivi qualcosa: ");
        String s = br.readLine();
        System.out.print("Inserisci un numero: ");
        try {
            int i = Integer.parseInt(br.readLine());
        }catch(NumberFormatException nfe){
            System.err.println("Non hai inserito un numero!!!");
        }
        */
