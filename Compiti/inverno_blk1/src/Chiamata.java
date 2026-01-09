import java.util.ArrayList;

class Chiamata {
    private static ArrayList<String> cronologia = new ArrayList<>();

    public static void registra(String codiceBiglietto, String cassa) {
        String ora = java.time.LocalTime.now().withNano(0).toString();
        cronologia.add(codiceBiglietto + " | " + ora + " | " + cassa);
    }

    public static ArrayList<String> getCronologia() {
        return cronologia;
    }
}
