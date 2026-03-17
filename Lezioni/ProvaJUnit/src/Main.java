void main() {
    Calcolatrice calc = new Calcolatrice();
    int risultato = calc.somma(2, 3);
    System.out.println("Risultato: " + risultato);


    risultato = calc.differenza(2, 3);
    System.out.println("Risultato: " + risultato);
    risultato = calc.prodotto(2, 3);
    System.out.println("Risultato: " + risultato);
    double r = calc.quoziente(2, 3);
    System.out.println("Risultato: " + r);


}
