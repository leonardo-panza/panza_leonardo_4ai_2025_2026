public static void main(String[] args) {

    /*
     * Creiamo un albero con radice = 50
     */
    AlberoChat albero = new AlberoChat(50);

    /*
     * Inseriamo altri 6 numeri (totale 7)
     */
    albero.aggiungiNumero(30);
    albero.aggiungiNumero(70);
    albero.aggiungiNumero(20);
    albero.aggiungiNumero(40);
    albero.aggiungiNumero(60);
    albero.aggiungiNumero(80);

    /*
     * Struttura risultante:
     *
     *         50
     *       /    \
     *     30      70
     *    /  \    /  \
     *   20  40  60  80
     */

    System.out.println("Stampa InOrder:");
    albero.stampaInOrder();

    System.out.println("Stampa PreOrder:");
    albero.stampaPreOrder();

    System.out.println("Stampa PostOrder:");
    albero.stampaPostOrder();
}