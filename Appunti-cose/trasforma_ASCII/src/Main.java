public class Main {

    public static void main(String[] args) {

        //Trasformo il char nel suo codice ASCII
        char b = 'c';
        int a = (int) b;

        System.out.println(b);

        //Stampo per controllare
        System.out.println(a);

        //Trasformo in lettera in grande (in ASCII, -32)
        a = a-32;
        char c = (char) a;
        System.out.println(c);

    }
}