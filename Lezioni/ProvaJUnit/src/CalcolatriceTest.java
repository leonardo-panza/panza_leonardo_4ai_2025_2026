import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalcolatriceTest {

    @Test
    void testSomma() {
        Calcolatrice calc = new Calcolatrice();
        int risultato = calc.somma(2, 3);
        assertEquals(5, risultato);
    }

    @Test
    void testDifferenza(){
        Calcolatrice calc = new Calcolatrice();
        int risultato = calc.differenza(9, 4);
        assertEquals(5, risultato);
    }

    @Test
    void testProdotto(){
        Calcolatrice calc = new Calcolatrice();
        int risultato = calc.prodotto(2, 4);
        assertEquals(8, risultato);
    }

    @Test
    void testQuoziente(){
        Calcolatrice calc = new Calcolatrice();
        double risultato = calc.quoziente(9, 4);
        assertEquals(2.25, risultato);
    }

    @Test
    void testPotenza(){
        Calcolatrice calc = new Calcolatrice();
        double risultato = calc.potenza(5, 2);
        assertEquals(25, risultato);
    }

    @Test
    void testRadice(){
        Calcolatrice calc = new Calcolatrice();
        double risultato = calc.radice(9, 2);
        assertEquals(3, risultato);
    }

    @Test
    void testLogaritmo(){
        Calcolatrice calc = new Calcolatrice();
        double risultato = calc.logaritmo(10);
        assertEquals(1, risultato);
    }

}