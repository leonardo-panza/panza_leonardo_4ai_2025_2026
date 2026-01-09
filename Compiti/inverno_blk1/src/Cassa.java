class Cassa {
    private static int num = 1;
    private String codice;
    private static int chiamateNormali = 0;

    public Cassa() {
        codice = "C" + num++;
    }

    public String getCodice() {
        return codice;
    }

    public String chiamaProssimo() {
        String cliente = Biglietto.prossimoCliente(chiamateNormali);
        if (cliente == null) return "Nessuno in attesa";
        if (cliente.startsWith("N")) chiamateNormali++;
        Chiamata.registra(cliente, codice);
        return cliente;
    }
}