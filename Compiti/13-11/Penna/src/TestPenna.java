

void main() {

    Penna penna1 = new Penna();

    penna1.setMarca("Leonardo's Pen Factories");
    penna1.setCancellabile(true);
    penna1.setColore("Bianco");
    penna1.setQuantitaInchiostro(78.3);

    String marca = penna1.getMarca();
    boolean canc = penna1.getCancellabile();
    double quantita = penna1.getQuantitaInchiostro();
    String colore = penna1.getColore();

    IO.println("PENNA ---" +
            "\nMarca: " + marca+
            "\nColore: " + colore+
            "\nQuantità inchiostro: " + quantita+
            "\nCancellabile: "+canc);

    Penna penna2 = new Penna();
    boolean in_cancellabile = false;

    penna2.setMarca(IO.readln("Marca della tua penna: "));

    String a = IO.readln("È cancellabile? (si o no): ");
    a = a.toLowerCase();
    if(a.equals("si") || a.equals("sì")) {
        in_cancellabile = true;
    }
    penna2.setCancellabile(in_cancellabile);

    String b = IO.readln("Colore della tua penna: ");
    penna2.setColore(b);

    String c = IO.readln("Percentuale di inchiostro (0-100): ");
    double in_inchiostro = Double.parseDouble(c);
    penna2.setQuantitaInchiostro(in_inchiostro);

    IO.println("Marca della penna: " + penna2.getMarca() +
            "\nColore: " + penna2.getColore() +
            "\nCancellabile: " + in_cancellabile +
            "\nPercentuale di inchiostro: " + in_inchiostro + "%");

}
