//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void funzioncina(){
        String variabile = "Stringa per funzione";
        System.out.println(variabile);
    }

    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        int numero = 133;
        System.out.println(numero);
        numero = 123;
        System.out.println(numero);

        System.out.print("Non vado a capo ---> ");
        System.out.println("Ora sì");

        String nome = "Sono Leonardo";

        System.out.println(nome);

        //standard for
        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }

        //chiamo una funzione
        funzioncina();
        funzionesotto();

        //if e for da me
        int x = 9;
        if (x>10){
            for (int i = 1; i <= 10; i++){
                System.out.println(i);
            }
        }else{
            System.out.println("Errore! Numero non valido!");
        }

    }
    
    private static void funzionesotto(){
        System.out.println("Funzione sotto al main! WOW!");
    }
}